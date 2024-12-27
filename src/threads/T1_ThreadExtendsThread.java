package threads;

public class T1_ThreadExtendsThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyThread myThread = new MyThread();
		myThread.start();
		
		for(int i=0; i<10; i++) {
			System.out.println("MainThread");
		}
	}

}

class MyThread extends Thread{

	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("Child Thread");
		}
	}
	
}
