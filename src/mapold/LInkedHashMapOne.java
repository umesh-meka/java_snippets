package map;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LInkedHashMapOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
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
		
		System.out.println("Keys set : "+ map.keySet());

		System.out.println("Values Collection : "+ map.values());
		
		System.out.println("Entries set : "+ map.entrySet());
	}

}
