package syhan.analysis.pilot;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import syhan.analysis.pilot.analyzer.Analyzer;
import syhan.analysis.pilot.analyzer.PackageAnalyzer;
import syhan.analysis.pilot.config.AnalysisConfiguration;
import syhan.analysis.pilot.store.JavaDependencyStore;
import syhan.analysis.pilot.store.StoreConfig;

public class CodeAnalysis {
    //private static final String SOURCE_PATH = "/Users/daniel/Documents/work/source_gen/source-gen-work/source-project";
    private static final String SOURCE_PATH = "/Users/daniel/Documents/work/namooio/git_temp/nara-platform/pavilion/pavilion-service";
// /Users/daniel/Documents/work/namooio/git_temp/nara-platform/pavilion/pavilion-service/src/main/java/nara
    public static void main(String[] args) throws Exception {
        //
        ApplicationContext ctx = new AnnotationConfigApplicationContext(StoreConfig.class);
        JavaDependencyStore store = ctx.getBean(JavaDependencyStore.class);

        AnalysisConfiguration configuration = new AnalysisConfiguration(SOURCE_PATH);

        // 1. java file analyze
        //Analyzer analyzer = new JavaAnalyzer(configuration, store);
        //analyzer.analyze("com/foo/bar/service/SampleService.java");

        // 2. package analyze
        Analyzer analyzer = new PackageAnalyzer(configuration, store);
        analyzer.analyze("nara.pavilion");
        System.out.println("### Complete analyze ###");

        //
        //List<JavaDependency> list = store.findByFromModule("com.foo.bar.service.SampleService");
        //List<JavaDependency> list = store.findAll();
        //list.forEach(System.out::println);
    }
}
