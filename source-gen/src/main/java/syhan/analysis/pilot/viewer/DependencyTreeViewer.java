package syhan.analysis.pilot.viewer;

import syhan.analysis.pilot.entity.JavaDependency;

import java.util.List;

public class DependencyTreeViewer {
    //
    private PackageNode root;

    public DependencyTreeViewer(List<JavaDependency> modules) {
        this.root = new PackageNode("");
        for (JavaDependency module : modules) {
            this.root.add(module.getToModule());
        }
    }

    public String show() {
        return root.show("");
    }

    @Override
    public String toString() {
        return root.toString();
    }
}