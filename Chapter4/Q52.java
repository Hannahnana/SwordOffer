package to_be_a_better_woman;

import java.util.Stack;

public class Q52 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//借助栈
	//时间复杂度O(m+n)
	//空间复杂度O(m+n)
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		 if(pHead1==null||pHead2==null) {
			 return null;
		 }
		 if(pHead1==pHead2){
	            return pHead1;
	        }
		 Stack<ListNode> s1 = new Stack<ListNode>();
		 Stack<ListNode> s2 = new Stack<ListNode>();
		 while(pHead1!=null) {
			 s1.push(pHead1);
			 pHead1 = pHead1.next;
		 }
		 while(pHead2!=null) {
			 s2.push(pHead2);
			 pHead2 = pHead2.next;
		 }
		 ListNode p1=null;
		 ListNode p2=null;
		 while(!s1.isEmpty()&&!s2.isEmpty() && s1.peek()==s2.peek()) {  //每次都是在边界处出问题，在取栈的最顶层元素时，要先判断栈是否为空。
			 p1 = s1.pop();
			 p2 = s2.pop();
		 }
		 return p1;
    }
	//统计长度，再从相同长度处开始遍历
	//时间复杂度O(m+n)
	//空间复杂度O(1)
	public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
		if(pHead1==null||pHead2==null) {
			 return null;
		 }
		int len1 = linkLength(pHead1);
		int len2 = linkLength(pHead2);
		if(len1>len2) {
			int i=len1-len2;
			while(i>0) {
				pHead1 = pHead1.next;
				i--;
			}
		}
		if(len1<len2) {
			int i=len2-len1;
			while(i>0) {
				pHead2 = pHead2.next;
				i--;
			}
		}
		while(pHead1!=null && pHead2!=null && pHead1!=pHead2) {
			pHead1 = pHead1.next;
			pHead2 = pHead2.next;
		}
		return pHead1;
	}
	public int linkLength(ListNode pHead) {
		int len = 0;
		while(pHead!=null) {
			len++;
			pHead=pHead.next;
		}
		return len;
	}
	

}
