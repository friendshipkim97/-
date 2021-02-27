package service;

import java.util.Vector;

import model.MCollege;
import valueObject.VData;

public class SCollege {

	public Vector<VData> getData(String fileName){
		MCollege mCollege = new MCollege();
		System.out.println(fileName);
		return mCollege.getData(fileName);
	}
}
