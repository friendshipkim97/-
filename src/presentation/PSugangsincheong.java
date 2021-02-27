package presentation;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URISyntaxException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import valueObject.VPersonalInfo;

public class PSugangsincheong extends JPanel{

	private VPersonalInfo vPersonalInfo;
	private PGangjwaSeonTaek pGangjwaSeonTaek;
	private PCampus pCampus;
	private PCollege pCollege;
	private PDepartment pDepartment;
	private PLecture pLecture;
	//	private PMiridamgi pMiridamgi;
	//	private PSincheong pSincheong;

	Vector<String> vector1;
	Vector<String> vector2;
	Vector<String> vector3 = new Vector<String>();

	Vector<String> vectorLecture;

	String tempCampus;
	int temp; //��������
	String a;
	boolean check = true;  //��������

	public String major;
	public String number;
	public String name;


	JButton logoutButton = new JButton("�α׾ƿ�");

	public PSugangsincheong(VPersonalInfo vPersonalInfo) {

		this.pGangjwaSeonTaek = new PGangjwaSeonTaek();
		this.vPersonalInfo = vPersonalInfo;

		setBackground(Color.white);
		setLayout(null);
		setBounds(100, 100, 919, 494);

		vector3.add(major);
		vector3.add(number);
		vector3.add(name);

		this.pGangjwaSeonTaek = new PGangjwaSeonTaek();
		this.pCampus = new PCampus();
		this.pCollege = new PCollege();
		this.pDepartment = new PDepartment();
		this.pLecture = new PLecture();

		this.pGangjwaSeonTaek.showCampus();
		JList<String> campusList = new JList<String>();
		campusList.setBackground(new Color(224, 255, 255));
		JList<String> collegeList = new JList<String>();
		collegeList.setBackground(new Color(224, 255, 255));
		JList<String> departmentList = new JList<String>();
		departmentList.setBackground(new Color(224, 255, 255));
		JList<String> lectureList = new JList<String>();
		lectureList.setBackground(new Color(224, 255, 255));

		JLabel tempCampusLabel = new JLabel(pGangjwaSeonTaek.getTempCollegeFileName()+" ķ�۽��Դϴ�.");

		campusList.setListData(pGangjwaSeonTaek.getCampusVector());
		campusList.setBounds(31, 85, 151, 242);
		add(campusList);
		campusList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				System.out.println(e.getSource());
				check = false;
				temp = campusList.getSelectedIndex();
				tempCampusLabel.setText(pGangjwaSeonTaek.getTempCollegeFileName()+" ķ�۽��Դϴ�.");
				if(temp<0) {
					pGangjwaSeonTaek.setTempCollegeFileName(null);
				}
				else {
					pGangjwaSeonTaek.setTempCollegeFileName(pGangjwaSeonTaek.getCampusVector2().get(temp));
					collegeList.setListData(pGangjwaSeonTaek.showCollege());
				}
			}
		});

		collegeList.setBounds(216, 85, 146, 242);
		add(collegeList);
		collegeList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				check = false;
				int temp = collegeList.getSelectedIndex();
				if(temp<0) {
					pGangjwaSeonTaek.setTempDepartmentFileName(null);
				}
				else {
					pGangjwaSeonTaek.setTempDepartmentFileName(pGangjwaSeonTaek.getCollegeVector2().get(temp));
					departmentList.setListData(pGangjwaSeonTaek.showDepartment());
				}
			}
		});

		departmentList.setBounds(396, 85, 151, 242);
		add(departmentList);
		departmentList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				check = false;
				int temp = departmentList.getSelectedIndex();
				if(temp<0) {
					pGangjwaSeonTaek.setTempLectureFileName(null);

				}
				else {
					pGangjwaSeonTaek.setTempLectureFileName(pGangjwaSeonTaek.getDepartmentVector2().get(temp));
					Vector<String> vectorLecture = new Vector<String>();
					vectorLecture = pGangjwaSeonTaek.showLecture();
					setVectorLecture(vectorLecture);
					lectureList.setListData(vectorLecture);
				}
			}
		});

		lectureList.setBounds(31, 355, 516, 91);
		lectureList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				check=true;
				if(temp>=0&&check==true) { 
					int temp = lectureList.getSelectedIndex();
					pGangjwaSeonTaek.tempLecture(temp);
				}

			}
		});
		add(lectureList);

		JLabel CampusLabel = new JLabel("ķ�۽�");
		CampusLabel.setBounds(71, 47, 86, 28);
		add(CampusLabel);

		JLabel CollegeLabel = new JLabel("����");
		CollegeLabel.setBounds(270, 60, 50, 15);
		add(CollegeLabel);

		JLabel DepartmentLabel = new JLabel("�а�");
		DepartmentLabel.setBounds(458, 60, 50, 15);
		add(DepartmentLabel);

		JLabel lectureLabel = new JLabel("����");
		lectureLabel.setBounds(270, 337, 50, 15);
		add(lectureLabel);

		JLabel messageLabel = new JLabel(vPersonalInfo.major + "�а� " + vPersonalInfo.number + "�й� " + vPersonalInfo.name + "��, " + "ȯ���մϴ�.");
		messageLabel.setBounds(157, 10, 400, 33);
		add(messageLabel);
		setPersonalInfo(vPersonalInfo.major, vPersonalInfo.number, vPersonalInfo.name);

		JButton getBagButton = new JButton("å������");
		getBagButton.setBackground(SystemColor.textHighlightText);
		getBagButton.setToolTipText("å������");
		getBagButton.setBorderPainted(false);
		getBagButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pGangjwaSeonTaek.selectedBag(vPersonalInfo);

			}
		});
		getBagButton.setBounds(559, 355, 99, 43);
		add(getBagButton);

		JButton checkBagButton = new JButton("å����Ȯ��");
		checkBagButton.setBackground(SystemColor.textHighlightText);
		checkBagButton.setToolTipText("å����Ȯ��");
		checkBagButton.setBorderPainted(false);
		checkBagButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Vector<String> hi = pGangjwaSeonTaek.selectedBag;
				Vector<String> hi2 = pGangjwaSeonTaek.selectedLecture;
				PGangjwaSeonTaek pGangjwaSeonTaek = new PGangjwaSeonTaek(hi, hi2, vector3, vPersonalInfo);
				pGangjwaSeonTaek.setVisible(true);

			}
		});
		checkBagButton.setBounds(682, 355, 99, 43);
		add(checkBagButton);

		JButton checkLectureButton = new JButton("��ûȮ��");
		checkLectureButton.setBackground(SystemColor.textHighlightText);
		checkLectureButton.setToolTipText("��ûȮ��");
		checkLectureButton.setBorderPainted(false);
		checkLectureButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Vector<String> hi = pGangjwaSeonTaek.selectedBag;
				Vector<String> hi2 = pGangjwaSeonTaek.selectedLecture;
				PGangjwaSeonTaek pGangjwaSeonTaek = new PGangjwaSeonTaek(hi, hi2, "temp", vector3, vPersonalInfo);
				pGangjwaSeonTaek.setVisible(true);
			}
		});
		checkLectureButton.setBounds(682, 403, 99, 43);
		add(checkLectureButton);

		JButton doLectureButton = new JButton("��û�ϱ�");
		doLectureButton.setBackground(SystemColor.textHighlightText);
		doLectureButton.setToolTipText("��û�ϱ�");
		doLectureButton.setBorderPainted(false);
		doLectureButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				pGangjwaSeonTaek.selectedLecture(vPersonalInfo);

			}
		});
		doLectureButton.setBounds(559, 403, 99, 43);
		add(doLectureButton);

		JButton passwordChangeButton = new JButton("��й�ȣ ����");
		passwordChangeButton.setBackground(SystemColor.textHighlightText);
		passwordChangeButton.setToolTipText("��й�ȣ ����");
		passwordChangeButton.setBorderPainted(false);
		passwordChangeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				PChangePw pChangePw = new PChangePw(vPersonalInfo);
				pChangePw.setVisible(true);
			}
		});
		passwordChangeButton.setBounds(800, 355, 110, 43);
		add(passwordChangeButton);


		logoutButton.setBackground(SystemColor.textHighlightText);
		logoutButton.setToolTipText("�α׾ƿ�");
		logoutButton.setBorderPainted(false);
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					PMain pMain = new PMain();
					JOptionPane.showMessageDialog(null, "�α׾ƿ� �Ͽ����ϴ�.");
					setVisible(false);
					pMain.setVisible(true);
				} catch (URISyntaxException e1) {

					e1.printStackTrace();
				}

			}
		});
		logoutButton.setBounds(803, 403, 99, 43);
		add(logoutButton);

		ImageIcon mariImg = new ImageIcon("data/mari&maru.png");
		JLabel mari = new JLabel("", mariImg, JLabel.CENTER);
		mari.setBounds(596, 54, 300, 300);
		add(mari);


		tempCampusLabel.setBounds(108, 457, 150, 15);
		add(tempCampusLabel);

		JButton detailedButton = new JButton("���� �ڼ��� ����");
		detailedButton.setBackground(SystemColor.textHighlightText);
		detailedButton.setToolTipText("���� �ڼ��� ����");
		detailedButton.setBorderPainted(false);
		detailedButton.setBounds(300, 457, 150, 15);
		detailedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PDetailed pDetailed = new PDetailed(getVectorLecture(), pGangjwaSeonTaek.getSelectedLecture(), vPersonalInfo);
				pDetailed.setVisible(true);
			}
		});
		add(detailedButton);


	}

	public void setPersonalInfo(String major, String number, String name) {
		this.major = major;
		this.number = number;
		this.name = name;
	}

	public String getPersonalInfo(String major, String number, String name) {
		return major+number+name;
	}

	public void setVectorLecture(Vector<String> vectorLecture) {
		this.vectorLecture=vectorLecture;
	}

	public Vector<String> getVectorLecture(){
		return vectorLecture;
	}



}
