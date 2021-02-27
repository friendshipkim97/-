package presentation;
import service.SLogin;
import valueObject.VCheckInfo;
import valueObject.VLoginInfo;
import valueObject.VPersonalInfo;

public class PLogin {

	public PLogin() {
		// TODO Auto-generated constructor stub
	}

	public VPersonalInfo show(String temp_id, String temp_password) {


		VLoginInfo vLoginInfo = new VLoginInfo();
		vLoginInfo.id=temp_id;
		vLoginInfo.password=temp_password;
		// service
		SLogin sLogin = new SLogin();
		VPersonalInfo vPersonalInfo = sLogin.validate(vLoginInfo);

		return vPersonalInfo;

	}

	public String idCheckShow(String temp_id) {

		VCheckInfo vCheckInfo = new VCheckInfo();
		vCheckInfo.id=temp_id;
		// service
		SLogin sLogin = new SLogin();
		VPersonalInfo vPersonalInfo = sLogin.idValidate(vCheckInfo);
		if(vPersonalInfo==null) {
			return null;
		}
		else {
			String temp = vPersonalInfo.id;
			return temp;
		}

	}



}
