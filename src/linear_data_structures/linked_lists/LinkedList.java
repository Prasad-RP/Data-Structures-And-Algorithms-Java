package linear_data_structures.linked_lists;

import java.util.Scanner;

/**
 * This file contins methods to create and traverse a singly linked list.
 * 
 * @author Prasad Pansare
 *
 */
public class LinkedList {

	/**
	 * Class node for Linked list.
	 */
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	// Setting head to null , since no element is present in list.
	Node head = null;

	/**
	 * function for a creating Singly Linked list.
	 */
	public void createSinglyLinkedList() {
		int n, data;
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
	 * function for traversing Linked list.
	 */
	public void traverse() {
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
		LinkedList list = new LinkedList();
		list.createSinglyLinkedList();
		list.traverse();
	}
}
