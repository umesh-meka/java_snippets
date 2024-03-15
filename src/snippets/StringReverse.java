package snippets;

public class StringReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//using StringBuffer
		StringBuffer sb = new StringBuffer("MyJavaCode");
		System.out.println(sb.reverse());
		
		//using for loop
		String str = "MyJavaCode";
		for(int i = str.length()-1; i>=0; i--) {
			System.out.print(str.charAt(i));
		}
		System.out.println();
		
		//using recursive methods
		String strRec = "MyJavaCode";
		System.out.println("recursive : "+recursiveMethod(strRec));
	}
	
	public static String recursiveMethod(String str) {
		if(str.length() <= 1)
			return str;
		
		return recursiveMethod(str.substring(1)) + str.charAt(0);
		
	}

}
