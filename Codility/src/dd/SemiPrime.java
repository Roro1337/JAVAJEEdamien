package dd;

import java.util.ArrayList;
import java.util.Collections;

public class SemiPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SemiPrime sp = new SemiPrime();
		sp.init();

	}

	public void init() {
		int[] pIn = { 1, 4, 16 };
		int[] qIn = { 26, 10, 20 };
		int N = 26;
		int[] resTab = solution(N, pIn, qIn);
		for (int i = 0; i < resTab.length; i++) {
			System.out.println(resTab[i]);
		}

	}

	public int[] solution(int N, int[] P, int[] Q) {
		int m = P.length;
		int[] resTab = new int[m];
		ArrayList<Integer> primeList = new ArrayList<Integer>();
		ArrayList<Integer> semiPrimeList = new ArrayList<Integer>();
		System.out.println("------Prime------");
		primeList.add(1);
		System.out.print(1 + ",");
		primeList.add(2);
		System.out.print(2 + ",");
		for (int i = 3; i <= N; i += 2) {
			if (isPrimeNumber(i)) {
				primeList.add(i);
				System.out.print(i + ",");
			}
		}

		System.out.println(" ");
		System.out.println("------semiPrime------");
		for (int i = 1; i < primeList.size(); i++) {
			for (int j = i; j < primeList.size(); j++) {
				if (primeList.get(i) * primeList.get(j) <= N) {
					semiPrimeList.add(primeList.get(i) * primeList.get(j));
				}

			}
		}

		Collections.sort(semiPrimeList);
		for (Integer i : semiPrimeList) {
			System.out.print(i + ",");
		}
		System.out.println();
		for (int i = 0; i < m; i++) {
			for (Integer sP : semiPrimeList) {
				if (sP >= P[i] && sP <= Q[i]) {
					resTab[i]++;
				}
			}
		}
		return resTab;

	}

	public boolean isPrimeNumber(int i) {
		boolean res = true;
		int j = 2;
		while (j < i) {
			if (i % j == 0) {
				res = false;
				break;
			}
			j++;
		}
		return res;
	}

}
