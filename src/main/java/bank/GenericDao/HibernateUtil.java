package bank.GenericDao;

import bank.Model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Scanner;

public class HibernateUtil<T> {
    private static String pass = "";
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        pass();
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/bank?serverTimezone=UTC");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, pass);
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                //settings.put(Environment.HBM2DDL_AUTO, "create-drop");
                settings.put(Environment.HBM2DDL_AUTO, "update");
                configuration.setProperties(settings);
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Account.class);
                configuration.addAnnotatedClass(User_details.class);
                configuration.addAnnotatedClass(Account_type.class);
                configuration.addAnnotatedClass(Transaction.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }




    public void add(T object) {
        Session session = sessionFactory.openSession();
        org.hibernate.Transaction transaction = session.beginTransaction();
        session.save(object);
        transaction.commit();
        session.close();
    }

    public void update(T object) {
        Session session = sessionFactory.openSession();
        org.hibernate.Transaction transaction = session.beginTransaction();
        session.update(object);
        transaction.commit();
        session.close();
    }

    public T findById(T object, int id) {
        Session session = sessionFactory.openSession();
        org.hibernate.Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from " + object.getClass().getName() + " where id=" + id +"");
        T result = (T) query.getSingleResult();
        transaction.commit();
        session.close();
        return result;
    }

    public T readUserDetails(T object, int id) {
        Session session = sessionFactory.openSession();
        org.hibernate.Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from " + object.getClass().getName() + " where id=" + id +"");
        T result = (T) query.getSingleResult();
        transaction.commit();
        session.close();
        return result;
    }

    public T findByIBAN(T object, int iban) {
        Session session = sessionFactory.openSession();
        org.hibernate.Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from " + object.getClass().getName() + " where IBAN=" + iban +"");
        T result = (T) query.getSingleResult();
        transaction.commit();
        session.close();
        return result;
    }

    public void delete(T object) {
        Session session = sessionFactory.openSession();
        org.hibernate.Transaction transaction = session.beginTransaction();
        session.delete(object);
        transaction.commit();
        session.close();
    }













    public static void pass() {
        File file = new File("C:/Users/ACASA/IdeaProjects/pass.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                pass = scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}
