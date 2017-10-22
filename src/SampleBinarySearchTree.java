package com.example.collections;

public class SampleBinarySearchTree<E extends Comparable> {
	private  BTNode root = null;

	public SampleBinarySearchTree() {}

	SampleBinarySearchTree(E element) {
		root = new BTNode(element);
	}

	public void insert(E element) {
		BTNode temp = root;
		BTNode newNode = new BTNode(element);
		if (root == null) {
			root = newNode;
		} else  {
			while (true) {
				if (temp.compareTo(newNode) > 0) {
					if (temp.left == null) {
						temp.left = newNode;
						break;
					}
					temp = temp.left;
				} else if (temp.compareTo(newNode) < 0) {
					if (temp.right == null) {
						temp.right = newNode;
						break;
					}
					temp = temp.right;
				} else {
					if (temp.left == null) {
						temp.left = newNode;
						break;
					}
					temp = temp.left;
				}
			}
		}
	}

	private void print(BTNode node) {
		System.out.print(node.element+" ");
		BTNode left = node.left;
		BTNode right = node.right;
		if (left != null) {
			print(left);
		}
		if (right != null) {
			print(right);
		}
	}
	void printElements() {
		if (root != null) {
			print(root);
		}
		System.out.println();
	}
	void printInOrder() {
		inOrder(root);
		System.out.println();
	}
	void inOrder(BTNode root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.element+" ");
			inOrder(root.right);
		}
	}
	
	public class BTNode<E extends Comparable> implements Comparable<BTNode> {
		E element;
		BTNode<E> left, right;

		BTNode(E element) {
			this.element = element;
		}

		@Override
		public int compareTo(BTNode o) {
			return this.element.compareTo(o.element);
		}
		
	}
	
	public static void main(String args[]) {
		SampleBinarySearchTree sbt = new SampleBinarySearchTree();
		sbt.insert(0);
		sbt.insert(5);
		sbt.insert(2);
		sbt.insert(3);
		sbt.insert(50);
		sbt.insert(30);
		sbt.insert(20);
		sbt.insert(40);
		sbt.insert(70);
		sbt.insert(60);
		sbt.insert(80);
		sbt.printElements();
		sbt.printInOrder();
	}
}
