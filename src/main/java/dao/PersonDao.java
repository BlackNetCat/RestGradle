package dao;

import model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import java.util.List;

/**
 * Created by netcat on 30.05.2015.
 */
public class PersonDao {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public Person getPersonById(int id) {
        Person person = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            person = (Person) session.createQuery("from Person p where p.id = :id").setParameter("id", id).uniqueResult();
            session.getTransaction().commit();
        }
        catch (Exception ex) {
            if (session != null) {
                session.getTransaction().rollback();
            }
        }
        finally {
            if (session != null) {
                session.close();
            }
        }

        return person;
    }

    public List<Person> getAllPersons() {
        List<Person> persons = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            persons = session.createQuery("from Person p").list();
            session.getTransaction().commit();
        }
        catch (Exception ex) {
            if (session != null) {
                session.getTransaction().rollback();
            }
        }
        finally {
            if (session != null) {
                session.close();
            }
        }
        return persons;
    }

    public boolean savePerson(Person person) {
        Session session = null;
        boolean hasErrors = false;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.saveOrUpdate(person);
            session.getTransaction().commit();
        }
        catch (Exception ex) {
            if (session != null) {
                session.getTransaction().rollback();

            }
            hasErrors = true;
        }
        finally {
            if (session != null) {
                session.close();
            }
        }
        return hasErrors;
    }
}
