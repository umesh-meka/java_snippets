package threads;

public class ThreadImplementsRunnable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyRunnable myRunnable = new MyRunnable();
		Thread t = new Thread(myRunnable);
		t.start();

		System.out.println("Inside ThreadImplementsRunnable");
	}

}

class MyRunnable implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Inside MyRunnable");
	}
	
}
