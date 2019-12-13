package to_be_a_better_woman;
/**
 * 剑指offer第3题
 * 题目描述：在一个长度为n的数组里的所有数字都是在0~n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 * 例如：如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应输出的是重复数字2或者3。
 */


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class Q3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {0,1,2,3,2};
		int array_len = array.length;
		Q3 q3 = new Q3();
//		int ret = q3.my_method(array); //我自己想出来的方法
//		int ret = q3.hash_map_method(array); // 采用HashMap，遍历数组，不在哈希表中就添加，在的话就输出。
		int ret = q3.Purposeful_sorting(array);
		if (ret == array_len) {
			System.out.print("None");
		}
		else {
			System.out.print(ret);
		}
	}
	
	//解题思路：先对数组进行排序，再从头开始比较；
	public int my_method(int[] array) {
		Arrays.sort(array); //首先对数组进行排序
		int array_len = array.length;
		if(array_len <= 1) {  //数组为空或者只有一个值时，不存在重复值
			return array_len;
		}
		else {
			int ret = array[0];
			for(int i=1; i<array.length; i++) {
				if(array[i] == ret) {
					return ret;
				}
				else {
					ret = array[i];
//					continue;
				}
			}
			return array_len;   //遍历结束没有找到重复值则没有重复值
		}
		
	}
	//我的理解是哈希表就像python里的字典key:value
	public int hash_map_method(int[] array) {
		int array_len = array.length;
		if(array_len <= 1) {  //数组为空或者只有一个值时，不存在重复值
			return array_len;
		}
		else {
			Map<Integer, Integer> array_map = new HashMap<>();
			for(int x:array) {
				if (array_map.containsKey(x)){
					return x;
				}
				else {
					array_map.put(x, 1);
				} 
			}
			if(array_map.size() == array_len) {
				return array_len;
			}
		}
		return array_len;
	}
	
	//有规律地排序
	// 结合了数据的特点，n位0~n-1的数字按照顺序排好的话，应该是索引值==该位置的值
	public int Purposeful_sorting(int[] array) {
		int array_len = array.length;
		if(array_len <= 1) {  //数组为空或者只有一个值时，不存在重复值
			return array_len;
		}
		else {
			for(int i=0; i<array_len;i++) {
				int val = array[i];   //获取索引为i的数组的值
				if(i == val) {   //如果i和val相同，继续走
					continue;
				}
				else {//如果索引i和val不相同
					if(val == array[val]) { //并且val处的值已经是val了
						return val;
					}
					else {
						array[i] = array[val];
						array[val] = val;
					}
				}
			}
			return array_len;
		}
	}
}
