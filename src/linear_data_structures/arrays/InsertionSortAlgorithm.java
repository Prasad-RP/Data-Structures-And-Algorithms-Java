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
		// Dry Run
		// -1 0 1 2 3 4 5
		// 12,| 54, 65, 07, 23, 09 --> i=1, key=54, j=0
		// 12,| 54, 65, 07, 23, 09 --> 1st pass done (i=1)!

		// 12, 54,| 65, 07, 23, 09 --> i=2, key=65, j=1
		// 12, 54,| 65, 07, 23, 09 --> 2nd pass done (i=2)!

		// 12, 54, 65,| 07, 23, 09 --> i=3, key=7, j=2
		// 12, 54, 65,| 65, 23, 09 --> i=3, key=7, j=1
		// 12, 54, 54,| 65, 23, 09 --> i=3, key=7, j=0
		// 12, 12, 54,| 65, 23, 09 --> i=3, key=7, j=-1
		// 07, 12, 54,| 65, 23, 09 --> i=3, key=7, j=-1--> 3rd pass done (i=3)!

		// Fast forwarding and 4th and 5th pass will give:
		// 07, 12, 54, 65,| 23, 09 --> i=4, key=23, j=3
		// 07, 12, 23, 54,| 65, 09 --> After the 4th pass

		// 07, 12, 23, 54, 65,| 09 --> i=5, key=09, j=4
		// 07, 09, 12, 23, 54, 65| --> After the 5th pass

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
