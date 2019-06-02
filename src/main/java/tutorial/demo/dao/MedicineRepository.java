package tutorial.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import tutorial.demo.entity.Medicine;

@RepositoryRestResource(path = "drugs")
public interface MedicineRepository extends JpaRepository<Medicine,Integer> {

}
