package dd.metier;

import dd.stock.StockArrayList;

public class Commercant {

	private String nomDucommercant;
	private StockArrayList monStock;

	public Commercant() {
		monStock = new StockArrayList();
	}

	public Commercant(String nom) {
		setNomDucommercant(nom);
		monStock = new StockArrayList();
	}

	public Commercant(float f) {
		monStock = new StockArrayList();
		monStock.setLimitePrix(f);
	}

	public StockArrayList getMonStock() {
		return monStock;
	}

	public void setMonStock(StockArrayList monStock) {
		this.monStock = monStock;
	}

	public Commercant(String nom, float limite) {
		setNomDucommercant(nomDucommercant);
		monStock = new StockArrayList();
		monStock.setLimitePrix(limite);
	}

	public String getNomDucommercant() {
		return nomDucommercant;
	}

	public void setNomDucommercant(String nomDucommercant) {
		this.nomDucommercant = nomDucommercant;
	}

}
