package syhan.analysis.pilot.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(indexes = @Index(name = "IDX_FROM_TO_JAVA_DEP", unique = true, columnList = "fromModule,toModule"))
public class JavaDependency {
    //
    @Id
    private String id;
    private String fromModule;
    private String toModule;

    public JavaDependency() {
    }

    public JavaDependency(String fromModule, String toModule) {
        //
        this.id = UUID.randomUUID().toString();
        this.fromModule = fromModule;
        this.toModule = toModule;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFromModule() {
        return fromModule;
    }

    public void setFromModule(String fromModule) {
        this.fromModule = fromModule;
    }

    public String getToModule() {
        return toModule;
    }

    public void setToModule(String toModule) {
        this.toModule = toModule;
    }

    @Override
    public String toString() {
        return "JavaDependency{" +
                "id='" + id + '\'' +
                ", fromModule='" + fromModule + '\'' +
                ", toModule='" + toModule + '\'' +
                '}';
    }
}
