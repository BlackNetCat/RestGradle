package dao;

import model.Address;
import model.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PersonDao {

    @PersistenceContext(unitName = "Persons")
    private EntityManager em;

    public void persist(Object entity){
        em.persist(entity);
    }

    public Person getPersonById(int id) {
        return em.find(Person.class, id);
    }

    public List<Person> getCustom() {
        String q = "select p.fullName, a.city from Person p join Address a on a.person.id = p.id";
        return em.createQuery(q,Person.class).getResultList();
    }

    public List<Person> getAllPersons() {
        String q = "SELECT p FROM Person p";
        return em.createQuery(q,Person.class).getResultList();
    }

    public void deletePerson(int id) {
        String q = "DELETE FROM Person p WHERE p.id = ?1";
        em.createQuery(q).setParameter(1, id).executeUpdate();
    }
}
