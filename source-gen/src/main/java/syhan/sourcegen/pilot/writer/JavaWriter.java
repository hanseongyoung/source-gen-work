package syhan.sourcegen.pilot.writer;

import syhan.sourcegen.pilot.config.ConvertConfiguration;
import syhan.sourcegen.pilot.source.JavaSource;

import java.io.IOException;

public class JavaWriter implements Writer {
    //
    private ConvertConfiguration configuration;

    public JavaWriter(ConvertConfiguration configuration) {
        //
        this.configuration = configuration;
    }

    @Override
    public void write(JavaSource source) throws IOException {
        //
        String targetFilePath = source.getSourceFilePath();
        String physicalTargetFilePath = configuration.getPhysicalTargetFilePath(targetFilePath);
        writeSource(source, physicalTargetFilePath);
    }

    private void writeSource(JavaSource source, String physicalTargetFilePath) throws IOException {
        //
        source.write(physicalTargetFilePath);
    }
}
