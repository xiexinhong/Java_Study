package org.study.thread;

/*
 * 线程的互斥   synchronized  
 * 
 */
public class TraditionalThreadSynchronized {
	
	public static void main(String[] args) {
		new TraditionalThreadSynchronized().init();
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
    	//this 
		public synchronized void output(String name) {
			int len = name.length();
				for(int i=0;i<len;i++) {
					System.out.print(name.charAt(i)+" ");
				}
				System.out.println();
		}
		
		// this
		public synchronized void output1(String name) {
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
