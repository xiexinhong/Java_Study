package org.study.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 多个线程共享数据
 * @author Administrator
 *1、静对象逐一传递给
 */
public class MultiThreadShareData {

	public static void main(String[] args) {
		ShareData1 data1 = new ShareData1();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				data1.incretement();
			}
		}).start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				data1.decretement();
			}
		}).start();
//		new Thread().start();
//		new Thread().start();
	}
	static class ShareData1 implements Runnable {
		private int count = 100;
		@Override
		public void run() {
			while(true) {
				count-- ;
			}
		}
		
		int j=0;
		public synchronized void incretement() {
			j++;
		}
		public synchronized void decretement() {
			j--;
		}
	}
}
