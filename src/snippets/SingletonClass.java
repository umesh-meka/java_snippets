package snippets;

public class SingletonClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//A3 a = new A3();
		
		A3 a = A3.getInstance();
	}

}


class A3 {
	// for private constructed classes objects can't be created.
//	private A3() {
//		System.out.println("Inside constructor");
//	}
	
	private static A3 instance;
	
	private A3() {
	System.out.println("Inside constructor");
	}
	
	public static A3 getInstance() {
		System.out.println("usefull for returning the instance");
		if(instance == null) {
			return new A3(); // this lazy implementation
		}
		return instance;
	}
		
}