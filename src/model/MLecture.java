package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import valueObject.VData;

public class MLecture {
public Vector<VData> getData(String fileName) {
		
		Vector<VData> vLecture = null;
		Scanner scanner = null;
		try {
			File file = new File("data/" + fileName);
			scanner = new Scanner(file);
			
			vLecture = new Vector<VData>();
			while(scanner.hasNext()) {
				
				VData vData = new VData();
				
				vData.setId(scanner.next());
				vData.setText(scanner.next());
				vData.setProName(scanner.next());
				vData.setCredit(scanner.next());
				vData.setTime(scanner.next());
				// read
				vLecture.add(vData);
			}			
			
			scanner.close();		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return vLecture;
	}

}

