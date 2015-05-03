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

import fr.istic.master1.SIR.tp.client.PersonService;
import fr.istic.master1.SIR.tp.shared.House;
import fr.istic.master1.SIR.tp.shared.Person;

@Path("/house")
public class PersonServiceImpl implements PersonService {

	EntityManager em;
	
	public PersonServiceImpl(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		em = factory.createEntityManager();
	}
	
	@POST
	@Path("/createPerson/{person}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void createPerson(@PathParam("person") Person p) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(p);
		t.commit();
	}

	@GET
	@Path("/getAllPerson")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> getAllPerson() {
		List<Person> listP = new ArrayList<Person>();
		Person p = em.find(Person.class, 0);
		for(int id = 1; p != null; id++){
			listP.add(p);
			p = em.find(Person.class, id);
		}
		return listP;
	}

	@GET
	@Path("/getPersonById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Person getPersonById(@PathParam("id") long id) {
		return em.find(Person.class, id);
	}

	@GET
	@Path("/getAllHouse/{person}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<House> getAllHouseByPerson(@PathParam("person") Person p) {
		if(em.find(Person.class, p.getId()) != null){
			return em.createQuery("select homes from Person where id=" + p.getId()).getResultList();
		}
		return null;
	}

	@GET
	@Path("/getHouseById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public House getHouseById(@PathParam("id") long id) {
		return em.find(House.class, id);
	}

	@DELETE
	@Path("/deletePerson/{person}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deletePerson(@PathParam("person") Person p) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.remove(em.find(Person.class, p));
		t.commit();
	}

	@DELETE
	@Path("/deleteHouse/{person}/{house}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteHouse(@PathParam("person") Person p, @PathParam("house") House h) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		p.removeHome(h);
		em.persist(p);
		t.commit();
	}

	@PUT
	@Path("/addHouse/{person}/{house}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addHouse(@PathParam("person") Person p, @PathParam("house") House h) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		p.addHomes(h);
		em.persist(p);
		t.commit();
	}
}
