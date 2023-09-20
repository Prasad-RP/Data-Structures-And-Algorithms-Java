package non_linear_data_structures.tress;

import java.util.Scanner;

/**
 * File contains all tree operations using Linked list data structure.
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

	/**
	 * Recurrsive function to create a binary tree.
	 * 
	 * @return root Node
	 */
	static Node create() {
		Scanner sc = new Scanner(System.in);

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

	public static void main(String[] args) {

		Node root = create();
	}
}
