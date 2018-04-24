package syhan.sourcegen.pilot.writer;

import syhan.sourcegen.pilot.source.JavaSource;

import java.io.IOException;

public interface Writer {
    //
    void write(JavaSource source) throws IOException;
}
