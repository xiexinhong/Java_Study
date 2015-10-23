package org.xxh.arrowoffer;

import org.xxh.arrowoffer.datastruct.ListNode;

public class ThirteenProblem {

	public static void main(String[] args) {
		ListNode head = new ListNode();
		ListNode p = head;
		ListNode deletNode = null;
		for(int i=0;i<10;i++) {
			ListNode node = new ListNode();
			node.value = i;
			p.next = node;
			p = node;
			if(i==9) {
				deletNode = node;
			}
		}
		deleteListNode(head, deletNode);
		p = head.next;
		while(p!=null) {
			System.out.println(p.value);
			p = p.next;
		}
	}
	
	private static void deleteListNode(ListNode head,ListNode node) {
		if(head == null || node == null ){
			return;
		}
		ListNode p = head.next;
		ListNode pre = head;
		while(p != null) {
			if(p.value == node.value) {
				if(p.next ==null) {
					pre.next = null;
				} else {
					pre.next = p.next;
				}
				
			}
			pre = pre.next;
			p = p.next;
		}
		
	}
}
