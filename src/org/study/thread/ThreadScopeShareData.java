package org.study.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 线程内的数据共享
 * @author Administrator
 *
 */
public class ThreadScopeShareData {
    
    public static Map<Thread,Integer> dataMap = new HashMap<Thread, Integer>();
	
    public static void main(String[] args) {
    	
			new Thread(new Runnable() {
				@Override
				public void run() {
					int data = new Random().nextInt();
					System.out.println(Thread.currentThread().getName()+
							"has put data"+data);
					dataMap.put(Thread.currentThread(),data);
					new A().get();
					new B().get();
					
				}
			}).start();
			
			new Thread(new Runnable() {
				@Override
				public void run() {
					int data = new Random().nextInt();
					System.out.println(Thread.currentThread().getName()+
							"has put data"+data);
					dataMap.put(Thread.currentThread(),data);
					new A().get();
					new B().get();
					
				}
			}).start();
	}
        
	static class A {
		public void get() {
			System.out.println(Thread.currentThread().getName()+"from A get data = "+dataMap.get(Thread.currentThread()));
		}
	}
	
	static class B {
		public void get() {
			System.out.println(Thread.currentThread().getName()+"from B get data = "+dataMap.get(Thread.currentThread()));
		}
	}
}
