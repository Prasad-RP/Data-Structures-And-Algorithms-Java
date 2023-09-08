package linear_data_structures.queues;

import java.util.Scanner;

/**
 * File contains all queue operations using Linked List data structure.
 * 
 * @author Prasad Pansare
 *
 */
public class QueueWithLinkedList {
	class Queue {
		int data;
		Queue next;

		public Queue(int data) {
			this.data = data;
			this.next = null;
		}
	}

	Queue front = null;
	Queue rear = null;

	int enQueue(int data) {
		Queue node = new Queue(data);
		if (rear == null && front == null) {
			rear = node;
			front = node;
		} else {
			rear.next = node;
			rear = node;
		}
		return data;
	}

	void deQueue() {
		if (isEmpty()) {
			System.out.println("Queue Underflow.");
		} else {
			front = front.next;
		}
	}

	// to display the Queue
	void displayQueue() {
		Queue ptr = front;
		while (ptr != null) {
			System.out.print(" " + ptr.data);
			ptr = ptr.next;
		}
		System.out.println();
	}

	boolean isEmpty() {
		if (front == null) {
			return true;
		}
		return false;
	}

	void callMenu() {
		int ch;
		Scanner sc = new Scanner(System.in);
		System.out.println("Stack using Array");
		do {
			System.out.println("\n1.Enqueue\n2.Dequeue\n3.Display\n4.Exit");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				System.out.println("Enter element to enqueue: ");
				enQueue(sc.nextInt());
				break;
			case 2:
				deQueue();
				break;
			case 3:
				displayQueue();
				break;
			case 4:
				System.exit(0);
			default:
				break;
			}
		} while (ch != 5);

	}

	public static void main(String[] args) {
		QueueWithLinkedList queue = new QueueWithLinkedList();
		queue.callMenu();
	}
}
