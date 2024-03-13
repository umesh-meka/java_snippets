package map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<String, Integer> map = new HashMap<>();
		map.put("name1", 32);
		map.put("name6", 23);
		map.put("name4", 45);
		map.put("name2", 32);
		map.put("name5", 12);
		map.put("name3", 17);
		
		Set<Map.Entry<String, Integer>> mapEntry = map.entrySet();
		for(Map.Entry<String, Integer> entry: mapEntry) {
			System.out.println("Key : "+entry.getKey() +" - "+"Value : "+entry.getValue());
		}
		
		System.out.println("Ascending Order");
		map.entrySet().stream()
		.sorted(Map.Entry.comparingByKey())
		.forEach(System.out::println);
		// similarly we have comaparingByValue()
		
		System.out.println("Descending Order");
		map.entrySet()
		.stream()
		.sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
		.forEach(System.out::println);
		// similarly we have comaparingByValue(Comaparator)
		
		
	}	

}
