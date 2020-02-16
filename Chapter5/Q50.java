package to_be_a_better_woman;

import java.util.HashMap;
import java.util.Map;

public class Q50 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q50 a = new Q50();
		String str = "gogle";
		System.out.print(a.FirstNotRepeatingChar1(str));
	}
	public int FirstNotRepeatingChar(String str) {
		if(str.length()==0) {
			return -1;
		}
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		char[] s = str.toCharArray();
		for(int i=0;i<s.length;i++) {
			if(map.containsKey(s[i])) {
				map.put(s[i], map.get(s[i])+1);
			}
			else {
				map.put(s[i], 1);
			}
			
		}
		for(int i=0;i<s.length;i++) {
			if(map.get(s[i])==1) {
				return i;
			}
		}
        return 0;
    }
	//看题解有个人写的挺有意思的
	public int FirstNotRepeatingChar1(String str) {
		if(str.length()==0) {
			return -1;
		}
		char[] s = str.toCharArray();
		for(int i=0;i<s.length;i++) {
			if(str.indexOf(s[i])==i && str.lastIndexOf(s[i])==i) {
				return i;
			}
		}
		return 0;
	}
}
