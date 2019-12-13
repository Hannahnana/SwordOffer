package to_be_a_better_woman;
/*
 * 剑指offer第六题
 * 题目：输入一个链表的头节点，从尾到头反过来打印每个节点的值。
 * */
import java.util.ArrayList;
import java.util.Scanner;

public class Q6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//=========本来想新建个链表，然后调用printListFromTailToHead()方法，但是，我发现不会调==========
		//======柯柯同学点醒我，链表问题根本不需要真的创建个链表类，只要是获得头节点，就能访问所有的节点=====
//		 Link link = new Link() ;
//		 link.add(1);   //增加节点
//		 link.add(2);
//		 link.add(3);
//		 link.add(4);
//		 Q6 qqq = new Q6();
//		 qqq.printListFromTailToHead();
		
//		手动创建链表
//		ListNode root = new ListNode(1);		
//		ListNode node2 = new ListNode(2);
//		ListNode node3 = new ListNode(3);
//		
//		root.next = node2;
//		node2.next =node3;
		
		
//		控制台输入节点
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(); //节点个数
		ListNode root = new ListNode(in.nextInt());
		ListNode head = root;
		
		while(n-->1) {
			head.next = new ListNode(in.nextInt());
			head = head.next;
		}
		
		
		 Q6 qqq = new Q6();
		 System.out.print(qqq.printListFromTailToHead(root));
		 
		
	}
	
	ArrayList<Integer> a = new ArrayList<>();
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		if(listNode!=null) {
			a = printListFromTailToHead(listNode.next);
			a.add(listNode.val);
		}
		return a;
    }

}

//链表节点类
//每一个链表实际上就是由多个节点组成的
class ListNode{
	int val;
	ListNode next = null;
	ListNode(int val){
		this.val = val;
	}
	public void setNext(ListNode next) {
		this.next = next;
	}
	public ListNode getNext() {
		return this.next;
	}

	public int getData() {
		return this.val;
	}
//	// 实现节点的添加:
//	public void addNode(ListNode oldNode, ListNode newNode) {
//		if (this.next == null) {   // 保存新节点
//			this.next = newNode; 
//		} else {                 // 当前节点后面还有节点			
//			this.next.addNode(this.next,newNode);  // 当前节点的下一个节点继续保存,这里采用的是递归添加节点
//		}
//	}
}

////链表
//class Link {
//	
//	private ListNode root; //新建根节点
//	public void add (int data){
//		  ListNode newNode = new ListNode(data);  //链表中新增节点类对象	  
//		  if(this.root == null ){         // 如果链表还没有任何节点,就添加第一个节点作为根节点
//			  this.root = newNode;
//		  }else{
//			  this.root.addNode(this.root,newNode);  //从根节点节点新链接一个节点
//		  }
//	}
//
//}