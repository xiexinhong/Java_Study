package org.xxh.arrowoffer;

import org.xxh.arrowoffer.datastruct.ListNode;

public class FifteenProblem {

	public static void main(String[] args) {
		ListNode head = new ListNode();
		ListNode p = head;
		for(int i=0;i<10;i++) {
			ListNode node = new ListNode();
			node.value = i;
			p.next = node;
			p = node;
		}
		ListNode node = getTailNode(head, 3);
		System.out.println(node.value);
		
	}
	
	private static ListNode getTailNode(ListNode head,int k) {
		if(head == null || k <= 0)
			return null;
		ListNode pOne = head.next;
		ListNode pTwo = head.next;
		while(k>0) {
			k--;
			if(pTwo != null)
				pTwo = pTwo.next;
			else 
				return null;
		}
		while(pTwo != null) {
			pTwo = pTwo.next;
			pOne = pOne.next;
		}
		
		return pOne;
		
	}
	
	
}
