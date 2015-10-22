package org.study.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
	
	public static void main(String[] args) {
		//固定的线程线程池
//		ExecutorService threadPool =  Executors.newFixedThreadPool(3);
		//动态
//		ExecutorService threadPool =  Executors.newCachedThreadPool();
		//耽搁先线程  不用担心线程死了的问题 （如何实现线程死了在从新启动）
		ExecutorService threadPool =  Executors.newSingleThreadExecutor();
		//定时器
		for(int i=0;i<=10;i++) {
			final int task = i;
			threadPool.execute(new Runnable() {
				
				@Override
				public void run() {
					for(int j=0;j<10;j++) {
						System.out.println(Thread.currentThread().getName()+"is looping of "+j+"for task"+task);
					}
				}
			});
		}
		//调度线程池
		ScheduledExecutorService threadPools =  Executors.newScheduledThreadPool(3);
		threadPools.schedule(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("bombing ");
			}
		}, 10, TimeUnit.SECONDS);
		
		threadPools.scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("bombing    ");
				
			}
		}, 6, 2, TimeUnit.SECONDS);
		
	}
	
}
