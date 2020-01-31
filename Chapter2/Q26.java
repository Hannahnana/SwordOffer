package to_be_a_better_woman;

public class Q26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root1 = new TreeNode(8);
		root1.left = new TreeNode(8);
		root1.right = new TreeNode(7);
		root1.left.left = new TreeNode(9);
		root1.left.right = new TreeNode(2);
		root1.left.right.left = new TreeNode(4);
		root1.left.right.right = new TreeNode(7);
		
		TreeNode root2 = new TreeNode(8);
		root2.left = new TreeNode(9);
		root2.right = new TreeNode(9);
		Q26 hst = new Q26();
		boolean ret = hst.HasSubtree(root1,root2);
		System.out.print(ret);
		
		
	}
	 public boolean HasSubtree(TreeNode root1,TreeNode root2) { //在树1中找到和root2根节点相同的节点
		 boolean result = false;
		 if(root1!=null && root2!=null) {
			 if(root1.val==root2.val) {
				 result = DoesTree1HaveTree2(root1,root2);
			 }
			 if(!result) {
				 result = HasSubtree(root1.left,root2);
			 }
			 if(!result) {
				 result = HasSubtree(root1.right,root2);
			 }
		 }
		 return result;
	 }
	 public boolean DoesTree1HaveTree2(TreeNode root1,TreeNode root2) {
		 if(root2==null) {
			 return true;
		 }
		 else if(root1==null) {  
			 return false;
		 }
		 else if(root1.val!=root2.val) {
			 return false;
		 }
		 return DoesTree1HaveTree2(root1.left, root2.left) && DoesTree1HaveTree2(root1.right,root2.right);
	 }
}
