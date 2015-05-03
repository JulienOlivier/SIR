package fr.istic.master1.SIR_tp4_NoSQL_mongodb;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;

/**
 * Hello world!
 *
 */
public class mainMongoDB {
	public static void main( String[] args ) throws UnknownHostException {
		Morphia morphia = new Morphia();
		Mongo mongo = new Mongo();
		morphia.map(Person.class).map(Address.class);
		Datastore ds = morphia.createDatastore(mongo, "my_database");

		mainMongoDB app = new mainMongoDB();
		
		List<Address> addressPers1 = new ArrayList<Address>();
		addressPers1.add(app.createAddress(ds, "rue 1", "Ville 1", "10000", "PAYS 1"));
		addressPers1.add(app.createAddress(ds, "rue 2", "Ville 1", "10000", "PAYS 1"));
		
		Person pers1 = app.createPerson(ds, addressPers1, "TITI");
		
		Person pers2 = app.createPerson(ds, null, "TOTO");
		
		List<Person> listPers = new ArrayList<Person>();
		listPers.add(pers1);
		listPers.add(pers2);
		app.createArticle(ds, listPers, "Le cours de SIR", 3);
		
		//Print JAVA
		for(Person e : ds.find(Person.class)){
			System.out.println(e.getName());
		}
		//Print CONSOLE
		/*
		 * use my_database
		 * db.Person.find()
		 * db.Address.find()
		 */
	}

	/**
	 * Creation d'un article dans la base
	 * @param ds
	 * @param listPers
	 * @param nomArticle
	 * @param note
	 * @return
	 */
	public Article createArticle(Datastore ds, List<Person> listPers, String nomArticle, int note){
		Article article = new Article();
		article.setName(nomArticle);
		article.setStars(note);
		article.setBuyers(listPers);
		ds.save(article);
		return article;
	}

	/**
	 * Creation d'une personne dans la base
	 * @param ds
	 * @param addressPers1
	 * @param nomPersonne
	 * @return
	 */
	public Person createPerson(Datastore ds, List<Address> addressPers1, String nomPersonne){
		Person p = new Person();
		p.setName(nomPersonne);
		p.setAddress(addressPers1);
		ds.save(p);
		return p;
	}

	/**
	 * Creation d'une adresse dans la base
	 * @param ds
	 * @param nomRue
	 * @param nomVille
	 * @param codePostal
	 * @param nomPays
	 * @return
	 */
	public Address createAddress(Datastore ds, String nomRue, String nomVille, String codePostal, String nomPays){
		Address address = new Address();
		address.setStreet(nomRue);
		address.setCity(nomVille);
		address.setPostCode(codePostal);
		address.setCountry(nomPays);
		ds.save(address);
		return address;
	}
}
