package org.xxh.study;

import java.util.Scanner;

public class Hello {
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int n = scan.nextInt();
			if(n == 0)
				break;
			int m = scan.nextInt();
			int array[] = new int[n];
			for(int i = 0; i < array.length ; i++)
				array[i] = i;
			int num = 0;
			for(int i = 0; i < m ; i++){
				int x = scan.nextInt();
				int y = scan.nextInt();
				int pid = array[x-1];
				int qid = array[y-1];
				if(pid != qid){
					for(int j = 0 ; j < array.length ; j++){
						if(array[j] == pid){ //将每一个id与pid相同的都要修改成与qid同一值，表示在一个阵营
							array[j] = qid;
						}
					}				
				}
			}
			int arr[] = new int[n];
			for(int i = 0; i < n;i++)
				arr[i] = 0;
			for(int i = 0; i < n ; i++)
				arr[array[i]]++;
			for(int i = 0 ; i < n; i++){
				if(arr[i]!=0)
					num++;
			}
			System.out.println(num-1);

		}
		
	}
	
	

}
