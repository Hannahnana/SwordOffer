package to_be_a_better_woman;
//题目描述：求二叉树的镜像
public class Q27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void Mirror(TreeNode root) {
		// 注意边界条件
		if(root==null) return;  //空树，不做任何操作
		if(root.left == null && root.right == null) return;  //没有孩子节点，不做任何操作
		
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		if(root.left!=null) {
			Mirror(root.left);
		}
		if(root.right!=null) {
			Mirror(root.right);
		}
    }
}
