package syhan.analysis.pilot.config;

import java.io.File;

public class AnalysisConfiguration {
    //
    private static final String PATH_DELIM = File.separator;
    private final String sourceJavaFolder = String.format("src%smain%sjava", PATH_DELIM, PATH_DELIM);    // src/main/java
    private final String physicalPrefix;

    public AnalysisConfiguration(String sourceHomePath) {
        //
        this.physicalPrefix = sourceHomePath + PATH_DELIM + sourceJavaFolder + PATH_DELIM;
    }

    public String getPhysicalSourceFilePath(String sourceFilePath) {
        //
        return physicalPrefix + sourceFilePath;
    }

    public String getSourceFilePath(String physicalSourceFilePath) {
        //
        if (!physicalSourceFilePath.startsWith(physicalPrefix)) {
            throw new RuntimeException("physicalSourceFilePath is not correct! : " + physicalSourceFilePath);
        }

        return physicalSourceFilePath.substring(physicalPrefix.length());
    }

}
