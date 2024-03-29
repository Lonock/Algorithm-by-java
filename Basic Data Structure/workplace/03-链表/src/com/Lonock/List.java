package com.Lonock;

public interface List<E> {
	void clear();
	
	int size();
	
	void checkIndex(int index);
	
	boolean isEmpty();
	
	boolean contains(E element);
	
	void add(E element);
	
	E get(int index);
	
	E set(int index, E element);
	
	void add(int index, E element);
	
	E remove(int index);
	
	int indexOf(E element);
}
