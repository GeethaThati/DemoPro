package com.geetha.miniproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ReadFromFile {
	
	 public ArrayList<Rows> readfromfile (ArrayList<Rows> list){
		int i=0;
		String line = null;
		BufferedReader br =null;
		try {
			
			br= new BufferedReader(new FileReader("C:\\Users\\geeth\\Downloads\\complaints.csv"));	
			try {
					while((line=br.readLine())!=null) {
						if(i==0) {
							i++;
							continue;
						}
						
						String values[] =line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)",-1);
					
						list.add(new Rows(values[0],values[1],values[2],values[3],values[4],values[5],values[6],values[7],values[8],values[9],values[10],values[11],values[12],values[13]));
		              }
			 }
			catch(IOException e) {
				e.printStackTrace();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				br.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

		return list;
	 }

}
