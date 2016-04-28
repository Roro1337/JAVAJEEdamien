package dd.stock;

import java.util.ArrayList;

import dd.produit.Produit;

public class PaStock {

	private ArrayList<Produit> monStock;

	public PaStock() {
		monStock = new ArrayList<Produit>();
	}

	public ArrayList<Produit> getMonStock() {
		return monStock;
	}

	public void setMonStock(ArrayList<Produit> monStock) {
		this.monStock = monStock;
	}
}
