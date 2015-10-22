package org.xxh.study;

import java.util.Scanner;

public class HelloOne {

	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while(scan.hasNext()) {
			int n = scan.nextInt();
			int thSet[] = new int[n];
			for(int i=1;i<=n;i++) {
				thSet[i] = i;
			}
			int m = scan.nextInt();
			for(int i=0;i<m;i++) {
				int firstN = scan.nextInt();
				int secondN = scan.nextInt();
				int threeN = scan.nextInt(); //1 表示朋友  0 表示敌人
				//找到自己的集合 并加入
				if(threeN == 1) {
					for(int k=0;k < thSet.length;k++) {
						
					}
					thSet[secondN] = thSet[firstN];
				}
				
			}
			
			//才分一共有多少团队
		}
		
	}
	
	int pre[] = new int[1000];

	int find(int x)                                                                                                         //查找根节点
	{ 
	    int r=x;
	    while ( pre[r] != r )                                                                                              //返回根节点 r
	    {
	    	r=pre[r];
	    }
	    
	    int i=x , j ;
	    while( i != r )                                                                                                        //路径压缩
	    {
	         j = pre[ i ]; // 在改变上级之前用临时变量  j 记录下他的值 
	         pre[ i ]= r ; //把上级改为根节点
	         i=j;
	    }
	    return r ;
	}

	void join(int x,int y) {

	    int fx=find(x),fy=find(y);
	    if(fx!=fy)
	        pre[fx ]=fy;
	}
}
