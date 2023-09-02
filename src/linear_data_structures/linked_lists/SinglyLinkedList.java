package linear_data_structures.linked_lists;

import java.util.Scanner;

/**
 * This file contins methods to create, traverse , insertion and deletion in a
 * singly linked list.
 * 
 * @author Prasad Pansare
 *
 */

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

public class SinglyLinkedList {
	// global resourse for accepting user input
	Scanner sc = new Scanner(System.in);

	// Setting head to null , since no element is present in list.
	Node head = null;

	/**
	 * function for a creating Singly Linked list.
	 */
	public void createSinglyLinkedList() {
		int n;
		int data;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Enter element to create Linked list: ");
			data = sc.nextInt();
			Node newNode = new Node(data);
			// if linked list does not exist, then we assign value of head to new node
			if (head == null) {
				head = newNode;
			}
			/*
			 * if linked list exist , then first we assign value of new node's next to head
			 * and then then we assign value of head to new node (Basically its insertion in
			 * the begining)
			 */
			else {
				newNode.next = head;
				head = newNode;
			}
			// For adding extra elements (depends on user.)
			System.out.println("Do you wants to add more data, If yes Enter 1.");
			n = sc.nextInt();
		} while (n == 1);
	}

	/**
	 * function for traversing the whole Linked list.
	 */
	public void traverse() {
		Node ptr = head;
		if (head == null) {
			System.out.println("LL does not exist...");
		} else {
			System.out.println("\nElements of Linked List...");
			while (ptr != null) {
				System.out.print(ptr.data + " ");
				ptr = ptr.next;
			}
			System.out.println();
		}
	}

	/**
	 * method to insert element at begining of list
	 * 
	 * @param data
	 */
	public void insertAtBegining(int data) {
		Node beginingNode = new Node(data);
		/*
		 * first we assign value of new node's next to head and then then we assign
		 * value of head to new node This will only happen if head is not null
		 */
		if (head != null) {
			beginingNode.next = head;
			head = beginingNode;
		}
	}

	/**
	 * method to insert element at the end of list.
	 * 
	 * @param data
	 */
	public void insertAtEnd(int data) {
		Node endingNode = new Node(data);
		Node ptr = head;
		// traversing till last node
		while (ptr.next != null) {
			ptr = ptr.next;
		}
		// finally we reach at last node
		// then we simply assign new node value to last node
		ptr.next = endingNode;
	}

	/**
	 * method to insert element at given position
	 * 
	 * @param positionToInsert
	 * @param data
	 */
	public void insertAtGivenPosition(int positionToInsert, int data) {
		Node ptr = head;
		Node middleNode = new Node(data);
		int currentIndex = 0;
		while (ptr != null && currentIndex < positionToInsert - 2) {
			ptr = ptr.next;
			currentIndex++;
		}
		middleNode.next = ptr.next;
		ptr.next = middleNode;
	}

	// Menu for all operations
	public void callMenu() {
		int ch;
		System.out.println("Linked list.... ");
		do {
			System.out.println(
					"\n0.create A linked list \n1.insert At begining \n2.Insert at Position \n3.Insert At end \n4.Display list \n5.Exit");
			System.out.println("Enter Your choice : ");
			ch = sc.nextInt();
			switch (ch) {
			case 0:
				createSinglyLinkedList();
				break;
			case 1:
				System.out.print("Enter element to insert at begining: ");
				int element = sc.nextInt();
				insertAtBegining(element);
				break;
			case 2:

				System.out.print("Enter position to insert: ");
				int positionToInsert = sc.nextInt();
				System.out.print("Enter element to insert at given position: ");
				insertAtGivenPosition(positionToInsert, sc.nextInt());
				break;
			case 3:
				System.out.print("Enter element to insert at End: ");
				insertAtEnd(sc.nextInt());
				break;
			case 4:
				traverse();
				break;
			case 5:
				System.exit(0);

			default:
				break;
			}
		} while (ch != 5);
	}

	public static void main(String[] args) {

		SinglyLinkedList list = new SinglyLinkedList();
		list.callMenu();
	}
}
