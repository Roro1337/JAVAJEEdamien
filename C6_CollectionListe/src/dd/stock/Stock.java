package dd.stock;

import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import dd.produit.Produit;

public class Stock extends TreeMap<String, Produit> {

	@Override
	public String toString() {
		String chaine = "";
		Set<Entry<String, Produit>> set = this.entrySet();
		for (Entry<String, Produit> entry : set) {
			//System.out.println(entry.getValue().getNom() + ", ");
			// équivalent à condition de la convention nom = clé
			// System.out.println(entry.getKey()+", ");
			chaine += entry.getValue().getNom()+", ";
		}

		return chaine;
	}

}
