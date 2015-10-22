package org.xxh.arrowoffer;


public class EightProblem {

	public static void main(String[] args) {
		int[] data = {3,4,5,8,2};
		int[] data2 = {1,2,3,4,5,6,7,8,9,10};
		System.out.println(getMinNumber(data));
		System.out.println(binarySearch(data2,500));
	}
	
	private static int getMinNumber(int[] data) {
		if(data == null)
			return 0;
		int idxOne = 0;
		int idxTwo = data.length-1;
		int idxMiddle = idxOne;
		while(data[idxOne] > data[idxTwo]) {
			
			if(idxTwo - idxOne == 1) {
				idxMiddle = idxTwo;
				break;
			}
			idxMiddle = (idxOne + idxTwo) /2;
			if(data[idxMiddle] > data[idxOne]) {
				idxOne = idxMiddle;
			} else if(data[idxMiddle] <= data[idxOne]) {
				idxTwo = idxMiddle;
			}
			
		}
		
		return data[idxMiddle];
	}
	
	//标准的二分检索
	private static boolean binarySearch(int data[],int key) {
		if(data == null) 
			return false;
		int idxOne = 0;
		int idxTwo = data.length -1;
		int idxMiddle = idxOne;
		while(idxOne < idxTwo) {
			idxMiddle = (idxOne + idxTwo) / 2;
			if(data[idxMiddle] == key) {
				return true;
			}
			
			if(data[idxMiddle] > key) {
				idxTwo = idxMiddle;
			} else if(data[idxMiddle] < key) {
				idxOne = idxMiddle+1;
			}
		}
		return false;
	}
	
}
