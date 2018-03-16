package syhan.analysis.pilot.viewer;

import java.util.ArrayList;
import java.util.List;

public class PackageNode {
    //
    private String name;
    private List<PackageNode> children;
    private PackageNode parent;

    public PackageNode(String name) {
        //
        this(name, null);
    }

    public PackageNode(String name, PackageNode parent) {
        //
        this.name = name;
        this.parent = parent;
        this.children = new ArrayList<>();
    }

    public boolean add(String childName) {
        //
        boolean childAdded = false;
        if (isMyChildName(childName)) {
            childAdded = addChildrensChild(childName);
            if (!childAdded) {
                addMyChild(childName);
                childAdded = true;
            }
        }
        return childAdded;
    }

    private boolean isMyChildName(String childName) {
        //
        if (isRoot()) {
            return true;
        }
        return childName.startsWith(this.name + ".");
    }

    private boolean isRoot() {
        //
        return this.parent == null;
    }

    private void addMyChild(String childName) {
        //
        this.children.add(new PackageNode(childName, this));
    }

    private boolean addChildrensChild(String childName) {
        //
        for (PackageNode child : children) {
            if (child.add(childName)) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public List<PackageNode> getChildren() {
        return children;
    }

    public PackageNode getParent() {
        return parent;
    }

    public String getEndedName() {
        if (parent == null || parent.name == null || parent.name.length() <= 0) {
            return name;
        }
        return name.substring(parent.name.length());
    }

    public String show(String prefix) {
        //
        StringBuilder sb = new StringBuilder();
        sb.append("\n").append(prefix).append("+ ").append(getEndedName());
        for (PackageNode child : children) {
            sb.append(child.show(prefix + "    "));
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n +").append(this.name);
        for (PackageNode child : children) {
            sb.append(child.toString());
        }
        return sb.toString();
    }
}