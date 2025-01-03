package methods;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// https://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html
public class ArraysMethods {

	public static void main(String[] args) {
		Integer[] a = {99, 76, 34, 55, 8};
		int[] b = new int[] {9, 2, 6, 3, 5};
		
		// asList works best on Object class but not on primitive array
		List<Integer> lista = Arrays.asList(a);
		
		System.out.println("lista : "+ lista);
		System.out.println("listb : "+ Arrays.asList(b));
		
		// binarySearch
		Integer[] aa = {99, 76, 34, 55, 8};
		Arrays.sort(aa);
		int[] bb = new int[] {9, 2, 6, 3, 5};
		Arrays.sort(bb);
		System.out.println("lista : "+ Arrays.binarySearch(aa, 76));
		System.out.println("lista : "+ Arrays.binarySearch(aa, 75));
		System.out.println("listb : "+ Arrays.binarySearch(bb, 9));
		
		int[] ab = Arrays.copyOf(b, 2);
		System.out.println("CopyOf : "+ Arrays.toString(ab));
		
		int[] abb = Arrays.copyOfRange(b, 1, 3);
		System.out.println("CopyOf : "+ Arrays.toString(abb));
		
		System.out.println(Arrays.toString(aa));
		System.out.println(Arrays.deepToString(aa));
		System.out.println(Arrays.deepHashCode(aa));
		Integer[] aaa = {99, 76, 34, 55, 8};
		System.out.println(Arrays.deepEquals(aa, aaa));
		
		// Arrays.equals() is for single dimensional array
		// Arrays.deepEquals() is for multi-dimensional array
		
		// performs the binary operation on each element
		Arrays.parallelPrefix(aaa, (x,y)->x+1);
		System.out.println(Arrays.toString(aaa));
		
		Arrays.sort(aa, Comparator.reverseOrder());
		System.out.println(Arrays.toString(aa));
		
		Arrays.sort(aa, Comparator.reverseOrder());
		System.out.println(Arrays.toString(aa));
		
		
		
	}

}

