package snippets;

public class RemoveWhiteSpaces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "My Java Code";
		char[] array = str.toCharArray();
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < array.length; i++) {
			if(!Character.isWhitespace(array[i])) {
				sb.append(array[i]);
			}
		}
		System.out.println(" After removing whitespaces : "+sb.toString());
		
		System.out.println(str.replaceAll("\\s", ""));
	}

}
