package to_be_a_better_woman;

import java.util.Arrays;

public class Q56_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {2,4,3,6,3,2,5,5};
		int num1[] = new int[1];
		int num2[] = new int[1];
		Q56_1 a = new  Q56_1();
		a.FindNumsAppearOnce(array, num1, num2);
		System.out.print(""+num1[0]+num2[0]);
		

	}
	//num1,num2分别为长度为1的数组。传出参数
	//将num1[0],num2[0]设置为返回结果
	public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
		if(array.length<2) {
			return;
		}
        Arrays.sort(array);
        for(int x:array) {
        	System.out.print(x);
        }
        int i = 0;
        int j = 0;
        while(i<=array.length-1) {
        	if(i==array.length-1) {
        		num2[0] = array[i];
        		break;
        	}
        	else {
        		if(array[i]==array[i+1]) {
        			i = i+2;
        		}else {
        			if(j==0) {
        				num1[0] = array[i];
        			}
        			num2[0] =array[i];
        			j++;
        			i++;
        		}
        	}
        }
	}
}
