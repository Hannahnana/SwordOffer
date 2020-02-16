package to_be_a_better_woman;

public class Q58_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ahduhidasio";
		int n = str.length()+1;
		Q58_1 a = new Q58_1();
		System.out.print(a.LeftRotateString(str, n));
	}
	public String LeftRotateString(String str,int n) {
		if(n<=0||n>=str.length()) {
			return str;
		}
//        String sub1 = str.substring(0, n);
//        String sub2 = str.substring(n,str.length()-1);
//        String ret = sub2+sub1;
//        return ret;
		return str.substring(0, n)+str.substring(n,str.length()-1);
    }

}
