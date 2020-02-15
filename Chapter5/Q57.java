package to_be_a_better_woman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Q57 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2,4,7,15};
		int sum = 15;
		Q57 a = new Q57();
		System.out.print(a.FindNumbersWithSum2(array, sum));
	}
	//非递增情况下的解法
	//时间复杂度O(n^2)
	//空间复杂度O(1)
	public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		for(int i=0; i<array.length-1;i++) {
			int cha = sum-array[i];
			for(int j=i+1;j<=array.length-1;j++) {
				if(array[j]==cha) {
					a.add(array[i]);
					a.add(array[j]);
				}
			}
		}
		return a;
    }
	//非递增下的优化解法
	//这是借鉴leetcode的两数之和，但是这个不求下标，所以没那么麻烦
	//时间复杂度O(n)
	//空间复杂度O(n)
	public ArrayList<Integer> FindNumbersWithSum1(int [] array,int sum) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<array.length;i++) {
			if(map.containsKey(array[i])) {
				a.add(sum-array[i]);
				a.add(array[i]);
			}
			map.put(sum-array[i], i);
		}
		return a;
	}
	//利用有序这个特点做大
	//两个指针一个从0开始，一个从array.length-1开始把最大和最小的数字加一起，如果大了，大数小一点
	//时间复杂度为O(n)
	//空间复杂度为O(1)
	public ArrayList<Integer> FindNumbersWithSum2(int [] array,int sum) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		int low = 0;
		int high = array.length-1;
		int s = 0;
		while(low<high) {
			s = array[low] + array[high];
			if(s>sum) {
				high--;
			}else if(s<sum) {
				low++;
			}else {
				a.add(array[low]);
				a.add(array[high]);
				break;
			}
		}
		return a;
	}
}
