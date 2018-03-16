package syhan.analysis.pilot.store.repository;

import org.springframework.data.repository.CrudRepository;
import syhan.analysis.pilot.entity.JavaDependency;

import java.util.List;

public interface JavaDependencyRepository extends CrudRepository<JavaDependency, String> {
    //
    List<JavaDependency> findByFromModule(String fromModule);
    long countByFromModuleAndAndToModule(String fromModule, String toModule);
}
