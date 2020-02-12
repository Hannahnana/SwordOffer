package to_be_a_better_woman;

public class Q53 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q53 s = new Q53();
		int[] array = {1,2,3,4,5,5,6};
		int k = 7;
		System.out.print(s.GetNumberOfK(array, k));

	}
	public int GetNumberOfK(int [] array , int k) {
		if(array==null||array.length==0) {
			return 0;
		}
		int low = 0;
		int high = array.length-1;
		if(array[low]>k||array[high]<k) {  //数组里根本没有k
			return 0;
		}
		int first = GetFistk(array, k, low, high);
		int last = GetLastk(array, k, low, high);
		if(first==-1 && last==-1) {
			return 0;
		}
		return (last-first+1);
		
    }
	//确定第一个k的位置
	public int GetFistk(int[] array, int k, int low, int high) {
		if(low>high)  return -1;
		int mid = (low+high)/2;
		if(k>array[mid]) {
			low = mid+1;
		}
		else if(k<array[mid]){
			high = mid-1;
		}
		else if(k==array[mid]){
			if(mid==0|| (mid>0 && array[mid-1]!=k)){
				return mid;
			}
			else {
				//以下操作是不是就会导致不是时间复杂度不是logn
//				while(mid>=low && array[mid-1]==k) {
//					mid--;
//				}
//				return mid;
				//继续往前面找
				high = mid-1;
			}
		}
		return GetFistk(array, k, low, high);
	}
	public int GetLastk(int[] array, int k, int low, int high) {
		if(low>high)  return -1;
		int mid = (low+high)/2;
		if(k>array[mid]) {
			low = mid+1;
		}
		else if(k<array[mid]){
			high = mid-1;
		}
		else if(k==array[mid]){
			if(mid==array.length-1|| (mid<array.length-1 && array[mid+1]!=k)){
				return mid;
			}
			else {
				//继续往后面找
				low = mid+1;
			}
		}
		return GetLastk(array, k, low, high);
	}

}
