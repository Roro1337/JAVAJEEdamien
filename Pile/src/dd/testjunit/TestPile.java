package dd.testjunit;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import dd.metier.Pile;
import dd.metier.PilePleineException;

public class TestPile {

	Pile maTestPile;

	public void before() {
		maTestPile = new Pile();
	}

	@Test
	public void test() {

		int[] A = { 2, 5, 4, 1, 6, 8, 2, 3, 7, 4, 1, 2 };
		// int reponse = maTestPile.??(?,?);
		// assertEquals(8, reponse);

	}

	@Test
	public void testEstVide() {

		int monSp = -1;
		maTestPile.setSp(monSp);
		assertTrue(maTestPile.estVide());
		maTestPile.setSp(0);
		assertFalse(maTestPile.estVide());
		maTestPile.setSp(9);
		assertFalse(maTestPile.estVide());
		// int reponse = maTestPile.??(?,?);
		// assertEquals(8, reponse);

	}

	@Test
	// test constructeur
	public void testPile() {

		Pile p = new Pile();

		assertEquals(-1, p.getSp());
		assertNotNull(p.getP());
		assertEquals(10, p.getP().length);

	}

	public void testEmpile() {

		int[] tab = { 2, 5, 4, 1, 6, 8, 2, 3, 7, 4, 1, 2 };
		maTestPile.setP(tab);
		maTestPile.setSp(-1);

		try {
			maTestPile.empiler(50);
		} catch (ArrayIndexOutOfBoundsException | PilePleineException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		int[] tabRes = { 50, 5, 4, 1, 6, 8, 2, 3, 7, 4, 1, 2 };
		assertArrayEquals(tabRes, maTestPile.getP());
		assertEquals(0, maTestPile.getSp());

	}

}
