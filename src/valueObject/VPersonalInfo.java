package valueObject;

import java.util.Vector;

//valueobject 전달할때 싸서주는 오브젝트이다. 
public class VPersonalInfo {

	public String id;
	public String password;
	public String name;
	public String major;
	public String number;
	
	public int a = 5;
	
	public Vector<String> saveId = new Vector<String>();
	public Vector<String> savePassword = new Vector<String>();
	public Vector<String> saveName = new Vector<String>();
	public Vector<String> saveMajor = new Vector<String>();
	public Vector<String> saveNumber = new Vector<String>();
	
	public Vector<String> saveLecture = new Vector<String>();
	public Vector<String> saveBagLecture = new Vector<String>();
	

	public VPersonalInfo() {
		
	}

}
