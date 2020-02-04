package to_be_a_better_woman;

import java.util.ArrayList;
import java.util.Stack;

public class Q32_2 {
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(8);
		root1.left = new TreeNode(6);
		root1.right = new TreeNode(10);
		root1.left.left = new TreeNode(5);
		root1.left.right = new TreeNode(7);
		root1.right.left = new TreeNode(9);
		root1.right.right = new TreeNode(11);
		Q32_2 pf = new Q32_2();
		System.out.print(pf.Print(root1));
	}
	//思想是每次用栈存储树的函数（找规律来的）
	public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer> > ret = new ArrayList<ArrayList<Integer> >();
		if(pRoot==null) {
			return ret;
		}
		Stack<TreeNode> s1 = new Stack<TreeNode>();
		Stack<TreeNode> s2 = null;
		int count = 1;
		s1.push(pRoot);
		int recent_num = 1;
		int next_num = 0;
		
		while(s1!=null && s1.size()>0) {
			ArrayList<Integer> inter = new ArrayList<Integer>();
			s2 = new Stack<TreeNode>();
			while(recent_num>0) {
				TreeNode p = s1.pop();
				recent_num--;
				inter.add(p.val);
				if((count & 0x1) == 1) { //奇数
					if(p.left!=null) {
						s2.push(p.left);
						next_num++;
					}
					if(p.right!=null) {
						s2.push(p.right);
						next_num++;
					}
				}
				else {
					if(p.right!=null) {
						s2.push(p.right);
						next_num++;
					}
					if(p.left!=null) {
						s2.push(p.left);
						next_num++;
					}
				}
			}
			ret.add(inter);
			count++;
//			System.out.print(ret);
			if(recent_num == 0) {
				s1 = s2;
				recent_num = next_num;
				next_num = 0;
			}
		}
		
		return ret;
    }
}
