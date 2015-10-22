package org.study.thread;

import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadAndWriteLockTest {
	
	public static void main(String[] args) {
		ReadAndWrite raw = new ReadAndWrite();
		for(int i=0;i<3;i++) {
			
			
			new Thread(new Runnable() {
				@Override
				public void run() {
					raw.put(new Random().nextInt());
				}
			}).start();
			
			new Thread(new Runnable() {
				@Override
				public void run() {
					raw.get();
				}
			}).start();
		}
		
			
	}
	
	static class ReadAndWrite {
		private Object data = null;
		private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
		public void get() {
			rwl.readLock().lock();
			System.out.println(Thread.currentThread().getName()+" be ready to read data!");
			try {
				Thread.sleep((long)Math.random()*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"hava read data :"+data);
			rwl.readLock().unlock();
		}
		
		private void put(Object data) {
			rwl.writeLock().lock();
			System.out.println(Thread.currentThread().getName()+" be wrted to write data !");
			try {
				Thread.sleep((long)Math.random()*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.data = data;
			System.out.println(Thread.currentThread().getName()+"hava wrted data:"+this.data);
			rwl.writeLock().unlock();
		}
	}
	
	
	
}
