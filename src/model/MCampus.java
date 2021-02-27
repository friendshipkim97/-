package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import valueObject.VData;

public class MCampus {

	public Vector<VData> getData(String fileName) {
		
		Vector<VData> vCampus = null;
		Scanner scanner = null;
		try {
			File file = new File("data/" + fileName);
			scanner = new Scanner(file);
			
			vCampus = new Vector<VData>();
			while(scanner.hasNext()) {
				
				VData vData = new VData();
				
				vData.setId(scanner.next());
				vData.setText(scanner.next());
				vData.setFileName(scanner.next());
				// read
				vCampus.add(vData);
			}			
			
			scanner.close();		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return vCampus;
	}

}