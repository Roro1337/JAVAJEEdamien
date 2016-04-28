package dd.PassingCars;

public class MainPassingCars {

	public static void main(String[] args) {
		MainPassingCars mps = new MainPassingCars();
		mps.init();

	}

	public void init() {

	}

	public int solution(int[] A) {
		int result = -1;
		if (A.length <= 1000000) {
			result = 0;
			for (int i = 0; i < A.length - 1; i++) {
				if (A[i] == 0) {
					for (int j = i + 1; j < A.length; j++) {
						if (A[j] == 1) {
							result += 1;
						}
					}
				}
			}
		}
		return result;
	}

	public int solution2(int[] A) {
		int result = 0;
		int conditionE = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 0) {
				conditionE++;
			} else if (A[i] == 1) {
				result += conditionE;
			}

		}
		if (result > 1000000) {
			result = -1;
		}
		return result;
	}
}
