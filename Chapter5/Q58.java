package to_be_a_better_woman;

public class Q58 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = " ";
		Q58 a = new Q58();
		System.out.print(a.ReverseSentence(str));
	}
	public String ReverseSentence(String str) {
        String[] s = str.split(" ");
        if(s.length==0){
        	return str;
        }
        StringBuffer ssss = new StringBuffer();
        for(int i=s.length-1;i>0;i--) {
        	ssss.append(s[i]+" ");
        }
        ssss.append(s[0]);
        String a = ssss.toString();
        return a;
    }

}
