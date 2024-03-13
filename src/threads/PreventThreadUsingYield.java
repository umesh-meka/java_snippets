package threads;public class PreventThreadUsingYield {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyThread2 myThread2 = new MyThread2();
		myThread2.start();
		
		Thread.currentThread().setPriority(8);
		
		for(int i=0; i<10; i++) 
		System.out.println("Inside ThreadExtendsThread");
	}

}

class MyThread2 extends Thread {
	public void run() {
		for(int i=0; i<10; i++) {
		System.out.println("Inside MyThread");
		System.out.println("child priority: " +Thread.currentThread().getPriority());
		Thread.currentThread();
		// passes its execution to give the control to the thread of same priority or low ones
		Thread.yield();
		}
	}
}