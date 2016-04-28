package dd.metier;

public class Pile {

	public static int NB_MAX = 10;
	private int[] p;
	private int sp;

	public Pile(int taille) {

		NB_MAX = taille;
		this.p = new int[taille];
		this.sp = -1;
	}

	public Pile() {
		this(NB_MAX);
	}

	public boolean estVide() {
		boolean bool = false;
		if (sp == -1) {
			bool = true;
		}
		return bool;
	}

	public boolean estPlein() {
		boolean bool = false;
		if (sp >= NB_MAX) {
			bool = true;
		}
		return bool;
	}

	public void empiler(int val) throws PilePleineException, ArrayIndexOutOfBoundsException {
		if (this.estPlein()) {
			throw new PilePleineException();
		}
		this.sp++;
		this.p[this.sp] = val;
	}

	public int depiler() throws PileVideException {
		if (this.estVide()) {
			throw new PileVideException();
		}
		this.sp--;
		return p[sp + 1];
	}

	public int[] getP() {
		return p;
	}

	public int returnValPile(int ind) {
		return this.p[ind];
	}

	public void setP(int[] p) {
		this.p = p;
	}

	public int getSp() {
		return sp;
	}

	public void setSp(int sp) {
		this.sp = sp;
	}

}
