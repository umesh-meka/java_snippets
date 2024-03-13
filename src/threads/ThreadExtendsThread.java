package threads;

public class ThreadExtendsThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyThread myThread = new MyThread();
		myThread.start();
		
		System.out.println("Inside ThreadExtendsThread");
	}

}

class MyThread extends Thread {
	public void run() {
		System.out.println("Inside MyThread");
	}
}
