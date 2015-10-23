package org.xxh.arrowoffer;

/**
 * 思路  把一个整数的 减去1 并与之相与  就是把2进制  的最后一位 1变成 0
 * @author Administrator
 *
 */
public class TenProblem {
	
	public static void main(String[] args) {
		int tmp = 7;
		System.out.println(findOneNumber(tmp));
		System.out.println(findOneNumberTwo(tmp));
		System.out.println(findOneNumberThree(tmp));
		System.out.println(judgeIsTwoPower(7));
		System.out.println(mTonNeedChangeNumber(7, 3));
	}
	
	//这个解法是错误的  当输入负数的时候最高位会被设为1 所以  
	private static int findOneNumber(int n) {
		if(n == 0)
			return 0;
		int result = 0;
		while(n>0) {
			if( (n & 1) == 1) {
				result++;
			}
			n = n >>1;
		}
		return result;
	}
	
	private static int findOneNumberTwo(int n) {
		if(n == 0)
			return 0;
		int result = 0;
		int flag = 1;
		while(flag > 0){
			if( (flag & n) > 0) {
				result++;
			}
			flag = flag << 1;
		}
		return result;
	}
	
	private static int findOneNumberThree(int n) {
		if(n == 0)
			return 0;
		int result = 0;
		while(n> 0){
			result++;
			n = n & (n-1);
		}
		return result;
	}
	
	/**
	 * 用一条语句判断 一个数是不是2的次方
	 * @param n
	 * @return
	 */
	private static boolean judgeIsTwoPower(int n) {
		return (n & (n-1)) == 0;
	}
	
	/**
	 * m二进制 到 n的二进制 需要变换多少次 
	 * @param m
	 * @param n
	 * @return
	 */
	private static int mTonNeedChangeNumber(int m,int n) {
		int tmp = m ^ n;
		return findOneNumberThree(tmp);
	}
}
