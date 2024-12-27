package threads;public class T5_PreventThreadUsingYield {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("main priority: " +Thread.currentThread().getPriority());
		
		ChildThread5 childThread5 = new ChildThread5();
		childThread5.start();
		
		Thread.currentThread().setPriority(8);
		
		for(int i=0; i<100; i++) 
		System.out.print(".");
	}

}

class ChildThread5 extends Thread {
	public void run() {
		System.out.println("child priority: " +Thread.currentThread().getPriority());
		for(int i=0; i<100; i++) {
			System.out.print(Thread.currentThread().getPriority()+"#");
		
		// current thread stops its execution to give the chance to the thread of same priority or higher priority
		// simply it gives hint to the Thread Scheduler
		// TS is free to ignore the hint
		Thread.yield();
		}
	}
}