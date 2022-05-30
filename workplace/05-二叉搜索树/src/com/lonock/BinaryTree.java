package com.lonock;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.mj.printer.BinaryTreeInfo;

public class BinaryTree<E> implements BinaryTreeInfo{
	protected int size = 0;
	protected Node<E> root = null;
	protected Comparator<E> comparator;
	
	protected static class Node<E> {
		E elementE;
		Node<E> left;
		Node<E> right;
		Node<E> parent;
		
		public Node(E element){
			elementE = element;
		}
		public Node(E element, Node<E> head){
			elementE = element;
			this.parent = head;
		}
		
		public int leavescount() {
			int count = 0;
			if(left != null) count++;
			if(right != null) count++;
			return count;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return elementE+"";
		}
		
		public boolean isLeftChild() {
			if(parent == null) return false;
			return this == parent.left;
		}
		
		public boolean isRightChild() {
			if(parent == null) return false;
			return this == parent.right;
		}
	}
	
	public BinaryTree(){

	}
	
	public BinaryTree(Comparator<E> com){
		comparator = com;
	}
	
	protected Node<E> createNode(E element, Node<E> parent) {
		return new Node<>(element, parent);
	}
	
	public int size() {
		return size;
	}
	
	public boolean empty() {
		return size == 0;
	}
	
	@SuppressWarnings("unchecked")
	protected int compare(E e1,E e2) {
		if(comparator != null) {
			return comparator.compare(e1,e2);
		}
		return ((Comparable<E>) e1).compareTo(e2);
	}
	
	public void preorder() {
		preorder(root);
	}
	
	public void preorderbystack() {
		preorderbystack(root);
	}
	
	public void inorder() {
		inorder(root);
	}
	
	public void inorderbystack() {
		inorderbystack(root);
	}
	
	public void postorder() {
		postorder(root);
	}
	
	public void floororder() {
		floororder(root);
	}
	
	public void preorder(Node<E> node) {
		if(node == null)
			return;
		
		System.out.print(node.elementE+"_");
//		System.out.print("_");
		preorder(node.left);
		preorder(node.right);
	}
	
	public void preorderbystack(Node<E> node) {
		if(node == null)
			return;
		
		Stack<Node<E>> st = new Stack<>();
		st.push(node);
		
		while(!st.empty()) {
			node = st.pop();
			System.out.print(node.elementE + "_");
			if(node.right!=null)
				st.push(node.right);
			if(node.left!=null)
				st.push(node.left);
		}
	}
	
	public void inorder(Node<E> node) {
		if(node == null)
			return;
		
		inorder(node.left);
		System.out.print(node.elementE+"_");
		inorder(node.right);
	}

	public void inorderbystack(Node<E> node) {
		if(node == null)
			return;
		Stack<Node<E>> st = new Stack<>();
		while(!st.empty() || node!=null) {
			while(node!=null ) {
				st.push(node);
				node = node.left;
			}
			node = st.pop();
			System.out.print(node.elementE + "_");
			node = node.right;
		}
	}
	
	public void postorder(Node<E> node) {
		if(node == null)
			return;
		
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.elementE+"_");
	}

	public void postbystack(Node<E> node) {
		if(node == null)
			return;
		Stack<Node<E>> st = new Stack<>();
		while(!st.empty() || node!=null) {
			while(node!=null ) {
				st.push(node);
				node = node.left;
			}
			node = st.pop();
			System.out.print(node.elementE + "_");
			node = node.right;
		}
	}
	
	public void floororder(Node<E> node) {
		if(node == null)
			return;
		
		Queue<Node<E>> l1 = new LinkedList<>();
		l1.offer(node);
		while(!l1.isEmpty()) {
			node = l1.poll();
			System.out.print(node.elementE+"_");
			
			if(node.left != null) {
				l1.offer(node.left);
			}
			if(node.right != null) {
				l1.offer(node.right);
			}
		}
	}
	
	public Node<E> predecessor(Node<E> node) {
		if(node == null) return null;
		if(node.left != null) {
			node = node.left;
			while(node.right != null) 
				node = node.right;
			return node;
		}else {
			while(node.parent != null) {
				if(node == node.parent.right)
					return node.parent;
				else
					node = node.parent;
			}
		}
		
		return null;
	}
	
	public Node<E> successor(Node<E> node){
		if(node == null) return null;
		if(node.right != null) {
			node = node.right;
			while(node.left != null) 
				node = node.left;
			return node;
		}else {
			while(node.parent != null) {
				if(node == node.parent.left)
					return node.parent;
				else
					node = node.parent;
			}
		}
		
		return null;
	}
	
	public boolean contain() {
		
		return true;
	}

	
	
	@Override
	public Object root() {
		// TODO Auto-generated method stub
		return root;
	}

	@Override
	public Object left(Object node) {
		// TODO Auto-generated method stub
		return ((Node<E>) node).left;
	}

	@Override
	public Object right(Object node) {
		// TODO Auto-generated method stub
		return ((Node<E>) node).right;
	}

	@Override
	public Object string(Object node) {
		// TODO Auto-generated method stub
		return ((Node<E>) node).elementE;
	}
}
