package to_be_a_better_woman;

import java.util.ArrayList;

public class Q57_1 {
	public static void main(String[] args) {
		int sum = 100;
		Q57_1 fcs = new Q57_1();
		System.out.print(fcs.FindContinuousSequence(sum));
	}
	public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer> > a = new ArrayList<ArrayList<Integer> >();
		if(sum<3) {
			return a;
		}
		int n_max = (-1+(int)Math.sqrt(1+8*sum))/2; //最长的序列只有可能是从1开始加起：(n+1)n/2 = sum
		System.out.print(n_max);
		int n_min = 2; //最短的序列至少是2个数字相加
		//根据求根公式 n(a1+an)/2=sum,即 n(a1+a1+n-1)/2=sum,即a1=(sum*2/n+1-n)/2
		//如果能整除，则a1就确定了
		for(int i=n_max;i>=n_min;i--) {
			ArrayList<Integer> inter = new ArrayList<Integer>();
			if(sum*2%i==0) { //能够整除
				if((sum*2/i+1-i)%2==0) {
					int a1 = (sum*2/i+1-i)/2;
					for(int j=0;j<i;j++) {
						inter.add(a1+j);
					}
					a.add(inter);
				}
			}
		}
		return a;
    }
}
