package org.xxh.pattern.singleton;

/**
 * 饿汉模式
 * @author Administrator
 *
 */
public class SingletonTwo {

	private SingletonTwo(){}
	
	private static SingletonTwo instance = new SingletonTwo();
	
	public static SingletonTwo getInstance() {
		return instance;
	}
	

}
