package syhan.analysis.pilot.analyzer;

import syhan.analysis.pilot.store.JavaDependencyStore;

import java.util.ArrayList;
import java.util.List;

public class PackageDependencyWriter {
    //
    private String fromModule;
    private String toModule;
    private JavaDependencyStore store;

    public PackageDependencyWriter(String fromModule, String toModule, JavaDependencyStore store) {
        //
        this.fromModule = fromModule;
        this.toModule = toModule;
        this.store = store;
    }

    public void write() {
        //
        List<String> fromPackages = extractPackages(fromModule);
        List<String> toPackages = extractPackages(toModule);
        for (String fromPackage : fromPackages) {
            write(fromPackage, toPackages);
        }
    }

    private void write(String fromPackage, List<String> toPackages) {
        //
        for (String toPackage: toPackages) {
            write(fromPackage, toPackage);
        }
    }

    private void write(String fromPackage, String toPackage) {
        //
        if (!store.exists(fromPackage, toPackage)) {
            store.create(fromPackage, toPackage);
        }
    }

    // com.foo.bar.Sample -> com, com.foo, com.foo.bar, com.foo.bar.Sample
    private List<String> extractPackages(String moduleName) {
        //
        String[] packs = moduleName.split("\\.");
        StringBuilder sb = new StringBuilder();
        List<String> packages = new ArrayList<>();
        for (int i = 0; i < packs.length; i++) {
            if (i > 0) {
                sb.append(".");
            }
            sb.append(packs[i]);
            packages.add(sb.toString());
        }

        return packages;
    }
}
