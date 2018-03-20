package syhan.analysis.pilot.viewer;

import org.junit.Test;
import syhan.analysis.pilot.entity.JavaDependency;

import java.util.ArrayList;
import java.util.List;

public class DependencyViewerTest {
    //
    @Test
    public void test() {
        //
        List<JavaDependency> list = new ArrayList<>();
        list.add(new JavaDependency("com", 1, "net", 1));
        list.add(new JavaDependency("com", 1, "net", 1));
        DependencyViewer dependencyViewer = new DependencyViewer(list);
        System.out.println(dependencyViewer.show());
    }
}
