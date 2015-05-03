package fr.istic.master1.SIR.tp.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import fr.istic.master1.SIR.tp.shared.House;
import fr.istic.master1.SIR.tp.shared.Person;

public interface PersonServiceAsync {

	void createPerson(Person p, AsyncCallback<Void> callback);

	void getAllPerson(AsyncCallback<List<Person>> callback);

	void getPersonById(long id, AsyncCallback<Person> callback);

	void getAllHouseByPerson(Person p, AsyncCallback<List<House>> callback);

	void getHouseById(long id, AsyncCallback<House> callback);

	void deletePerson(Person p, AsyncCallback<Void> callback);

	void deleteHouse(Person p, House h, AsyncCallback<Void> callback);

	void addHouse(Person p, House h, AsyncCallback<Void> callback);

}
