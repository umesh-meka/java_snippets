package threads;


// if a thread wants to execute the synchronized area (method or block) on a object 
// a thread should get the object lock.

// similarly if a thread wants to execute the statis synchronized area (method or block) on a object 
//a thread should get the class lock.
public class T7_SynchronizedThread {

	public static void main(String[] args) {
		// Same object will be passed to two different threads
		SynchronizedClass synchronizedClass = new SynchronizedClass();
		
		ChildThread7 t1 = new ChildThread7(synchronizedClass);
		ChildThread7 t2 = new ChildThread7(synchronizedClass);
		

		t2.start();
		t1.start();
		
		// here if t1 is executing synchronized area it wont execute non synchronized area but
		// other threads like t2 will execute the non synchronized				
	}

}

class SynchronizedClass {
	public synchronized void display(String name) throws InterruptedException {
		for(int i=0; i<5; i++) {
			System.out.println("Inside display : "+name);	
			Thread.sleep(1000);		
		}
	}
	
	public void display2(String name) throws InterruptedException {
		for(int i=0; i<5; i++) {
			System.out.println("Inside display2 : "+name);	
			Thread.sleep(500);		
		}
	}
}

class ChildThread7 extends Thread {
	SynchronizedClass synchronizedClass;
	
	public ChildThread7(SynchronizedClass synchronizedClass) {
		this.synchronizedClass = synchronizedClass;
	}
	
	public void run() {
		try {
			this.synchronizedClass.display(Thread.currentThread().getName());
			//this.synchronizedClass.display2(Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}