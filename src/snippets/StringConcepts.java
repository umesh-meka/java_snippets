package snippets;


// final is like reassignment cant be done and its fixed
// if updating a value is possible that works for ex append()
public class StringConcepts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String s1 = "Hello";
		String s2 = s1;
		
		// below will fail as it is declared as final
		// final refer to reference
		
		// without final it will work 
		//s1 = "Hai";
		
		final StringBuilder sb = new StringBuilder("hello");
		StringBuilder sb2 = sb;
		
		StringBuilder sb3 = new StringBuilder("hello2");
		sb.append("3");
		
		System.out.println(s1);
		System.out.println(s2);
		
		System.out.println(sb);
		System.out.println(sb2);
		

	}

}
