package syhan.analysis.pilot.store.repository;

import org.springframework.data.repository.CrudRepository;
import syhan.analysis.pilot.entity.JavaDependency;

import java.util.List;

public interface JavaDependencyRepository extends CrudRepository<JavaDependency, String> {
    //
    List<JavaDependency> findByFromModule(String fromModule);
    List<JavaDependency> findByFromModuleAndToLevel(String fromModule, int toLevel);
    List<JavaDependency> findByFromModuleAndToModule(String fromModule, String toModule);
    long countByFromModuleAndAndToModule(String fromModule, String toModule);
}
