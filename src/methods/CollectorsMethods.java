package methods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html
public class CollectorsMethods {

	public static void main(String[] args) {
		
		//Collectors.toList()
		List<Integer> toList = Stream.of(76, 55, 87, 99, 5, 3, 5, 3).collect(Collectors.toList());
		System.out.println("Collectors.toList() : "+ toList);
		
		//Collectors.toSet()
		Set<Integer> toSet = Stream.of(76, 55, 87, 99, 5, 3).collect(Collectors.toSet());
		System.out.println("Collectors.toSet() : "+ toSet);

		//Collectors.toMap()
		Map<Integer, Integer> toMap = Stream.of(76, 55, 87, 99, 5, 3).collect(Collectors.toMap(x->x, x->x*10));
		System.out.println("Collectors.toMap() : "+ toMap);
		
		Student1 s1 = new Student1("Umesh", 1);
        Student1 s3 = new Student1("Hello", 10);
        Student1 s2 = new Student1("Umi", 8);
        Student1 s4 = new Student1("Umi", 4);
        List<Student1> Student1List = Arrays.asList(s1, s2, s3, s4);
        
		//Collectors.toMap() -- third parameter for removing the duplicate elements
		Map<String, Integer> toMap1 = Student1List.stream().collect(Collectors.toMap(Student1::getName, Student1::getStringLength, (x, y)->y));
		System.out.println("Collectors.toMap1() : "+ toMap1);
        
		//Collectors.toMap()
		//		third parameter for removing the duplicate elements
		// 		fourth element for what type of map collection
		Map<String, Integer> toMap2 = Student1List.stream().collect(Collectors.toMap(Student1::getName, Student1::getStringLength, (x, y)->y, TreeMap::new));
		System.out.println("Collectors.toMap2() : "+ toMap2);
        
		// similarly we have concurrentMap methods
		// allows concurerrent operations and provides threadsafe
		
		// Collectors.maxBy()
		Optional<Student1> maxBy= Student1List.stream().collect(Collectors.maxBy(Comparator.comparingInt(Student1::getAge)));
		System.out.println("Collectors.maxBy() : "+ maxBy.get());
		
		// Collectors.maxBy()
		Optional<Integer> maxBy2 = Student1List.stream().map(Student1::getAge).collect(Collectors.maxBy(Comparator.naturalOrder()));
		System.out.println("Collectors.maxBy2() : "+ maxBy2.get());
		
		// Collectors.reducing(binary)
		List<Integer> list = List.of(1, 2, 3, 4, 5);
		System.out.println("Collectors.reducing() : "+ list.stream().collect(Collectors.reducing((x,y)->x+y)).get());
		System.out.println("Collectors.reducing() : "+ list.stream().collect(Collectors.reducing(Integer::sum)).get());
		
		// Collectors.reducing(intial/default, binary)
		System.out.println("Collectors.reducing() : "+ list.stream().collect(Collectors.reducing(5, (x,y)->x+y)));
		System.out.println("Collectors.reducing() : "+ list.stream().collect(Collectors.reducing(5, Integer::sum)));
		
		// Collectors.reducing(intial/default, function, binary)
		System.out.println("Collectors.reducing() : "+ Student1List.stream().collect(Collectors.reducing(5, Student1::getAge, (x,y)->x+y)));
		System.out.println("Collectors.reducing() : "+ Student1List.stream().collect(Collectors.reducing(5, Student1::getAge, Integer::sum)));
		
		// Collectors.joining()
		System.out.println("Collectors.joining() : "+ list.stream().map(String::valueOf).collect(Collectors.joining()));
		System.out.println("Collectors.joining() : "+ list.stream().map(String::valueOf).collect(Collectors.joining(",")));
		System.out.println("Collectors.joining() : "+ list.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]")));
		
		// Collectors.averagingInt(function)
		System.out.println("Collectors.reducing() : "+ Student1List.stream().collect(Collectors.averagingInt(Student1::getAge)));
		
		// Collectors.collectingAndThen() 
		List<String> words = Arrays.asList("apple", "banana", "cherry");
		String result = words.stream()
	            .collect(Collectors.collectingAndThen(
	                Collectors.toList(),            								  // Downstream collector to collect into a list
	                collectingAndThenList -> collectingAndThenList.stream()          // Convert the list back to a stream
	                    .map(String::toUpperCase)   								// Convert each element to uppercase
	                    .collect(Collectors.joining(", "))  					   // Join into a single string with ", "
	            ));

	    System.out.println(result);
	    
	    // Collectors.counting()
	    System.out.println("Collectors.counting() : "+ list.stream().map(String::valueOf).collect(Collectors.counting()));
	    
	    // Collectors.groupingBy(Function)
	    System.out.println("Collectors.groupingBy() : "+ Student1List.stream().collect(Collectors.groupingBy(Student1::getName)));
	    
	    // Collectors.groupingBy(Function, Collector)
	    System.out.println("Collectors.groupingBy() : "+ Student1List.stream().collect(Collectors.groupingBy(Student1::getName, Collectors.counting())));
	    
	    // Collectors.groupingBy(Function, Supplier, Collector)
	    System.out.println("Collectors.groupingBy() : "+ Student1List.stream().collect(Collectors.groupingBy(Student1::getName, TreeMap::new, Collectors.counting())));
	    System.out.println("Collectors.groupingBy() : "+ Student1List.stream().collect(Collectors.groupingBy(Student1::getName, () -> new TreeMap<>(Comparator.reverseOrder()), Collectors.counting())));
	    
	    // Collectors.mapping(Function, Collector) 
	    // used along with groupingBy() and partitioningBy()
	    System.out.println("Collectors.mapping() : "+ Student1List.stream().collect(Collectors.groupingBy(Student1::getName, Collectors.mapping(Student1::getAge, Collectors.toList()))));
	    
	    // Collectors.partitioningBy()
	    System.out.println("Collectors.partitioningBy() : "+ Student1List.stream().collect(Collectors.partitioningBy(s -> s.getAge()>9)));
	    System.out.println("Collectors.mapping() : "+ Student1List.stream().collect(Collectors.partitioningBy(s -> s.getAge()>9, Collectors.mapping(Student1::getAge, Collectors.toList()))));
	    
	    // Collectors.summingInt() //summingLong //summingDouble
		System.out.println("Collectors.summingInt() : "+ Student1List.stream().collect(Collectors.summingInt(Student1::getAge)));
	    
		// Collectors.toCollection()
		System.out.println("Collectors.toCollection() : "+ Student1List.stream().collect(Collectors.toCollection(ArrayList::new)));
		
		// Collectors.summarizingInt(ToIntFunction)
		IntSummaryStatistics stats = Student1List.stream().map(Student1::getAge)
	            .collect(Collectors.summarizingInt(Integer::intValue));

        System.out.println("Count: " + stats.getCount());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Average: " + stats.getAverage());
        System.out.println("Max: " + stats.getMax());
		
	}

}

class Student1 {

    public String name;
    public int age;

    public Student1(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Student1() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    
    public int getStringLength() {
    	return name.length();
    }
    
    @Override
    public String toString() {
        return "Student1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
