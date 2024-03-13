package threads;

public class PreventThreadUsingJoin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		MyThread3 myThread3 = new MyThread3();
		myThread3.start();
		
		Thread.currentThread().setPriority(3);
		
		for(int i=0; i<10; i++) {
			myThread3.join(); 
			// current thread (main) stops its execution until  
			// completion of thread on which join is called.
			
			// to call join method parent should have the child thread with it.
			
			// looks like join is powerful than the yield and sleep.
			
			// at any case main will be executed after completion of child as main called join on child
			// telling main wants to wait until completion if child
			
			//myThread3.interrupt();
			// interrupt the current waiting or sleeping thread.
			// if the current thread is not waiting or sleeping then there is no effect but
			// it will wait until the current thread comes to waiting or sleep mode then 
			// it will be interrupted immediately
			
			System.out.println("--> main thread");
		}
	}

}

class MyThread3 extends Thread {
	public void run() {
		for(int i=0; i<10; i++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("child thread");
			Thread.yield();
		}
	}
}