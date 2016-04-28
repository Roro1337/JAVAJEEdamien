package dd;

import java.util.ArrayList;

public class ChocolateNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChocolateNumbers cN = new ChocolateNumbers();
		cN.init();

	}

	public void init() {

		int N = 10;
		int M = 4;
		int sol = solution(N, M);
		System.out.println(sol);
	}

	public int solution(int N, int M) {
		int sol = 1;
		int chocNumb = 0;
		boolean wrapFull = true;
		ArrayList<Integer> chocoEatNum = new ArrayList<Integer>();
		chocoEatNum.add(chocNumb);
		while (wrapFull) {
			if (chocoEatNum.contains((chocNumb + M) % N)) {
				wrapFull = false;

			} else {
				chocNumb += M;
				sol++;
			}
		}
		return sol;
	}

}
