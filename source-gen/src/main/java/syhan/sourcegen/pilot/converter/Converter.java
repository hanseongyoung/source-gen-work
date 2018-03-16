package syhan.sourcegen.pilot.converter;

import java.io.IOException;

public interface Converter {
    //
    void convert(String sourceName) throws IOException;
}
