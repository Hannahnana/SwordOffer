package to_be_a_better_woman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * 
 * */
public class Q7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("请输入前序遍历序列，以,间隔:");
		Scanner sc1 =new Scanner(System.in);
		String str1 = sc1.nextLine();
        String[] srr1=str1.split(",");
        int[] pre = new int[srr1.length];
        for (int i = 0; i < srr1.length; i++) {
        	pre[i] = Integer.parseInt(srr1[i]);
        }
        System.out.print("请输入中序遍历序列，以,间隔:");
		String str2 = sc1.nextLine();
        String[] srr2=str2.split(",");
        int[] in = new int[srr2.length];
        for (int i = 0; i < srr2.length; i++) {
        	in[i] = Integer.parseInt(srr2[i]);
        }
        sc1.close();
        Q7 tree = new Q7();
        System.out.print(tree.reConstructBinaryTree(pre, in));
	}
	// 左子树和右子树创建的过程和整棵树是一样的，所以可以采用递归。
	// 树和链表一样，都是知道头节点就可以构建出整棵树，因为，可以通过root.left和root.right访问左孩子和右孩子。
	// 我们构建树的过程就可以理解为是在给当前树根节点，root.left和root.right赋值的过程
	public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		if(pre.length == 0 || in.length == 0) {
			return null;  //递归停止（返回）条件:他的左孩子为空或者右孩子为空（到达叶子节点或次叶子节点）
		}
        TreeNode root = new TreeNode(pre[0]); //当前树的根节点为前序遍历的第一个值
        for(int i=0; i<in.length; i++) { //在中序遍历序列中找到和根节点的index，左边为以当前根节点的
        	if(in[i] == pre[0]) {
        		root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in, 0, i));
        		root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,i,pre.length),Arrays.copyOfRange(in, i+1, in.length));
        		break;
        	}
        }
		return root;
    }
}
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { 
		val = x; 
	}
}