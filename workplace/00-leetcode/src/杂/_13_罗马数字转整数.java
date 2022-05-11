package 杂;
/*
 * https://leetcode-cn.com/problems/roman-to-integer/
 */

//I， V， X， L，C，D 和 M
public class _13_罗马数字转整数 {
    public int romanToInt(String s) {
        char[] ch = s.toCharArray();
        int ret = 0;
        int i = 0;
    	for (; i < ch.length-1; i++) {
			if(ch[i] == 'I') {
				if(ch[i+1] == 'V') {
					ret += 4;
					i++;
				}else if(ch[i+1] == 'X') {
					ret += 9;
					i++;
				}else {
					ret += 1;
				}
			}else if(ch[i] == 'X') {
				if(ch[i+1] == 'L') {
					ret += 40;
					i++;
				}else if(ch[i+1] == 'C') {
					ret += 90;
					i++;
				}else {
					ret += 10;
				}
			}else if(ch[i] == 'C') {
				if(ch[i+1] == 'D') {
					ret += 400;
					i++;
				}else if(ch[i+1] == 'M') {
					ret += 900;
					i++;
				}else {
					ret += 100;
				}
			}else if(ch[i] == 'V'){
				ret += 5;
			}else if(ch[i] == 'L'){
				ret += 50;
			}else if(ch[i] == 'D'){
				ret += 500;
			}else if(ch[i] == 'M'){
				ret += 1000;
			}
		}
        if(i < ch.length) {
			if(ch[i] == 'I') {
				ret += 1;
			}else if(ch[i] == 'X') {			
				ret += 10;
			}else if(ch[i] == 'C') {
				ret += 100;
			}else if(ch[i] == 'V'){
				ret += 5;
			}else if(ch[i] == 'L'){
				ret += 50;
			}else if(ch[i] == 'D'){
				ret += 500;
			}else if(ch[i] == 'M'){
				ret += 1000;
			}
        }	
    	return ret;
    }
    	    public int romanToInt2(String s) {
    	        char[] chars = s.toCharArray();
    	        int num1 = 0,num2 = 0;
    	        int value = 0;
    	        for (int i = chars.length-1;i >= 0;i--){
    	            switch (chars[i]){
    	                case 'I' : num1 = 1;break;
    	                case 'V' : num1 = 5;break;
    	                case 'X' : num1 = 10;break;
    	                case 'L' : num1 = 50;break;
    	                case 'C' : num1 = 100;break;
    	                case 'D' : num1 = 500;break;
    	                case 'M' : num1 = 1000;break;
    	            }
    	            if (num2 <= num1){
    	                value += num1;
    	            }else{
    	                value -=num1;
    	            }
    	            num2 = num1;
    	        }
    	        return value;
    	    }
}
