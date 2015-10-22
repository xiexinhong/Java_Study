package org.xxh.pattern.singleton;

/**
 * 静态内部类
 * @author Administrator
 *
 */
public class SingletonThree {

	private SingletonThree(){}
	
	
	private static class LazyHolder {
		private static final SingletonThree INSTANCE = new SingletonThree();
	}
	
	public static SingletonThree getInstance() {
		return LazyHolder.INSTANCE;
	}
	

}
