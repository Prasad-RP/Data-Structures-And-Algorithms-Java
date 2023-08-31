package linear_data_structures.arrays;

import java.util.Scanner;

/**
 * This file contains implementation for insertion sort algo.
 * 
 * @author Prasad Pansare
 *
 */
public class InsertionSortAlgorithm {

	/**
	 * 
	 * @param arr (unsorted array)
	 * @return sorted array
	 */
	public static int[] insertionSort(int arr[]) {
		int key, j;
		// loop for total passes i.e array legth -1
		for (int i = 0; i <= arr.length - 1; i++) {
			key = arr[i];
			j = i - 1;
			// Loop for each pass (comapres key and J)
			while (j >= 0 && arr[j] > key) {
				// shifting element to its right since we found greater element than key
				arr[j + 1] = arr[j];
				// decrementing J , since we are traversing in left direction
				j--;
			}
			// finally element at its actual position in sorted array
			arr[j + 1] = key;
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
		// calling insertion sort
		insertionSort(a);
		System.out.println("Array elements after sort...");
		printArray(a);
	}
}
