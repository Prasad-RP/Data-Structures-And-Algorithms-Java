package linear_data_structures.queues;

import java.util.Scanner;

public class CircularQueue {
	public int size = 10;
	int queue[] = new int[size];
	int front = -1;
	int rear = -1;

	// to check if queue is empty or not
	boolean isEmpty() {
		return front == -1 && rear == -1;
	}

	// to check if queue is full or not
	boolean isFull() {
		return (rear + 1) % size == front;
	}

	// to enqueue (insert ) element in queue
	int enQueue(int data) {
		if (isFull()) {
			System.out.println("Queue Overflow.");
		} else if (front == -1 && rear == -1) {
			front = 0;
			rear = 0;
			queue[rear] = data;
		} else {
			// for circular queue
			rear = (rear + 1) % size;
			queue[rear] = data;
		}
		return data;
	}

	// to deQueue (delete) element in queue
	int deQueue() {
		int data = -1;
		if (isEmpty()) {
			System.out.println("Queue Underflow.");
		} else if (front == rear) {
			data = queue[front];
			front = -1;
			rear = -1;
		} else {
			data = queue[front];
			front = (front + 1) % size;
		}
		return data;
	}

	// display
	void displayQueue() {
		if (isEmpty()) {
			System.out.println("Queue is empty.");
			return;
		}
		System.out.println("Elements of Queue:");
		int i = front;
		do {
			System.out.print(" " + queue[i]);
			i = (i + 1) % size;
		} while (i != (rear + 1) % size);
		System.out.println();
	}

	/*
	 // display in another way
	void displayQueue() {
		if (isEmpty()) {
			System.out.println("Queue is empty.");
			return;
		}
		System.out.println("Elements of Queue:");
		int i = front;
		for (; i != rear; i = (i + 1) % size) {
			System.out.print(" " + queue[i]);
		}
		System.out.print(" " + queue[i] + "\n");
	}
	 */
	
	public static void main(String[] args) {
		CircularQueue queue = new CircularQueue();
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
