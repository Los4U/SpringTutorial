package tutorial.demo.dao;

import tutorial.demo.entity.Medicine;
import java.util.List;

public interface MedicineDAO {

    public List<Medicine> findAll();

    public Medicine findById(int theId);

    public void save(Medicine theMedicine);

    public void deleteById(int theId);
}
