package java8;

import java.util.Arrays;
import java.util.Comparator;

public class J8_ParallelSort {

	public static void main(String[] args) {
		// Parallel sorting for an array of primitives  
        int[] numbers = {9, 3, 1, 5, 13, 12, 7, 4, 11, 6};  
        System.out.println("Original array: " + Arrays.toString(numbers));  
        Arrays.parallelSort(numbers);  
        System.out.println("Sorted array: " + Arrays.toString(numbers));  
        // Parallel sorting for an array of objects with a custom comparator  
        String[] fruits = {"Peach", "Apple", "Orange", "Banana", "Grape", "Pear"};  
        System.out.println("\nOriginal array: " + Arrays.toString(fruits));  
        // Using a lambda expression for the comparator to sort in reverse alphabetical order  
        Arrays.parallelSort(fruits, Comparator.reverseOrder());  
        System.out.println("Sorted array in reverse order: " + Arrays.toString(fruits));  
	}

}
