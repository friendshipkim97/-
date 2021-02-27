package presentation;

import java.util.Vector;

import service.SDepartment;
import valueObject.VData;

public class PDepartment {

	Vector<String> a;
	Vector<String> b;

	public PDepartment() {

	}

	public void show(String fileName) {
		a = new Vector<String>();
		b = new Vector<String>();

		SDepartment sDepartment = new SDepartment();
		Vector<VData> vData = sDepartment.getData(fileName);

		if(vData != null) {
			for(VData vDatum: vData) {
				String temp = vDatum.getText();
				String temp2 = vDatum.getFileName();
				a.add(temp);
				b.add(temp2);
			}
		}



	}

}


