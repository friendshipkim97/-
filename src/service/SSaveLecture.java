package service;

import model.MSaveLecture;
import valueObject.VPersonalInfo;

public class SSaveLecture {

	public SSaveLecture() {
		// TODO Auto-generated constructor stub
	}

	public void show(VPersonalInfo vPersonalInfo) {
		MSaveLecture mSaveLecture = new MSaveLecture();
		mSaveLecture.saveLecture(vPersonalInfo);
	}

	public void makeFile(VPersonalInfo vPersonalInfo) {

		MSaveLecture mSaveLecture = new MSaveLecture();
		mSaveLecture.makeFile(vPersonalInfo);
	}

}
