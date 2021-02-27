package service;

import model.MPersonalInfo;
import valueObject.VCheckInfo;
import valueObject.VLoginInfo;
import valueObject.VPersonalInfo;

public class SLogin {
	int a=3;
	int b=3;

	public SLogin() {
		
	}

	public VPersonalInfo validate(VLoginInfo vLoginInfo) {
		
		MPersonalInfo mPersonalInfo = new MPersonalInfo();		
		VPersonalInfo vPersonalInfo = mPersonalInfo.read(vLoginInfo.id); //id만전달 
		
		if(vPersonalInfo==null) {
			return null;
			
		}
		else {
				if(vLoginInfo.password.equals(vPersonalInfo.password)) {
				return vPersonalInfo;
			} else {
	
				return null;
			}
		}
	}
	
     public VPersonalInfo idValidate(VCheckInfo vCheckInfo) {
		
		MPersonalInfo mPersonalInfo = new MPersonalInfo();	
		VPersonalInfo vPersonalInfo = mPersonalInfo.read(vCheckInfo.id); //id만전달 
		
		if(vPersonalInfo==null) 
		   return null;
		
		else 
				return vPersonalInfo;
		
	}

     }

