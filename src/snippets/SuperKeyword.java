package snippets;

public class SuperKeyword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B1 b = new B1();
		
		A1 a = new A1();
		
		b.callCons();
	}

}


class A1 {
	A1() {
		System.out.println("inside parent");
	}

	void callCons() {
		System.out.println("inside parent callCons");	
	}
}

class B1 extends A1 {
	B1() {
		super();
		System.out.println("inside child");	
	}
	
	void callCons() {
		super.callCons();
		System.out.println("inside child callCons");
	}
}

