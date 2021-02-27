package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import valueObject.VPersonalInfo;

public class MSearchPersonalInfo {

	public MSearchPersonalInfo() {
		// TODO Auto-generated constructor stub
	}
	
     public VPersonalInfo searchId(String name, String major, String number) {
		
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
				if(vPersonalInfo.name.equals(name) && vPersonalInfo.major.equals(major) && vPersonalInfo.number.equals(number)) {
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

	public VPersonalInfo searchPw(String id, String name, String major, String number) {
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
				if(vPersonalInfo.id.equals(id) && vPersonalInfo.name.equals(name) && 
						vPersonalInfo.major.equals(major) && vPersonalInfo.number.equals(number)) {
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
	
	public VPersonalInfo changePw(String currentPw, String changePw) {
		try {
			File file = new File("temp");
			Scanner scanner;
			scanner = new Scanner(file);
			VPersonalInfo vPersonalInfo = new VPersonalInfo();
			int i=-1;
			
			boolean found = false;
			
			while(scanner.hasNext() && !found) {
				i++;
				vPersonalInfo.id = scanner.next();
				vPersonalInfo.password = scanner.next();
				vPersonalInfo.name = scanner.next();
				vPersonalInfo.major = scanner.next();
				vPersonalInfo.number = scanner.next();
				if(vPersonalInfo.password.equals(currentPw)) {
					vPersonalInfo.password=changePw;
				found = true;
				}
				
			}
			
			scanner.close();
			
			if(found) {
				write(vPersonalInfo, i);
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
	
        @SuppressWarnings("resource")
		public void write(VPersonalInfo vPersonalInfo, int i) {
		
		try {

			File file = new File("temp");
			Scanner scanner;
			scanner = new Scanner(file);
			while(scanner.hasNext()) {
				vPersonalInfo.saveId.add(scanner.next());
				vPersonalInfo.savePassword.add(scanner.next());
				vPersonalInfo.saveName.add(scanner.next());
				vPersonalInfo.saveMajor.add(scanner.next());
				vPersonalInfo.saveNumber.add(scanner.next());
			}
			
			FileWriter fileWriter = new FileWriter(file);
			PrintWriter printWriter =  new PrintWriter(fileWriter);
			
			if(i>0) {
			for(int j=0; j<i; j++) {
				printWriter.println(vPersonalInfo.saveId.get(j));
				printWriter.println(vPersonalInfo.savePassword.get(j));
				printWriter.println(vPersonalInfo.saveName.get(j));
				printWriter.println(vPersonalInfo.saveMajor.get(j));
				printWriter.println(vPersonalInfo.saveNumber.get(j));
			}
			printWriter.println(vPersonalInfo.id);
			printWriter.println(vPersonalInfo.password);
			printWriter.println(vPersonalInfo.name);
			printWriter.println(vPersonalInfo.major);
			printWriter.println(vPersonalInfo.number);
			
			for(int j=i+1; j<vPersonalInfo.saveId.size(); j++) {
				printWriter.println(vPersonalInfo.saveId.get(j));
				printWriter.println(vPersonalInfo.savePassword.get(j));
				printWriter.println(vPersonalInfo.saveName.get(j));
				printWriter.println(vPersonalInfo.saveMajor.get(j));
				printWriter.println(vPersonalInfo.saveNumber.get(j));
			}
			
			}
			else if(i==0) {
				printWriter.println(vPersonalInfo.id);
				printWriter.println(vPersonalInfo.password);
				printWriter.println(vPersonalInfo.name);
				printWriter.println(vPersonalInfo.major);
				printWriter.println(vPersonalInfo.number);
				
				for(int j=i+1; j<vPersonalInfo.saveId.size(); j++) {
					printWriter.println(vPersonalInfo.saveId.get(j));
					printWriter.println(vPersonalInfo.savePassword.get(j));
					printWriter.println(vPersonalInfo.saveName.get(j));
					printWriter.println(vPersonalInfo.saveMajor.get(j));
					printWriter.println(vPersonalInfo.saveNumber.get(j));
				}
			}
			
			fileWriter.close();

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

}
