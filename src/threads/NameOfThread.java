package threads;

public class NameOfThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Main Thread Name : "+Thread.currentThread().getName());
		Thread.currentThread().setName("main wala thread");
		
		NameOfThread2 nameOfThread2 = new NameOfThread2();
		nameOfThread2.start();
		
		System.out.println("Main Thread Name : "+Thread.currentThread().getName());
		System.out.println("Inside ThreadExtendsThread");
	}

}

class NameOfThread2 extends Thread {
	public void run() {
		System.out.println("Inside MyThread");
	}
}
