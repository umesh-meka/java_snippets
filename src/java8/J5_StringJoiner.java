package java8;

import java.util.StringJoiner;

// It is final class StringJoiner in java.util package. 
// It is used to construct a sequence of characters separated by a delimiter.

public class J5_StringJoiner {

	public static void main(String[] args) {
		// Create a StringJoiner with a delimiter, prefix, and suffix  
        StringJoiner joiner = new StringJoiner("- ", "[", "]");  
        // Add strings to the StringJoiner  
        joiner.add("Apple");  
        joiner.add("Banana");  
        joiner.add("Cherry");  
        joiner.add("Date");  
        // Convert the StringJoiner to String and print the result  
        String result = joiner.toString();  
        System.out.println(result);  

	}

}
