package org.study.thread;

import java.util.Random;

/**
 * 
 * @author Administrator
 *
 */
public class ThreadLocalTest {
	
	
    public static void main(String[] args) {
    	
			new Thread(new Runnable() {
				@Override
				public void run() {
					int data = new Random().nextInt();
					System.out.println(Thread.currentThread().getName()+
							"has put data"+data);
					MyThreadScopeData myData =  MyThreadScopeData.getInstance();
					myData.setName(Thread.currentThread().getName());
					myData.setAge(data);
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
					MyThreadScopeData myData =  MyThreadScopeData.getInstance();
					myData.setName(Thread.currentThread().getName());
					myData.setAge(data);
					new A().get();
					new B().get();
					
				}
			}).start();
	}
        
	static class A {
		public void get() {
			System.out.println(Thread.currentThread().getName()+"from A get data = "+MyThreadScopeData.getInstance());
		}
	}
	
	static class B {
		public void get() {
			System.out.println(Thread.currentThread().getName()+"from B get data = "+MyThreadScopeData.getInstance());
		}
	}

}

class MyThreadScopeData {
	
	private String name;
	private int age;

	private MyThreadScopeData() {}
	
	public static MyThreadScopeData getInstance() {
		MyThreadScopeData instance = map.get();
		if(instance == null) {
			instance = new MyThreadScopeData();
			map.set(instance);
		}
		return instance;
	}
	
	private static ThreadLocal<MyThreadScopeData> map = new ThreadLocal<MyThreadScopeData>();
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "MyThreadScopeData [name=" + name + ", age=" + age + "]";
	}
	
}
