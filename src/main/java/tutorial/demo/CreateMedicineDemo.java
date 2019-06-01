package tutorial.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//
//public class CreateMedicineDemo {
//
//    public static void main(String[] args) {
//
//
//        SessionFactory factory = new
//        Session session = factory.getCurrentSession();
//
//        try{
//            Medicine med1 = new Medicine(213,"Polopiryna", "Mocne");
//            session.beginTransaction();
//            session.save(med1);
//            session.getTransaction().commit();
//
//
//        }finally {
//            factory.close();
//        }
//
//
//    }
//
//}
