package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// - Java 8 Method reference is used to refer method of functional interface.
// - It is compact and easy form of lambda expression.
// - Each time when you are using lambda expression to just referring a method, 
//   we can replace our lambda expression with method reference.

// Types
// - Method reference (static and instance methods)
// - Constructor reference


public class J2_MethodReferences {

	public static void main(String[] args) {
        List<String> words = Arrays.asList("Java", "Stream", "Method", "References");
        List<String> uppercaseWords = 
        		words.stream().map(String::toUpperCase)
        		.collect(Collectors.toList());
        
        System.out.println("Uppercase Strings: " + uppercaseWords);
        
        //constructor reference
        SampleFI1 fi = SampleClassFI1:: new;
        fi.getObject().check();
        
        //method reference
        SampleFI2 fi2 =  SampleClassFI1 :: check;
        fi2.checks();
	}

}

interface SampleFI1 {
	public SampleClassFI1 getObject();
}

@FunctionalInterface
interface SampleFI2 {
	void checks();
}

class SampleClassFI1 {
	public static void check () {
		System.out.println("SampleFI called.");
	}
}

