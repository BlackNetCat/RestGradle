
package demo;

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
public class HelloWorld {

    /*private static Map<Integer, Person> persons = new HashMap<Integer, Person>();


    static {
        for( int i = 0; i < 10; i ++){
            Person person = new Person();
            int id = i + 1;
            person.setId(id);
            person.setFullName("My Name" + id);
            person.setAge(new Random().nextInt(40) + 1);

            persons.put(id, person);
        }
    }*/
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

    @Inject
    HelloService helloService;


    @GET
    @Path("json")
    @Produces({ "application/json" })
    public JsonObject getHelloWorldJSON() {
        return Json.createObjectBuilder()
                .add("result", helloService.createHelloMessage("Alex"))
                .build();
    }


    @GET
    @Path("xml")
    @Produces({ "application/xml" })
    public String getHelloWorldXML() {
        return "<xml><result>" + helloService.createHelloMessage("Alex") + "</result></xml>";
    }

}