package to_be_a_better_woman;

import java.util.ArrayList;

public class Q34 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode t10 = new TreeNode(10);
        TreeNode t5 = new TreeNode(5);
        TreeNode t12 = new TreeNode(12);
        TreeNode t7 = new TreeNode(7);
 
        t10.left = t12;
        t10.right = t5;
        t5.right = t7;
        Q34 fp = new Q34();
        
        System.out.print(fp.FindPath(t10, 22));
	}
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		if(root==null) {
			return ret;
		}
		ArrayList<Integer> inter = new ArrayList<Integer>();
		//除了8种基本数据类型是值传参外，其余的都是引用传参，所以find()函数里对ret和inter的修改都会令当前函数中的值发生改变
		find(root,target,ret,inter);
		return ret;
	}
	public void find(TreeNode root,int target, ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> inter) {
		//节点为空返回
		if(root==null) {
			return;
		}
		inter.add(root.val);
		target -= root.val;
		//目标值小于0，return
		if(target<0) {
			return;
		}
		//到达叶子节点时，满足和，添加路径并返回
		if(target==0 && root.left==null && root.right==null){
			ret.add(inter);
			return;
		}
		// 继续遍历左右节点
        // 这里new inter 是因为左右都会在下次递归inter.add(root.val);
		find(root.left,target,ret,new ArrayList<Integer>(inter));
		find(root.right,target,ret,new ArrayList<Integer>(inter));
		
	}
    	 
}
