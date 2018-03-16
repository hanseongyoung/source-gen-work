package syhan.analysis.pilot.store;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import syhan.analysis.pilot.entity.JavaDependency;
import syhan.analysis.pilot.store.repository.JavaDependencyRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JavaDependencyStore {
    //
    @Autowired
    private JavaDependencyRepository javaDependencyRepository;

    private Logger logger = LoggerFactory.getLogger(getClass());

    public void create(String fromModule, String toModule) {
        //
        JavaDependency javaDependency = new JavaDependency(fromModule, toModule);
        javaDependencyRepository.save(javaDependency);
    }

    public List<JavaDependency> findByFromModule(String fromModule) {
        //
        return javaDependencyRepository.findByFromModule(fromModule);
    }

    public boolean exists(String fromModule, String toModule) {
        //
        return javaDependencyRepository.countByFromModuleAndAndToModule(fromModule, toModule) > 0;
    }

    public List<JavaDependency> findAll() {
        //
        logger.debug("findAll called...");
        List<JavaDependency> list = new ArrayList<>();
        javaDependencyRepository.findAll().forEach(list::add);
        return list;
    }
}
