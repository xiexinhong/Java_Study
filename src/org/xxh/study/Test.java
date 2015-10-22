package org.xxh.study;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;


public class Test {
	public static void main(String[] args) {
	
		String path = "F:\\aaa.txt";
		File file = new File(path);
		if(file.exists()) {
			
			try {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String tmp = null;
				while((tmp = reader.readLine()) != null) {
					System.out.println(tmp);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}
