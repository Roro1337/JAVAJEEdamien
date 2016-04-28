package dd.stock;

import java.io.Serializable;
import java.util.ArrayList;

import dd.produit.Alimentaire;
import dd.produit.Consomable;
import dd.produit.Produit;

public class StockArrayList extends ArrayList<Produit> implements Serializable {

	private static final long serialVersionUID = 1L;

	public static int NUM_STOCK;

	private String nomDuStock;
	private float limitePrix;
	private float prixTotalStock;

	public StockArrayList() {
		nomDuStock = "stock" + Integer.toString(NUM_STOCK);
		limitePrix = 100f;
		prixTotalStock = 0;
		NUM_STOCK++;
	}

	public StockArrayList(String nomDuStock) {
		this.nomDuStock = nomDuStock;
		limitePrix = 100f;
		prixTotalStock = 0;
		NUM_STOCK++;
	}

	public StockArrayList(String nomDuStock, float lim) {
		this.nomDuStock = nomDuStock;
		this.limitePrix = lim;

		prixTotalStock = 0;
		NUM_STOCK++;
	}

	public void setLimitePrix(float limitePrix) {
		this.limitePrix = limitePrix;
		if (limitePrix == 0) {
			this.limitePrix = Float.POSITIVE_INFINITY;
		}
	}

	public String getNomDuStock() {
		return nomDuStock;
	}

	public void setNomDuStock(String nomDuStock) {
		this.nomDuStock = nomDuStock;
	}

	public float getLimitePrix() {
		return limitePrix;
	}

	@Override
	public void add(int index, Produit element) {
		float sum = /* calculSomme() */this.prixTotalStock + element.getPrix();
		if (sum <= limitePrix || limitePrix == 0) {
			super.add(index, element);
			this.prixTotalStock = sum;
		}
	}

	@Override
	public boolean add(Produit e) {
		boolean added = false;
		float sum = /* calculSomme() */this.prixTotalStock + e.getPrix();
		if (sum <= limitePrix || limitePrix == 0) {
			if (contains(e)) {
				Produit prodExist = get(indexOf(e));
				prodExist.rajoute(e);
			} else {
				super.add(e);
			}
		}
		this.prixTotalStock = sum;
		return added;
	}

	private Produit rechercheProd(Produit e) {
		Produit prodRech = null;
		for (Produit produit : this) {
			if (produit.getNom().equals(e.getNom())) {
				if (produit instanceof Alimentaire && e instanceof Alimentaire
						|| produit instanceof Consomable && e instanceof Consomable) {
					prodRech = produit;
					break;
				}
			}
		}
		return prodRech;
	}

	public float calculSomme() {
		float somme = 0;
		for (int i = 0; i < this.size(); i++) {
			somme += this.get(i).getPrix();
		}
		return somme;
	}

	@Override
	public Produit remove(int index) {
		// TODO Auto-generated method stub
		return super.remove(index);
	}

	@Override
	public boolean remove(Object o) {
		Produit e = (Produit) o;
		this.setPrixTotalStock(getPrixTotalStock() - e.getPrix());
		return super.remove(o);
	}

	public float getPrixTotalStock() {
		return prixTotalStock;
	}

	public void setPrixTotalStock(float prixTotalStock) {
		this.prixTotalStock = prixTotalStock;
	}

	@Override
	public boolean contains(Object o) {
		boolean bool = false;
		if (rechercheProd((Produit) o) != null) {
			bool = true;
		}
		return bool;
	}

	@Override
	public int indexOf(Object o) {
		int index = -1;
		for (int i = 0; i < this.size(); i++) {
			if (this.contains(o)) {
				index = i;
			}
		}
		return index;
	}

}
