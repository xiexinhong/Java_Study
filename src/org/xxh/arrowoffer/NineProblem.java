package org.xxh.arrowoffer;

/**
 * 青蛙跳 一级台阶 二级台阶  n级台阶有多少种跳法。
 * 2*8 的矩形 被 2*1的矩形放 是一个道理 都是斐波拉切 
 * @author Administrator
 *
 */
public class NineProblem {

	public static void main(String[] args) {
		long tmp = 35;
		System.out.println(fibonacci(tmp));
		System.out.println(fibonacciFor(tmp));
	}
	
	private static long fibonacci(long n) {
		if(n <= 0) { 
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		return fibonacci(n-1) + fibonacci(n-2); 
	}
	
	private static long fibonacciFor(long n) {
		if(n <= 0) { 
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		long nDevOne = 0;
		long nDevTwo = 1;
		long result = 0;
		for(int i=2;i<=n;i++) {
			result = nDevOne + nDevTwo;
			nDevOne = nDevTwo;
			nDevTwo = result;
		}
		return result;
	}
	
	
}
