package com.lonock;

import java.util.Comparator;

import com.mj.printer.BinaryTrees;
//import com.mj.printer.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		BinarySearchTree<Integer> t1 = new BinarySearchTree<>();
		AVLTree<Integer> t2 = new AVLTree<>(new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1-o2;
			}
		});
//		Integer data[] = new Integer[] {8,5,2,6,1,2,54,23,5,67,34,33,35};
		Integer data[] = new Integer[] {1,2,3,4,5,6,7,37,38};
		for(int a: data) {
			t2.add(a);
		}
		
		BinaryTrees.println(t2);
//		t2.add(37);
//		t2.add(38);
		t2.remove(5);
//		t2.postorder();
//		System.out.println(t2.successor(t2.node(6)));
//		t2.inorderbystack();
//	BinaryTrees.PrintStyle(t1);
		BinaryTrees.println(t2);
		
	}
}
