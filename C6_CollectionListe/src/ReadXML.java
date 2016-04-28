import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

import dd.produit.Alimentaire;
import dd.produit.Consomable;
import dd.stock.StockArrayList;

public class ReadXML {

	public void creerStock(File f) {
		String line = "";
		FileReader file = null;
		StockArrayList stockCree = null;
		try {
			file = new FileReader(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		LineNumberReader resLecture = new LineNumberReader(file);
		try {
			line = resLecture.readLine();
			while (line != null) {
				// chercher les bonnes valeur et créer mon objet
				if (line.contains("<StockArrayList ")) {
					stockCree = new StockArrayList();
					String nomStock = extraitAtt(line, "nomStock='");
					stockCree.setNomDuStock(nomStock);

				} else if (line.contains("<Alimentaire ")) {
					String nomA = extraitAtt(line, "nom='");
					String poidsA = extraitAtt(line, "poids='");
					String prixUA = extraitAtt(line, "prixUnitaire='");
					Alimentaire a = new Alimentaire(nomA, Float.valueOf(poidsA), Float.valueOf(prixUA));
					stockCree.add(a);
				} else if (line.contains("<Consommable'")) {
					String nomC = extraitAtt(line, "nom='");
					String qteC = extraitAtt(line, "qte='");
					String prixUC = extraitAtt(line, "prixUnitaire='");
					Consomable c = new Consomable(nomC, Integer.valueOf(qteC), Float.valueOf(prixUC));
					stockCree.add(c);
				} else if (line.contains("</StockArrayList>")) {

				}

				line = resLecture.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String extraitAtt(String line, String ch) {
		String newLine = line.replace("\"", "'");

		String res = "";
		int deb = newLine.indexOf(ch);
		int fin = newLine.indexOf("'", deb + ch.length());
		res = line.substring(deb + ch.length(), fin);
		return res;
	}
}
