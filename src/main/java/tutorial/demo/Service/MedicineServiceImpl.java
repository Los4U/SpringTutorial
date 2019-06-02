package tutorial.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tutorial.demo.dao.MedicineRepository;
import tutorial.demo.entity.Medicine;

import java.util.List;
import java.util.Optional;

@Service
public class MedicineServiceImpl implements MedicineService {

//    private MedicineDAO medicineDAO;
//
//    @Autowired
//    public MedicineServiceImpl(@Qualifier("medicineDAOJPAImpl") MedicineDAO medicineDAO) {
//        this.medicineDAO = medicineDAO;
//    }

    private MedicineRepository medicineRepository;

    @Autowired
    public MedicineServiceImpl(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    @Override
    //@Transactional
    public List<Medicine> findAll() {
        System.out.println("medicineRepository");
        return medicineRepository.findAll();
    }

    @Override
    //@Transactional
    public Medicine findById(int theId) {
        Optional<Medicine> result = medicineRepository.findById(theId);
        Medicine theMedicine = null;
        if(result.isPresent()){
            theMedicine = result.get();
        }else{
            throw new RuntimeException("Dod not find medicine id" + theId);
        }
        return theMedicine;
    }

    @Override
    //@Transactional
    public void save(Medicine theMedicine) {
        medicineRepository.save(theMedicine);
    }

    @Override
    //@Transactional
    public void deleteById(int theId) {
        medicineRepository.deleteById(theId);
    }
}
