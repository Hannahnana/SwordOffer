package to_be_a_better_woman;

public class Q33 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q33 vs = new Q33();
		int[] a = new int[] {4,6,7,5};
		System.out.print(vs.VerifySquenceOfBST(a));

	}
	//递归的返回条件很重要
	public boolean VerifySquenceOfBST(int [] sequence) {
		if(sequence==null||sequence.length<=0) {
			return false;
		}
		if(sequence.length==1||sequence.length==2) {
			return true;
		}
		int last = sequence.length-1;
		int root = sequence[last];  //根节点
		int i=0;
		while(sequence[i]<root) {
			i++;
		}
		for(int j=i;j<last;j++) {
			if(sequence[j]<root) {
				return false;
			}
		}
		int[] l = new int[i];
		for(int x=0; x<i; x++) {
			l[x] = sequence[x];
		}
		int[] r = new int[last-i];
		for(int x=0; x<last-i; x++) {
			r[x] = sequence[x+i];
		}
		
		boolean left=true;
		//可能没有左子树
		if(i>0)
			left = VerifySquenceOfBST(l);
		boolean right=true;
		//可能没有右子树
		if (i<last)
			right = VerifySquenceOfBST(r);
		return (left && right);
    }

}
