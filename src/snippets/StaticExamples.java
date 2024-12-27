package snippets;

// rules for static
// static method can only access static variables and static methods
// static methods cant be overridden as they are specific to clss
// this keyword cant be used as it refers to current object


public class StaticExamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// call instance method (non-static)
		// throws compiler error as it can't access the non-static
		// as main is static method
		//nonStaticMethod();
		
		//static methods can only access 
		// other static methods or static variables only
		
		A a = new A();
		a.changeValue();
		
		A.changeValue();
		B.changeValue();
		
		B b = new B();
		b.y = 18;
		b.changeValue();
		
		//though parent instance storing the child address
		// still parent static method will called at runtime
		// so no runtime polymorphism works with static keyword.
		A a1 = b;
		a1.changeValue();
	}
	
	public void nonStaticMethod() {
		System.out.println("inside main non-static method");
	}

}


class A {
	int x;
	static int y = 10;
	
	// throws error
	// as illeagle modifier only public, protected and default are accepted
//	static A() {
//		System.out.println("inside constructor : "+y);
//	}
	
	static void changeValue() {
		//throws compilation error as static method can only access the static instance variables
		//x = 10; 
		y = 15;
		System.out.println("inside static method : "+y);
	}
	
	static void changeValue(int a) {
		y = 16;
		System.out.println("inside overloaded static method : "+y);
	}
}

class B extends A {
	//with out static we can't override
	static void changeValue() {
		System.out.println("inside overridden static method : "+y);
	}
}
