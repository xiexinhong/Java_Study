package org.xxh.arrowoffer;

public class FourTeenProblem {
	
	public static void main(String[] args) {
		int[] data = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13};
		changeArrayOrder(data);
		for(int i=0;i<data.length;i++) {
			System.out.println(data[i]);
		}
	}
	
	private static void changeArrayOrder(int[] array) {
		if(array == null) 
			return;
		int pre = 0;
		int tail = array.length-1;
		while(pre <= tail) {
			for(int i=pre;i<tail;i++) {
				if(array[i] % 2 == 0) {
					pre = i;
					break;
				}
			}
			for(int i=tail;i >= pre;i--) {
				if(array[i] % 2 != 0) {
					tail = i;
					break;
				}				
			}
			if(pre <= tail) {
				int tmp = array[pre];
				array[pre] = array[tail];
				array[tail] = tmp;
				pre++;
				tail--;
			} else {
				break;
			}
		}
	}
	
	

}
