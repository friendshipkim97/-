package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import valueObject.VPersonalInfo;

public class MSaveBagLecture {

	public MSaveBagLecture() {
		// TODO Auto-generated constructor stub
	}
	
	public void saveBagLecture(VPersonalInfo vPersonalInfo) {
		
		File file = new File("bag" + vPersonalInfo.id);
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(file);
			PrintWriter printWriter =  new PrintWriter(fileWriter);
			
			printWriter.println(vPersonalInfo.id);
			printWriter.println(vPersonalInfo.password);
			printWriter.println(vPersonalInfo.name);
			printWriter.println(vPersonalInfo.major);
			printWriter.println(vPersonalInfo.number);
			
			for(int i=0; i<vPersonalInfo.saveBagLecture.size(); i++) {
				printWriter.println(vPersonalInfo.saveBagLecture.get(i));
			}
			
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	public void makeFile(VPersonalInfo vPersonalInfo) {
		File file = new File("bag" + vPersonalInfo.id);
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