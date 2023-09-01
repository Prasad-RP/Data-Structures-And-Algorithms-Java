package linear_data_structures.arrays;

import java.util.Scanner;

/**
 * 
 * @author Prasad Pansare
 *
 */
public class SelectionSortAlgorithm {
	/**
	 *  method for selection sort 
	 * @param arr
	 * @return sorted array
	 */
	public static int[] selectionSort(int arr[]) {
		// loop for each pass 
		for (int i = 0; i < arr.length - 1; i++) {
			//assuming i is our minimum index for each pass
			int minIndex = i;
			// loop for comparision array element with min Index element i.e element at min Index 
			for (int j = i + 1; j < arr.length; j++) {
				// actual comparision to find minimum from array
				if (arr[j] < arr[minIndex]) {
					// if minimum element found assigning it to mimimum
					minIndex = j;
				}
			}
			// swapping element at I and minimum index with each other
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
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
		
		// Dry run for selection sort
		// Input Array (There will be total n-1 passes. 
		// 00  01  02  03  04 -->index
		// |03, 05, 02, 13, 12

		// After first pass
		// 00  01  02  03  04 -->index
		// 02,|05, 03, 13, 12

		// After second pass
		// 00  01  02  03  04 -->index
		// 02, 03,|05, 13, 12

		// After third pass
		// 00  01  02  03  04 -->index
		// 02, 03, 05,|13, 12

		// After fourth pass
		// 00  01  02  03  04 -->index
		// 02, 03, 05, 12,|13

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
		// calling quick sort
		selectionSort(a);
		System.out.println("Array elements after sort...");
		printArray(a);
	}
}
