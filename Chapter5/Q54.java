package to_be_a_better_woman;

import java.util.ArrayList;

//二叉搜索树中第k大的节点
//按照中序遍历就可找到第k大
public class Q54 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//二叉树的中序遍历
	//中序遍历的第k个数就是二叉搜索树的第k大节点
	ArrayList<TreeNode> a = new ArrayList<TreeNode>();
	TreeNode KthNode(TreeNode pRoot, int k)
    {
		if(pRoot==null||k==0) return null;
		midOrder(pRoot);
		if(a.size()>=k) {
			return a.get(k-1);
		}
		return null;
		
    }
	public void midOrder(TreeNode root) {
		if(root.left!=null) {
			midOrder(root.left);
		}
		a.add(root);
		if(root.right!=null) {
			midOrder(root.right);
		}
	}

}
