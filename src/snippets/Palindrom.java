package snippets;

import java.util.Collections;
import java.util.LinkedList;

public class Palindrom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str =  "paparapap";
		int l = str.length();
		for(int i=0; i<l/2; i++) {
			System.out.println(str.charAt(i) + " - "+str.charAt(l-1 - i));
			if(str.charAt(i) != str.charAt(l-1 - i)) {
				System.out.println("not a palindrom");
				break;
			}
		}
		

		
		LinkedList<Integer> ll = new LinkedList<Integer>();

		ll.add(1);
		ll.add(2);
		ll.add(3);
		
		System.out.println(ll);
		
		Collections.reverse(ll);

		System.out.println(ll);
	}

}
