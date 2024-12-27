package threads;

public class T3_NameOfThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Main Thread Name : "+Thread.currentThread().getName());
		Thread.currentThread().setName("main renamed");
		
		ChildThread3 childThread3 = new ChildThread3();
		childThread3.start();
		System.out.println("Child Thread Name in main: "+ childThread3.currentThread().getName());
		System.out.println("Main Thread Name : "+Thread.currentThread().getName());
		System.out.println("Inside ThreadExtendsThread");
	}

}

class ChildThread3 extends Thread {
	public void run() {
		System.out.println("Child Thread Name : "+ Thread.currentThread().getName());
		System.out.println("in ChildThread");
	}
}
