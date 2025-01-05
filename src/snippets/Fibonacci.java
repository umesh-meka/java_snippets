package snippets;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int x = 10;
		
		int a = 0;
		int b = 1;
		int c = 1;
		
		for(int i = 1; i<=x; i++) {
			System.out.print(a+ "-");
			a = b;
			b = c;
			c = a+b;			
		}

	}

}
