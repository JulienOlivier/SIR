package fr.istic.master1.SIR_tp3_SERVLET;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
public class App {
	private EntityManager manager;
	Home hp1 = new Home();
	Home hp12 = new Home();
	Home hp2 = new Home();
	Person p1 = new Person();
	Person p2 = new Person();
	Person p3 = new Person();
	//CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
	/*CriteriaQuery<Integer.class> query = criteriaBuilder.createQuery(Integer.class);
CriteriaQuery<Integer.class> query = criteriaBuilder.createQuery(Integer.class);
Root<B.class> from = query.from(Bean.class);
query.select(from.get("a"))
.where(from.get("a").in(1, 2, 3, 4));
	 */
	public App(EntityManager manager) {
		this.manager = manager;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("example");
		EntityManager manager = factory.createEntityManager();
		App test = new App(manager);
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		test.createDB();
		tx.commit();
		// TODO run request
		tx.begin();
		test.listHome();
		tx.commit();
		manager.close();
		System.out.println(".. done");
	}
	private void createDB(){
		List<Home> listHome = new ArrayList<Home>();
		listHome.add(hp1);
		listHome.add(hp12);
		p1.setHomes(listHome);
		List<Home> listHome2 = new ArrayList<Home>();
		listHome2.add(hp2);
		p2.setHomes(listHome2);
		manager.persist(hp1);
		manager.persist(hp12);
		manager.persist(hp2);
		manager.persist(p1);
		manager.persist(p2);
		manager.persist(p3);
	}
	private void listHome(){
		List<Person> listPersonne = manager.createQuery("Select h From Person h", Person.class).getResultList();
		System.out.println("nb ligne : "+listPersonne.size());
		for(Person next : listPersonne)
			System.out.println("-> "+next.getId());
		System.out.println("*****************************");
		List<Home> listHome = manager.createQuery("Select h From Home h", Home.class).getResultList();
		System.out.println("nb ligne : "+listHome.size());
		for(Home next : listHome)
			System.out.println("-> "+next.getId());
	}
}