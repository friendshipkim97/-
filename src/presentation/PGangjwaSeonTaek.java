package presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import service.SSaveBagLecture;
import service.SSaveLecture;
import valueObject.VPersonalInfo;

public class PGangjwaSeonTaek extends JFrame{

	private static final long serialVersionUID = 1L;
	PCampus pCampus  = new PCampus();
	PCollege pCollege= new PCollege();
	PDepartment pDepartment= new PDepartment();
	PLecture pLecture = new PLecture();

	public Vector<String> campus;
	public Vector<String> campus2;
	public Vector<String> college;
	public Vector<String> college2;
	public Vector<String> department;
	public Vector<String> department2;
	public Vector<String> lecture;
	public Vector<String> lecture2;

	public Vector<String> selectedLecture =  new Vector<String>();
	public Vector<String> selectedBag = new Vector<String>();
	public Vector<String> personalInfo = new Vector<String>();

	private String tempCampusFileName;
	private String tempCollegeFileName;
	private String tempDepartmentFileName;
	private String tempLectureFileName;

	private String tempLecture;
	//private String tempBag;

	public int tempBagIndex;

	boolean cal = false;

	JList<String> lectureList = new JList<String>();

	//@SuppressWarnings("deprecation")
	public PGangjwaSeonTaek(Vector<String> bag, Vector<String> lecture, Vector<String> aa, VPersonalInfo vPersonalInfo) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 919, 520);
		JMenuBar jMenuBar = new JMenuBar();
		JMenu jMenu = new JMenu("User");
		jMenu.setMnemonic('U');
		JMenuItem personalMenuItem = new JMenuItem("PersonalInfo");
		personalMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "사용자정보"+ "\n" +
						"id : " + vPersonalInfo.id + "\n"+
						"password : " + vPersonalInfo.password+ "\n"+
						"name : " + vPersonalInfo.name + "\n"+
						"major : " + vPersonalInfo.major + "\n"+
						"number : " + vPersonalInfo.number + "\n");	
			}
		});
		personalMenuItem.setAccelerator(KeyStroke.getKeyStroke 
				('P',InputEvent.CTRL_DOWN_MASK));
		JMenuItem logoutMenuItem = new JMenuItem("Logout");
		logoutMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				PSugangsincheong pSugangsincheong = new PSugangsincheong(vPersonalInfo);
				pSugangsincheong.logoutButton.doClick();				
			}		
		});
		logoutMenuItem.setAccelerator(KeyStroke.getKeyStroke 
				('L',InputEvent.CTRL_DOWN_MASK));
		jMenu.add(personalMenuItem);
		jMenu.add(logoutMenuItem);
		jMenuBar.add(jMenu);
		this.setJMenuBar(jMenuBar);

		JPanel contentPane = new JPanel();

		this.setTitle("책가방");
		contentPane.setBackground(Color.WHITE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JList<String> bagList = new JList<String>();
		bagList.setBackground(SystemColor.activeCaption);
		bagList.setBounds(58, 50, 753, 349);
		selectedBag=bag;
		selectedLecture=lecture;
		setSelectedBag(selectedBag);
		setSelectedLecture(selectedLecture);
		bagList.setListData(getSelectedBag());
		getContentPane().add(bagList);

		cal=true;
		calBagNumber(getSelectedBag());
		JLabel canBagLabel = new JLabel("책가방 최대신청학점 22 학점");
		canBagLabel.setFont(new Font("궁서", Font.BOLD, 12));
		canBagLabel.setBounds(220, 10, 512, 30);
		getContentPane().add(canBagLabel);

		JLabel personalLabel = new JLabel(vPersonalInfo.major + "학과 " + vPersonalInfo.number + "학번 " + vPersonalInfo.name + "님, 책가방 창 입니다.");
		personalLabel.setBounds(400, 10, 512, 30);
		personalLabel.setFont(new Font("궁서", Font.BOLD, 12));
		getContentPane().add(personalLabel);


		JButton exitButton = new JButton("나가기");
		exitButton.setBackground(SystemColor.textHighlightText);
		exitButton.setToolTipText("나가기");
		exitButton.setBorderPainted(false);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}});
		exitButton.setBounds(721, 416, 91, 23);
		getContentPane().add(exitButton);

		JButton canLecture = new JButton("수강신청");
		canLecture.setBackground(SystemColor.textHighlightText);
		canLecture.setToolTipText("수강신청");
		canLecture.setBorderPainted(false);
		canLecture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				tempBagIndex = bagList.getSelectedIndex();
				enrollLecture(tempBagIndex);
				selectedLecture(vPersonalInfo);

			}});
		canLecture.setBounds(595, 416, 91, 23);
		getContentPane().add(canLecture);

		JLabel canBagLabel2 = new JLabel("현재 책가방" + calBagNumber(getSelectedBag()) + "학점");
		canBagLabel2.setToolTipText("현재 책가방 학점");
		canBagLabel2.setFont(new Font("궁서", Font.BOLD, 12));
		canBagLabel2.setBounds(68, 10, 150, 30);
		getContentPane().add(canBagLabel2);

		JButton bagCancelButton = new JButton("책가방 취소");
		bagCancelButton.setBackground(SystemColor.textHighlightText);
		bagCancelButton.setToolTipText("책가방 취소");
		bagCancelButton.setBorderPainted(false);
		bagCancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				tempBagIndex = bagList.getSelectedIndex();
				selectedBag.remove(tempBagIndex);
				setSelectedBag(selectedBag);
				bagList.setListData(getSelectedBag());
				SSaveBagLecture sSaveBagLecture = new SSaveBagLecture();
				vPersonalInfo.saveBagLecture = selectedBag;
				sSaveBagLecture.show(vPersonalInfo);
				canBagLabel2.setText("현재 책가방 학점" + calBagNumber(getSelectedBag()) + "학점");

			}});
		bagCancelButton.setBounds(400, 416, 120, 23);
		getContentPane().add(bagCancelButton);


		JButton currentBagNumberButton = new JButton("현재학점확인");
		currentBagNumberButton.setBackground(SystemColor.textHighlightText);
		currentBagNumberButton.setToolTipText("현재 학점 확인");
		currentBagNumberButton.setBorderPainted(false);
		currentBagNumberButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cal=true;
				canBagLabel2.setText("현재 책가방 학점" + calBagNumber(getSelectedBag()) + "학점");
			}});
		currentBagNumberButton.setBounds(200, 416, 120, 23);
		getContentPane().add(currentBagNumberButton);

	}

	public PGangjwaSeonTaek(Vector<String> bag, Vector<String> lecture, String a, Vector<String> aa, VPersonalInfo vPersonalInfo) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 919, 520);
		JPanel lectureContentPane = new JPanel();

		this.setTitle("수강신청");
		lectureContentPane.setBackground(Color.WHITE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		lectureContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(lectureContentPane);
		lectureContentPane.setLayout(null);


		JList<String> lectureList = new JList<String>();
		lectureList.setBounds(58, 50, 753, 349);
		lectureList.setBackground(SystemColor.activeCaption);
		lectureList.setListData(lecture);
		selectedBag=bag;
		selectedLecture=lecture;
		lectureList.setListData(getSelectedLecture());
		getContentPane().add(lectureList);

		JLabel personalLabel = new JLabel(vPersonalInfo.major + "학과 " + vPersonalInfo.number + "학번 " + vPersonalInfo.name + "님, 수강신청창 입니다.");
		personalLabel.setBounds(400, 10, 512, 30);
		getContentPane().add(personalLabel);


		cal=true;
		calLectureNumber(getSelectedLecture());
		JTextField canLectureField = new JTextField("현재 수강신청" + calLectureNumber(getSelectedLecture()) + "학점");
		canLectureField.setToolTipText("현재 수강신청 학점");
		canLectureField.setBounds(68, 10, 150, 30);
		getContentPane().add(canLectureField);

		JLabel canLectureLabel = new JLabel("최대 수강신청가능학점 : 18학점" );
		canLectureLabel.setBounds(220, 10, 512, 30);
		getContentPane().add(canLectureLabel);

		JButton exitButton = new JButton("나가기");
		exitButton.setBackground(SystemColor.textHighlightText);
		exitButton.setToolTipText("나가기");
		exitButton.setBorderPainted(false);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}});
		exitButton.setBounds(721, 416, 91, 23);
		getContentPane().add(exitButton);

		JButton lectureCancel = new JButton("수강취소");
		lectureCancel.setBackground(SystemColor.textHighlightText);
		lectureCancel.setToolTipText("수강취소");
		lectureCancel.setBorderPainted(false);
		lectureCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int temp = lectureList.getSelectedIndex();
				selectedLecture.remove(temp);
				setSelectedLecture(selectedLecture);
				lectureList.setListData(getSelectedLecture());
				SSaveLecture sSaveLecture = new SSaveLecture();
				vPersonalInfo.saveLecture = selectedLecture;
				sSaveLecture.show(vPersonalInfo);
				canLectureField.setText("현재 수강신청 학점" + calLectureNumber(getSelectedLecture()) + "학점");
			}});
		lectureCancel.setBounds(595, 416, 91, 23);
		getContentPane().add(lectureCancel);


	}

	private void setPersonalInfo(VPersonalInfo vPersonalInfo) {
		// TODO Auto-generated method stub

	}

	public PGangjwaSeonTaek() {
	}



	public Vector<String> showCampus() {

		campus = new Vector<String>();
		campus2 = new Vector<String>();
		this.pCampus.show("root");

		setCampusVector(pCampus.a);
		setCampusVector2(pCampus.b);

		return getCampusVector();
	}

	public Vector<String> showCollege() {

		college = new Vector<String>();
		college2 = new Vector<String>();
		this.pCollege.show(getTempCollegeFileName());

		setCollegeVector(pCollege.a);
		setCollegeVector2(pCollege.b);

		return getCollegeVector();

	}

	public Vector<String> showDepartment() {

		department = new Vector<String>();
		department2 = new Vector<String>();
		this.pDepartment.show(getTempDepartmentFileName());

		setDepartmentVector(pDepartment.a);
		setDepartmentVector2(pDepartment.b);

		return getDepartmentVector();
	}

	public Vector<String> showLecture() {

		lecture = new Vector<String>();
		lecture2 = new Vector<String>();
		this.pLecture.show(getTempLectureFileName());

		setLectureVector(pLecture.f);
		setLectureVector2(pLecture.f);

		return getLectureVector();
	}

	public void tempLecture(int temp) {

		if(temp!=-1) {
			tempLecture=pLecture.f.get(temp);
		}
	}

	public void setTempLecture(String temp) {

		tempLecture=temp;
	}

	public void selectedLecture(VPersonalInfo vPersonalInfo) {

		boolean check = false;

		for(int i=0; i<selectedLecture.size(); i++) {
			if(selectedLecture.get(i).equals(tempLecture)) {
				JOptionPane.showMessageDialog(null, "이미 신청한 강좌입니다.");
				check = true;
				break;
			}
		}
		cal=true;
		if(calTempLectureNumber(tempLecture)+calLectureNumber(getSelectedLecture())>18) {
			JOptionPane.showMessageDialog(null, "18학점 초과로 담지 못합니다.");
		}		
		else if(check==false && calTempLectureNumber(tempLecture)+calLectureNumber(getSelectedLecture())<=18){		
			selectedLecture.add(tempLecture);

			SSaveLecture sSaveLecture = new SSaveLecture();
			vPersonalInfo.saveLecture = selectedLecture;
			sSaveLecture.show(vPersonalInfo);
		}

	}


	public void tempBag(int temp) {

		tempLecture=pLecture.f.get(temp);

	}

	public void selectedBag(VPersonalInfo vPersonalInfo) {
		boolean check = false;

		for(int i=0; i<selectedBag.size(); i++) {
			if(selectedBag.get(i).equals(tempLecture)) {
				JOptionPane.showMessageDialog(null, "책가방에 있는 강좌입니다.");
				check = true;
				break;
			}
		}
		cal=true;
		if(calTempLectureNumber(tempLecture)+calBagNumber(getSelectedBag())>22) {
			JOptionPane.showMessageDialog(null, "22학점 초과로 담지 못합니다.");
		}		
		else if(check==false && calTempLectureNumber(tempLecture)+calBagNumber(getSelectedBag())<=22){		
			selectedBag.add(tempLecture);	
			
			SSaveBagLecture sSaveBagLecture = new SSaveBagLecture();
			vPersonalInfo.saveBagLecture = selectedBag;
			sSaveBagLecture.show(vPersonalInfo);
		}
	}

	public void enrollLecture(int temp) {
		tempLecture=selectedBag.get(temp);
	}

	public int calBagNumber(Vector<String> selectedBag) {

		int currentBagNumber=0;

		if(cal==true) {
			for(int i=0; i<selectedBag.size(); i++) {
				String a = selectedBag.get(i);
				String[] str = a.split("\\s+");

				for(int j=0; j<str.length; j++) {
					if(j%3==0 && j!=0) {
						currentBagNumber = Integer.parseInt(str[j]) + currentBagNumber;
					}
				}
			}

		}
		return currentBagNumber;
	}

	public int calLectureNumber(Vector<String> selectedLecture) {

		int currentLectureNumber=0;

		if(cal==true) {
			for(int i=0; i<selectedLecture.size(); i++) {
				String a = selectedLecture.get(i);
				String[] str = a.split("\\s+");

				for(int j=0; j<str.length; j++) {
					if(j%3==0 && j!=0) {
						currentLectureNumber = Integer.parseInt(str[j]) + currentLectureNumber;
					}
				}
			}

		}
		return currentLectureNumber;
	}

	public int calTempLectureNumber(String tempLecture) {

		String a = tempLecture;
		String[] str = a.split("\\s+");
		int temp = Integer.parseInt(str[3]);

		return temp;
	}

	public void setSelectedBag(Vector<String> selectedBag) {	this.selectedBag=selectedBag;}
	public Vector<String> getSelectedBag() {	return selectedBag;}
	public void setSelectedLecture(Vector<String> selectedLecture) {	this.selectedLecture=selectedLecture;	}
	public Vector<String> getSelectedLecture() {	return selectedLecture;	}

	public void setCampusVector(Vector<String> a) {		campus = a;	}
	Vector<String> getCampusVector() {	return campus;}
	public void setCampusVector2(Vector<String> b) {		campus2 = b;	}
	Vector<String> getCampusVector2() {	return campus2;	}
	public void setCollegeVector(Vector<String> b) {	college = b;}
	Vector<String> getCollegeVector() {	return college;}
	public void setCollegeVector2(Vector<String> b) {	college2 = b;	}
	Vector<String> getCollegeVector2() {		return college2;	}
	public void setDepartmentVector(Vector<String> c) {		department = c;	}
	Vector<String> getDepartmentVector() {		return department;	}
	public void setDepartmentVector2(Vector<String> c) {		department2 = c;	}
	Vector<String> getDepartmentVector2() {		return department2;	}
	public void setLectureVector(Vector<String> d) {		lecture = d;	}
	Vector<String> getLectureVector() {		return lecture;	}
	public void setLectureVector2(Vector<String> d) {		lecture2 = d;	}
	Vector<String> getLectureVector2() {		return lecture2;	}

	public void setTempCampusFileName(String temp) {		tempCampusFileName = temp;	}
	public String getTempCampusFileName() {		return tempCampusFileName;	}
	public void setTempCollegeFileName(Object object) {		tempCollegeFileName = (String) object;	}
	public String getTempCollegeFileName() {		return tempCollegeFileName;	}
	public void setTempDepartmentFileName(Object object) {		tempDepartmentFileName = (String) object;	}
	public String getTempDepartmentFileName() {		return tempDepartmentFileName;	}
	public void setTempLectureFileName(Object object) {		tempLectureFileName = (String) object;	}
	public String getTempLectureFileName() {		return tempLectureFileName;	}

}
