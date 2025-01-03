package methods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html
public class CollectionsMethod {

	public static void main(String[] args) {
		List<Integer> list = List.of(5, 3, 1, 2);
		
		List<String> arrlist = new ArrayList<String>(); 
        arrlist.add("A"); 
        arrlist.add("B"); 
        arrlist.add("C"); 
        arrlist.add("Tajmahal"); 
		Collections.addAll(arrlist, "A", "b");
		System.out.println("addAll : "+ arrlist);
		
		// returns the index if found and some negative value if not available
		System.out.println(Collections.binarySearch(arrlist, "b"));
		
		// copy
		List<String> arrlistCopy1 = new ArrayList<String>(); 
		arrlistCopy1.add("A"); 
		arrlistCopy1.add("B"); 
		arrlistCopy1.add("z"); 
        List<String> arrlistCopy2 = new ArrayList<String>(); 
        arrlistCopy2.add("C"); 
        arrlistCopy2.add("D"); 
		//arrlistCopy2.add("D"); 
		//arrlistCopy2.add("D"); 
        
        // copy(dest, src);
        Collections.copy(arrlistCopy1, arrlistCopy2);
		System.out.println(arrlistCopy1);
		System.out.println(arrlistCopy2);
        
		// Collections.disJoint(col1, col2) --> returns true if no elements matches
		
		//Collections.emptyList()
		// returns empty singleton immutable empty list to avoid null pointer issues
		
		System.out.println("frequency : "+ Collections.frequency(arrlist, "A"));
		
		System.out.println("max : "+ Collections.max(list));
		System.out.println("max : "+ Collections.max(list, Comparator.reverseOrder()));
		System.out.println("max : "+ Collections.min(list));
		System.out.println("max : "+ Collections.min(list, Comparator.reverseOrder()));
		
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(5);
		list1.add(3);
		list1.add(4);
		Collections.reverse(list1);
		System.out.println("reverse : "+ list1);
		
		//Collections.reverseOrder()
		//Collections.reverseOrder(Comparator)
		//Collections.shuffle(list)
		//Collections.singleton(Obj)/singletonList(Obj)/singletonMap(K key, V value)
		//		returns set of single Obj can be used to removeAll on arrayList
		
		// immutable collection
		// 		can't modify the collection like can't perform the (add(), remove(), set())
		//		Collections.emptyList(), List.of()
		
		// unmodifiable collection
		// 		allows us to create new read-only collection
		// 		underlying original collection can be still changed
		// 		Collections.unmodifiableList(list)
		
		
	}

}

 