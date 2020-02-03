package to_be_a_better_woman;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q32_1 {
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(8);
		root1.left = new TreeNode(8);
		root1.right = new TreeNode(7);
		root1.left.left = new TreeNode(9);
		root1.left.right = new TreeNode(2);
		root1.left.right.left = new TreeNode(4);
		root1.left.right.right = new TreeNode(7);
		Q32_1 pf = new Q32_1();
		System.out.print(pf.Print(root1));
	}
	ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
	    ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
	    if(pRoot==null) {
	    	return ret;
	    }
	    int recent_num;
	    int next_num = 0;
	    Queue<TreeNode> queue = new LinkedList<TreeNode>(); 
	    queue.offer(pRoot);
	    recent_num=1;
	    while(queue!=null && queue.size()!=0) {
	    	ArrayList<Integer> inter = new ArrayList<Integer>();
	    	while(recent_num>0) {
	    		TreeNode p = queue.poll();
	    		inter.add(p.val);
	    		if(p.left!=null) {
	    			queue.offer(p.left);
	    			next_num++;
	    		}
	    		if(p.right!=null) {
	    			queue.offer(p.right);
	    			next_num++;
	    		}
	    		recent_num--;
			}
	    	ret.add(inter);
	    	if(recent_num==0) {
	    		recent_num = next_num;
	    		next_num = 0;
	    	}
			
	    }
	    return ret;
    }
}
