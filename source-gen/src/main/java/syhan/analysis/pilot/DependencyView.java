package syhan.analysis.pilot;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import syhan.analysis.pilot.entity.JavaDependency;
import syhan.analysis.pilot.store.JavaDependencyStore;
import syhan.analysis.pilot.store.StoreConfig;
import syhan.analysis.pilot.viewer.DependencyTreeViewer;

import java.util.List;

public class DependencyView {
    //
    public static void main(String[] args) {
        //
        ApplicationContext ctx = new AnnotationConfigApplicationContext(StoreConfig.class);
        JavaDependencyStore store = ctx.getBean(JavaDependencyStore.class);

        // 특정 모듈이 참조하는 전체 모듈 조회
        //List<JavaDependency> list = store.findByFromModule("nara.pavilion");

        // 특정 모듈이 참조하는 1단계 모듈 조회
        List<JavaDependency> list = store.findByFromModule("nara.pavilion", 2);

        System.out.println(new DependencyTreeViewer(list).show());
    }
}
