package to_be_a_better_woman;

import java.util.Scanner;
import java.util.Stack;

public class Q24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode root = new ListNode(-1);
		ListNode head = root;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(n>=1) {
			head.next = new ListNode(sc.nextInt());
			head = head.next;
			n--;
		}
		sc.close();
		Q24 rl = new Q24();
		ListNode p = rl.ReverseList(root.next);
		ListNode q = root.next;
		while(q!=null) {
			System.out.print(q.val);
			q = q.next;
		}
		while(p!=null) {
			System.out.print(p.val);
			p = p.next;
		}
	}
	public ListNode ReverseList(ListNode head) {
		if(head == null) {
			return null;
		}
		if(head.next == null) {
			return head;
		}
		ListNode root = new ListNode(-1);
		ListNode h = root;
		ListNode p = head;
		Stack sk = new Stack();
		while(p!=null) {
			sk.push(p.val);
			p = p.next;
		}
		while(!sk.empty()) {
			int k = (int) sk.pop();
			h.next = new ListNode(k);
			h = h.next;
		}
		return root.next;
    }

}
