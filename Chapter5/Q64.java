package to_be_a_better_woman;

public class Q64 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q64 su = new Q64();
		System.out.print(su.Sum_Solution2(4));
	}
	public int Sum_Solution(int n) {
		//利用构造函数来进行循环操作
		//思想是 每创建一个类对象就会调用一次构造函数，在构造函数里进行加运算
		Summation.reset();
		Summation[] a = new Summation[n]; 
        return Summation.getSum();
    }
	public int Sum_Solution1(int n) {  // n*(n+1)/2 = (n^2+n)/2 都写到这里了，也知道移位操作了，就是不会用求幂运算……
		return ((int) Math.pow(n, 2)+n)>>1;
	}
	//利用短路效应
	public int Sum_Solution2(int n) {  //n传进来个4
		int sum = n;
//		System.out.println(sum);
		boolean flag = (sum>0) && ((sum += Sum_Solution2(n-1))>0);
//		System.out.println("ret"+sum);
		return sum;
	}
}

class Summation{
	static int sum;
	static int N;
	public Summation(){
		System.out.println("构造"+N);
		N++;
		sum+=N;
	}
	public static void reset() {
		System.out.println("reset"+N);
		N=0;
		sum = 0;
	}
	public static int getSum() {
		System.out.println("getSum"+N);
		return sum;
	}
}
