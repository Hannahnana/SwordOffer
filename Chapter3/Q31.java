package to_be_a_better_woman;
//栈的压入、弹出序列
import java.util.Stack;

public class Q31 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q31 ipo = new Q31();
		int [] pushA = new int[] {1};
		int [] popA = new int[] {1};
		System.out.print(ipo.IsPopOrder(pushA, popA));

	}
	//思路：模仿压栈入栈的过程，如果无法匹配则返回false
	public boolean IsPopOrder(int [] pushA,int [] popA) {
		boolean flag = false;
		if(pushA.length!=popA.length||pushA==null||pushA.length==0) {
			return false;
		}
		int i = 1,j=0;
		Stack<Integer> A = new Stack<Integer>();
		A.push(pushA[0]);
		while(j < popA.length || i < pushA.length) {
			if(A.peek() != popA[j]) {
				if(i<pushA.length) {
					A.push(pushA[i]);
					i++;
				}
				else {  //如果pushA里的元素全都进过栈了，且当前栈顶的元素和popA的当前元素不一样，说明顺序出错了
					break;
				}
			}
			else {
				A.pop();
				j++;
			}
		}
		if(A.isEmpty()) {
			flag = true;
		}
		return flag;
    }
}
