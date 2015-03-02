package fr.istic.sir.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.istic.master1.SIR_tp3_SERVLET.Heater;
import fr.istic.master1.SIR_tp3_SERVLET.Home;

@Path("/hello")
public class SampleWebService {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello, how are you?";
    }
    
    @GET
    @Path("/home")
    @Produces(MediaType.APPLICATION_JSON)
    public Home getHome() {
        Home h = new Home();
        h.setAdresse("1 rue des Annanas");
        Heater h1 = new Heater();
        h1.setName("radiateur_couloir");
        Heater h2 = new Heater();
        h2.setName("radiateur_chambre1");
        h.addSmartDevice(h1);
        h.addSmartDevice(h2);
        return h;
    }
}