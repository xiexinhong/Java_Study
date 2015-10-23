package org.xxh.arrowoffer;

public class ElevenProblem {
	
	public static void main(String[] args) {
		System.out.println(powerTwo(2, -1));
	}
	
	/**
	 * 边界值   负数 特殊值 没考虑问题
	 * @param x
	 * @param n
	 * @return
	 */
	private static double power(int x,int n) {
		double result = 1.0D;
		for(int i=1;i<=n;i++) {
			result *= x;
		}
		return result;
	}
	
	private static double powerTwo(int x,int n) {
		double result = 1.0D;
		if(x == 0 && n < 0) {
			return 0.0D;
		}
		boolean isNagetive = false;
		if(n < 0)  {
			isNagetive = true;
			n = n * -1;
		}
		for(int i=1;i<=n;i++) {
			result *= x;
		}
		if(isNagetive) {
			result = 1/result;
		}
		return result;
		
	}
	
	
}
