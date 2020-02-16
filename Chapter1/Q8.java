package to_be_a_better_woman;
/*
 * 剑指offer第8题
 * 题目：给定一棵二叉树和其中一个节点，如何找出中序遍历序列的下一个节点？
 * 树中的节点除了有两个分别指向左、右子节点的指针，还有一个指向父节点的指针。
 * */

//解题思路
//（1）如果一个节点有右子树那么他下一个节点为右子树中的最左节点；
//（2）如果一个节点没有右子树，且该节点是其父节点的左孩子，则它的下一个节点就是它的父节点；
//（3）如果一个节点没有右子树，且该节点是其父节点的右孩子，则顺着其指向父节点的指针遍历。如果指向的节点为其父节点的左孩子，则返回该节点的父节点。
public class Q8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeLinkNode root = new TreeLinkNode(1);
		TreeLinkNode tn1 = new TreeLinkNode(2);
		TreeLinkNode tn2 = new TreeLinkNode(3);
		TreeLinkNode tn3 = new TreeLinkNode(4);
		TreeLinkNode tn4 = new TreeLinkNode(5);
		TreeLinkNode tn5 = new TreeLinkNode(6);
		TreeLinkNode tn6 = new TreeLinkNode(7);
		TreeLinkNode tn7 = new TreeLinkNode(8);
		TreeLinkNode tn8 = new TreeLinkNode(9);
		
		root.left = tn1;
		root.right = tn2;
		root.father = null;
		
		tn1.left = tn3;
		tn1.right = tn4;
		tn1.father = root;
		
		tn2.left = tn5;
		tn2.right = tn6;
		tn2.father = root;
		
		tn3.left = null;
		tn3.right = null;
		tn3.father = tn1;
		
		tn4.left = tn7;
		tn4.right = tn8;
		tn4.father = tn1;
		
		tn5.left = null;
		tn5.right = null;
		tn5.father = tn2;
		
		tn6.left = null;
		tn6.right = null;
		tn6.father = tn2;
		
		tn7.left = null;
		tn7.right = null;
		tn7.father = tn4;
		
		tn8.left = null;
		tn8.right = null;
		tn8.father = tn4;
		
		Q8 nextNode = new Q8();
		TreeLinkNode pNode = tn6;
		System.out.print(tn6.val);
		TreeLinkNode next = nextNode.Solution(pNode);
		System.out.print(next.val);
	}
	/**
	 * 获取中序遍历节点的下一个节点
	 * @param pNode 某个节点
	 * @return pNode的下一个节点
	 */
	public TreeLinkNode Solution(TreeLinkNode pNode) {
		if(pNode == null) {
			return null;
		}
		if(pNode.right != null) { //具有右子树
			pNode = pNode.right;
			while(pNode.left != null) { //一直往左遍历
				pNode = pNode.left;
			}
			return pNode;
		}
		if(pNode.right == null) { //没有右子树
			TreeLinkNode pNode_father = pNode.father;
			if (pNode_father!=null) {
				if(pNode_father.left == pNode) { //该节点为其父节点的左孩子
					return pNode.father;
				}else {
					while(pNode.father != null) {
						pNode = pNode.father;
						if(pNode.father!=null && pNode.father.left!=pNode) {  //注意判断条件：首先要满足pNode.father!=null才能对pNode.father.left进行判断
							continue;
						}
						else {
							return pNode.father;
						}
					}
					return null;
				}
			}else {
				return null;
			}
		}
		return null;
		
	}
}

class TreeLinkNode{
	int val;
	TreeLinkNode left;
	TreeLinkNode right;
	TreeLinkNode father;
	public TreeLinkNode(int val) {
		this.val = val;
	}
}