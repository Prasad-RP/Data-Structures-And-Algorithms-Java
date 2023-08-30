package linear_data_structures.arrays;

import java.util.Scanner;
/**
 * 
 * @author Prasad Pansare
 *
 */
public class QuickSortAlgorithm {

	/**
	 * This is an method which will merge given array into a temp array and retuns a
	 * partition index such at left this index all elements are less than equal and
	 * at right side all elements are greater than partition index.
	 * 
	 * @param arr
	 * @param low
	 * @param high
	 * @return partition index
	 */
	private static int partitionProcedure(int[] arr, int low, int high) {
		// Choosing the first element as the pivot
		int pivot = arr[low];
		// i is for finding element greater than or equal to pivot
		int i = low + 1;
		// j is for finding element less than pivot
		int j = high;
		// temporary variable for swapping
		int temp;

		// This procedure will execute till I < J
		do {
			// loop will execute till we found element greater than or equal to pivot
			while (arr[i] <= pivot) {
				i++;
			}
			// loop will execute till we found element less to pivot
			while (arr[j] > pivot) {
				j--;
			}
			// when I exceeds J , we'll swap them
			if (i < j) {
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		} while (i < j);

		// final swapping in array and returning partition index
		temp = arr[low];
		arr[low] = arr[j];
		arr[j] = temp;

		return j;
	}

	/**
	 * This is an recurrsive quick sort which will call to partitionProcedure. It
	 * will divide array till low is less than high i.e upto 2 elements.
	 * 
	 * @param arr
	 * @param low
	 * @param high
	 */
	public static void quickSort(int arr[], int low, int high) {
		if (low < high) {
			// partition index
			int partitionIndex = partitionProcedure(arr, low, high);
			quickSort(arr, low, partitionIndex - 1);
			quickSort(arr, partitionIndex + 1, high);
		}
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
		// calling quick sort
		quickSort(a, 0, n - 1);
		System.out.println("Array elements after sort...");
		printArray(a);
	}
}
