package to_be_a_better_woman;

public class Q42 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int FindGreatestSumOfSubArray(int[] array) {
        if(array==null||array.length==0) {
        	return 0;
        }
        int recent_max = array[0]; //当前最大值
        int sum=0;
        for(int i=0;i<array.length;i++) {
        	sum+=array[i];
        	if(sum>array[i]) {  //如果之前一串数字的和加当前数字比当前该数字还小，那么丢弃之前的数字
        		if(sum>recent_max) {
        			recent_max = sum;
        		}
        	} else {
        		sum=array[i] ;
        		if(sum>recent_max) {
        			recent_max = sum;
        		}
        	}
        }
        return recent_max;
    }
}
