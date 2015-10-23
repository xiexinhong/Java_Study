package org.xxh.arrowoffer;

public class TwelveProblem {
	
	public static void main(String[] args) {
//		printMaxNumber(3);
//		printMaxNumberTwo(3);
		printMaxNumberThree(3);
	}
	
	private static void printMaxNumber(int m) {
		int max = 1;
		for(int i=0;i<m;i++) {
			max *= 10;
		}
		for(int i=1;i<max;i++) {
			System.out.println(i+" ");
		}
	}
	
	private static void printMaxNumberTwo(int m) {
		char[] result = new char[m+1];
		for(int i=0;i<result.length;i++) {
			result[i] = '0';
		}
		while(true) {

			for(int i=result.length -1;i>=0;i--) {
				int sum = result[i] - '0' + 1;
				if(sum == 10) {
					result[i] = '0';
				} else {
					result[i] = (char) (sum + (int)'0');
					break;
				}
			}
			if(result[0] != '1')
				System.out.println(new String(result));//可以写一个方法不打印前面的0
			else 
				break;
		}
	}
	
	private static void printMaxNumberThree(int n) {
		char[] data = new char[n];
		for(int i=0;i<data.length;i++) {
			data[i] = '0';
		}
		paiLei(data,0,n);
	}
	// 	TODO
	//未解决
	private static void paiLei(char[] data,int index,int length) {
		if(index == length -1) {
			System.out.println(new String(data));
			return;
		}
		System.out.println(new String(data));
		for(int i=0;i<10;i++) {
			data[index] = (char) ('0' + i);
			paiLei(data,index+1,length);
		}
	} 
	
	
	
}
