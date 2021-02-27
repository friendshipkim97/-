package service;

import java.util.Vector;

import model.MLecture;
import valueObject.VData;

public class SLecture {


	public Vector<VData> getData(String fileName){
		MLecture mLecture = new MLecture();
		return mLecture.getData(fileName);
	}

}
