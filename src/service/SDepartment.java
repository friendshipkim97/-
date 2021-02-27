package service;

import java.util.Vector;

import model.MDepartment;
import valueObject.VData;

public class SDepartment {
	public Vector<VData> getData(String fileName){
		MDepartment mDepartment = new MDepartment();
		return mDepartment.getData(fileName);
	}
}
