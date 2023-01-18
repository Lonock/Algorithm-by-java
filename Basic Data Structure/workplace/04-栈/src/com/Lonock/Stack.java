package com.Lonock;

public class Stack<E> {
	private int size = 0;
	private Node<E> first = null; 
	
	private static class Node<E> {
		E elementE;
		Node<E> next;
		
		public Node(E elementE, Node<E> next) {
			this.elementE = elementE;
			this.next = next;
		}
	}
	
	int size() {
		return size;
	}
	boolean isEmpty() {
		return size == 0;
	}
	void push(E element) {
		first = new Node<>(element, first);
	}
	E pop() {
		E old = first.elementE;
		first = first.next;
		return old;
	}
	E top() {
		return first.elementE;
	}
	void clear() {
		first = null;
	}
	
}
