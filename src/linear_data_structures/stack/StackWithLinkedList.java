package linear_data_structures.stack;

import java.util.Scanner;

public class StackWithLinkedList {
	Scanner sc = new Scanner(System.in);

	class Stack {
		int data;
		Stack next;

		Stack(int data) {
			this.data = data;
			this.next = null;
		}
	}

	Stack top = null;

	// to push element in stack
	int push(int data) {
		Stack node = new Stack(data);

		if (top == null) {
			top = node;
		} else {
			// similar to insertion in the begining concept from singly linked list
			node.next = top;
			top = node;
		}
		return data;
	}

	// to pop element in stack
	int pop() {
		int data = -1;
		if (top == null) {
			System.out.println("Stack UnderFlow");
		} else {
			// similar to deletion in the begining concept from singly linked list
			data = top.data;
			top = top.next;
		}
		return data;
	}

	// to check where our top is pointing now
	int peek() {
		return top.data;
	}

	// to display the Stack
	void displayStack() {
		Stack stack = top;
		while (stack != null) {
			System.out.print(" " + stack.data);
			stack = stack.next;
		}
		System.out.println();
	}

	// to perform opearation , this is driver code
	void callMenu() {
		int ch;
		System.out.println("Stack using Array");
		do {
			System.out.println("\n1.Push\n2.Pop\n3.Display\n4.Peek\n5.Exit");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				System.out.println("Enter element to push: ");
				push(sc.nextInt());
				break;
			case 2:
				pop();
				break;
			case 3:
				displayStack();
				break;
			case 4:
				System.out.println("Element at top : " + peek());
				;
				break;
			case 5:
				System.exit(0);
			default:
				break;
			}
		} while (ch != 5);
	}

	public static void main(String[] args) {
		StackWithLinkedList stack = new StackWithLinkedList();
		stack.callMenu();
	}

}
