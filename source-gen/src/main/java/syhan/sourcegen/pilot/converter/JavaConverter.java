package syhan.sourcegen.pilot.converter;

import syhan.sourcegen.pilot.config.ConvertConfiguration;
import syhan.sourcegen.pilot.source.JavaSource;

import java.io.FileNotFoundException;
import java.io.IOException;

public class JavaConverter implements Converter {
    //
    private ConvertConfiguration configuration;

    public JavaConverter(ConvertConfiguration configuration) {
        //
        this.configuration = configuration;
    }

    @Override
    public void convert(String sourceFile) throws IOException {
        // sourceFile : com/foo/bar/SampleService.java
        String physicalSourceFile = configuration.getPhysicalSourceFilePath(sourceFile);
        JavaSource source = readSource(physicalSourceFile);

        String targetPathName = configuration.getPhysicalTargetFilePath(source);
        writeSource(source, targetPathName);
    }

    private JavaSource readSource(String physicalSourceFile) throws FileNotFoundException {
        //
        return new JavaSource(physicalSourceFile);
    }

    private void writeSource(JavaSource source, String targetPathName) throws IOException {
        //
        source.write(targetPathName);
    }
}
