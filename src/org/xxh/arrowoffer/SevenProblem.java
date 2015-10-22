package org.xxh.arrowoffer;

import java.util.EmptyStackException;
import java.util.Queue;
import java.util.Stack;


/**
 * 两个栈实现一个队列
 * @author Administrator
 *
 */
public class SevenProblem {

	public static void main(String[] args) {
	
		TwoStackToQueue queue = new TwoStackToQueue();
		queue.push("a");
		queue.push("b");
		queue.push("c");
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		queue.push("d");
		queue.push("e");
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
	}
	
	public static class TwoStackToQueue {
		private Stack oneStack = new Stack();
		private Stack twoStack = new Stack();
		
		public void push(Object obj) {
			oneStack.push(obj);
		}
		
		public Object pop() {
			if(twoStack.size() == 0) {
				while(oneStack.size() > 0) {
					twoStack.push(oneStack.pop());
				}
			}
//			if(!twoStack.isEmpty()){
				return twoStack.pop();
//			} else {
//			}
		}
		
	}
	
}
