package com.Lonock;
import java.util.Iterator;
import java.util.Stack;

import com.Lonock.LinkedList;
public class Main {

	static int josephus() {
		CricleLinkedList<Integer> list = new CricleLinkedList<Integer>();
		for (int i = 1; i < 9; i++) {
			list.add(i);
		}
		list.reset();
		while(list.size() != 1) {
			for (int i = 0; i < 2; i++) {
				list.next();
			}
			System.out.println(list.remove()); 
		}
		return list.get(0);
	}
	
	public static void main(String[] args) {
		System.out.println(new int[] {-1,-1});
//		System.out.println(josephus());
		// TODO Auto-generated method stub
//		CricleLinkedList<Integer> linkList = new CricleLinkedList<Integer>();
//		linkList.add(10);
//		linkList.add(20);
//		linkList.add(30);
//		linkList.add(40);
//		linkList.add(50);
//		linkList.add(60);
//		linkList.add(70);
//		linkList.add(0,0);
//		linkList.add(8,80);
////		System.out.println(linkList);
////		linkList.add(4, 50);
//		linkList.remove(0);
//		linkList.remove(3);
////		
//		System.out.println(linkList);

		
	}
}
