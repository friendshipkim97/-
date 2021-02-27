package presentation;

import java.util.Vector;

import service.SLecture;
import valueObject.VData;

public class PLecture{

	Vector<String> a;
	Vector<String> b;
	Vector<String> c;
	Vector<String> d;
	Vector<String> e;
	Vector<String> f;

	public PLecture() {

	}

	@SuppressWarnings("rawtypes")
	public Vector show(String fileName) {

		a = new Vector<String>();
		b = new Vector<String>();
		c = new Vector<String>();
		d = new Vector<String>();
		e = new Vector<String>();	
		f = new Vector<String>();

		SLecture sLecture = new SLecture();
		Vector<VData> vData = sLecture.getData(fileName);

		if(vData != null) {
			for(VData vDatum: vData) {
				String temp = vDatum.getId();
				String temp2 = vDatum.getText();
				String temp3 = vDatum.getProName();
				String temp4 = vDatum.getCredit();
				String temp5 = vDatum.getTime();
				a.add(temp);
				b.add(temp2);
				b.add(temp3);
				b.add(temp4);
				b.add(temp5);

				f.add(temp+" "+" "+temp2+" "+temp3+" "+temp4+" "+temp5);
			}
		}

		return f;
	}

}


