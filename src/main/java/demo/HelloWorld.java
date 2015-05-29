
package demo;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
public class HelloWorld {
    @Inject
    HelloService helloService;


    @GET
    @Path("json")
    @Produces({ "application/json" })
    public JsonObject getHelloWorldJSON() {
        return Json.createObjectBuilder()
                .add("result", helloService.createHelloMessage("World"))
                .build();
    }


    @GET
    @Path("xml")
    @Produces({ "application/xml" })
    public String getHelloWorldXML() {
        return "<xml><result>" + helloService.createHelloMessage("World") + "</result></xml>";
    }

}