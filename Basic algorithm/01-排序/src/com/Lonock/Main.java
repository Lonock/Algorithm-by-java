package com.Lonock;

public class Main {

	public static void main(String[] args) {
		
		Integer[] array = {1,4,5,13,56,21,7,234,6,56,43,75,214};
		
//		for (int end = array.length; end > 0; end--) {
//			boolean shorter = true;
//			for (int begin = 1; begin < end; begin++) {
//				if(array[begin] < array[begin-1]) {
//					int tmp = array[begin];
//					array[begin] = array[begin-1];
//					array[begin-1] = tmp;
//					shorter = false;
//				}
//			}
//			if(shorter) break;
//		}
		bubbleSort3(array);
		
		for (Integer i = 0; i < array.length; i++) {
			System.out.print(array[i] + "_");
		}
	}
	
	static void bubbleSort1(Integer[] array) {
		for (int end = array.length; end > 0; end--) {
			for (int begin = 1; begin < end; begin++) {
				if(array[begin] < array[begin-1]) {
					int tmp = array[begin];
					array[begin] = array[begin-1];
					array[begin-1] = tmp;
				}
			}
		}
	}
	
	static void bubbleSort2(Integer[] array) {//若有序则提前结束排序
		for (int end = array.length; end > 0; end--) {
			boolean shorter = true;//排序过程是否进行了交换
			for (int begin = 1; begin < end; begin++) {
				if(array[begin] < array[begin-1]) {
					int tmp = array[begin];
					array[begin] = array[begin-1];
					array[begin-1] = tmp;
					shorter = false;
				}
			}
			if(shorter) break;//未进行交换，数组已有序，直接结束。
		}
	}
	
	static void bubbleSort3(Integer[] array) {//如果末尾已排好序则末尾不再排序
		for (int end = array.length; end > 0; end--) {
			int shortIndex = 0;
			for (int begin = 1; begin < end; begin++) {
				if(array[begin] < array[begin-1]) {
					int tmp = array[begin];
					array[begin] = array[begin-1];
					array[begin-1] = tmp;
					shortIndex = begin;//最后一次交换的位置
				}
			}
			end = shortIndex + 1;
		}
	}
}
