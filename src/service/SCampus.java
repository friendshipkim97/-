package service;

import java.util.Vector;

import model.MCampus;
import valueObject.VData;

public class SCampus {

	public SCampus() {

	}

	public Vector<VData> getData(String fileName){
		MCampus mCampus = new MCampus();
		return mCampus.getData(fileName);
	}

}
