package to_be_a_better_woman;

import java.util.HashMap;
import java.util.Map;

public class Q39 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q39 ms = new Q39();
		int [] array = new int[] {};
		System.out.print(ms.MoreThanHalfNum_Solution(array));
	}
	public int MoreThanHalfNum_Solution(int [] array) {
		if(array.length==1) {
			return array[0];
		}
        Map<Integer,Integer> aaa = new HashMap<Integer,Integer>();
        for(int x:array) {
        	if(aaa.containsKey(x)) {
        		aaa.put(x, aaa.get(x)+1);
        		if(aaa.get(x)>array.length/2.0) {
        			return x;
        		}
        	}
        	else {
        		aaa.put(x, 1);
        	}
        }
		return 0;
    }

}
