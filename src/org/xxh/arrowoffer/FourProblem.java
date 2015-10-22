package org.xxh.arrowoffer;

public class FourProblem {
	
	public static void main(String[] args) {
		String dataString = "We are happy";
		System.out.println(replaceSpace(dataString));
	}
	
	private static String replaceSpace(String arg) {
		if(arg == null) 
			return null;
		char[] datas = arg.toCharArray();
		int num = 0;
		for(int i=0;i<datas.length;i++) {
			if(datas[i] == ' ')
				num++;
		}
		char[] results = new char[datas.length + num*2];
		int pOne = datas.length-1;
		int pTwo = results.length-1;
		while(pOne >= 0) {
			if(datas[pOne] == ' '){
				results[pTwo] = '0';   
				results[pTwo-1] = '2';   
				results[pTwo-2] = '%';
				pTwo = pTwo - 3;
				pOne--;
			} else {
				results[pTwo] = datas[pOne];
				pOne--;
				pTwo--;
			}
		}
		return new String(results);
	}
	
	

}
