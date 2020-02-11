package to_be_a_better_woman;

public class Q12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//DFS回溯剪枝问题
	//只要找到一条路径就可以返回true
	//由于要用到递归，所以我们只需要知道当前步做什么不需要管下一步要做什么
	//递归重要的是有递归返回的条件
	boolean[] visited = null; 
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
		
		visited = new boolean[matrix.length];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				if(hasPathCore(matrix,rows,cols,str,i,j,0)) //矩阵中的任意元素都可能是入口元素，只要是以其中
					return true;
			}
		}
		return false;
    }
	public boolean hasPathCore(char[]matrix, int rows, int cols, char[] str, int row, int col, int length) {
		if(matrix[row*cols+col]!=str[length] || visited[row*cols+col]==true) return false; //矩阵中当前元素已被访问或者未被访问但是和str的当前元素不一样
		if(length==str.length-1) return true; //已经全部把str匹配上了
		visited[row*cols+col] = true;
		if(col>0 && hasPathCore(matrix,rows,cols,str,row,col-1,length+1)) return true; //左边走
		if(col<cols-1 && hasPathCore(matrix,rows,cols,str,row,col+1,length+1)) return true; // 右边走
		if(row>0 && hasPathCore(matrix,rows-1,cols,str,row-1,col,length+1)) return true; //上
		if(row<rows-1 && hasPathCore(matrix,rows,cols,str,row+1,col,length+1)) return true; //下
		visited[row*cols+col] = false;  //如果上下左右都不通，那么把当前位置为未访问，并返回false
		return false;
	}

}
