package linear_data_structures.arrays;

/**
 * 
 * @author Prasad Pansare
 * @category This file contains Linear search implementation of array.
 *
 */
public class LinearSerach {
	/**
	 * 
	 * @param arr
	 * @param search
	 * @return index of element if present else 0.
	 */

	public static int linearSerach(int arr[], int search) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == search) {
				return i;
			}
		}
		return 0;
	}

	public static void main(String[] args) {

		int arr[] = { 1, 2, 33, 4, 66, 78, 9 };
		int search = 66;
		if (linearSerach(arr, search) == 0) {
			System.out.println("Element not found..");
		} else {
			System.out.println("Element found at index: " + linearSerach(arr, search));
		}

	}
}
