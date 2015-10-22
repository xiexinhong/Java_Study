package org.study.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程同步通信
 * 子线程 循环十次  接着主线程循环100次 这样循环100次
 * @author Administrator
 *
 */
public class ConditionCommunication {

	public static void main(String[] args) {
		
		Business business = new Business();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
					for(int i=1;i<=100;i++) {
						business.sub(i);
					}	
			}
		}).start();
		
		for(int i=1;i<=100;i++) {
			business.main(i);
		}
	}
	/**
	 *  synchronized  notify 和  wait 必须在 Synchronized 块中写  对象都是同一个对象。
	 * @author Administrator
	 *
	 */
	static class Business {
		private boolean bShouldSub = true;
		Lock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
		public void sub(int index) {
			lock.lock();
			try {
				while(!bShouldSub) {
					try {
						condition.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				for(int j=1;j<=10;j++) {
					System.out.println("inner loop"+j+"sub thread"+"of the outer"+index);
				}
				bShouldSub = false;
				condition.signal();
			} finally {
				lock.unlock();
			}
		
		}
		
		public void main(int index) {
			//伪换新  spurious 
			lock.lock();
			try{
				while(bShouldSub) {
					try {
						condition.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}	
				for(int j=1;j<=10;j++) {
					System.out.println("inner loop"+j+"main thread"+"of the outer"+index);
				}
				bShouldSub = true;
				condition.signal();
		  } finally {
			  lock.unlock();
		  }
		}
	}
	
}
