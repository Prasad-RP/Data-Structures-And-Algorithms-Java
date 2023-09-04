package linear_data_structures.linked_lists;

import java.util.Scanner;

import linear_data_structures.linked_lists.CircularLinkedList.Node;

/**
 * This file contains methods to create, traverse , insertion and deletion in a
 * singly circular linked list.
 * 
 * @author Prasad Pansare
 *
 */
public class SinglyCircularLinkedList {
	// global resourse for accepting user input
	Scanner sc = new Scanner(System.in);

	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	Node head = null;
	Node tail = null;

	// to create a Singly Circular Linked List
	public void createSinglyCircularLinkedList() {
		int data;
		int n;
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

	// to traverse the list
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

	public void insertAtBegining(int data) {
		Node newNode = new Node(data);
		/*
		 * first we assign value of new node's next to head and then then we assign
		 * value of head to new node , also we need to connect them from end i.e tail
		 */
		newNode.next = head;
		head = newNode;
		tail.next = newNode;
		System.out.println("Linked list after inserting element at begining...");
		displayLinkedList();
	}

	public void insertAtEnd(int data) {
		Node newNode = new Node(data);
		/*
		 * we have tail node which is points to last node so to insert last node we need
		 * to set, tail's next to node , new node's next to head and tail to new node
		 * since it is pointing to last
		 */
		tail.next = newNode;
		newNode.next = head;
		tail = newNode;
		System.out.println("Linked list after inserting element at end...");
		displayLinkedList();
	}

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

	public void deleteAtBegining() {
		if (head == null) {
			System.out.println("Empty Linked List..");
		} else {
			head = head.next;
			tail.next = head;
		}
		System.out.println("Linked list after deleting first element...");
		displayLinkedList();
	}

	public void deleteAtEnd() {
		if (head == null) {
			System.out.println("Empty Linked List..");
		} else {
			Node previousOfEndingNode = head;
			Node endingNode = previousOfEndingNode.next;
			while (endingNode.next != head) {
				previousOfEndingNode = endingNode;
				endingNode = endingNode.next;
			}
			previousOfEndingNode.next = head;
			tail = previousOfEndingNode;

		}
		System.out.println("Linked list after deleting first element...");
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
		System.out.println("Singly Circular Linked list.... ");
		do {
			System.out.println(
					"\n0.create A linked list \n1.insert At begining \n2.Insert at Position \n3.Insert At end\n4.Delete At Begining\n5.Delete At position\n6.Delete at End\n7.Display list \n8.Exit");
			System.out.println("Enter Your choice : ");
			ch = sc.nextInt();
			switch (ch) {
			case 0:
				createSinglyCircularLinkedList();
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
		SinglyCircularLinkedList list = new SinglyCircularLinkedList();
		list.showMenu();
	}
}
