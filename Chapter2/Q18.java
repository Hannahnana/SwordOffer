package to_be_a_better_woman;
import java.util.Scanner;
/*
 * 剑指offer第18题
 * 在O(1)时间内删除链表节点
 * 给定单向链表的头指针和一个节点指针，定义一个函数在O(1)时间内删除该节点。
 * */
public class Q18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //输入链表的节点个数
		if(n==0) {
			sc.close();
			return;
		}
		ListNode root = new ListNode(sc.nextInt()); //第一个数字是给头节点赋值，
		ListNode head = root; //记录头指针（头节点）
		while(n>1) {
			root.next = new ListNode(sc.nextInt());
			root = root.next;
			n--;
		}
		int rm_index = sc.nextInt();
		sc.close();
		ListNode todel = head;
		while(rm_index>1) {
			todel = todel.next;
			rm_index -- ;
		}
		Q18 del_node = new Q18();
		del_node.deleteNode(head, todel);
		//打印
		ListNode p = head;
		while(p!=null) {
			System.out.print(p.val);
			p = p.next;
		}
	}
	
	public void deleteNode(ListNode head, ListNode pToBeDeleted) {
		if(pToBeDeleted.next!=null) { //不是尾节点
			pToBeDeleted.val = pToBeDeleted.next.val;
			pToBeDeleted.next = pToBeDeleted.next.next;
		}else if(head == pToBeDeleted) { //只有一个节点
			head = null;
		}else { //删尾节点
			ListNode p = head;
			while(p.next!=null) {
				p = p.next;
			}
			p.next = null;
		}
	}
}