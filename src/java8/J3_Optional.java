package java8;

import java.util.Optional;

// Optional class deal with NPE
// represents the optional values instead of null references

public class J3_Optional {
 public static void main(String[] args) {
	 String[] str = new String[10]; // Initialize an array of strings with default null values.  
     //str[5] = "Hello, Optional!"; // Uncomment this line to test with a non-null value.  
     // Create an Optional object from the value of str[5].  
     Optional<String> checkNull = Optional.ofNullable(str[5]);  
     // Check if the Optional object contains a value.  
     if (checkNull.isPresent()) {  
         // Convert the string to lowercase if it's not null.  
         String word = str[5].toLowerCase();  
         System.out.println(word); // Print the lowercase string.  
     } else {  
         System.out.println("string is null"); // Indicate that the string is null.  
     }  
 }
}
