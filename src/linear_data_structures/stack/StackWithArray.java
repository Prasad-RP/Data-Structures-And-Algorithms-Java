package linear_data_structures.stack;

import java.util.Scanner;

/**
 * File contains all stack operations using array data structure.
 * 
 * @author Prasad Pansare
 *
 */
class Stack {
	int top = -1;
	int n = 10;
	int stack[] = new int[n];

	// to insert(push) element in stack
	int push(int data) {
		if (isFull()) {
			System.out.println("Stack Overflow.");
		} else {
			top++;
			stack[top] = data;
			System.out.println("Element pushed in stack");
		}
		return data;
	}

	// to remove(pop) element from stack
	int pop() {
		int data = -1;
		if (isEmpty()) {
			System.out.println("Stack Underflow.");
		} else {
			stack[top] = data;
			top--;
			System.out.println("Element popped from stack");
		}
		return data;
	}

	// to check stack underflow condition
	boolean isEmpty() {
		if (top == -1) {
			return true;
		}
		return false;
	}

	// to check stack overflow condition
	boolean isFull() {
		if (top == stack.length - 1) {
			return true;
		}
		return false;
	}

	// to display the Stack
	void displayStack() {
		if (isEmpty()) {
			System.out.println("Stack Underflow.");
		} else {
			for (int i = top; i >= 0; i--) {
				System.out.print(" " + stack[i]);
			}
		}
	}

	// to check where our top is pointing now
	int peek() {
		return stack[top];
	}
}

public class StackWithArray {
	public static void main(String[] args) {

		Stack stack = new Stack();
		int ch;
		Scanner sc = new Scanner(System.in);
		System.out.println("Stack using Array");
		do {
			System.out.println("\n1.Push\n2.Pop\n3.Display\n4.Peek\n5.Exit");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				System.out.println("Enter element to push: ");
				stack.push(sc.nextInt());
				break;
			case 2:
				stack.pop();
				break;
			case 3:
				stack.displayStack();
				break;
			case 4:
				System.out.println("Element at top : " + stack.peek());
				break;
			case 5:
				System.exit(0);
			default:
				break;
			}
		} while (ch != 5);
	}
}
