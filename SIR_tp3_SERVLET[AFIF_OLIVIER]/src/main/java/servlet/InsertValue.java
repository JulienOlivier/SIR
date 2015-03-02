package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.istic.master1.SIR_tp3_SERVLET.Person;

@WebServlet(name="insertvalue", urlPatterns={"/InsertValue"})
public class InsertValue extends HttpServlet {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("example");
	EntityManager manager = factory.createEntityManager();
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            
        PrintWriter p = new PrintWriter(resp.getOutputStream());
        p.print("Hello world SIR");
        p.flush();
        
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String nom = req.getParameter("nom");
    	String prenom = req.getParameter("prenom");
    	String genre = req.getParameter("genre");
    	String dateNaissance = req.getParameter("datenaissance");
    	String profilFacebook = req.getParameter("profilfacebook");
    	String mail = req.getParameter("mail");
    	EntityTransaction tx = manager.getTransaction();
		tx.begin();
		this.insertValue(nom, prenom, genre, dateNaissance, profilFacebook, mail);
		tx.commit();
		
		PrintWriter out = resp.getWriter();
		out.println("DONE");
		out.close();
	}

	private void insertValue(String nom, String prenom, String genre, String dateNaissance, String profilFacebook, String mail){
		// TODO Auto-generated method stub
		
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		Person pers = new Person();
		try {
			pers.setDateNaissance(convertJavaDateToSqlDate(formatter.parse(dateNaissance)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pers.setGenre((genre == "homme"));
		pers.setMail(mail);
		pers.setNom(nom);
		pers.setPrenom(prenom);
		pers.setProfilFacebook(profilFacebook);
	}
	public java.sql.Date convertJavaDateToSqlDate(java.util.Date date) {
		return new java.sql.Date(date.getTime());
	}
}
