package linear_data_structures.linked_lists;

import java.util.Scanner;

public class DoublyLinkedListOperations {
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

	public void insertAtBegining(int data) {
		Node newNode = new Node(data);

		/*
		 * first set prev of head to new node then new node's next now 1st node i.e head
		 * so set it. and now modify head to new node.
		 */
		head.prev = newNode;
		newNode.next = head;
		head = newNode;

		// to display the change
		System.out.println("Linked list after inserting element at begining...");
		displayLinkedList();
	}

	public void insertAtEnd(int data) {
		Node newNode = new Node(data);
		/*
		 * since we already have last element i.e tail so, setting last element's next
		 * to new node's , and new node's prev to tail and updating tail to new node.
		 */
		tail.next = newNode;
		newNode.prev = tail;
		tail = newNode;

		// to display the change
		System.out.println("Linked list after inserting element at end...");
		displayLinkedList();
	}

	public void insertAtGivenPosition(int positionToInsert, int data) {
		Node newNode = new Node(data);
		Node previousOfMiddleNode = head;
		Node middleNode = previousOfMiddleNode.next;
		int currentIndex = 0;
		// loop to reach upto the node where new node is going to be inserted
		while (middleNode.next != null && currentIndex < positionToInsert - 1) {
			previousOfMiddleNode = middleNode;
			middleNode = middleNode.next;
			currentIndex++;
		}
		// here , we are at position where we need to insert, now linking them
		// so new nodes prev will be previousOfMiddleNode
		newNode.prev = previousOfMiddleNode;
		// new nodes next will be MiddleNode
		newNode.next = middleNode;
		// previousOfMiddleNode'S next will be New node
		previousOfMiddleNode.next = newNode;
		// and MiddleNode'S prev will be New node
		middleNode.prev = newNode;

		System.out.println("\nLinked List After insertion at position: " + positionToInsert + "\n");
		displayLinkedList();
	}

	public void deleteAtBegining() {
		if (head == null) {
			System.out.println("Empty Linked List..");
		} else {
			Node ptr = head;
			head = head.next;
			head.prev = null;
			ptr.next = null;
		}
		System.out.println("Linked list after deleting first element...");
		displayLinkedList();
	}

	public void deleteAtEnd() {
		if (head == null) {
			System.out.println("Empty Linked List..");
		} else {
			Node ptr = tail;
			tail = tail.prev;
			tail.next = null;
			ptr.prev = null;
		}
		System.out.println("Linked list after deleting last element...");
		displayLinkedList();
	}

	// Menu for all operations
	public void showMenu() {
		int ch;
		System.out.println("Doubly Linked list.... ");
		do {
			System.out.println(
					"\n0.create A linked list \n1.insert At begining \n2.Insert at Position \n3.Insert At end\n4.Delete At Begining\n5.Delete At position\n6.Delete at End\n7.Display list \n8.Exit");
			System.out.println("Enter Your choice : ");
			ch = sc.nextInt();
			switch (ch) {
			case 0:
				createDoublyLinkedList();
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
//			case 5:
//				System.out.print("Enter position to Delete: ");
//				deleteAtGivenPosition(sc.nextInt());
//				break;
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
		DoublyLinkedListOperations list = new DoublyLinkedListOperations();
		list.showMenu();
	}
}
