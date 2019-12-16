package to_be_a_better_woman;

import java.util.Scanner;

/*
 * 剑指offer面试题10拓展
 * 题目描述：青蛙每次可以跳1，2，3,...,n阶
 * 跳上n阶有多少种跳法。
 * */
//一开始我会想到f(n) = f(n-1)+f(n-2)+...+f(2)+f(1)+1
//归纳发现f(n) = 2^(n-1)
public class Q10_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		Q10_3 frog_jump = new Q10_3();
		System.out.print(frog_jump.JumpFloorII(n));
		
		
	}
	public int JumpFloorII(int target) {
        return (int) Math.pow(2, (target-1));
    }

}
