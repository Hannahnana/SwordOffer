package to_be_a_better_woman;
//题目描述：判断一棵二叉树是不是对称的（如果一棵二叉树和它的镜像一样，那么它是对称的）
public class Q28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	boolean isSymmetrical(TreeNode pRoot)
    {
        return isSymmetrical(pRoot,pRoot);
    }
	boolean isSymmetrical(TreeNode pRoot1,TreeNode pRoot2)
    {
        if(pRoot1==null && pRoot2==null) {
        	return true;
        }
        if(pRoot1==null||pRoot2==null) {
        	return false;
        }
        if(pRoot1.val!=pRoot2.val) {
        	return false;
        }
        //这里错误，如果有这个条件的话直接就走一层就跳出递归了，
        //如果值相等的话应当是，继续递归，直到走完叶子节点
//        if(pRoot1.val==pRoot2.val) {
//        	return true;
//        }
        return isSymmetrical(pRoot1.left,pRoot2.right) && isSymmetrical(pRoot1.right,pRoot2.left);
    }
}
