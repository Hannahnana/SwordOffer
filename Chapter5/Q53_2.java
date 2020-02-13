package to_be_a_better_woman;

public class Q53_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array =  {-1,1,2};
		Q53_2 sss = new Q53_2();
		System.out.print(sss.NumequalsIndex(array));
	}
	public int NumequalsIndex(int[] array) {
		if(array==null||array.length==1) {
			return -1;
		}
		int low = 0;
		int high = array.length-1;
		return find(array,low,high);
	}
	public int find(int[] array, int low, int high) {
		if(low>high) return -1;
		int mid = (low+high)/2;
		if(array[mid]<mid) {
			low = mid+1;
		}else if(array[mid] == mid) {
			return mid;
		}else {
			high = mid-1;
		}
		return find(array,low,high);
	}
	

}
