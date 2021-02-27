package presentation;

import java.util.Vector;

import service.SCampus;
import valueObject.VData;

public class PCampus {

	Vector<String> a;
	Vector<String> b;

	public PCampus(){


	}

	public void show(String fileName) {
		a = new Vector<String>();
		b = new Vector<String>();

		SCampus sCampus = new SCampus();
		Vector<VData> vData = sCampus.getData(fileName);

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






