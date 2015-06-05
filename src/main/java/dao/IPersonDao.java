package dao;

import model.Person;
import java.util.List;

/**
 * Created by melnikov on 02.06.2015.
 */
public interface IPersonDao {

    public void addPerson(Person person);


    public void updatePerson(Person person);


    public void deletePerson(Person person);


    public Person getPersonById(int id);


    public List<Person> getProducts();
}
