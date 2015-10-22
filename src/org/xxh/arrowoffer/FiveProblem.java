package org.xxh.arrowoffer;

import java.util.Stack;

import org.xxh.arrowoffer.datastruct.ListNode;


/**
 * 
 * @author Administrator
 *
 */
public class FiveProblem {
	
	public static void main(String[] args) {
		ListNode head = new ListNode();
		head.value = 100;
		ListNode p = head;
		for(int i=0;i<10;i++) {
			ListNode cNode = new ListNode();
			cNode.value = i;
			System.out.println(cNode.value);
			p.next = cNode;
			p = cNode;
		}
		printTailToHead(head);
	}
	
	private static void printTailToHead(ListNode head) {
		if(head == null){
			return;
		}
		
		Stack<ListNode> tStack = new Stack<ListNode>();
		ListNode p = head;
		while(p != null) {
			tStack.push(p);
			p = p.next;
		}
		while(tStack.size() >0) {
			System.out.println(tStack.pop().value); 
		}
		
	}

}
