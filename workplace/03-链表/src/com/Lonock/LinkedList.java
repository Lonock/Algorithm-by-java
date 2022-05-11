package com.Lonock;

import java.util.Iterator;

public class LinkedList<E> implements List<E>{
	private int size = 0;
	private Node<E> first = null; 
	private Node<E> last = null;
	
	private static class Node<E> {
		E elementE;
		Node<E> next;
		Node<E> prev;
		
		public Node(Node<E> prev, E elementE, Node<E> next) {
			this.elementE = elementE;
			this.next = next;
			this.prev = prev;
		}
		
	}
	
	@Override
	public void clear() {
		first = last = null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public boolean contains(E element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void add(E element) {
		// TODO Auto-generated method stub
		add(size,element);
	}

	@Override
	public E get(int index) {
		checkIndex(index);
		return getNode(index).elementE;
	}
	
	public Node<E> getNode(int index){
		if(index < size >> 1){ 
			Node<E> node = first;
			for (int i = 0; i < index; i++) {
				node = node.next;
			}
			return node;
		}else {
			Node<E> node = last;
			for (int i = size-1; i > index; i--) {
				node = node.prev;
			}
			return node;
		}
	}

	@Override
	public E set(int index, E element) {
		Node<E> node = getNode(index);
		E old = node.elementE;
		node.elementE = element;
		return old;
	}

	@Override
	public void add(int index, E element) {
		if (size == 0) {
			first = last = new Node<>(null,element,null);
		}else if(index == 0) {
			Node<E> newFirst = new Node<>(null, element, first);
			first.prev = newFirst;
			first = newFirst;
		}else if(index == size){
			Node<E> prev = getNode(index);
			prev.next = new Node<>(prev, element, prev.next);
			last = prev.next;
		}
		else{
			checkIndexForAdd(index);
			Node<E> next = getNode(index);
			next.prev = new Node<>(next.prev, element, next);
			next.prev.prev.next = next.prev;
		}
		size++;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		E old = null;
		Node<E> node = getNode(index);
		Node<E> prev = node.prev;
		Node<E> next = node.next;
		old = node.elementE;
		
		if(size==1) {
			clear();
		}else if(index == 0) {
			next.prev = prev;
			first = next;
		}else if(index == size-1){
			prev.next = next;
			last = prev;
		}else {
			prev.next = next;
			next.prev = prev;
		}
		
		size--;
		return old;
	}

	@Override
	public int indexOf(E element){
		for (Node<E> node = first; node.next != null; node = node.next) 
			if(node.elementE == element) 
				return size;
		return -1;
	}

//	public boolean equal(E element){
//		
//		return true;
//	}
	
	@Override
	public void checkIndex(int index) {
		if(index >= size || index < 0) {
			throw new ArrayIndexOutOfBoundsException("参数越界");
		}
	}
	
	public void checkIndexForAdd(int index) {
		if(index > size || index < 0) {
			throw new ArrayIndexOutOfBoundsException("参数越界");
		}
	}
	
	public String toString() {
		String str = "The size is: " + size + "，[";
		int i = 0;
		for (; i < size - 1; i++) {
			str = str + get(i) + " ,";
		}
		str += get(i) + "]";
		
		return str;
	}
	
}
