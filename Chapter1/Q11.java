package to_be_a_better_woman;
/**
 *剑指offer第11题
 *题目描述：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出其中最小的元素。
 *如：数组{3，4，5，1，2}是数组{1，2，3，4，5}的一个旋转，该数组的最小值为1。
 *解题思路：对于有序或部分有序的数组的查找，最适用的方法是二分查找法。
 *旋转数组可以看作是两个排序的子数组，并且前面的子数组的元素都大于或等于后面子数组的元素。
 *所以我们可以用两个指针分别指向第一个元素和最后一个元素（第一个元素大于或等于最后一个元素，还有特例）
 *接着，我们应该找到数组中间的元素，如果中间元素大于等于第一个指针指向的元素，那么此时数组的最小值应该处于中间元素的后面。
 *因此我们把第一个指针指向中间元素，移动后的第一个指针仍位于前面的递增子数组。循环停止的条件是两个指针指向相邻的位置，则第二个指针指向的是最小值。、
 *
 *特例一：所有的元素都搬到了数组的末尾，此时如果第一个指针小于第二个指针，直接返回第一个值。
 *特例二：第一个指针和第二个指针以及中间元素值都一样，此时只能进行顺序查找。如{1，0，1，1，1}和{1，1，1，0，1}  
 *关于特例二，看牛客网上大佬分享的思路，可以通过以下方式(如minNumberInRotateArray_dl()所示)进行避免以上所说情况。
 */
public class Q11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	//我的想法是，最小值的位置是，从前往后遍历，返回第一次使得array[i+1]<array[i]的array[i+1]的值
	//时间复杂度为O(n)
	public int minNumberInRotateArray_mine(int [] array) {
		if(array.length == 0) {
			return 0;
		}else if(array.length == 1){
			return array[0];
		}else {
			if(array[0]<array[array.length-1]) {
				return array[0]; 
			}else {
				int i=0;
				while(array[i]<=array[i+1]) {
					i++;
				}
				return array[i+1];
			}
		}
    }
	public int minNumberInRotateArray_dl(int [] array) {
		int i=0, j=array.length-1;
		while(i<j) {
			if(array[i]<array[j]) {
				return array[i];
			}
			int mid = (i+j)/2;
			if(array[mid]>array[i]) {
				i = mid + 1;
			}else if(array[mid]<array[i]) {
				j = mid; //mid-1 的话可能错过最小值
			}else {
				i++;  //完美避免了上述特例二的情况
			}
		}
		return array[i];
	}
}
