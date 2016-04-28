package dd.PassingCars;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestPassingCars {

	MainPassingCars mainPassingCars;

	@Before
	public void before() {
		mainPassingCars = new MainPassingCars();
	}

	@Test
	public void test() {

		int[] A = { 0, 1, 0, 1, 1 };
		int reponse = mainPassingCars.solution(A);
		assertEquals(5, reponse);

	}

	@Test
	public void random() {

		int[] A = new int[100];

		for (int i = 0; i < A.length; i++) {
			A[i] = (int) Math.random();
		}

		int reponse = mainPassingCars.solution2(A);
		int reponseTrue = mainPassingCars.solution(A);
		assertEquals(reponseTrue, reponse);

	}

}
