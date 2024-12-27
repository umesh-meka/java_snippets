package threads;

public class T9_ThreadDeadlock extends Thread {
	
	One one = new One();
	Two two = new Two();
	
	public void startOfDeadLock() throws InterruptedException {
		this.start();
		one.OnesOne(two);
	}
	
	public void run() {
		try {
			two.TwosOne(one);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		//ThreadDeadlock.main(null); -- gets StackOverflowError
		T9_ThreadDeadlock threadDeadlock = new T9_ThreadDeadlock();
		threadDeadlock.startOfDeadLock();
	}

}

class One {
	public synchronized void OnesOne(Two two) throws InterruptedException {
		System.out.println(Thread.currentThread().getName());
		System.out.println("Inside OnesOne before sleep");
		//Thread.sleep(2000);
		System.out.println("Inside OnesOne after sllep");
		
		two.TwosTwo(); 
		// here it is trying to access the synchronized method of another object 
		// which is actually locked by another thread
		
		// that other thread is also trying to get the lock on this object but 
		// until above line is completed current thread wont release the lock.
		
		System.out.println("Ones execution completed");
		
	}
	
	public synchronized void OnesTwo() {
		System.out.println("Inside OnesTwo");		
	}
}

class Two {
	public synchronized void TwosOne(One one) throws InterruptedException {
		System.out.println(Thread.currentThread().getName());
		System.out.println("Inside TwosOne before sleep");
		//Thread.sleep(2000);
		System.out.println("Inside TwosOne after sllep");
		
		one.OnesTwo();

		System.out.println("Twos execution completed");
	}
	
	public synchronized void TwosTwo() throws InterruptedException {
		System.out.println("Inside TwosTwo");
	}
}
