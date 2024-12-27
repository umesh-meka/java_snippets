package threads;

public class T4_PriorityOfThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Main Thread Priority : "+Thread.currentThread().getPriority());
		Thread.currentThread().setPriority(6);
		
		ChildThread4 childThread4 = new ChildThread4();
		System.out.println("childThread Thread Priority : "+childThread4.getPriority());
		childThread4.setPriority(7);
		childThread4.start();
		
		System.out.println("childThread Thread Priority : "+childThread4.getPriority());
		
		System.out.println("Inside ThreadExtendsThread");
	}

}

class ChildThread4 extends Thread {
	public void run() {
		System.out.println("Inside MyThread");
	}
}
