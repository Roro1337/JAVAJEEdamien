import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import dd.metier.Marchand;
import dd.produit.Alimentaire;
import dd.produit.Consomable;
import dd.produit.Produit;
import dd.stock.Stock;
import dd.stock.StockArrayList;

public class ProjetMarchand {

	public static void main(String[] args) {
		ProjetMarchand m = new ProjetMarchand();
		m.fillStockByUser();
	}

	public void recup() {
		File file = new File("alimentair.ser");
		ObjectInputStream objIn = null;

		try {
			objIn = new ObjectInputStream(new FileInputStream(file));
			Stock alimentaire = (Stock) objIn.readObject();
			System.out.println(alimentaire.toString());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveStock(StockArrayList s) {

		File fileAlimentaire = new File("alimentaire.ser");
		ObjectOutputStream obj = null;
		try {
			obj = new ObjectOutputStream(new FileOutputStream(fileAlimentaire));
			// SERIALIZATION
			obj.writeObject(s);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				obj.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void save() {
		Alimentaire alim = new Alimentaire("bannane", 12, 2);
		File fileAlimentaire = new File("alimentaire.ser");
		ObjectOutputStream obj = null;
		try {
			obj = new ObjectOutputStream(new FileOutputStream(fileAlimentaire));
			obj.writeObject(alim);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				obj.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void fillStockByUser() {

		// lire le nom, le type,le poids/qte, et prixUnit de l'objet
		// si lenom = "" sortir du programme

		InputStreamReader entreeStandard = new InputStreamReader(System.in);
		LineNumberReader resLecture = new LineNumberReader(entreeStandard);

		String nom = null;
		String type = null;
		String poids = null;
		String prixUnitaire = null;
		StockArrayList monStock = new StockArrayList();
		Produit prodSpe = null;

		try {
			System.out.println("nom:");
			nom = resLecture.readLine();

			while (!nom.equals("")) {

				// System.out.println("nom:");
				// nom = resLecture.readLine();
				System.out.println("type? a alimentaire c consommable:");
				type = resLecture.readLine();
				if (type.toLowerCase().equals("a")) {
					System.out.println("poids:");
					poids = resLecture.readLine();
					System.out.println("prixUnitaire:");
					prixUnitaire = resLecture.readLine();
					prodSpe = new Alimentaire(nom, Float.parseFloat(poids), Float.parseFloat(prixUnitaire));

				} else {
					System.out.println("quantité:");
					poids = resLecture.readLine();
					System.out.println("prixUnitaire:");
					prixUnitaire = resLecture.readLine();
					prodSpe = new Consomable(nom, Integer.parseInt(prixUnitaire), Float.parseFloat(poids));
				}
				monStock.add(prodSpe);
				System.out.println("nom:");
				nom = resLecture.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// affichage du stock
		System.out.println("--------------------Stock------------------------");
		for (Produit p : monStock) {
			System.out.println(p);
		}

	}

	private void saveMarchand() {
		Marchand m = new Marchand(0, 0, 200);
		m.setNomDucommercant("Robert");
		for (int i = 0; i < 10; i++) {
			m.getMonStock().add(new Alimentaire("Aliment " + i, 2, i + 1));
			m.getMonStockFamille().add(new Consomable("Consomable " + i, 2, i + 1));
			m.getMonStockPrive().add(new Alimentaire("Aliment " + i, 2, i + 1));
		}
		File fMarchand = new File("marchand.ser");
		ObjectOutputStream o = null;
		try {
			o = new ObjectOutputStream(new FileOutputStream(fMarchand));
			o.writeObject(m);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				o.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void init() {

		System.out.println(Produit.CPT);
		Alimentaire banane = new Alimentaire("Banane", 3.5f, 0.99f);
		Consomable enveloppe = new Consomable("Enveloppe", 50, 0.1f);
		Produit fraise = new Alimentaire("Fraise", 0.5f, 2.99f);
		Alimentaire patate = new Alimentaire("Patate", 3.5f, 4.99f);
		Consomable dentifrice = new Consomable("Dentifrice", 50, 5.1f);
		Produit orange = new Alimentaire("Orange", 0.5f, 2.99f);
		Alimentaire banane2 = new Alimentaire("Banane", 12.3f, 1.03f);

		// introduction des listes
		ArrayList<Produit> stock = new ArrayList<Produit>();
		stock.add(banane);
		stock.add(enveloppe);
		stock.add(fraise);

		// remplace ces ligne qui instanci des tableaux de produit
		/*
		 * Produit[] stock = new Produit[100]; stock[0] = banane; stock[1] =
		 * enveloppe; stock[2] = fraise;
		 */

		// solution apres création de ma classe Stock: list de Produit
		// ArrayList<Produit>
		Marchand unMarchand = new Marchand();

		unMarchand.getMonStock().add(banane);
		unMarchand.getMonStock().add(fraise);
		unMarchand.getMonStock().add(enveloppe);

		unMarchand.getMonStockFamille().calculSomme();

		// Map <clé, objet>
		// ArrayList.add() treeMap.put()

		TreeMap<String, Produit> treeMap = new TreeMap<String, Produit>();
		if (treeMap.containsKey(banane.getNom())) {
			rajouteDansTreeMap(treeMap, banane2);
		}

		Set<Entry<String, Produit>> set = treeMap.entrySet();
		for (Entry<String, Produit> entry : set) {
			System.out.println(entry.getValue());

		}

		String toto = treeMap.toString();

		treeMap.put(banane.getNom(), banane);
		treeMap.put(fraise.getNom(), fraise);
		treeMap.put(enveloppe.getNom(), enveloppe);
		treeMap.put(patate.getNom(), patate);
		treeMap.put(orange.getNom(), orange);

		for (int i = 0; i < stock.size(); i++) {
			System.out.println(stock.get(i));
		}

	}

	private void rajouteDansTreeMap(TreeMap<String, Produit> treeMap, Produit banane2) {
		Produit produit = treeMap.get(banane2.getNom());
		produit.rajoute(banane2);

	}

}
