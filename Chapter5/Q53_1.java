package to_be_a_better_woman;
////0~n-1中缺少的数字
public class Q53_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = {1,2,3,4,5};
		Q53_1 sss = new Q53_1();
		System.out.print(sss.GetMissingNum1(a));
		}
	//时间复杂度为O(n)的解法
	public int GetMissingNum(int[] array) {
		if(array==null||array.length==0) {
			return 0;
		}
		int n = array.length;  //0~n-1中最大的数字是n-1，因为缺少了一个数字，所以数组长度为n-1。因此应求1~array.length的和
		int sum1 = n*(n+1)/2;
		int sum2 = 0;
		for(int x:array) {
			sum2+=x;
		}
		return (sum1-sum2);
	}
	public int GetMissingNum1(int[] array) {
		if(array==null||array.length==0) {
			return 0;
		}
		int low = 0;
		int high = array.length-1;
		return find(array,low,high);
	}
	public int find(int[] array, int low, int high) {
		if(low>=array.length-1) return array.length;
		if(high<=0) return 0;
		int mid = (low+high)/2;
		if(mid==array[mid]) { //往后找
			low = mid+1;
		}
		else if(array[mid]>mid){
			if(mid>0) {
				if(array[mid-1] == mid-1)  return mid;
				else high = mid-1;
			}
			else if(mid==0) return mid;
		}
		return find(array,low,high);
	}
}
