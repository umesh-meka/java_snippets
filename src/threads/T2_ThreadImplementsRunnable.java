package threads;

public class T2_ThreadImplementsRunnable {

	public static void main(String[] args) {
		MyRunnable myRunnable = new MyRunnable();
		Thread t = new Thread(myRunnable);
		t.start();

		for(int i=0; i<10; i++) {
			System.out.println("MainThread");
		}
	}

}

class MyRunnable implements Runnable{

	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("Child Thread");
		}
	}
	
}
