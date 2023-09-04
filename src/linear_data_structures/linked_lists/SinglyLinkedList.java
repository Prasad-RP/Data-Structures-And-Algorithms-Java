package linear_data_structures.linked_lists;

import java.util.Scanner;

/**
 * This file contains methods to create, traverse , insertion and deletion in a
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
	public void displayLinkedList() {
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
		 * value of head to new node.
		 */
		beginingNode.next = head;
		head = beginingNode;

		System.out.println("\nLinked List After insertion at Begining...\n");
		displayLinkedList();
	}

	/**
	 * method to insert element at the end of list.
	 * 
	 * @param data
	 */
	public void insertAtEnd(int data) {
		Node newNode = new Node(data);
		Node endingNode = head;
		// traversing till last node
		while (endingNode.next != null) {
			endingNode = endingNode.next;
		}
		// finally we reach at last node
		// then we simply assign new node value to last node
		endingNode.next = newNode;
		System.out.println("\nLinked List After insertion at End...\n");
		displayLinkedList();
	}

	/**
	 * method to insert element at given position
	 * 
	 * @param positionToInsert
	 * @param data
	 */
	public void insertAtGivenPosition(int positionToInsert, int data) {
		Node middleNode = head;
		Node newNode = new Node(data);
		int currentIndex = 0;
		// loop to reach upto the node where new node is going to be inserted
		while (middleNode != null && currentIndex < positionToInsert - 2) {
			middleNode = middleNode.next;
			currentIndex++;
		}
		// new node is point to current middle node
		newNode.next = middleNode.next;
		// middle node will be now new node
		middleNode.next = newNode;

		System.out.println("\nLinked List After insertion at position: " + positionToInsert + "\n");
		displayLinkedList();
	}

	// method to delete element at begining
	public void deleteAtBegining() {
		if (head == null) {
			System.out.println("Empty Linked List..");
		} else {
			// removing first node
			head = head.next;
		}
		System.out.println("Linked list after deleting first element...");
		displayLinkedList();
	}

	// method to delete element at end
	public void deleteAtEnd() {
		if (head == null) {
			System.out.println("Empty Linked List..");
		} else {
			// pointer to move upto second last node
			Node previousOfEndingNode = head;
			// pointer to move upto last node
			Node endingNode = previousOfEndingNode.next;

			while (endingNode.next != null) {
				previousOfEndingNode = endingNode;
				endingNode = endingNode.next;
			}
			// removing last node
			previousOfEndingNode.next = null;
		}
		System.out.println("Linked list after deleting last element...");
		displayLinkedList();
	}

	// method to delete element at given position
	public void deleteAtGivenPosition(int positionToInsert) {
		// pointer to move upto the previous of the node which is going to be deleted.
		Node previousOfMiddleNode = head;
		// pointer to move upto node which is going to be deleted.
		Node middleNode = previousOfMiddleNode.next;

		int currentIndex = 0;
		// loop to reach upto the node which is going to be deleted
		while (middleNode != null && currentIndex < positionToInsert - 2) {
			previousOfMiddleNode = middleNode;
			middleNode = middleNode.next;
			currentIndex++;
		}
		// setting address of deleted's next node to prev node
		previousOfMiddleNode.next = middleNode.next;

		System.out.println("\nLinked List After deleting element at position: " + positionToInsert + "\n");
		displayLinkedList();
	}

	// Menu for all operations
	public void showMenu() {
		int ch;
		System.out.println("Singly Linked list.... ");
		do {
			System.out.println(
					"\n0.create A linked list \n1.insert At begining \n2.Insert at Position \n3.Insert At end\n4.Delete At Begining\n5.Delete At position\n6.Delete at End\n7.Display list \n8.Exit");
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
				deleteAtBegining();
				break;
			case 5:
				System.out.print("Enter position to Delete: ");
				deleteAtGivenPosition(sc.nextInt());
				break;
			case 6:
				deleteAtEnd();
				break;
			case 7:
				displayLinkedList();
				break;
			case 8:
				System.exit(0);

			default:
				break;
			}
		} while (ch != 8);
	}

	public static void main(String[] args) {

		SinglyLinkedList list = new SinglyLinkedList();
		list.showMenu();
	}
}
