package linear_data_structures.linked_lists;

import java.util.Scanner;

/**
 * 
 * @author Prasad Pansare
 *
 */
public class SinglyCircularLinkedList {
	// global resourse for accepting user input
	Scanner sc = new Scanner(System.in);

	/**
	 * Class node for Linked list.
	 */
	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	// point to first element
	Node head = null;
	// point to last element
	Node tail = null;

	/**
	 * function for a creating Singly Linked list.
	 */
	public void createSinglyCircularLinkedList() {
		int n;
		int data;
		do {
			System.out.println("Enter element to create Linked list: ");
			data = sc.nextInt();
			Node newNode = new Node(data);
			// if linked list does not exist, then we assign value of head to new node
			// and also tail is equal to new node due to only one node and circular list
			if (head == null) {
				head = newNode;
				tail = newNode;
				newNode.next = head;
			}
			/*
			 * if linked list exist , then first we assign value of new node's next to head
			 * and then then we assign value of head to new node and we have last node
			 * called tail , so assign tail's next to head . since it is a circular list
			 * (Basically its insertion in the begining)
			 */
			else {
				newNode.next = head;
				head = newNode;
				tail.next = head;
			}
			// For adding extra elements (depends on user.)
			System.out.println("Do you wants to add more data, If yes Enter 1.");
			n = sc.nextInt();
		} while (n == 1);
	}

	/**
	 * function for traversing the whole Linked list.
	 */
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
		SinglyCircularLinkedList list = new SinglyCircularLinkedList();
		list.createSinglyCircularLinkedList();
		list.displayLinkedList();
	}
}
