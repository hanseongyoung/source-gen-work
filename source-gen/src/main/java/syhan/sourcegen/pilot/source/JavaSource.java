package syhan.sourcegen.pilot.source;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class JavaSource {
    //
    private String physicalSourceFile;
    private String fileName;
    private CompilationUnit compilationUnit;

    public JavaSource(String physicalSourceFile) throws FileNotFoundException {
        //
        this.physicalSourceFile = physicalSourceFile;
        this.fileName = new File(physicalSourceFile).getName();
        this.compilationUnit = JavaParser.parse(new FileInputStream(physicalSourceFile));
    }

    public void write(String targetPathName) throws IOException {
        //
        File file = new File(targetPathName);
        FileUtils.writeStringToFile(file, compilationUnit.toString(), "UTF-8");
    }

    public String getFileName() {
        //
        return fileName;
    }

    public String getPhysicalSourceFile() {
        //
        return physicalSourceFile;
    }

    public static void createDir(File dir) {
        //
        try {
            System.out.println("dir:"+dir);
            FileUtils.forceMkdir(dir);
        } catch (IOException e) {
            // TODO
            e.printStackTrace();
        }
    }
}
