package dd;

public class EquiLeader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EquiLeader monEqui = new EquiLeader();
		monEqui.init();

	}

	public void init() {

	}

	public int solution(int[] A) {
		int half1 = 0;
		int half2 = 0;
		int res = 0;
		int cptOccurs1 = 0;
		int cptOccurs2 = 0;
		int lead1 = A[0];
		int lead2 = 0;

		for (int j = 1; j < A.length - 1; j++) {

			half1 = (int) (j / 2);
			half2 = (int) ((A.length - j) / 2);
			lead2 = A[j];
			for (int i = j; i < A.length; i++) {
				if (lead2 == A[i]) {
					cptOccurs2++;
				}
				if (lead2 < A[i]) {
					lead2 = A[i];
					cptOccurs2 = 1;

				}

			}
			if (lead1 == lead2 && cptOccurs1 > half1 && cptOccurs2 > half2) {
				res++;
			}
			if (lead1 == A[j]) {
				cptOccurs1++;
			}
			if (lead1 < A[j]) {
				lead1 = A[j];
				cptOccurs1 = 1;
			}
		}
		return res;
	}

}
