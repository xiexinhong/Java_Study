package org.study.thread;

/**
 * 线程同步通信
 * 子线程 循环十次  接着主线程循环100次 这样循环100次
 * @author Administrator
 *
 */
public class TraditionalSynchronizedCommunication {

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
	
	static class Business {
		private boolean bShouldSub = true;
		public synchronized void sub(int index) {
			while(!bShouldSub) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for(int j=1;j<=10;j++) {
				System.out.println("inner loop"+j+"sub thread"+"of the outer"+index);
			}
			bShouldSub = false;
			this.notify();
		}
		
		public synchronized void main(int index) {
			//伪换新  spurious 
			while(bShouldSub) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}	
			for(int j=1;j<=10;j++) {
				System.out.println("inner loop"+j+"main thread"+"of the outer"+index);
			}
			bShouldSub = true;
			this.notify();
		}
	}
	
}
