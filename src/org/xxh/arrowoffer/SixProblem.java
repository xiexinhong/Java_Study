package org.xxh.arrowoffer;

import java.util.Arrays;

import org.xxh.arrowoffer.datastruct.BinarytreeNode;
import org.xxh.arrowoffer.datastruct.ScanBinaryTree;

public class SixProblem {

	
	public static void main(String[] args) {
	
		int[] preOrder = {1,2,4,7,3,5,6,8};
		int[] middleOrder = {4,7,2,1,5,3,8,6};
		BinarytreeNode tree = ReCreateTree(preOrder,middleOrder);
		ScanBinaryTree.preScan(tree);
		System.out.println();
		ScanBinaryTree.middleScan(tree);
		
	}
	
	private static BinarytreeNode ReCreateTree(int[] preOrder,int[] middleOrder) {
		if(preOrder == null || middleOrder == null )
			return null;
		if((preOrder.length <= 0 && preOrder.length <= 0) ||( preOrder.length != middleOrder.length))
			return null;
		BinarytreeNode root = new BinarytreeNode();
		root.value = preOrder[0];
		int middle = 0;
		for(int i=0;i<middleOrder.length;i++) {
			if(middleOrder[i] == preOrder[0]) {
				middle = i;
			}
		}
		if(middle >= 0) { //这里一定要是等于0也可以
			/**
			 * 每次都这样暴力的穿件一份数组其实很浪费  可以用指针移动来处理
			 * */
			root.left = ReCreateTree(Arrays.copyOfRange(preOrder, 1, middle+1),
					Arrays.copyOfRange(middleOrder, 0, middle));
			
			root.right = ReCreateTree(Arrays.copyOfRange(preOrder, middle+1,preOrder.length),
					Arrays.copyOfRange(middleOrder, middle+1, middleOrder.length));
		}
		return root;
	}
	
	
	
	
}
