package com.lonock;

import java.util.Comparator;

public class AVLTree<E> extends BinarySearchTree<E>{

	private static class AVLNode<E> extends Node<E> {
		public AVLNode(E element) {
			super(element);
			// TODO Auto-generated constructor stub
		}
		
		public AVLNode(E element, Node<E> parent) {
			super(element,parent);
		}
		int height;
		
		public int balanceFactor() {
			int leftHeight = left == null? 0 : ((AVLNode<E>)left).height;
			int rightHeight = right == null? 0 : ((AVLNode<E>)right).height;
			return leftHeight - rightHeight;
		}
		
		public void updateHeight() {
			int leftHeight = left == null? 0 : ((AVLNode<E>)left).height;
			int rightHeight = right == null? 0 : ((AVLNode<E>)right).height;
			int maxHeight = Math.max(leftHeight, rightHeight);
		}
		
		public Node<E> tallerChild() {
			int leftHeight = left == null? 0 : ((AVLNode<E>)left).height;
			int rightHeight = right == null? 0 : ((AVLNode<E>)right).height;
			if(leftHeight < rightHeight) return left;
			else return right;
		}
	}
	
	@Override
	protected Node<E> createNode(E element, Node<E> parent) {
		// TODO Auto-generated method stub
		return new AVLNode<>(element, parent);
	}
	
	private boolean isBalanced(Node<E> node) {
		return Math.abs(((AVLNode<E>)node).balanceFactor()) <= 1;
	}
	
	private void updateHeight(Node<E> node) {
		((AVLNode<E>)node).updateHeight();
	}
	
	private void rebanlance(Node<E> grand) {
		Node<E> parent = ((AVLNode<E>)grand).tallerChild();
		Node<E> node = ((AVLNode<E>)grand).tallerChild();
		if(parent.isLeftChild()) {//L
			if(node.isLeftChild()) {//LL
				rotateleft(grand);
			}else {//LR
				rotateright(parent);
				rotateleft(grand);
			}
		}else {//R
			if(node.isLeftChild()) {//RL
				rotateright(grand);
			}else {//RR
				rotateleft(parent);
				rotateright(grand);
			}
		}
	}
	
	private void rotateleft(Node<E> node) {
		
	}
	
	private void rotateright(Node<E> node) {
		
	}
	
	public AVLTree() {
		this(null);
	}
	
	public AVLTree(Comparator<E> com){
		super(com);
	}
	
	protected void afterAdd(Node<E> node) {
		while((node = node.parent) != null) {
			if(isBalanced(node)) {
				updateHeight(node);
			}else {
				rebanlance(node);
			}
		}
		
	}
	

}
