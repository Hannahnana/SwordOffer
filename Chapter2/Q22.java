package to_be_a_better_woman;

import java.util.Scanner;

/*剑指offer第22题
 * 题目描述：输入一个链表，输出该链表中的倒数第k个节点。
 * */
public class Q22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node0 = new ListNode(-1);
		ListNode head = node0;
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int n = sc.nextInt();
		if(n<=0) {
			return;
		}
		while(n>0) {
			head.next = new ListNode(sc.nextInt());
			head = head.next;
			n--;
		}
		Q22 fknode = new Q22();
		ListNode p = fknode.FindKthToTail(node0.next, k);
		if(p == null) {
			System.out.print("输入不合法");
		}
		else System.out.print(p.val);
	}
	// 剑指offer题解有给出比较巧妙的算法，给两个指针：第一个指针先从头节点开始往前走k-1步，第二个指针再从头节点开始两个指针一起走，
	// 直到第一个指针走到尾节点，第二个节点就到了倒数第k个节点。
	public ListNode FindKthToTail(ListNode head, int k) {
		if(head==null || k==0) { //空链表或输入参数不合法
			return null;
		}
		ListNode pAhead = head;
		ListNode pBehind = head;
		for(int i=1; i<=k-1; i++) {
			if(pAhead.next!=null) {
				pAhead = pAhead.next;
			}
			else // 如果链表统共就没k个节点
				return null;  
		}
		while(pAhead.next!=null) {   //尾节点的条件是pAhead.next = null;
			pAhead = pAhead.next;
			pBehind = pBehind.next;
		}
		return pBehind;
	}

}