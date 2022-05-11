package 杂;
/*
 * https://leetcode-cn.com/problems/number-of-students-unable-to-eat-lunch/
 */
public class _1700_无法吃午餐的学生数量 {
	   public int countStudents(int[] students, int[] sandwiches) {
		   int ret = students.length;
		   int num0 = 0;
		   int num1 = 0;
		   for (int i = 0; i < students.length; i++) {
			    if(students[i] == 0) num0++;
			    else num1++;
		   }
		   for (int j = 0; j < sandwiches.length; j++) {
//			   for (int i = 0;i < students.length; i++) {
////				   i = i % students.length;
//				   if(students[i] == sandwiches[j]) {
//					   ret--;
//					   if(j == sandwiches.length - 1)
//						   return ret;
//					   students[i] = 2;
//					   if(sandwiches[j] == 0) {
//						   if(--num0 <= 0 && sandwiches[j+1] == 0) 
//							   return ret;
//					   }else {
//						   if(--num1 <= 0 && sandwiches[j+1] == 1) 
//							   return ret;
//					   }
//					   break;
//				   }
//			   }
//			   if(num0 == 0 && sandwiches[j] == 0) //第一个就卡死
//				   return ret;
//			   if(num1 == 0 && sandwiches[j] == 1) 
//				   return ret;
			   if(sandwiches[j] == 0) {
				   if(num0 > 0) {
					   num0--;
					   ret--;
				   }else {
					   return ret;
				   }
			   }else if(sandwiches[j] == 1) {
				   if(num1 > 0) {
					   num1--;
					   ret--;
				   }else {
					   return ret;
				   }
			   }
		   }
		   return ret;
	    }
	   
}
