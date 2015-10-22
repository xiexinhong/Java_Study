package org.study.thread;

import java.util.Observable;

public class RuntimeTest {
	public static void main(String[] args) {
		Runtime runtime = Runtime.getRuntime();
		runtime.addShutdownHook(new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("the runtion is die !!!");	
			}
		}));
	}
	
	class TestThreadDestory extends Observable implements Runnable {

		@Override
		public void run() {
			
		}
		
	}
}
