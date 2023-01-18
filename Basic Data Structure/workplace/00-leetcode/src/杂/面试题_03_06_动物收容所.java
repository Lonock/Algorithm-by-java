package 杂;

import java.util.LinkedList;

public class 面试题_03_06_动物收容所 {
	LinkedList<int[]> dogList;
	LinkedList<int[]> catList;
	
	public 面试题_03_06_动物收容所() {
		dogList = new LinkedList<>();
		catList = new LinkedList<>();
    }
    
    public void enqueue(int[] animal) {
    	if(animal[1] == 0)
    		catList.add(animal);
    	else
    		dogList.add(animal);
    }
    
    public int[] dequeueAny() {
    	if(dogList.isEmpty())
    		return dequeueCat();
    	else if(catList.isEmpty())
    		return dequeueDog();
    	if(dogList.peekFirst()[0] < catList.peekFirst()[0])
    		return dequeueDog();
    	else
    		return dequeueCat();
    }
    
    public int[] dequeueDog() {
    	if(dogList.isEmpty())
    		return new int[] {-1,-1};
    	else
    		return dogList.removeFirst();
    }
    
    public int[] dequeueCat() {
    	if(catList.isEmpty())
    		return new int[] {-1,-1};
    	else
    		return catList.removeFirst();
    }
}
