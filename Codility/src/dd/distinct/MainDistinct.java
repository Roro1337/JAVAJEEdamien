package dd.distinct;

import java.util.ArrayList;

public class MainDistinct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solution(int[] A) {
		long result = 0;
		ArrayList<Integer> monArray = new ArrayList<Integer>();
		for (int i = 0; i < A.length; i++) {
			if (!monArray.contains(Integer.valueOf(A[i]))) {
				monArray.add(A[i]);
				result++;
			}
		}
		return (int) result;
	}
}
