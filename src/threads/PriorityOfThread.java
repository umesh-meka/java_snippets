package threads;

public class PriorityOfThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Main Thread Priority : "+Thread.currentThread().getPriority());
		Thread.currentThread().setPriority(6);
		
		NameOfThread3 nameOfThread3 = new NameOfThread3();
		System.out.println("nameOfThread3 Thread Priority : "+nameOfThread3.getPriority());
		nameOfThread3.setPriority(7);
		nameOfThread3.start();
		
		System.out.println("nameOfThread3 Thread Priority : "+nameOfThread3.getPriority());
		
		System.out.println("Inside ThreadExtendsThread");
	}

}

class NameOfThread3 extends Thread {
	public void run() {
		System.out.println("Inside MyThread");
	}
}
