package com.example.collections;

import java.util.EmptyStackException;

public class SampleStack<E> {
	
	private SampleLinkedList<E> list;
	
	public SampleStack(){
	list = new SampleLinkedList<E>();
	}
	
	public E pop(){
		if (list.start == null) throw new EmptyStackException(); 
		
		E retval = list.current.getObj();
		
		list.current = list.previous;
		
		return retval;
	}
	
	public void push(E e){
		list.add(e);
	}
	
	public E peek(){
		return list.current.getObj();
	}
	
	public static void main(String[] args){
		SampleStack<Integer> stack = new SampleStack();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		System.out.println("peeking "+stack.peek());
		
		System.out.println("stack.pop: "+stack.pop());
		System.out.println("stack.pop: "+stack.pop());
		
	}

}
