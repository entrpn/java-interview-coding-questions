package com.example.collections;

public class SampleLinkedList<E> {

	Node<E> start;
	Node<E> current;
	Node<E> previous;
	private int count;

	public SampleLinkedList(){
		count = 0;
	}

	public void addFirst(E e){
		if (start != null){
			Node<E> startCurrent = start;
			start = new Node(e);
			start.setNextNode(startCurrent);
		} else{
			add (e);
		}
		count++;
	}
	
	public E get(int index){
		if (index > count) throw new IndexOutOfBoundsException("Index: "+index+", Size: "+count);
	
		int i=0;
		Node<E> temp = start;
		while (i < index){
			temp = temp.getNextNode();
			i++;
		}
		
		return temp.getObj();
		
	}
	
	public void add(int index, E e){
		if (index > count) throw new IndexOutOfBoundsException("Index: "+index+", Size: "+count);
		
		int i =0;
		Node temp = start;
		Node previous = null;
		while (i < index){
			previous = temp;
			temp = temp.getNextNode();
			i++;
		}
		
		Node<E> newCurrent = temp;
		temp = new Node(e);
		temp.setNextNode(newCurrent);
		previous.setNextNode(temp);
	
		count++;
	}
	
	public void removeLast(){
		
	}

	public void add(E e){

		if (start == null){
			start = new Node(e);
			current = start;
		} else{
			Node temp = new Node(e);
			current.setNextNode(temp);
			previous = current;
			current = current.getNextNode();
		}
		count++;
	}

	public int size(){
		return count;
	}

	public class Node<E> {
		private E obj;
		private Node nextNode;
		
		public Node(){}
		
		public Node(E obj){
			this.obj = obj;
		}
		
		public E getObj() {
			return obj;
		}
		public void setObj(E obj) {
			this.obj = obj;
		}
		Node getNextNode() {
			return nextNode;
		}
		void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}
	}
}
