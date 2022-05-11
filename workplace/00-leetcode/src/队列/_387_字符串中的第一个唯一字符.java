package 队列;
/*
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 */
public class _387_字符串中的第一个唯一字符 {
    public int firstUniqChar(String s) {
    	char[] ch = s.toCharArray();
    	for (int i = 0; i < ch.length; i++) {
			for (int j = 0; j < ch.length; j++) {
				if(ch[i] == ch[j] && i != j)
					break;
				if(j == ch.length - 1)
					return i;
			}
		}
    	return -1;
    }
    
}
