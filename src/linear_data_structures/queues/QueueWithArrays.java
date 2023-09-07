package linear_data_structures.queues;

import java.util.Scanner;

/**
 * File contains all queue operations using array data structure.
 * 
 * @author Prasad Pansare
 *
 */
public class QueueWithArrays {

	int[] queue = new int[10];
	int front = -1;
	int rear = -1;

	// to check if queue is empty or not
	boolean isEmpty() {
		if (front == -1) {
			return true;
		} else {
			return false;
		}
	}

	// to check if queue is full or not
	boolean isFull() {
		if (rear == queue.length - 1) {
			return true;
		} else {
			return false;
		}
	}

	// to enqueue (insert ) element in queue
	int enQueue(int data) {
		if (isFull()) {
			System.out.println("Queue Overflow.");
		} else if (isEmpty()) {
			front = 0;
			rear = 0;
			queue[rear] = data;
		} else {
			rear++;
			queue[rear] = data;
		}
		return data;
	}

	// to deQueue (delete ) element in queue
	int deQueue() {
		int data = -1;
		if (isEmpty()) {
			System.out.println("Queue Underflow.");
		} else {
			data = queue[front];
			front++;
		}
		return data;
	}

	// display
	void displayQueue() {
		System.out.println("Elements of Queue..\n");
		for (int i = front; i <= rear; i++) {
			System.out.print(" " + queue[i]);
		}
	}

	public static void main(String[] args) {
		QueueWithArrays queue = new QueueWithArrays();
		int ch;
		Scanner sc = new Scanner(System.in);
		System.out.println("Stack using Array");
		do {
			System.out.println("\n1.Enqueue\n2.Dequeue\n3.Display\n4.Exit");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				System.out.println("Enter element to enqueue: ");
				queue.enQueue(sc.nextInt());
				break;
			case 2:
				queue.deQueue();
				break;
			case 3:
				queue.displayQueue();
				break;
			case 4:
				System.exit(0);
			default:
				break;
			}
		} while (ch != 5);
	}
}
