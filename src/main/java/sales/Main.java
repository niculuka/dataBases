package sales;

import org.hibernate.Session;


public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        //save client
//        Client client = new Client("AAA", "0711222222");
//        session.beginTransaction();
//        session.save(client);
//        session.getTransaction().commit();
//        System.out.println("=========================================================================================");

        //save order
//        Order order = new Order("bananas", 1.2);
//        session.beginTransaction();
//        session.save(order);
//        session.getTransaction().commit();
//        System.out.println("=========================================================================================");








        //read from DB
        session.beginTransaction();
        System.out.println(session.get(Client.class, 4));
        session.getTransaction().commit();
        System.out.println("=========================================================================================");


        //HQL
//        session.getTransaction();
//        List<Customers> customersList = session.createQuery("from Customers WHERE first_name LIKE '%an%'").list();
//        for (Customers custom : customersList) {
//            System.out.println(custom.toString());
//        }
//        session.close();
    }

}
