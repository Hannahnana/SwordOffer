package to_be_a_better_woman;

import java.util.Scanner;

//打印从1到最大的n位数
//注意事项：大数问题
public class Q17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		Q17 p = new Q17();
		p.print1ToMaxOfNDigits(n);
	}

	public void print1ToMaxOfNDigits(int n) {
		//int型数组，默认每一位都是0，不需要我们初始化-_-|||
		int[] array = new int[n+1]; //申请一个n+1位的数组，当最高位为1时，说明后面n位数已经最大了
		int index = n;
		while(array[0]!=1) { //最高位进到1时，说明后面n位已经“满”了
			if(array[index]<10) {
				array[index] += 1;
			}
			while(array[index]==10) { //9->10,99->100,999->1000 进位处理
				array[index] = 0;
				index--;
				array[index]+=1; 
			}
			printNum(array);
			index = n; //每次从最小位开始递增
		}
	}
	public void printNum(int[] array) {
		int n = array.length-1;
		boolean flag = false;
		for(int i=1; i<=n;i++) {
			//这样会导致，所有的零都输不出来，所以才要设置flag,遇到首个不为零的数字，后面的数字值都可以正常输出
//			if(array[i]==0) {
//				continue;
//			}
//			if(array[i]!=0) {
//				System.out.print(array[i]);
//			}
			if(array[i]!=0) {
				flag = true;
			}
			if(flag) {
				System.out.print(array[i]);
			}
		}

		System.out.print('\n');
	}
}
