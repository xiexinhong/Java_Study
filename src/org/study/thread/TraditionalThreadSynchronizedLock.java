package org.study.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * 线程的互斥   Lock
 * 
 */
public class TraditionalThreadSynchronizedLock {
	
	public static void main(String[] args) {
		new TraditionalThreadSynchronizedLock().init();
	}
	
	private void init() {
		Outputer outputer = new Outputer();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					outputer.output("zhangxiaoxiang");
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					outputer.output("lihuoming");
				}
			}
		}).start();
	}
	
   static class Outputer {
	   Lock lock = new ReentrantLock();
    	//this 
		public void output(String name) {
			int len = name.length();
			lock.lock();
			try {
				for(int i=0;i<len;i++) {
					System.out.print(name.charAt(i)+" ");
				}
				System.out.println();
			} finally {
				lock.unlock(); //如果中间抛出了异常 所用用  try finally里面
			}
			
		}
		
		// this
		public  void output1(String name) {
			int len = name.length();
			    synchronized (this) {
					for(int i=0;i<len;i++) {
						System.out.print(name.charAt(i)+" ");
					}
					System.out.println();
				}
		}
		
		//字节码对象
		public static void output2(String name) {
			int len = name.length();
				for(int i=0;i<len;i++) {
					System.out.print(name.charAt(i)+" ");
				}
				System.out.println();
		}
	}
}
