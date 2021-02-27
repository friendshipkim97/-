package service;

import model.MSearchPersonalInfo;
import valueObject.VPersonalInfo;


public class SSearchPersonalInfo {

	public SSearchPersonalInfo() {

	}

	public VPersonalInfo searchId(String temp_name, String temp_major, String temp_number) {

		MSearchPersonalInfo mSearchPersonalInfo = new MSearchPersonalInfo();		
		VPersonalInfo vPersonalInfo = mSearchPersonalInfo.searchId(temp_name, temp_major, temp_number); 

		if(vPersonalInfo==null) {
			return null;

		}
		else 

			return vPersonalInfo;

	}

	public VPersonalInfo searchPw(String temp_id, String temp_name, String temp_major, String temp_number) {

		MSearchPersonalInfo mSearchPersonalInfo = new MSearchPersonalInfo();		
		VPersonalInfo vPersonalInfo = mSearchPersonalInfo.searchPw(temp_id, temp_name, temp_major, temp_number); 

		if(vPersonalInfo==null) {
			return null;

		}
		else 	
			return vPersonalInfo;
	}

	public VPersonalInfo changePw(String currentPw, String changePw) {
		MSearchPersonalInfo mSearchPersonalInfo = new MSearchPersonalInfo();		

		VPersonalInfo vPersonalInfo = mSearchPersonalInfo.changePw(currentPw, changePw); 
		if(vPersonalInfo==null) {
			return null;	
		}
		else 	
			return vPersonalInfo;

	}

}
