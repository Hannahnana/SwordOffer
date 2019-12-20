package to_be_a_better_woman;
/*
 * 剑指offer第16题，数值的整数次方
 * 题目描述：实现函数 double Power(double base, int exponent),求base得exponent次方。不得使用库函数，同时不需要考虑大数问题。
 * */


//本题收获总结：快速幂运算技巧，移位代替乘除计算提高效率，按位与判断奇数偶数。
public class Q16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// 拿到这道题我只考虑到了exponent为0时返回1的情况，没考虑到exponent为负数的情况。
	// exponent为负数时，涉及到求倒数，可能会出现对0求倒数的错误。
	
	// 另外，拿到题目，我立即想到的是，根据指数循环进行乘法。这样的效率非常低。
	// 从这道题里学到了快速求乘方的技巧。
	// 如求32方法，相当于求16次方的二次方，16次方相当于求8次方的乘方，...以此推，可知，32次方只需要求5次乘法。
	double Power(double base, int exponent) {
		if((base-0)<=1e-9 && exponent<0) {
			return 0.0;
		}
		double result = 0.0;
		if(exponent<0) {
			exponent = -exponent;
			result = 1 / getPower(base, exponent);
		}else {
			result = getPower(base, exponent);
		}
		return result;
	}
	double getPower(double base, int exponent) {
		if(exponent == 0) {
			return 1;
		}
		if(exponent == 1) {
			return base;
		}
		double result = getPower(base,exponent>>1); //使用移位代替除法操作能够大大提到效率
		result *= result;
		if((exponent & 0x1) == 1) { //通过按位与运算，判断奇偶数  ！！！这个很巧妙啊
			result *= base;
		}
		return result;
	}
}
