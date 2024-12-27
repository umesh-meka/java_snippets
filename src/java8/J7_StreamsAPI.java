package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class J7_StreamsAPI {

	public static void main(String[] args) {
		// A list of integers  
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);  

		// Use Stream API to filter, map, and collect operations  
		List<Integer> evenSquares = numbers.stream()  
				.filter(n -> n % 2 == 0) // Filter even numbers  
				.map(n -> n * n) // Map to their squares  
				.collect(Collectors.toList()); // Collect results into a list  

		// Print the resulting list  
		System.out.println(evenSquares);  

		// A list of names  
		List<String> names = Arrays.asList("John", "Sara", "Mark", "Jennifer", "Paul", "Jane");  
		// Use Stream API to filter names that start with "J"  
		List<String> namesStartingWithJ = names.stream()  
				.filter(name -> name.startsWith("J")) // Filter names starting with "J"  
				.collect(Collectors.toList()); // Collect results into a list  
		// Print the filtered list  
		System.out.println(namesStartingWithJ); 

		// create a stream of strings 
		Stream<String> myStream = Stream.of("Like", "and", "Share", "https://www.geeksforgeeks.org/"); 

		// only string starting with "http://" will be considered for next API(forEach) 
		myStream.filter(x -> x.startsWith("https://")).forEach(System.out::println);

		String[] myArray = new String[] { "stream", "is",  "a", 
				"sequence", "of",  "elements", 
				"like",     "list" };
		IntStream.rangeClosed(0, myArray.length - 1) 
		.filter(x -> x % 2 == 0) 
		.mapToObj(x -> myArray[x]) // ------ learn this
		.forEach(System.out::println);

		Stream.of(myArray).forEach(System.out::print);

		IntStream.range(1, 5).forEach(System.out::println);
		IntStream.rangeClosed(1, 5).forEach(System.out::println);

		List<Integer> intList = List.of(5, 19, 8, 23, 6, 54, 32, 5, 23);
		intList.stream()
		.distinct()
		.sorted()
		.map(element -> element * element * element)
		.filter(element -> element < 10000)
		.forEach(
				element -> System.out.print(element + " "));

		intList.stream()
		.distinct()
		.sorted(Comparator.reverseOrder())
		.map(element -> element * element * element)
		.filter(element -> element < 10000)
		.forEach(
				element -> System.out.print(element + " "));

		// flatmap
		// making the arraylist object of List of Integer
		List<List<Integer> > number = new ArrayList<List<Integer>>();

		// adding the elements to number arraylist
		number.add(Arrays.asList(1, 2));
		number.add(Arrays.asList(3, 4));
		number.add(Arrays.asList(5, 6));
		number.add(Arrays.asList(7, 8));

		System.out.println("List of list-" + number);

		// using flatmap() to flatten this list
		List<Integer> flatList
		= number.stream()
		.flatMap(list -> list.stream()) // used for flattening the stream into stream of stream values
		.map(x -> x*2)
		.collect(Collectors.toList());

		// printing the list
		System.out.println("List generate by flatMap-"
				+ flatList);

		// Create stream using Stream builder() 
		Stream.Builder<String> builder 
		= Stream.builder(); 

		// Adding elements in the stream of Strings 
		Stream<String> stream = builder.add("a") 
				.add("b") 
				.add("c") 
				.build();

		stream.forEach(element -> System.out.print(element + " "));


		Stream.iterate(2, 
				(Integer n) -> n * n) 
		.limit(5) 
		.forEach(System.out::println);

		// Create infinite stream 
		// using Stream.generate() method 
		Stream.generate(Math::random) 
		.limit(5) 
		.forEach(System.out::println);


		// map to stream
		Map<Integer, String> map1 = new HashMap<>(); 

		// Add entries to the Map 
		map1.put(1, "Geeks"); 
		map1.put(2, "forGeeks"); 
		map1.put(3, "A computer Portal");

		Stream<Map.Entry<Integer, String> > stream3 =  map1.entrySet().stream();
		stream3.forEach(System.out::println);

		//stream to set
		Set<Integer> set1 = Stream.of(5, 10, 15, 20, 20, 25).distinct().collect(Collectors.toSet());
		System.out.println(set1);

		// Creating a Stream of Integers 
		Stream<Integer> stream2 = Stream.of(5, 10, 15, 20, 25); 

		// Creating a HashSet 
		Set<Integer> set = new HashSet<>(); 

		// using set.add() to add elements of stream into empty set 
		stream2.forEach(set::add); 

		List<Integer> list1 = List.of(5, 10, 15, 20, 20, 25);
		Stream.of(list1.toArray()).forEach(System.out::println);

		List<Integer> list2 = List.of(5, 10, 15, 20, 20, 25);
		Stream.of(list2.toArray()).skip(2).limit(2).forEach(System.out::println);

		//sublist
		System.out.println("List : "+Stream.of(list1).collect(Collectors.toList()).subList(0, 1)); //-- check later
		
		// stream to map
		String input = "Geeks for Geek";
		
		Map<String, Integer> lengthMap 
        = Arrays.stream(input.split(" ")) 
              .collect(Collectors.toMap( 
                  value 
                  -> value, 
                  value -> value.length()));
		
		System.out.println("Map :" +lengthMap);
		
//		Map<String, List<User> > 
//        cityUserListMap 
//        = Arrays.asList(user1, user2, user3, 
//                        user4, user5) 
//              .stream() 
//              .collect(Collectors.groupingBy( 
//                  User::getCity));
		
		
//		Map<String, Long> 
//        cityUserCountMap 
//        = Arrays.asList(user1, user2, user3, 
//                        user4, user5) 
//              .stream() 
//              .collect( 
//                  Collectors.groupingBy( 
//                      User::getCity, 
//                      Collectors.counting())); 
		
		// to find the first element of stream
		Stream<String> stream4
        = Stream.of("Geek_First", "Geek_2", 
                    "Geek_3", "Geek_4", 
                    "Geek_Last");
		System.out.println(stream4.findFirst().orElse(null));
		Stream<String> stream5
        = Stream.of("Geek_First", "Geek_2", 
                    "Geek_3", "Geek_4", 
                    "Geek_Last");
		stream5.limit(1).forEach(System.out::println);
		Stream<String> stream6
        = Stream.of("Geek_First", "Geek_2", 
                    "Geek_3", "Geek_4", 
                    "Geek_Last");
		System.out.println(stream6.findAny().orElse(null));
		
		List<Integer> list = Arrays.asList(3, 4, 6, 12, 20);
	    // Stream anyMatch(Predicate predicate)  
	    boolean answer = list.stream().anyMatch(n 
	                     -> (n * (n + 1)) / 4 == 5); 
		System.out.println("Boolean : "+ answer);
		Stream<String> stream7 = Stream.of("Geeks", "fOr", 
                "GEEKSQUIZ", "GeeksforGeeks"); 
		stream7.anyMatch(str -> Character.isUpperCase(str.charAt(1))); 
		
		
		Map<Integer, List<String> > map = new HashMap<>();

        // Adding elements to the above Map object
        // Custom input entries
        map.put(1, Arrays.asList("1", "2", "3"));
        map.put(2, Arrays.asList("4", "5", "6"));
        
        map.values().stream().flatMap(x->x.stream()).forEach(System.out::println);
		
	}

}
