package collections.list;

public class dummy {
	static String str;
	
	//List<String> l = new ArrayList<>()
	
	public void dummy() {
		System.out.println("hello");
		str = "hai";
	}

	public static void main(String[] args) {
		try {
		badm();
		System.out.println("a");
		}
		catch(Exception e) {
			
		}
		finally {
			System.out.println("b");
		}
		System.out.println("c");
		
		
		int x =3&5;
		int y = 3|5;
		
		System.out.println(x);
		System.out.println(y);
		
		
	}
	
	public static void badm() {};
	
}

