package methods;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html
public class StreamMethods {

	public static void main(String[] args) {
		List<Integer> list = List.of(8, 3,7, 2, 9, 5, 1, 2);
		
		System.out.println("Skip(0) doesnt have any effect");
		list.stream().skip(1).forEach(System.out::print);
		System.out.println();
		
		System.out.println("limit(0) doesnt have any effect");
		list.stream().limit(1).forEach(System.out::print);
		System.out.println();
		
		System.out.println("to get last element");
		list.stream().skip(list.size()-1).limit(1).forEach(System.out::print);
		System.out.println();
		
		System.out.println("distinct -- removes the second occurence");
		list.stream().distinct().forEach(System.out::print);
		System.out.println();
		
		System.out.println("findAny -- any random");
		System.out.print(list.stream().findAny().get());
		System.out.println();
		
		System.out.println("findFirst -- first element");
		System.out.print(list.stream().findFirst().get());
		System.out.println();
		
		System.out.println("noneMatch");
		System.out.print(list.stream().noneMatch(x->x==10));
		System.out.println();
		
		System.out.println("anyMatch");
		System.out.print(list.stream().anyMatch(x->x==10));
		System.out.println();
		
		System.out.println("peek -- intermediate operation");
		System.out.print(
		list.stream()
        .peek(n -> System.out.println("Before filtering: " + n))  // Inspecting each element
        .filter(n -> n % 2 == 0)
        .peek(n -> System.out.println("After filtering: " + n))   // Inspecting after filtering
        .collect(Collectors.toList()));
		System.out.println();
		
		System.out.println("generate -- generates infinite stream elements");
		Stream.generate(() -> 1).limit(5).forEach(System.out::print);
		System.out.println();
		
		System.out.println("dropwhile -- drop elements until condition is true");
		list.stream().dropWhile(x->x<9).forEach(System.out::print);
		System.out.println();
		
		System.out.println("takeWhile -- drop elements once condition is false");
		list.stream().takeWhile(x->x<9).forEach(System.out::print);
		System.out.println();
		
		System.out.println("faltMap -- flattens the nested stream into single stream");
		List<List<Integer>> listOfLists = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(4, 5),
            Arrays.asList(6, 7, 8)
        );
		listOfLists.stream().flatMap(List::stream).forEach(System.out::print);
		System.out.println();
		
		
	}

}
