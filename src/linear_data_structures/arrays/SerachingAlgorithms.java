package linear_data_structures.arrays;

/**
 * 
 * @author Prasad Pansare
 * @category This file contains implementations searching algorithums of array.
 *
 */
public class SerachingAlgorithms {

	/**
	 * Method for linear search / also called as brute force search.
	 * @param arr
	 * @param search
	 * @return index if element is present else return 0.
	 */
	public static int linearSerach(int arr[], int search) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == search) {
				return i;
			}
		}
		return 0;
	}

	/**
	 * Method for Binary search.
	 * @param arr
	 * @param search
	 * @return index if element is present else return 0.
	 */
	public static int binarySerach(int arr[], int search) {
		int firstIndex = 0, lastIndex = arr.length - 1, midIndex;		
		// Loop executes till first index exceeds last index
		while (firstIndex <= lastIndex) {
			// setting mid index
			midIndex = (firstIndex + lastIndex) / 2;
			// if element found at middle then return mid index
			if (arr[midIndex] == search) {
				return midIndex;
			}
			// if element is greater than element at mid index then change first index to
			// mid +1
			else if (arr[midIndex] < search) {
				firstIndex = midIndex + 1;
			}
			// if element is less than element at mid index then change last index to mid -1
			else {
				lastIndex = midIndex - 1;
			}

		}
		return 0;
	}

	public static void main(String[] args) {

//		// Driver code for Linear Serch (Unsorted array)
//		int arr[] = { 1, 2, 33, 4, 66, 78, 9 };
//		int search = 66;
//		if (linearSerach(arr, search) == 0) {
//			System.out.println("Element not found..");
//		} else {
//			System.out.println("Element found at index: " + linearSerach(arr, search));
//		}

		// Driver code for Binary Serch (Sorted array)
		int sortedArray[] = { 11, 22, 33, 42, 66, 78, 99 };
		int searchElement = 66;
		int binarySerach = binarySerach(sortedArray, searchElement);
		if (binarySerach == 0) {
			System.out.println("Element not found..");
		} else {
			System.out.println("Element found at index: " + binarySerach);
		}

	}
}
