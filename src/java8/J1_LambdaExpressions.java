package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class J1_LambdaExpressions {

	public static void main(String[] args) {
		List<String> arrayList = Arrays.asList("One", "Two", "Three");
		System.out.println("Values containing T");
		
		J1_LambdaExpressions obj = new J1_LambdaExpressions();
		obj.filter(arrayList, (s) -> s.contains("T"));
		
		
		//Using Java 8 streams
System.out.println(arrayList.stream().filter(s -> s.contains("T"))
        		.collect(Collectors.toList()));

	}
	
	public void filter(List<String> arrayList, Predicate<String> p) {
		for(String str: arrayList) {
			if(p.test(str)) {
				System.out.println(str);
			}
		}
	}

}
