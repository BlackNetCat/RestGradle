package services;

/**
 * Created by netcat on 31.05.2015.
 */
import dao.PersonDao;
import model.Person;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.*;

@Path("/")
public class PersonService {

    private PersonDao personDao = new PersonDao();

    @GET
    @Path("/getPersonByIdXML/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Person getPersonByIdXML(@PathParam("id")int id) {
        return personDao.getPersonById(id);
    }

    @GET
    @Path("/getPersonByIdJSON/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonByIdJSON(@PathParam("id")int id) {
        return personDao.getPersonById(id);
    }

    @GET
    @Path("/getAllPersonByInXML")
    @Produces(MediaType.APPLICATION_XML)
    public List<Person> getAllPersonInXML() {
        return personDao.getAllPersons();
    }

    @GET
    @Path("/getAllPersonByInJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPersonInJSON() {
        return personDao.getAllPersons();
    }


    @GET
    @Path("/savePerson/{fullName}/{age}")
    @Produces(MediaType.APPLICATION_JSON)
    public String savePerson(@PathParam("fullName") String fullName, @PathParam("age") int age ) {
        Person person = new Person();
        person.setFullName(fullName);
        person.setAge(age);

        if (!personDao.savePerson(person)) {
            return "{\"status\":\"ok\"}";
        }
        else {
            return "{\"status\":\"not ok\"}";
        }

    }


    @GET
    @Path ("/savePerson/{id}/{fullName}/{age}")
    @Produces(MediaType.APPLICATION_JSON)
    public String updatePerson(@PathParam("id") int id, @PathParam("fullName") String fullName, @PathParam("age") int age) {
        Person person = new Person();
        person.setId(id);
        person.setFullName(fullName);
        person.setAge(age);

        if (!personDao.savePerson(person)) {
            return "{\"status\":\"ok\"}";
        }
        else {
            return "{\"status\":\"not ok\"}";
        }

    }


}