package to_be_a_better_woman;
import java.util.Scanner;

import to_be_a_better_woman.ListNode;
public class Q25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		ListNode node0 = new ListNode(-1);
		ListNode head = node0;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n<=0) {
			return;
		}
		while(n>0) {
			head.next = new ListNode(sc.nextInt());
			head = head.next;
			n--;
		}
		
		ListNode _node0 = new ListNode(-1);
		ListNode _head = _node0;
		int _n = sc.nextInt();
		if(_n<=0) {
			return;
		}
		while(_n>0) {
			_head.next = new ListNode(sc.nextInt());
			_head = _head.next;
			_n--;
		}
		sc.close();
		
		Q25 fknode = new Q25();
		ListNode phead = fknode.Merge(node0.next, _node0.next);
		ListNode p = phead;
		while(p!=null) {
			System.out.print(p.val);
			p = p.next;
		}
	}
	public ListNode Merge(ListNode list1, ListNode list2) {
		ListNode phead = new ListNode(-1);
		ListNode head = phead;
		ListNode p1 = list1;
		ListNode p2 = list2;
		if(list1 == null && list2 == null) {
			return null;
		}
		else if(list1 == null){
			return list2;
		}
		else if(list2 == null){
			return list1;
		}
		while(p1!=null || p2!=null) {
			if(p1 == null) {
				head.next = p2;
				break;
			}
			else if(p2 == null) {
				head.next = p1;
				break;	
			}else {
				if(p1.val<=p2.val) {
					head.next = p1;
					p1 = p1.next;
				}else {
					head.next = p2;
					p2 = p2.next;
				}
				head = head.next;
			}
		}
		return phead.next;	
					
	}

}
