package to_be_a_better_woman;
//求最小的k个数
import java.util.ArrayList;

public class Q40 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[] {1,3,4,2,6,7,3,0};
		Q40 sw = new Q40();
		System.out.print(sw.GetLeastNumbers_Solution(input, 5));
	}
	//解题思想，借鉴快速排序中定位基准数位置的方法
	//超时了。。。
	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		if(input==null||input.length==0||k==0||k>input.length) {  //注意边界条件……
			return ret;
		}
		int index = FindIndex2(input,0,input.length-1);
		while(index!=k-1) {  //当基准数位于k-1位置时，意味着基准数前面的数字都比它小
			if(index>k-1) { 
				index = FindIndex2(input,0,index-1);
			}
			else {
				index = FindIndex2(input,index+1,input.length-1);
			}
		}
		for(int i=0; i<k;i++) {
			ret.add(input[i]);
		}
		return ret;
		
    }
	//这里应该是超时了
	//
	public int FindIndex(int[] input, int start, int end) {
		int temp = input[start];
		while(start<end) {
			while(input[end]>temp && start<end) {
				end--;
			}
			input[start] = input[end];
			while(input[start]<=temp && start<end) {
				start++;
			}
			input[end] = input[start];
		}
		input[start] = temp;
		return start;
	}
	
	public int FindIndex2(int[] input, int start, int end) {
		int temp1 = input[end];
		input[end] = input[start]; //基准数字选为第一个数字
		input[start] = temp1;
		int small=start-1; //对比基准数小的数字计数，small就是基准数的位置
		for(int index=start;index<end;index++) {
			if(input[index]<input[end]) { //如果小于基准数 small就+1
				small++;
				if(index!=small) { //把比基准数小的都移到前面来
					int temp = input[small];
					input[small] = input[index];
					input[index] = temp;
				}
			}
		}
		small++; //比基准数小的数字的个数，small就是基准数的位置
		int temp = input[small];
		input[small] = input[end];
		input[end] = temp;
		return small;
		
	}

}
