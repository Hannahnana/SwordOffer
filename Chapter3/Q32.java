package to_be_a_better_woman;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q32 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root1 = new TreeNode(8);
		root1.left = new TreeNode(8);
		root1.right = new TreeNode(7);
		root1.left.left = new TreeNode(9);
		root1.left.right = new TreeNode(2);
		root1.left.right.left = new TreeNode(4);
		root1.left.right.right = new TreeNode(7);
		Q32 pf = new Q32();
		System.out.print(pf.PrintFromTopToBottom(root1));
	}
	Queue<TreeNode> queue = new LinkedList<TreeNode>();
	ArrayList<Integer> ret =new ArrayList<>();
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		if(root==null) { //空树
//			return null; //这里还是不对，如果返回null的话，是空指针异常……
			return ret; //这样是返回一个空的ArrayList
		}
		queue.offer(root);
		while(queue!=null&&queue.size()>0) {//注意边界条件，null和size=0是两码事
			TreeNode p = queue.poll();
			ret.add(p.val);
//			System.out.print(ret);
			if(p.left!=null) {
				queue.offer(p.left);
			}
			if(p.right!=null) {
				queue.offer(p.right);
			}
		}
		return ret;
    }

}
