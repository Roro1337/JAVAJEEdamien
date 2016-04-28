package dd.metier;

import dd.stock.Stock;

public class Vendeur {

	private Stock stock;
	private Stock stockPrive;
	private Stock stockFamille;

	public void Vendeur() {
		this.stock = null;
		this.stockFamille = null;
		this.stockPrive = null;
	}

	public Stock getStockPrive() {
		return stockPrive;
	}

	public void setStockPrive(Stock stockPrive) {
		this.stockPrive = stockPrive;
	}

	public Stock getStockFamille() {
		return stockFamille;
	}

	public void setStockFamille(Stock stockFamille) {
		this.stockFamille = stockFamille;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Stock getStock() {
		return stock;
	}

}
