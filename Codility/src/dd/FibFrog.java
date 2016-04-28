package dd;

import java.util.ArrayList;

public class FibFrog {

	// you can also use imports, for example:

	// you can write to stdout for debugging purposes, e.g.
	// System.out.println("this is a debug message");
	public int solution(int[] A) {
		int res = 0;
		int posFrog = -1;
		if (A.length <= 1) {
			res = -1;
		} else {
			ArrayList<Integer> fibSeq = new ArrayList<>();
			boolean nReach = false;
			int indArr = 2;
			fibSeq.add(1);
			fibSeq.add(2);
			while (!nReach) {
				fibSeq.add(fibSeq.get(indArr - 1) + fibSeq.get(indArr - 2));
				if (fibSeq.get(indArr) >= A.length) {
					nReach = true;
				}
				indArr++;
			}
			// Collections.reverseOrder(fibSeq);
			nReach = false;
			while (!nReach) {
				for (Integer i : fibSeq) {
					if (i == A.length - posFrog + 1) {
						nReach = true;
						res++;
						break;
					} else {
						if (A[i + posFrog + 1] == 1) {
							posFrog = i;
							res++;
							break;
						}
					}
				}
			}
		}
		return res;
	}

	public int solution2(int[] A) {
		int res = 0;
		int posFrog = -1;
		if (A.length <= 1) {
			res = -1;
		} else {
			ArrayList<Integer> fibSeq = new ArrayList<>();
			boolean nReach = false;
			int indArr = 2;
			fibSeq.add(1);
			fibSeq.add(2);
			while (!nReach) {
				fibSeq.add(fibSeq.get(indArr - 1) + fibSeq.get(indArr - 2));
				if (fibSeq.get(indArr) >= A.length) {
					nReach = true;
				}
				indArr++;
			}

			ArrayList<Integer> pos0 = new ArrayList<>();
			pos0.add(-1);
			ArrayList<Integer> pos1 = recherchePosPossible(fibSeq, A, pos0);

		}
		return res;
	}

	private ArrayList<Integer> recherchePosPossible(ArrayList<Integer> fibArr, int[] A, ArrayList<Integer> pos) {
		ArrayList<Integer> positionsFound = new ArrayList<>();
		sortie: for (Integer posDeb : pos) {
			for (Integer nbFib : fibArr) {

			}

		}

		return null;
	}

}
