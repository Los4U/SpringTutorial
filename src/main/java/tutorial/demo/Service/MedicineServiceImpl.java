package tutorial.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tutorial.demo.dao.MedicineDAO;
import tutorial.demo.entity.Medicine;

import java.util.List;

@Service
public class MedicineServiceImpl implements MedicineService {

    private MedicineDAO medicineDAO;

    @Autowired
    public MedicineServiceImpl(@Qualifier("medicineDAOJPAImpl") MedicineDAO medicineDAO) {
        this.medicineDAO = medicineDAO;
    }

    @Override
    @Transactional
    public List<Medicine> findAll() {
        System.out.println("serviceMedicine");
        return medicineDAO.findAll();
    }

    @Override
    @Transactional
    public Medicine findById(int theId) {
        return medicineDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(Medicine theMedicine) {
        medicineDAO.save(theMedicine);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        medicineDAO.deleteById(theId);
    }
}
