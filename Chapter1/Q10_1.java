package to_be_a_better_woman;

import java.util.Scanner;

/**
 * 剑指offer第十题的第一问
 * 题目描述：求斐波那契数列的第n项
 * 斐波那契数列：n=0时，f(n)=0; n=1时，f(n)=1; otherwise f(n)=f(n-1)+f(n-2)
 */
public class Q10_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		Q10_1 fib = new Q10_1();
		System.out.print(fib.Fibonacci_Recursion(n));
	}
	//递归：效率太低，而且重复计算太多
	public int Fibonacci_Recursion(int n) {
		if(n <= 0) { //注意0这里的边界值
			return 0;
		}else if(n == 1) {
			return 1;
		}else {
			return Fibonacci_Recursion(n-1)+Fibonacci_Recursion(n-2);
		}
    }
	//循环，由于递归导致了重复计算过多，所以我们可以保存数列的中间项
	public int Fibonacci_Loop(int n) {
		int f1 = 1; //保存f(n-1)
		int f2 = 0; //保存f(n-2)
		int ret = 0;
		if(n <= 0) { //注意0这里的边界值
			return 0;
		}else if(n == 1) {
			return 1;
		}else {
			for(int i=2; i<=n;i++) {
				ret = f1+f2;
				f2 = f1;
				f1 = ret;
			}
		}
		return ret;
	}
		
}
