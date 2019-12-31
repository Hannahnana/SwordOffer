package to_be_a_better_woman;

import java.util.Scanner;

/*
 * 剑指offer第21题
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分
 * */
public class Q21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //数组的长度
		if(n<=0) {
			return;
		}
		int[] a = new int[n];
		int i = 0;
		while(n>0) {
			a[i] = sc.nextInt();
			i++;
			n--;
		}
		Q21 arr = new Q21();
		arr.reOrder(a);
		for(int x:a) {
			System.out.print(x);
		}
		
	}
	public void reOrderArray(int[] array) {
		if(array.length == 0) {
			return;
		}
		int i = 0;
		int j = array.length-1;
		int temp = 0;
		while(j>i) {
			if((array[i] & 0x1) ==1) { //奇数
				i++;
			}
			if((array[j]&0x1)==0) { //偶数
				j--;
			}
			if((array[i] & 0x1) ==0 && (array[j]&0x1)==1) {
				temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
		}
	}
	//在实现题目要求的同时，保证奇数部分和偶数部分内部相对顺序不变
	//但时间效率太低了
	public void reOrder(int[]array) {
		if(array.length == 0) {
			return;
		}
		int temp = 0; //存储偶数
		int odd_count = 0;
		for(int i=0;i<array.length-1-odd_count;i++) {
			while((array[i]&0x1)==0) {
				odd_count++;
				temp = array[i];
				for(int j=i;j<array.length-1;j++) {
					array[j] = array[j+1];
				}
				array[array.length-1] = temp;
			}
			continue;
		}
	}
	//在实现题目要求的同时，保证奇数部分和偶数部分内部相对顺序不变
	public void rereOrder(int[]array) {
		if(array.length == 0) {
			return;
		}
		int temp = 0; //存储偶数
		int i = 0;
		while(i<array.length-1) {
			if((array[i] & 0x1) ==1) { //奇数
				i++;
			}
			int j = i+1;
			while((array[j] & 0x1) ==0) {
				j++;
			}
			
		}
	}

}
