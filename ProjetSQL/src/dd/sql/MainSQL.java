package dd.sql;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.Node;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import dd.metier.Formation;
import dd.metier.ListeFormation;

public class MainSQL {
	public static void main(String[] args) {
		MainSQL m = new MainSQL();
		// m.create();
		// m.insert();
		m.init();
	}

	public void init() {
		// ListeFormation listeFormation = lectureDom();
		// insertFormation(listeFormation);
		// listeFormation.clear();
		// listeFormation = selectFormations();
		selectFormations();
	}

	private ListeFormation selectFormations() {
		ListeFormation listeFormation = new ListeFormation();
		Connection con = null;
		ResultSet res = null;
		Statement statment = null;
		String requete = "";
		String login = "Active";
		String password = "VDDMichel";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String urlBDD = "jdbc:mysql://www.psyeval.fr/bddCV";
		try {
			con = DriverManager.getConnection(urlBDD, login, password);
			statment = con.createStatement();
			requete = "SELECT * FROM formation;";
			statment.executeQuery(requete);
			// récupération du résultat de executeQuery(requete)
			// cad toutes les lignes de formation res.first() pointe sur la
			// premiere ligne de la table formation
			res = statment.getResultSet();
			boolean encore = res.first();
			while (encore) {
				// getString(columIndex);
				String id = res.getString(1);
				String date = res.getString("dateFormation");
				String lieu = res.getString("lieuFormation");
				String domaine = res.getString("domaineFormation");
				System.out.println(id + " " + date + " " + lieu + " " + domaine);
				encore = res.next();
				Formation formation = new Formation(date, lieu, domaine);
				listeFormation.add(formation);
				encore = res.next();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statment.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return listeFormation;
	}

	private void insert() {
		Connection con = null;
		ResultSet res = null;
		Statement statment = null;
		String requete = "";

		String login = "root";
		String password = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String urlBDD = "jdbc:mysql://localhost/bddCV";
		try {
			con = DriverManager.getConnection(urlBDD, login, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		requete = "INSERT INTO etudiant" + //
				"(nom,prenom,metier,mail)" + //
				"VALUES (" + //
				"'Damien'," + //
				"'Dufourcq'," + //
				"'Ingenieur Statisticien'," + //
				"'damien.concept@gmail.com'" + //
				");";
		try {
			statment = con.createStatement();
			statment.execute(requete);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			statment.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void create() {
		Connection con = null;
		ResultSet res = null;
		Statement statment = null;
		String requete = "";

		String login = "root";
		String password = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String urlBDD = "jdbc:mysql://localhost/bddCV";
		try {
			con = DriverManager.getConnection(urlBDD, login, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		requete = "CREATE TABLE etudiant" + //
				"(id INT NOT NULL PRIMARY KEY," + //
				"nom VARCHAR(30)," + //
				"prenom VARCHAR(30)," + //
				"metier VARCHAR(30)," + //
				"mail VARCHAR(30)" + //
				");";
		try {
			statment = con.createStatement();
			statment.execute(requete);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			statment.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ListeFormation lectureDom() {
		ListeFormation listeFormation = new ListeFormation();
		File fLecture = new File("xml/listeFormation.xml");
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder documentBuilder = factory.newDocumentBuilder();
			Document document = documentBuilder.parse(fLecture);

			Element racine = document.getDocumentElement();
			NodeList list = racine.getChildNodes();
			int nbList = list.getLength();
			for (int i = 0; i < nbList; i++) {
				if (list.item(i).getNodeType() == Node.ELEMENT_NODE) {
					Element eFormation = (Element) list.item(i);
					String date = eFormation.getAttribute("dateFormation");
					String lieu = eFormation.getAttribute("lieuFormation");
					String domaine = eFormation.getAttribute("domaineFormation");
					Formation formation = new Formation(date, lieu, domaine);
					listeFormation.add(formation);
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listeFormation;
	}

	private void insertFormation(ListeFormation listeFormation) {
		Connection con = null;
		ResultSet res = null;
		Statement statment = null;
		String requete = "";

		String login = "root";
		String password = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String urlBDD = "jdbc:mysql://localhost/bddCV";
		try {
			con = DriverManager.getConnection(urlBDD, login, password);
			statment = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (Formation formation : listeFormation) {
			requete = "INSERT INTO formation" + //
					"(dateFormation,lieuFormation,domaineFormation)" + //
					"VALUES ('" + //
					formation.getDateFormation() + "','" + //
					formation.getLieuFormation() + "','" + //
					formation.getDomaineFormation() + "');";
			try {
				statment.execute(requete);

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		try {
			statment.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
