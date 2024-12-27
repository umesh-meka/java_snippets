package snippets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//read array size from command line
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		int arrayToBeSerached[] = new int[Integer.parseInt(br.readLine())];		
		System.out.println("array size : "+arrayToBeSerached.length);
		
		for(int i=0; i<arrayToBeSerached.length; i++) {
			arrayToBeSerached[i] = Integer.parseInt(br.readLine());
		}
		
		System.out.println("array : "+arrayToBeSerached[0]);
		
		boolean found = doBinarySearch(arrayToBeSerached);
		
		if(found) {
			System.out.println("Found");
		} else {
			System.out.println("Not found");
		}
	}
	
	public static boolean doBinarySearch(int arrayToBeSerached[]) {
		int min = 0;
		int max = arrayToBeSerached.length - 1;
		
		int mid = (min+max)/2;
		
		Scanner sc = new Scanner(System.in);
		int key = Integer.parseInt(sc.next());
		
		System.out.println("key : "+key);
		while(min<=max) {
			if(arrayToBeSerached[mid] < key) {
				min = mid +1;
			} else if(arrayToBeSerached[mid] > key) {
				max = mid - 1;
			} else {
				return true;
			}
			
			mid = (min+max)/2;
		}
		return false;
	}
}
