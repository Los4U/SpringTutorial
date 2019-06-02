package tutorial.demo.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tutorial.demo.entity.Medicine;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.sql.SQLOutput;
import java.util.List;

@Repository
public class MedicineDAOJPAImpl implements MedicineDAO {

    private EntityManager entityManager;

    @Autowired
    public MedicineDAOJPAImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    public List<Medicine> findAll() {
        Query theQuery = entityManager.createQuery("from Medicine");
        List<Medicine> medicines = theQuery.getResultList();
        return medicines;
    }

    @Override
    public Medicine findById(int theId) {
        Medicine theMedicine = entityManager.find(Medicine.class, theId);
        return theMedicine;
    }

    @Override
    public void save(Medicine theMedicine) {
        Medicine dbMedicine = entityManager.merge(theMedicine);
        theMedicine.setMedicineId(dbMedicine.getMedicineId());
    }

    @Override
    public void deleteById(int theId) {
        //VERY IMPORTAND WHEN DELETE , DELETE CAN NOT BY TYPED TO MEDICINE!!!!!!!!!!!!!!!!!
        Query theQuery =
                entityManager.createQuery("DELETE FROM Medicine AS m WHERE m.medicineId =: id");
        theQuery.setParameter("id", theId);
        int result = theQuery.executeUpdate();
    }
}
