package to_be_a_better_woman;


public class Q55 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.left.left = new TreeNode(8);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		Q55 p = new Q55();
		System.out.print(p.TreeDepth(root));
	}
	
	public int TreeDepth(TreeNode root) {
		int hleft=0;
		int hright=0;
		if(root==null) {
			return 0;
		}
		if(root.right==null && root.left==null) {
			return 1;
		}
        if(root.left!=null) {
        	hleft=TreeDepth(root.left);
        }
        if(root.right!=null) {
        	hright=TreeDepth(root.right);
        }
        return hleft>hright?(hleft+1):(hright+1);
    }
	
	public int TreeDepth1(TreeNode root) {
		if(root==null) {
			return 0;
		}
        int hleft=TreeDepth(root.left);
        int hright=TreeDepth(root.right);
        return hleft>hright?(hleft+1):(hright+1);
    }
	
}
