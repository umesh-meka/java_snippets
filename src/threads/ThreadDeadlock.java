package threads;

public class ThreadDeadlock extends Thread {
	
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
		// TODO Auto-generated method stub
		//System.out.println("loop");
		//ThreadDeadlock.main(null); -- gets StackOverflowError
		ThreadDeadlock threadDeadlock = new ThreadDeadlock();
		threadDeadlock.startOfDeadLock();
		
		ThreadDeadlock.main(null);
	}

}

class One {
	public synchronized void OnesOne(Two two) throws InterruptedException {
		System.out.println("Inside OnesOne before sleep");
		//Thread.sleep(2000);
		System.out.println("Inside OnesOne after sllep");
		
		two.TwosTwo(); 
		// here it is trying to access the synchronized method of another object 
		// which is actually locked by another object
		
		// that other object is also trying to get the lock on this object but 
		// until above line is completed current thread wont release the lock.
		
	}
	
	public synchronized void OnesTwo() {
		System.out.println("Inside OnesTwo");		
	}
}

class Two {
	public synchronized void TwosOne(One one) throws InterruptedException {
		System.out.println("Inside TwosOne before sleep");
		//Thread.sleep(2000);
		System.out.println("Inside TwosOne after sllep");
		
		one.OnesTwo();
	}
	
	public synchronized void TwosTwo() throws InterruptedException {
		System.out.println("Inside TwosTwo");
	}
}
