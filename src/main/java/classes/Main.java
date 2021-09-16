package classes;

import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();

            //save object in DB
//            Products products = new Products("Grande Cappuccino", 2.50, "Java");

//            session.beginTransaction();
//            session.save(products);
//            session.getTransaction().commit();
//            System.out.println("=====================================================================================");
//
//
//            //read from DB
//            session.beginTransaction();
//            System.out.println(session.get(Products.class, 10));
//            session.getTransaction().commit();
//            System.out.println("=====================================================================================");
//
//
//            //HQL
//            session.getTransaction();
//            List<Products> productsList = session.createQuery("from Products WHERE name LIKE '%pp%'").list();
//            for(Products p : productsList) {
//                System.out.println(p.toString());
//            }
//            session.close();

//            Instructor instructor = new Instructor(
//                    "John",
//                    "john@gmail.com",
//                    new InstructorDetail("Best Instructor"));
//
//            session.beginTransaction();
//            session.save(instructor);
//            session.getTransaction().commit();

            Post post = new Post("First Post");

            post.addComment( new PostComment("My first comment on FB"));
            post.addComment( new PostComment("your hair is ugly"));
            post.addComment( new PostComment("..."));

            session.beginTransaction();
            session.save(post);
            session.getTransaction().commit();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
