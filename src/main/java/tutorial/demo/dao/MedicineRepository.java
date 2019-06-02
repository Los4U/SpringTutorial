package tutorial.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tutorial.demo.entity.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine,Integer> {

}
