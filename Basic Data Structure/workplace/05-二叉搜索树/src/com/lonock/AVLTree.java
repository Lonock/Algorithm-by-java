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
		private int height = 1;
		
		public int balanceFactor() {
			int leftHeight = left == null? 0 : ((AVLNode<E>)left).height;
			int rightHeight = right == null? 0 : ((AVLNode<E>)right).height;
			return leftHeight - rightHeight;
		}
		
		public void updateHeight() {
			int leftHeight = left == null? 0 : ((AVLNode<E>)left).height;
			int rightHeight = right == null? 0 : ((AVLNode<E>)right).height;
			int maxHeight = Math.max(leftHeight, rightHeight);
			height = maxHeight + 1;
		}
		
		public Node<E> tallerChild() {
			int leftHeight = left == null? 0 : ((AVLNode<E>)left).height;
			int rightHeight = right == null? 0 : ((AVLNode<E>)right).height;
			if(leftHeight > rightHeight) return left;
			else return right;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			if(parent != null)
				return elementE + "(" + parent.elementE + ")" + "_" + height;
			else
				return elementE + "(" + "null" + ")" + "_" + height;
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
				rotateright(grand);
			}else {//LR
				rotateleft(parent);
				rotateright(grand);
			}
		}else {//R
			if(node.isRightChild()) {//RR
				rotateleft(grand);
			}else {//RL
				rotateright(parent);
				rotateleft(grand);
			}
		}
	}
	
	private void rotateleft(Node<E> grand) {
		Node<E> parent = grand.right;
		if(grand.isLeftChild()) {
			grand.parent.left = parent;
		}else if(grand.isRightChild()) {
			grand.parent.right = parent;
		}else {
			root = parent;
		}
		parent.parent = grand.parent;
		grand.right = parent.left;
		if(parent.left != null)
			parent.left.parent = grand;
		parent.left = grand;
		grand.parent = parent;

		updateHeight(grand);
		updateHeight(parent);
	}
	
	private void rotateright(Node<E> grand) {
		Node<E> parent = grand.left;
		if(grand.isLeftChild()) {
			grand.parent.left = parent;
		}else if(grand.isRightChild()){
			grand.parent.right = parent;
		}else {
			root = parent;
		}
		parent.parent = grand.parent;
		grand.left = parent.right;
		if(grand.left != null)
			grand.left.parent = grand;
		parent.right = grand;
		grand.parent = parent;

		updateHeight(grand);
		updateHeight(parent);
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
				break;
			}
		}
		
	}
	
	protected void afterRemove(Node<E> node) {
		while((node = node.parent) != null) {
			if(isBalanced(node)) {
				updateHeight(node);
			}else {
				rebanlance(node);
			}
		}
		
	}
	

}
