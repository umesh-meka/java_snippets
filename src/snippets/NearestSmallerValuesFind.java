package snippets;

import java.util.ArrayList;
import java.util.List;

class NearestSmallerValuesFind {

	  public static String NearestSmallerValues(int[] arr) {
	    // code goes here  
	    List<String> list = new ArrayList<>();
	    list.add(String.valueOf(-1));

	    for(int i = 1; i<arr.length; i++) {
	      for(int j = i-1; j>=0; j--) {
	        if(arr[j] < arr[i]) {
	          list.add(String.valueOf(arr[j]));
	          break;
	        }
	        if(j==0)
	          list.add(String.valueOf(-1));
	      }
	    }

	    return String.join(" ", list);
	  }

	  public static void main (String[] args) {  
	    // keep this function call here     
	    int[] arr = {4, 3, 3, 5, 1};
	    System.out.print(NearestSmallerValues(arr)); 
	  }

	}