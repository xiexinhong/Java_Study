package org.xxh.pattern.singleton;

/**
 * 懒汉模式
 * @author Administrator
 *
 */
public class SingletonOne {

	private SingletonOne(){}
	
	private static SingletonOne instance = null;
	
	//这个不是线程安全的
	public static SingletonOne getInstance() {
		if(instance == null) {
			instance = new SingletonOne();
		}
		return instance;
	}
	
	public static synchronized SingletonOne getInstanceSyn() {
		if(instance == null) {
			instance = new SingletonOne();
		}
		return instance;
	}
	
	public static SingletonOne getInstanceDSyn() {
		if(instance == null) {
			synchronized (SingletonOne.class) {
				if(instance == null) {
					instance = new SingletonOne();
				}
			}
		}
		return instance;
	}
}
