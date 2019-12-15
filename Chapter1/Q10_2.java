package to_be_a_better_woman;

import java.util.Scanner;

/**
 * 剑指offer第十题的第二问
 * 题目描述：青蛙跳台阶，一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上n级台阶有多少种跳法？
 * 该题可以转化为斐波那契数列问题：n=1时，f(n)=1; n=2时，f(n)=2; otherwise f(n)=f(n-1)+f(n-2)
 * f(n-1)可以理解为，第一次跳1级台阶，求剩下的台阶n-1的跳法数目
 * f(n-2)可以理解为，第一次跳2级台阶，求剩下的台阶n-2的跳法数目
 */
public class Q10_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		Q10_2 frog = new Q10_2();
		System.out.print(frog.JumpFloor(n));
	}
	
	public int JumpFloor(int target) {
		int f1 = 2; //保存f(n-1)
		int f2 = 1; //保存f(n-2)
		int ret = 0;
		if(target <= 1) { //注意0这里的边界值
			return 1;
		}else if(target == 2) {
			return 2;
		}else {
			for(int i=3; i<=target;i++) {
				ret = f1+f2;
				f2 = f1;
				f1 = ret;
			}
		}
		return ret;
    }
	
}
