package java8;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

// forEach() to iterate the elements
// It is defined in Iterable and Stream interfaces.
// It is a default method defined in the Iterable interface. 
// Collection classes which extends Iterable interface can use forEach() method to iterate elements.
// This method takes a single parameter which is a functional interface. 
// So, you can pass lambda expression as an argument.

public class J4_ForEach {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("One", "Two");
		list.forEach(str -> System.out.println(str));
		list.forEach(System.out::println);

	}

}
