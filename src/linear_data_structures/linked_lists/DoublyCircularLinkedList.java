package linear_data_structures.linked_lists;

import java.util.Scanner;

/**
 * This file contains methods to create , traverse , Insert and Delete in a
 * Doubly Circular linked list.
 * 
 * @author Prasad Pansare
 *
 */
public class DoublyCircularLinkedList {

	// global resourse for accepting user input
	Scanner sc = new Scanner(System.in);

	class Node {
		int data;
		Node next;
		Node prev;

		Node(int data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	Node head = null;
	Node tail = null;

	public void createDoublyCircularLinkedList() {
		int n;
		int data;
		do {
			System.out.println("Enter element to create Doubly Circular Linked list: ");
			data = sc.nextInt();
			Node newNode = new Node(data);

			if (head == null) {
				head = newNode;
				tail = newNode;
				newNode.prev = newNode;
				newNode.next = newNode;
			} else {
				newNode.next = head;
				newNode.prev = tail;
				tail.next = newNode;
				head.prev = newNode;
				head = newNode;
			}
			// For adding extra elements (depends on user.)
			System.out.println("Do you wants to add more data, If yes Enter 1.");
			n = sc.nextInt();
		} while (n == 1);
	}

	public void displayLinkedList() {
		Node ptr = head;
		if (head == null) {
			System.out.println("LL does not exist...");
		} else {
			System.out.println("\nElements of Linked List...");
			do {
				System.out.print(ptr.data + " ");
				ptr = ptr.next;
			} while (ptr != head);
			System.out.println();
		}
	}

	public static void main(String[] args) {
		DoublyCircularLinkedList list = new DoublyCircularLinkedList();
		list.createDoublyCircularLinkedList();
		list.displayLinkedList();
	}
}
