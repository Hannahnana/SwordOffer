package to_be_a_better_woman;

public class Q15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int NumberOf1(int n) {
        int count=0;
        while(n!=0){
            ++count;
            n = (n-1)&n;
        }
        return count;
	}
		
}
