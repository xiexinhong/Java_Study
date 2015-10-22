package org.xxh.arrowoffer.datastruct;

public class ScanBinaryTree {
	
	public static void preScan(BinarytreeNode root) {
		if(root != null) {
			System.out.print(root.value+" ");
			if(root.left != null) 
				preScan(root.left);
			if(root.right != null)
				preScan(root.right);
		}
	}
	
	public static void middleScan(BinarytreeNode root) {
		if(root != null) {
			
			if(root.left != null) 
				middleScan(root.left);
			
			System.out.print(root.value+" ");
			
			if(root.right != null)
				middleScan(root.right);
		}
	}

	public static void afterScan(BinarytreeNode root) {
		if(root != null) {
			
			if(root.left != null) 
				afterScan(root.left);
			
			if(root.right != null)
				afterScan(root.right);
			
			System.out.print(root.value+" ");
		}
	}
}
