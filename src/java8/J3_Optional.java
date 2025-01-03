package java8;

import java.util.Optional;

// The Optional class used to represent a value that may be present or may not be.
// Optional class deal with NPE by provoding methods to check it before accesing it.

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

// of: It creates an Optional with a non-null value.
// ofNullable: It creates an Optional with a given nullable value.
// empty: It creates an empty Optional.
// isPresent: This checks whether the Optional contains a non-null value.
// get: It gets the value if present, otherwise it throws an exception i.e. NoSuchElementException.
// orElse: It returns the value if present, otherwise returns the specified default value.
// orElseGet: It returns the value if present, otherwise it returns the result of invoking the supplier function.
// orElseThrow: It returns the value if present, otherwise it throws an exception produced by the provided supplier.
// map: It applies a function to the value if present and return a new Optional with the result, or return an empty Optional if no value is present.
// filter: It applies a predicate to the value if present and return an Optional with the value if it matches the predicate, otherwise return an empty Optional.
