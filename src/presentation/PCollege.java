package presentation;

import java.util.Vector;

import service.SCollege;
import valueObject.VData;

public class PCollege {

	Vector<String> a;
	Vector<String> b;

	public PCollege() {

	}

	public void show(String fileName) {
		a = new Vector<String>();
		b = new Vector<String>();

		SCollege sCollege = new SCollege();
		Vector<VData> vData = sCollege.getData(fileName);

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
