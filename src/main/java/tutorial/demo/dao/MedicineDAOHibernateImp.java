package tutorial.demo.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tutorial.demo.entity.Medicine;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.sql.SQLOutput;
import java.util.List;

@Repository
public class MedicineDAOHibernateImp implements MedicineDAO {

    private EntityManager entityManager;

    @Autowired
    public MedicineDAOHibernateImp(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    public List<Medicine> findAll() {
        Session curentSession =  entityManager.unwrap(Session.class);
        Query<Medicine> theQuery = curentSession.createQuery("from Medicine", Medicine.class);
        List<Medicine> medicines = theQuery.getResultList();
        return medicines;
    }

    @Override
    public Medicine findById(int theId) {
        Session curentSession =  entityManager.unwrap(Session.class);
        Medicine theMedicine = curentSession.get(Medicine.class, theId);
        return theMedicine;
    }

    @Override
    public void save(Medicine theMedicine) {
        Session curentSession =  entityManager.unwrap(Session.class);
        curentSession.saveOrUpdate(theMedicine);
    }

    @Override
    public void deleteById(int theId) {
        Session curentSession =  entityManager.unwrap(Session.class);
        //VERY IMPORTAND WHEN DELETE , DELETE CAN NOT BY TYPED TO MEDICINE!!!!!!!!!!!!!!!!!
        Query theQuery =  curentSession.createQuery("DELETE FROM Medicine AS m WHERE m.medicineId =: id");
        theQuery.setParameter("id", theId);
        int result = theQuery.executeUpdate();
    }
}