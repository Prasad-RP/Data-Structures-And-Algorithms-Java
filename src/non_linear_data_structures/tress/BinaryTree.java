package non_linear_data_structures.tress;

import java.util.Scanner;

/**
 * File contains all tree operations(create , traverse) using Linked list data
 * structure.
 * 
 * @author Prasad Pansare
 *
 */
class Node {
	Integer data;
	Node leftChild;
	Node rightChild;

	Node(Integer data) {
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
	}
}

public class BinaryTree {
	Scanner sc = new Scanner(System.in);

	/**
	 * Recurrsive function to create a binary tree.
	 * 
	 * @return root Node
	 */
	Node create() {

		System.out.println("Enter value of Node(for exit, enter -1):");
		int data = sc.nextInt();
		if (data == -1)
			return null;
		Node root = new Node(data);
		System.out.println("Enter left child of : " + root.data);
		root.leftChild = create();
		System.out.println("Enter Right child of : " + root.data);
		root.rightChild = create();
		return root;
	}

	// Tree Traversals
	void inOrder(Node root) {
		if (root != null) {
			inOrder(root.leftChild);
			System.out.println(root.data);
			inOrder(root.rightChild);
		}
	}

	void preOrder(Node root) {
		if (root != null) {
			System.out.println(root.data);
			preOrder(root.leftChild);
			preOrder(root.rightChild);
		}
	}

	void postOrder(Node root) {
		if (root != null) {
			postOrder(root.leftChild);
			postOrder(root.rightChild);
			System.out.println(root.data);
		}
	}

	void callMenu() {
		int ch;
		Node root = null;
		System.out.println("Binary Tree using Linked List");
		do {
			System.out.println("\n1.Create\n2.InOrder\n3.Preorder\n4.PostOrder\n5.Exit");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				root = create();
				break;
			case 2:
				System.out.println("Inorder of tree..");
				inOrder(root);
				break;
			case 3:
				System.out.println("Preorder of tree..");
				preOrder(root);
				break;
			case 4:
				System.out.println("Postorder of tree..");
				postOrder(root);
				break;
			case 5:
				System.exit(0);
			default:
				break;
			}
		} while (ch != 6);
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.callMenu();
	}
}
