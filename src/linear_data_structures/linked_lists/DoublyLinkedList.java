package linear_data_structures.linked_lists;

import java.util.Scanner;

/**
 * This file contains methods to create and traverse in a Doubly linked list.
 * 
 * @author Prasad Pansare
 *
 */
public class DoublyLinkedList {
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

	public void createDoublyLinkedList() {
		int n;
		int data;
		do {
			System.out.println("Enter element to create Linked list: ");
			data = sc.nextInt();
			Node newNode = new Node(data);

			if (head == null) {
				head = newNode;
				tail = newNode;
			} else {
				/*
				 * Its basically insertion in begining , first set prev of head to new node then
				 * new node's next now 1st node i.e head so set it. and now modify head to new
				 * node.
				 */
				head.prev = newNode;
				newNode.next = head;
				head = newNode;
			}
			// For adding extra elements (depends on user.)
			System.out.println("Do you wants to add more data, If yes Enter 1.");
			n = sc.nextInt();
		} while (n == 1);
	}

	// to traverse the list
	public void displayLinkedList() {
		Node ptr = head;
		if (head == null) {
			System.out.println("LL does not exist...");
		} else {
			System.out.println("Elements of Linked List...");
			while (ptr != null) {
				System.out.print(ptr.data + " ");
				ptr = ptr.next;
			}
		}
	}

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.createDoublyLinkedList();
		list.displayLinkedList();
	}
}
