package to_be_a_better_woman;
/*
 * 剑指offer第5题
 * 题目描述：把字符串中的每个空格替换成“%20”。
 * 输入样例：“we are happy”
 * 输出样例：“we%20are%20happy”
 * */
public class Q5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = new String("we are happy");
		str = str.replace(" ", "20%");
		System.out.print(str);
	}
	// 该函数的边界值：空串and没有空格
	public  String replaceSpace(StringBuffer str) {
		if(str.length()<1||str.lastIndexOf("")==-1) {
			return str.toString();
		}
		else {
			String str1 = str.toString();
			str1=str1.replace(" ", "%20");
			return str1;
		}
	}
}
