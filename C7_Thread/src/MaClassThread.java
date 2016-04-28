
public class MaClassThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaClassThread maClassThread = new MaClassThread();
		maClassThread.init();

	}

	public void init() {

		for (int i = 0; i < 10; i++) {

			ClasseRunnable cT = new ClasseRunnable();
			Thread mT = new Thread(cT,Integer.toString(i));
			mT.start();
		}
	}
}
