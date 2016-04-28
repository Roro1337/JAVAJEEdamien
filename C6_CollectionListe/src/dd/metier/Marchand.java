package dd.metier;

import java.io.Serializable;

import dd.stock.StockArrayList;

public class Marchand extends Commercant implements Serializable {

	private static final long serialVersionUID = 1L;
	// private PaStock fakeStock;
	private StockArrayList monStockPrive;
	private StockArrayList monStockFamille;

	public Marchand() {
		super();
		monStockPrive = new StockArrayList();
		monStockFamille = new StockArrayList();
	}

	public Marchand(float valStock, float valStockPriv, float valStockFam) {
		super(valStock);
		monStockPrive = new StockArrayList();
		monStockFamille = new StockArrayList();

	}

	public StockArrayList getMonStockPrive() {
		return monStockPrive;
	}

	public void setMonStockPrive(StockArrayList monStockPrive) {
		this.monStockPrive = monStockPrive;
	}

	public StockArrayList getMonStockFamille() {
		return monStockFamille;
	}

	public void setMonStockFamille(StockArrayList monStockFamille) {
		this.monStockFamille = monStockFamille;
	}

	public Marchand(String nom) {
		super(nom);
		monStockPrive = new StockArrayList();
		monStockFamille = new StockArrayList();

	}

}
