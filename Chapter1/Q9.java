package to_be_a_better_woman;

import java.util.Stack;

public class Q9 {
	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q9 queue = new Q9();
		queue.push(1);
		queue.push(2);
		queue.push(3);
		System.out.print(queue.pop());
		System.out.print(queue.pop());
		System.out.print(queue.pop());
	}
    // 想要用两个栈模拟队列，重点就在于，先把所有数据push到一个栈stack1里，然后全部pop到另一个栈stack2里。然后从stack2中pop()
	// 每次pop都需要把stack1中的所有值pop到stack2中
    public void push(int node) {
        stack1.push(node);  //从stack1中进
    }
    
    public int pop() {
    	if(stack2.size()<=0) {
    		while(stack1.size() > 0) {
    			stack2.push(stack1.pop());
    		}
    	}
    	return stack2.pop();
    }
}
