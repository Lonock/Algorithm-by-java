package com.Lonock.single;

import java.util.Iterator;

import com.Lonock.List;

public class CricleSingleLinkedList<E> implements List<E>{
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
	
	@Override
	public void clear() {
		first = null;
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
//		checkIndex(index);
		Node<E> node = first;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
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
		if(size==0) {
			first = new Node<>(element,first);
//			getNode(size-1).next = first;
			first.next = first;
		}else if(index == 0) {
			Node newFirst = new Node<>(element,first);
			getNode(size-1).next = first;
			first = newFirst;
		}else {
			checkIndexForAdd(index);
			Node<E> prev = getNode(index - 1);
			prev.next = new Node<>(element,prev.next);
			// TODO Auto-generated method stub
		}
		size++;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		E old = null;
		if(index == 0) {
			getNode(size-1).next = first.next;
			first = first.next;
		}else if(size == 1) {
			clear();
		}else {
			Node<E> prev = getNode(index - 1);
			Node<E> node = prev.next;
			old = node.elementE;
			prev.next = node.next;
		}
		size--;
		return old;
	}

	@Override
	public int indexOf(E element) {
		for (Node<E> node = first; node.next != null; node = node.next) {
			if(node.elementE == element) {
				return size;
			}
		}
		// TODO Auto-generated method stub
		return -1;
	}

//	public boolean equal(E element){
//		
//		return true;
//	}
	
	@Override
	public void checkIndex(int index) {
		if(index >= size) {
			throw new ArrayIndexOutOfBoundsException("参数越界");
		}
	}
	
	public void checkIndexForAdd(int index) {
		if(index > size) {
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
