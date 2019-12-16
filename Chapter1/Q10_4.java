package to_be_a_better_woman;
/*
 * 剑指offer面试题10拓展
 * 题目描述：用2x1的小矩形横着或竖着去覆盖更大的举行，问用n个2*1的小矩形五重叠地覆盖一个2xn的大矩形，共有多少种方法？
 * */
//解题思路：从最左边开始覆盖，有两种方法，竖着覆盖或者横着覆盖。
//（1）竖着覆盖，则右边还剩2x(n-1)的矩形需要覆盖，f(n-1)
//（2）横着覆盖，需要两个一起横着覆盖一个2x2的矩形，那右边还有2x(n-2)的矩形需要覆盖，f(n-2)
//综上所述：f(n)=f(n-1)+f(n-2) 依旧时斐波那契数列问题
public class Q10_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
