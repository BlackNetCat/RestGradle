package services;

/**
 * Created by netcat on 31.05.2015.
 */
import classes.MethodResult;
import dao.PersonDao;
import lombok.extern.slf4j.Slf4j;
import model.Person;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;


@Slf4j
@Stateless
@Path("/person")
@Consumes({"application/json","application/xml"})
@Produces({"application/json","application/xml"})
public class PersonService {

    @Inject
    private PersonDao personDao;

    @GET
    @Path("/get/{id}")
    public Person getPersonById(@PathParam("id")int id) {
        return personDao.getPersonById(id);
    }

    @GET
    @Path("/get")
    public List<Person> getAllPersonInXML() {
        return personDao.getAllPersons();
    }

    @GET
    @Path("/getc")
    public List<Person> getAllPerson2() {
        return personDao.getCustom();
    }



    @POST
    @Path("/save")
    @Produces(MediaType.APPLICATION_JSON)
    public MethodResult savePerson(Person person ) {
        try {
            if (person.getId() != null) {
                Person personForUpdate = personDao.getPersonById(person.getId());
                if (personForUpdate !=null){
                    personForUpdate.setFullName(person.getFullName());
                    personForUpdate.setAge(person.getAge());
                } else {
                    person.setId(null);
                    personDao.persist(person);
                }
            } else {
                personDao.persist(person);
            }
        } catch (Exception e) {
            log.error("---Error saving person {} with error: {}", person, e.getMessage(), e);
            return new MethodResult("Exception: "+e.getMessage());
        }
        return new MethodResult("OK");
    }

    @DELETE
    @Path("/delete/{id}")
    public MethodResult deletePersonByIdJSON(@PathParam("id")int id) {
        try {
            personDao.deletePerson(id);
        } catch (Exception e) {
            log.error("---Error deleting person for id {} with error: {}", id, e.getMessage(), e);
            return new MethodResult("Exception: "+e.getMessage());
        }
        return new MethodResult("OK");
    }

}