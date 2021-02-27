package model;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import valueObject.VPersonalInfo;

public class MPersonalInfo {
	

	public MPersonalInfo() {
	
	}
	
	public VPersonalInfo read(String id) {
		
		try {
			File file = new File("temp");
			Scanner scanner;
			scanner = new Scanner(file);
			VPersonalInfo vPersonalInfo = new VPersonalInfo();
			
			boolean found = false;
			
			while(scanner.hasNext() && !found) {
				vPersonalInfo.id = scanner.next();
				vPersonalInfo.password = scanner.next();
				vPersonalInfo.name = scanner.next();
				vPersonalInfo.major = scanner.next();
				vPersonalInfo.number = scanner.next();
				if(vPersonalInfo.id.equals(id)) {
				found = true;
				}
			}
			
			scanner.close();
			
			if(found) {
				return vPersonalInfo;
			}
			else {
				return null;
			}

			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public void write(VPersonalInfo vPersonalInfo) {
		
		try {

			File file = new File("temp");
			FileWriter fileWriter = new FileWriter(file, true);
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
