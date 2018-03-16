package com.syhan.parser;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.io.FileInputStream;

public class DependencyFindExample {
    private static final String FILE_PATH = "source-gen/src/main/java/com/github/javaparser/ReversePolishNotation.java";

    public static void main(String[] args) throws Exception {
        CompilationUnit cu = JavaParser.parse(new FileInputStream(FILE_PATH));

        VoidVisitor importVisitor = new ImportPrinter();
        importVisitor.visit(cu, null);
    }

    private static class ImportPrinter extends VoidVisitorAdapter<Void> {
        @Override
        public void visit(ImportDeclaration id, Void arg) {
            super.visit(id, arg);
            System.out.println("Import : " + id.getName());
        }
    }
}
