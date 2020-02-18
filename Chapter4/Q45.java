package to_be_a_better_woman;
import java.util.ArrayList;
import java.util.Arrays;;
public class Q45 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {3,32,321};
		Q45 qaqq = new Q45();
		qaqq.PrintMinNumber(numbers);
	}
	public String PrintMinNumber(int [] numbers) {
		String ret = "";
		if(numbers==null||numbers.length==0) {
			return ret;
		}
		ArrayList<String> a = new ArrayList<String>();
//		ArrayList<Integer> a = new ArrayList<Integer>();
		for(int x: numbers) {
			a.add(""+x);
		}
		for(int i=0;i<a.size();i++) {
			for(int j=i+1;j<=a.size()-1;j++) {
				if(compare(a.get(i),a.get(j))){
					String temp = a.get(i);
					a.set(i, a.get(j));
					a.set(j, temp);
				}
			}
		}
		for(String s:a) {
			ret+=s;
		}
		return ret;
    }
	public boolean compare(String s1, String s2) {
		String str1 = s1+s2;
		String str2 = s2+s1;
		for(int i=0;i<str1.length();i++) {
			int num1 = (int)str1.charAt(i) - (int)('0');
			int num2 = (int)str2.charAt(i) - (int)('0');
			if(num1>num2) {
				return true;
			}else if(num1==num2) {
				continue;
			}else {
				return false;
			}
		}
		return true; //这两个数字相等
	}
	//看到别人的解题，发现我被书上的题解给限制住思路了
	//从书上得到启发：比较两个拼接后的字符串表示的数字，mn>nm的话则n在前。根据以上规则，将各个元素从"小"到"大"进行排序。再把各元素拼接在一起。
	//同时思路限制，我比较nm和mn的值是通过按位比较字符串得来的，
	//实际上完全可以把nm或mn组成的字符串转化为int类型直接比较数字呀！根本不需要再写个函数，费时间
	//然后看到牛客上import了arraylist我就非得往上套，又浪费了很多时间
	public String PrintMinNumber1(int [] numbers) {
		String ret = "";
		if(numbers==null||numbers.length==0) {
			return ret;
		}
		for(int i=0;i<numbers.length;i++) {
			for(int j=i+1;j<numbers.length;j++) {
				int num1 = Integer.parseInt(String.valueOf(numbers[i])+String.valueOf(numbers[j]));
				int num2 = Integer.parseInt(String.valueOf(numbers[j])+String.valueOf(numbers[i]));
				if(num1>num2){
					int temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
		for(int x:numbers) {
			ret = ret+x;
		}
		return ret;
	}

}
