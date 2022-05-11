package com.Lonock.single;
import java.util.Stack;

import com.Lonock.LinkedList;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CricleSingleLinkedList<Integer> linkList = new CricleSingleLinkedList<Integer>();
		linkList.add(10);
		linkList.add(20);
		linkList.add(30);
		linkList.add(40);
		linkList.add(50);
		linkList.add(60);
		linkList.add(70);
		linkList.add(0,0);
		linkList.add(7,80);
//		System.out.println(linkList);
//		linkList.add(4, 50);
		linkList.remove(0);
		linkList.remove(7);
////		
		System.out.println(linkList.get(7));

		
	}
}
