package to_be_a_better_woman;
import java.util.Scanner;
public class Q18_1 {

	public static void main(String[] args) {
		ListNode node0 = new ListNode(-1); //虚节点，头指针为node0.next
//		node0.next = null;
		ListNode head = node0;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //节点数
		if(n<=0) {
			return;
		}
		while(n>0) {
			head.next = new ListNode(sc.nextInt());
			head = head.next;
			n--;
		}
		sc.close();
		Q18_1 del = new Q18_1();
		ListNode head1 = del.deleteDuplication(node0.next);
		ListNode p = head1;
		while(p!=null) {
			System.out.print(p.val);
			p = p.next;
		}
	}
	
	public ListNode deleteDuplication(ListNode pHead)
    {
		if(pHead == null || pHead.next == null) { //空链表或只有一个节点
			return pHead;
		}
		if(pHead.val == pHead.next.val) {
			ListNode node = pHead.next;
			// !!!!!!!这里！！！特别长知识
			// 边界错误常见问题~~~
			// while中的判断条件一开始我并没有加node!=null这个条件，我原本认为，node=null的时候，确实符合与phead不同的条件，便可跳出循环，返回null
			// 但是柯柯告诉我！！如果不设置这个条件当node为null时，判断语句为null.val，为空指针异常，确实是的呢~~~长知识了！！
			while(node!=null && node.val == pHead.val) {
				node = node.next;
			}
			pHead = deleteDuplication(node);
			return pHead;
		}else {
			pHead.next = deleteDuplication(pHead.next);
			return pHead;
		}
    }
}
