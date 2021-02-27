package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import valueObject.VPersonalInfo;

public class MSaveLecture {

	public MSaveLecture() {
		// TODO Auto-generated constructor stub
	}
	
	public void saveLecture(VPersonalInfo vPersonalInfo) {
	
		File file = new File(vPersonalInfo.id);
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(file);
			PrintWriter printWriter =  new PrintWriter(fileWriter);
			
			printWriter.println(vPersonalInfo.id);
			printWriter.println(vPersonalInfo.password);
			printWriter.println(vPersonalInfo.name);
			printWriter.println(vPersonalInfo.major);
			printWriter.println(vPersonalInfo.number);
			
			for(int i=0; i<vPersonalInfo.saveLecture.size(); i++) {
				printWriter.println(vPersonalInfo.saveLecture.get(i));
			}
			
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	public void makeFile(VPersonalInfo vPersonalInfo) {
		File file = new File(vPersonalInfo.id);	
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(file);
			PrintWriter printWriter =  new PrintWriter(fileWriter);
			
			printWriter.println(vPersonalInfo.id);
			printWriter.println(vPersonalInfo.password);
			printWriter.println(vPersonalInfo.name);
			printWriter.println(vPersonalInfo.major);
			printWriter.println(vPersonalInfo.number);
			
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
