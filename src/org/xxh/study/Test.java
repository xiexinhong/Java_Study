package org.xxh.study;

import java.util.Arrays;



public class Test {
	public static void main(String[] args) {
	
		int a[] = {1,2,3,4,5,6,7,8,9};
		print(Arrays.copyOfRange(a, 0, 2));
		
	}
	
	private static void print(int[] data) {
		for(int i=0;i<data.length;i++) {
			System.out.print(data[i]+" ");
		}
	}
}
