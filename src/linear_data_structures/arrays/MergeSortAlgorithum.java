package linear_data_structures.arrays;

import java.util.Scanner;

/**
 * This class contains methods for sorting an array using merge sort.
 * 
 * @author Prasad Pansare
 */
public class MergeSortAlgorithum {

	/**
	 * This is an method which will merge given array into a temp array and retuns a
	 * orinal array by sorting it.
	 * 
	 * @param arr  -> array that is going to sort
	 * @param low  -> first index of array
	 * @param mid  -> mid index of array
	 * @param high ->last index of array
	 * @return Sorted array using merge procedure
	 */
	public static int[] mergeProcedure(int arr[], int low, int mid, int high) {
		int temp[] = new int[100];
		int i = low, j = mid + 1, k = low;

		// loop executes till any one array not finished since we have divided our array
		// into two subparts
		while (i <= mid && j <= high) {
			// merging first array into temporary array
			if (arr[i] < arr[j]) {
				temp[k] = arr[i];
				i++;
			}
			// merging first array into temporary arrayelse
			{
				temp[k] = arr[j];
				j++;
			}
			// K must be incresed since any one of condition will be executed
			k++;
		}
		// copying remaining elements of first array
		while (i <= mid) {
			temp[k] = arr[i];
			i++;
			k++;
		}
		// copying remaining elements of second array
		while (j <= high) {
			temp[k] = arr[j];
			j++;
			k++;
		}
		// copying elements of temporary array into original array
		for (int l = low; l <= high; l++) {
			arr[l] = temp[l];
		}
		return arr;
	}

	/**
	 * This is an recurrsive merge sort which will call to mergeProcedur. It will
	 * divide array till low is less than high i.e upto 2 elements.
	 * 
	 * @param a    -> array to apply merge sort
	 * @param low  ->first index of array
	 * @param high ->last index of array
	 */
	public static void mergeSort(int arr[], int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid + 1, high);
			mergeProcedure(arr, low, mid, high);
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
		// Driver code
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number of elements in array: ");
		int n = sc.nextInt();
		int a[] = new int[n];

		for (int i = 0; i < n; i++) {
			System.out.println("Enter Number at index: " + (i + 1));
			int ele = sc.nextInt();
			a[i] = ele;
		}

		System.out.println("Array elements before merge sort...");
		printArray(a);
		// calling merge sort
		mergeSort(a, 0, n - 1);
		System.out.println("Array elements after merge sort...");
		printArray(a);
	}
}
