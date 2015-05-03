package fr.istic.master1.SIR.tp.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import fr.istic.master1.SIR.tp.shared.House;
import fr.istic.master1.SIR.tp.shared.Person;

@RemoteServiceRelativePath("person")
public interface PersonService extends RemoteService{
	public void createPerson(Person p);
	public List<Person> getAllPerson();
	public Person getPersonById(long id);
	public List<House> getAllHouseByPerson(Person p);
	public House getHouseById(long id);
	public void deletePerson(Person p);
	public void deleteHouse(Person p, House h);
	public void addHouse(Person p, House h);
}
