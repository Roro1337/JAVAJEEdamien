package dd.metier;

public class MainPile {

	public static void main(String[] args) {
		MainPile mainPile = new MainPile();
		mainPile.init();

	}

	public void init() {

		Pile maPile = new Pile(3);
		try {
			for (int i = 0; i < maPile.getP().length + 200; i++) {

				maPile.empiler((int) (Math.random() * 10));

				System.out.println(maPile.getP()[i]);

			}
		} catch (PilePleineException e) {
			System.out.println(e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Erreur DA "+e.getMessage());
		}

	}

}
