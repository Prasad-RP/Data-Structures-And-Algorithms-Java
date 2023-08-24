package linear_data_structures.arrays;

import java.util.Scanner;

/**
 * 
 * @author Prasad Pansare
 *  This file conatins methods for insertion, deletion in array.
 *         
 */
public class ArrayExample1D {

	/**
	 * 
	 * @param arr
	 * @param index
	 * @return array with removed element from given index.
	 */
	public static int[] removeElementByIndex(int arr[], int index) {
		int b[] = new int[arr.length - 1];
		for (int i = 0; i < arr.length; i++) {
			if (i < index) {
				b[i] = arr[i];
			} else if (i == index) {
				continue;
			} else {
				b[i - 1] = arr[i];
			}
		}
		return b;
	}

	/**
	 * 
	 * @param arr
	 * @param index
	 * @param element
	 * @return array with added element for given index.
	 */
	public static int[] addElement(int arr[], int index, int element) {
		int b[] = new int[arr.length + 1];
		for (int i = 0; i < b.length; i++) {
			if (i < index) {
				b[i] = arr[i];
			} else if (i == index) {
				b[i] = element;
			} else {
				b[i] = arr[i - 1];
			}
		}
		return b;
	}

	@SuppressWarnings("resource")
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
		System.out.println("Array elements..");
		for (int i = 0; i < n; i++) {
			System.out.println(a[i]);
		}
		
		// driver codes

//		System.out.println("Enter index to insert: ");
//		int index = sc.nextInt();
//
//		System.out.println("Enter index to insert: ");
//		int element = sc.nextInt();
//		int[] addElement = addElement(a, index, element);
//
//		System.out.println("Array elements after insertion..");
//		for (int i = 0; i < addElement.length; i++) {
//			System.out.println(addElement[i]);
//		}

		System.out.println("Enter index to delete: ");
		int index = sc.nextInt();
		int[] removeElementByIndex = removeElementByIndex(a, index);

		System.out.println("Array elements after deletion..");
		for (int i = 0; i < removeElementByIndex.length; i++) {
			System.out.println(removeElementByIndex[i]);
		}

	}
}
