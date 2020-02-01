package to_be_a_better_woman;
//题解：顺时针打印矩阵
import java.util.ArrayList;

public class Q29 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		Q29 pm = new Q29();
		System.out.print(pm.printMatrix(matrix));

	}
	/*题目分析
	 * 顺时针打印矩阵的步骤：1.从左到右->2.从上到下->3.从右到左->4.从下到上 画圈
	 * 设矩阵行数为row，列数为col。每个圈开始的位置为（0，0），（1，1），……
	 *  令画圈停止的条件为col>start*2和row>start*2（找规律来的……）
	 * */
	ArrayList<Integer> a = new ArrayList<>();
	public ArrayList<Integer> printMatrix(int [][] matrix) {
		int col = matrix[0].length;
		int row = matrix.length;
		int start = 0;
		
		if(matrix==null||col<=0||row<=0) { //传进来空数组
			return null;
		}
		while(col>start*2 && row>start*2) {
			int endX = col-start-1;
			int endY = row-start-1;
			//从左到右打印（只要进循环就可以走第一步）
			for(int i=start;i<=endX;i++) {
				a.add(matrix[start][i]);
			}
			//从上到下
			if(endY>start) {  //能走第二步的条件是endY>start
				for(int i=start+1;i<=endY;i++) {  //注意边界条件：i从start+1开始打印，不然的话，会把拐角处的元素重复打印，以下几个步骤也是如此。
					a.add(matrix[i][endX]);
				}
			}
			//从右到左
			if(endX>start && endY>start) { //能走第三步的条件是圈内至少有两行两列
				for(int i=endX-1;i>=start;i--) {
					a.add(matrix[endY][i]);
				}
			}
			//从下到上
			if(endX>start && endY>start+1) { //能走第四步的条件是圈内至少有三行两列
				for(int i=endY-1; i>=start+1; i--) {
					a.add(matrix[i][start]);
				}
			}
			start++;
		}
		return a;
	}
}
