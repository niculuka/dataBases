package job;

import org.hibernate.Session;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        //save object in DB
//        Customers customers = new Customers("George", "Ardei", "M", "21545522");
//        session.beginTransaction();
//        session.save(customers);
//        session.getTransaction().commit();
//        System.out.println("=========================================================================================");


        //read from DB
//        session.beginTransaction();
//        System.out.println(session.get(Customers.class, 4));
//        session.getTransaction().commit();
//        System.out.println("=========================================================================================");


        //HQL
        session.getTransaction();
        List<Customers> customersList = session.createQuery("from Customers WHERE first_name LIKE '%an%'").list();
        for (Customers custom : customersList) {
            System.out.println(custom.toString());
        }
        session.close();
    }

}
