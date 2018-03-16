import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileTest {
    private static final String PROJECT_PATH = "/Users/daniel/Documents/work/source_gen/source-gen-work/source-project";
    private static final String JAVA_PATH = "src/main/java";
    private static final String PACKAGE_PATH = "com/foo/bar";

    private static final String PROJECT_PATH2 = "/Users/daniel/Documents/work/source_gen/source-gen-work/source-gen";
    private static final String PACKAGE_PATH2 = "syhan";

    @Test
    public void testDir() throws Exception {
        //
        String srcPath = PROJECT_PATH + File.separator + JAVA_PATH + File.separator + PACKAGE_PATH;
        try (Stream<Path> paths = Files.walk(Paths.get(srcPath))) {
            paths
                    .filter(Files::isRegularFile)
                    //.filter(p -> p.toString().endsWith(".java"))
                    .map(Path::toFile)
                    .forEach(System.out::println);
        }
    }

    @Test
    public void testDir2() throws Exception {
        //
        String srcPath = PROJECT_PATH2 + File.separator + JAVA_PATH + File.separator + PACKAGE_PATH2;
        try (Stream<Path> paths = Files.walk(Paths.get(srcPath))) {
            paths
                    //.filter(Files::isRegularFile)
                    .filter(p -> p.toString().endsWith(".java"))
                    .map(Path::toFile)
                    .forEach(System.out::println);
        }
    }

    @Test
    public void testCreateDir() throws Exception {
        FileUtils.forceMkdir(new File("foo/bar/hello"));
    }
}
