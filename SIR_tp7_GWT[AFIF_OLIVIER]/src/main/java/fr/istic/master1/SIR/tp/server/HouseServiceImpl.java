package fr.istic.master1.SIR.tp.server;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.istic.master1.SIR.tp.client.HouseService;
import fr.istic.master1.SIR.tp.shared.Address;
import fr.istic.master1.SIR.tp.shared.House;
import fr.istic.master1.SIR.tp.shared.Person;
import fr.istic.master1.SIR.tp.shared.SmartDevice;

/*
 * AIDE Integration JSON
 */
@Path("/house")
public class HouseServiceImpl implements HouseService {

	EntityManager em;
	
	public HouseServiceImpl(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		em = factory.createEntityManager();
	}
	
	@POST
	@Path("/createHouse/{house}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void createHouse(@PathParam("house") House h) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(h);
		t.commit();
	}
	
	@GET
	@Path("/getAllHouse")
	@Produces(MediaType.APPLICATION_JSON)
	public List<House> getAllHouse() {
		List<House> listP = new ArrayList<House>();
		House p = em.find(House.class, 0);
		for(int id = 1; p != null; id++){
			listP.add(p);
			p = em.find(House.class, id);
		}
		return listP;
	}
	
	@GET
	@Path("/listSmartDevice/{house}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<SmartDevice> getAllSmartDevice(@PathParam("house") House h) {
		if(em.find(House.class, h.getId()) != null){
			return em.createQuery("select SmartDevice from House where id=" + h.getId()).getResultList();
		}
		return null;
	}

	@GET
	@Path("/listSmartDevice/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public SmartDevice getSmartDeviceById(@PathParam("id") long id) {
		return em.find(SmartDevice.class, id);
	}

	@GET
	@Path("/address/{house}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Address getAddress(@PathParam("house") House h) {
		return em.find(House.class, h).getAdresse();
	}

	@DELETE
	@Path("/deleteSmartDevice/{house}/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteSmartDevice(@PathParam("house") House h, @PathParam("id") long idSmartDevice) {
		EntityTransaction t = em.getTransaction();
		h.removeSmartDevice(em.find(SmartDevice.class, idSmartDevice));
		t.begin();
		em.persist(h);
		t.commit();
	}

	@PUT
	@Path("/addSmartDevice/{house}/{smartdevice}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addSmartDevice(@PathParam("house") House h, @PathParam("smartdevice") SmartDevice s) {
		EntityTransaction t = em.getTransaction();
		h.addSmartDevice(s);
		t.begin();
		em.persist(h);
		t.commit();
	}

	@PUT
	@Path("/addAddress/{house}/{address}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addAddress(@PathParam("house") House h, @PathParam("address") String address) {
		EntityTransaction t = em.getTransaction();
		h.setAdresse(address);
		t.begin();
		em.persist(h);
		t.commit();
	}
}
