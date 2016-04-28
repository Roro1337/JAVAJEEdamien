package dd.binarygap;

public class CodilityBinaryGapL1 {

	public static void main(String[] args) {
		CodilityBinaryGapL1 b = new CodilityBinaryGapL1();
		b.init();

	}

	private void init() {

		String s = "salut";
		System.out.println(11);
		System.out.println(17);
		System.out.println();
	}

	int solution(int N) {
		int n = 0;
		int cpt = 0;
		boolean demarre = false;

		while (N > 0) {
			int reste = N % 2;
			if (reste == 1) {
				if (!demarre) {
					n = 0;
					demarre = true;
				} else {
					n = Math.max(n, cpt);
				}
				cpt = 0;
			} else {
				cpt++;
			}
			N = N / 2;
		}
		return n;
	}

	int solution2(int N) {
		int n = 0;
		String s = Integer.toBinaryString(N);
		s = s.replace("0", " ");
		s = s.trim();
		String[] ls = s.split("1");
		for (int i = 0; i < ls.length; i++) {
			n = Math.max(n, ls[i].length());
		}
		return n;
	}

	int solution3(int N) {

		int n = 0;
		String s = Integer.toBinaryString(N);
		s = s.replace("0", " ");
		s = s.trim();
		for (int i = 0; i < s.length(); i++) {

		}

		String[] ls = s.split("1");
		for (int i = 0; i < ls.length; i++) {
			n = Math.max(n, ls[i].length());
		}
		return n;
	}

}
