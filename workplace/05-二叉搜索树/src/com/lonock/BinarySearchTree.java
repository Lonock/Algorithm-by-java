package com.lonock;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.management.Query;

import java.lang.Comparable;

import com.lonock.BinaryTree.Node;
import com.mj.printer.*;

public class BinarySearchTree<E> extends BinaryTree<E>{
	
	public BinarySearchTree(){

	}
	
	public BinarySearchTree(Comparator<E> com){
		comparator = com;
	}
	
	public void add(E element) {
		Node<E> node = root;
		if(node == null) {
			root = createNode(element, null);
			size++;
			afterAdd(node);
			return;
		}
		
		while(true) {
			int cmp = compare(element, node.elementE);
			if(cmp < 0) {
				if(node.left == null) {
					node.left = createNode(element,node.parent);
					size++;
					afterAdd(node);
					return;
				}
				node = node.left;
			}else if(cmp > 0) {
				if(node.right == null) {
					node.right = createNode(element,node.parent);
					size++;
					afterAdd(node);
					return;
				}
				node = node.right;
			}else {
				afterAdd(node);
				return;
			}
		}
	}
	
	protected void afterAdd(Node<E> node) {
		
	}
	
	public Node<E> node(E element) {
		Node<E> node = root;
		while(node!=null) {
			if(comparator.compare(element, node.elementE) > 0)
				node = node.right;
			else if(comparator.compare(element, node.elementE) < 0)
				node = node.left;
			else
				return node;
		}
		return null;
	}
	
	public E remove(E element) {
		Node<E> node = node(element);
		if(node == null) return null;
		
		if(node.leavescount() == 2) {//2个叶子
			Node<E> prenode = predecessor(node);
			node.elementE = prenode.elementE;
			node = prenode;
		}
		
		if(node.leavescount() == 1) {
			Node<E> leafNode = node.left != null ? node.left : node.right;
//			node.elementE = leafNode.elementE;
//			node = leafNode;
			leafNode.parent = node.parent;
			if(node.parent == null) root = null;
			if(node == node.parent.left) 
				node.parent.left = leafNode;
			else
				node.parent.right = leafNode;
		}
		
		if(node.leavescount() == 0) {
			if(node.parent == null) root = null;
			if(node == node.parent.left) 
				node.parent.left = null;
			else
				node.parent.right = null;
		}
		return element;
		
	}
}
