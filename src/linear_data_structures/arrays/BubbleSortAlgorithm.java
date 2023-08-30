package linear_data_structures.arrays;

import java.util.Scanner;

/**
 * 
 * @author Prasad Pansare
 *
 */
public class BubbleSortAlgorithm {

	/**
	 * This is classic Bubble sort algorithm.
	 * 
	 * @param unsorted arr
	 * @return sorted array
	 */
	public static int[] bubbleSort(int arr[]) {
		// for loop for no of passes
		for (int i = 0; i < arr.length - 1; i++) {
			System.out.println("Working on pass no :" + (i + 1));
			// for comaparision of each pass
			for (int j = 0; j < arr.length - 1 - i; j++) {
				// if we found greater element than its prevoius, then we swap them
				if (arr[j] > arr[j + 1]) {
					// swapping logic
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		return arr;
	}

	/**
	 * This is Adaptive Bubble sort algorithm. 
	 * This method takes less no of passes if array is sorted
	 * 
	 * @param unsorted arr
	 * @return sorted array
	 */
	public static int[] adaptiveBubbleSort(int arr[]) {
		Boolean isSorted = false;
		// for loop for no of passes
		for (int i = 0; i < arr.length - 1; i++) {
			System.out.println("Working on pass no :" + (i + 1));
			// assuming array is already sorted
			isSorted = true;
			// for comaparision of each pass
			for (int j = 0; j < arr.length - 1 - i; j++) {
				// if we found greater element than its prevoius, then we swap them
				if (arr[j] > arr[j + 1]) {
					// swapping logic
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					isSorted = false;
				}
			}
			// checking if no comaparision would be happen , then array will be already sorted.
			if (isSorted) {
				return arr;
			}
		}
		return arr;
	}

	/**
	 * 
	 * @param arr-> array to print elements
	 */
	public static void printArray(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number of elements in array: ");
		int n = sc.nextInt();
		int a[] = new int[n];

		for (int i = 0; i < n; i++) {
			System.out.println("Enter Number at index: " + (i + 1));
			int ele = sc.nextInt();
			a[i] = ele;
		}

		System.out.println("Array elements before sort...");
		printArray(a);
		// calling bubble sort
		// bubbleSort(a);
		
		// calling adaptive bubble sort
		 adaptiveBubbleSort(a);
		
		System.out.println("Array elements after sort...");
		printArray(a);
	
	}
}
