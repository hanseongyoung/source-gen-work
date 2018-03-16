package syhan.analysis.pilot.analyzer;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import syhan.analysis.pilot.config.AnalysisConfiguration;
import syhan.analysis.pilot.store.JavaDependencyStore;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class JavaAnalyzer implements Analyzer {
    //
    private AnalysisConfiguration configuration;
    private JavaDependencyStore store;

    public JavaAnalyzer(AnalysisConfiguration configuration, JavaDependencyStore store) {
        //
        this.configuration = configuration;
        this.store = store;
    }

    @Override
    public void analyze(String sourceFile) throws IOException {
        //
        String physicalSourceFile = configuration.getPhysicalSourceFilePath(sourceFile);
        CompilationUnit cu = JavaParser.parse(new FileInputStream(physicalSourceFile));

        VoidVisitor importVisitor = new ImportPrinter(toSourceName(sourceFile), store);
        importVisitor.visit(cu, null);
    }

    private String toSourceName(String sourceFile) {
        //
        return sourceFile.split(".java")[0].replace(File.separator, ".");
    }

    private static class ImportPrinter extends VoidVisitorAdapter<Void> {
        //
        private String sourceName;
        private JavaDependencyStore store;

        public ImportPrinter(String sourceName, JavaDependencyStore store) {
            this.sourceName = sourceName;
            this.store = store;
        }

        @Override
        public void visit(ImportDeclaration importDeclaration, Void arg) {
            super.visit(importDeclaration, arg);
            String referenceName = importDeclaration.getNameAsString();
            System.out.println(String.format("%s Reference %s", sourceName, referenceName));

            new PackageDependencyWriter(sourceName, referenceName, store).write();
        }
    }
}
