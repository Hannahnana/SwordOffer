package to_be_a_better_woman;
/**
 * 剑指offer第4题
 * 题目描述：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排列。
 * 请完成一个函数，输入这样的二维数组和一个整数，判断数组中是否有这样的整数。
 */
public class Q4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[][] = {{1,2,8,9},{2,4,9,12},{4,7,9,12},{6,8,11,15}};
		int num = 7;
		Q4 se = new Q4();
		boolean flag = se.search(array, num);
		System.out.print(flag);
		
	}
	//解题思路，根据数组数值的分布特点我们可以从右上角的数字开始比较，如果该数字小于右上角的数字，则删除该列；如果大于，则删除该行。
	//左下角也可以，如果数字小于左下角的数字，则删除该行；如果大于，则删除该列。
	//特别需要注意的一点，要注意边界值和错误处理考虑进去
	
	public boolean search(int[][] array, int num) {
		int rows = array.length-1;
		int row = 0;  // 行索引
		int col = array[0].length-1; //列索引
		boolean flag = false;
		if (rows<=0 ||col<=0) {
			return flag;
		}
		else {
			while(row<= rows && col>=0) {
				if(num<array[row][col]) {  //<右上角的数字，删除列
					--col;
				}
				else if(num>array[row][col]) {//<右上角的数字，删除行
					++row;
				}
				else {
					flag = true;
					break;
				}
			};
			return flag;
		}
	}
}
