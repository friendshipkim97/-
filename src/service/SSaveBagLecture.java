package service;

import model.MSaveBagLecture;
import valueObject.VPersonalInfo;

public class SSaveBagLecture {

	public SSaveBagLecture() {
		// TODO Auto-generated constructor stub
	}

	public void show(VPersonalInfo vPersonalInfo) {
		MSaveBagLecture mSaveBagLecture = new MSaveBagLecture();
		mSaveBagLecture.saveBagLecture(vPersonalInfo);
	}

	public void makeFile(VPersonalInfo vPersonalInfo) {

		MSaveBagLecture mSaveBagLecture = new MSaveBagLecture();
		mSaveBagLecture.makeFile(vPersonalInfo);
	}

}
