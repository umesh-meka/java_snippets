package threads;


// if a thread wants to execute the synchronized area (method or block) on a object 
// a thread should get the object lock.

// similarly if a thread wants to execute the statis synchronized area (method or block) on a object 
//a thread should get the class lock.
public class SynchronizedThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SynchronizedClass synchronizedClass = new SynchronizedClass();
		
		MyThread4 t1 = new MyThread4(synchronizedClass);
		MyThread4 t2 = new MyThread4(synchronizedClass);
		
		t1.start();
		t2.start();
		
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

class MyThread4 extends Thread {
	SynchronizedClass synchronizedClass;
	
	public MyThread4(SynchronizedClass synchronizedClass) {
		this.synchronizedClass = synchronizedClass;
	}
	
	public void run() {
		try {
			this.synchronizedClass.display(Thread.currentThread().getName());
			this.synchronizedClass.display2(Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}