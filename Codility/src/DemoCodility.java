
public class DemoCodility {

	public static void main(String[] args) {

	}

	public class Solution {

		public int solution(int[] A) {

			int res = -1;

			// stock de la somme du tableau
			for (int i = 0; i < A.length; i++) {

				long s1 = 0;
				long s2 = 0;

				for (int j = 0; j < A.length; j++) {
					s1 += A[j];
				}

				for (int j = i + 1; j < A.length; j++) {
					s2 += A[j];
				}
				if (s1 == s2) {
					res = i;
					break;
				}
			}
			return res;
		}
	}
}
