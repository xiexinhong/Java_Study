package org.xxh.arrowoffer;


/**
 * 
 * @author Administrator
 *
 */
public class TwoProblem {

	public static void main(String[] args) {
		int[][] data = new int[][]{{1,2,8,9},
								   {2,4,9,12},
								   {4,7,10,13},
								   {6,8,11,15}
								  };
		System.out.println(findNum(data,5));
	}
	
	private static boolean findNum(int[][] data,int num) {
		if(data == null)
			return false;
		int rows = 4;
		int row = 0;
		int col = 3;
		while(row < rows && col >= 0) {
			if(data[row][col] == num) {
				return true;
			} else if(data[row][col] < num) {
				row++;
			} else {
				col--;
			}
		}
		return false;
		
	}
	
}
