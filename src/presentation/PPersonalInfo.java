package presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import service.SPersonalInfo;
import service.SSaveLecture;
import valueObject.VPersonalInfo;

//presentation
public class PPersonalInfo extends JPanel {

	private int checkBoxState;

	public PPersonalInfo() {


		setBackground(Color.white);
		setLayout(null);
		setBounds(100, 100, 500, 520);
		setFont(new Font("궁서", Font.BOLD, 14));
		setForeground(SystemColor.activeCaption);

		JLabel label = new JLabel("회원가입");
		label.setFont(new Font("궁서", Font.BOLD, 14));
		label.setBounds(202, 20, 70, 50);
		add(label);

		JLabel lbLabel = new JLabel("Id");
		lbLabel.setBounds(98, 67, 74, 30);
		lbLabel.setForeground(SystemColor.activeCaption);
		add(lbLabel);

		JTextField idTextField = new JTextField();
		idTextField.setBounds(202, 72, 96, 21);
		idTextField.setToolTipText("id 입력");
		add(idTextField);
		idTextField.setColumns(10);

		JLabel PasswordLabel = new JLabel("Password");
		PasswordLabel.setBounds(98, 130, 63, 15);
		PasswordLabel.setForeground(SystemColor.activeCaption);
		add(PasswordLabel);

		JTextField passwordTextField = new JTextField();
		passwordTextField.setBounds(202, 127, 96, 21);
		passwordTextField.setToolTipText("password 입력");
		add(passwordTextField);
		passwordTextField.setColumns(10);

		JLabel passwordCTextField = new JLabel("Password확인");
		passwordCTextField.setBounds(98, 179, 92, 15);
		passwordCTextField.setForeground(SystemColor.activeCaption);
		add(passwordCTextField);

		JTextField PasswordCField = new JTextField();
		PasswordCField.setBounds(202, 176, 96, 21);
		PasswordCField.setToolTipText("password 한번 더 입력");
		add(PasswordCField);
		PasswordCField.setColumns(10);

		JLabel nameLabel = new JLabel("이름");
		nameLabel.setBounds(98, 260, 74, 21);
		nameLabel.setForeground(SystemColor.activeCaption);
		add(nameLabel);

		JTextField nameTextField = new JTextField();
		nameTextField.setBounds(202, 260, 96, 21);
		nameTextField.setToolTipText("이름입력");
		add(nameTextField);
		nameTextField.setColumns(10);

		JLabel majorLabel = new JLabel("학과");
		majorLabel.setBounds(98, 304, 50, 15);
		majorLabel.setForeground(SystemColor.activeCaption);
		add(majorLabel);

		JTextField mTextField = new JTextField();
		mTextField.setBounds(202, 301, 96, 21);
		mTextField.setToolTipText("학과입력");
		add(mTextField);
		mTextField.setColumns(10);

		JLabel nTextLabel = new JLabel("학번");
		nTextLabel.setBounds(98, 223, 50, 15);
		nTextLabel.setForeground(SystemColor.activeCaption);
		add(nTextLabel);

		JTextField nTextField = new JTextField();
		nTextField.setBounds(202, 220, 96, 21);
		nTextField.setToolTipText("학번입력");
		add(nTextField);
		nTextField.setColumns(10);

		JTextField agree = new JTextField();
		agree.setText("약관에 동의하십니까?");
		agree.setToolTipText("약관동의");
		agree.setBounds(332, 222, 150, 30);
		agree.setFont(new Font("궁서", Font.BOLD, 14));
		agree.setForeground(SystemColor.activeCaption);
		add(agree);
		agree.setColumns(10);

		JCheckBox checkBox = new JCheckBox("약관동의");
		checkBox.setBounds(333, 259, 133, 23);
		checkBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				checkBoxState = e.getStateChange();
			}
		});
		add(checkBox);

		JButton clearButton = new JButton("새로고침");
		clearButton.setBounds(332, 170, 134, 23);
		clearButton.setBackground(SystemColor.textHighlightText);
		clearButton.setToolTipText("새로고침");
		clearButton.setBorderPainted(false);
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idTextField.setText("");
				passwordTextField.setText("");
				PasswordCField.setText("");
				nameTextField.setText("");
				nTextField.setText("");
				mTextField.setText("");
				checkBox.setSelected(false);

			}});
		add(clearButton);



		JButton huiButton = new JButton("회원가입");
		huiButton.setBounds(332, 300, 134, 23);
		huiButton.setToolTipText("회원가입");
		huiButton.setActionCommand("회원가입"); 
		huiButton.setBackground(SystemColor.textHighlightText);
		huiButton.setBorderPainted(false);

		ActionListener actionListener = new ActionListener(){ 
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("회원가입")) {
					PLogin pLogin = new PLogin();
					VPersonalInfo vPersonalInfo = new VPersonalInfo();
					String temp = pLogin.idCheckShow(idTextField.getText());
					if(idTextField.getText().equals(temp)) {
						JOptionPane.showMessageDialog(null, "중복된 아이디입니다.");

					}
					if(passwordTextField.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요.");
					}
					else {
						if(passwordTextField.getText().length()>10 || PasswordCField.getText().length()>10) {
							JOptionPane.showMessageDialog(null, "비밀번호를 10자리 이하로 입력하세요.");
						}
						else {
							if (passwordTextField.getText().equals(PasswordCField.getText())) {
								if (checkBoxState == 1) {
									//VPersonalInfo vPersonalInfo = new VPersonalInfo();
									vPersonalInfo.id = idTextField.getText();
									vPersonalInfo.password = passwordTextField.getText();
									vPersonalInfo.name = nameTextField.getText();
									vPersonalInfo.major = mTextField.getText();
									vPersonalInfo.number = nTextField.getText();
									show(vPersonalInfo);

									PMain pMain;
									try {
										pMain = new PMain();
										JOptionPane.showMessageDialog(null, "회원가입 하였습니다.");
										SSaveLecture sSaveLecture = new SSaveLecture();
										sSaveLecture.makeFile(vPersonalInfo);
										setVisible(false);
										pMain.setVisible(true);
									} catch (URISyntaxException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								} else if(nameTextField.getText().equals("")||mTextField.getText().equals("")||nTextField.getText().equals("")) {
									JOptionPane.showMessageDialog(null, "모든 값을 입력하세요.");
								}
								else {
									JOptionPane.showMessageDialog(null, "체크박스가 선택되지 않았습니다.");
								}
							} else if(!passwordTextField.getText().equals(PasswordCField.getText())){
								JOptionPane.showMessageDialog(null, "비밀번호가 틀립니다.");
							}
							else {
								JOptionPane.showMessageDialog(null, "모든값을 입력하세요.");
							}
						}
					}
				}
			}
		};
		huiButton.addActionListener(actionListener);
		add(huiButton);

		idTextField.registerKeyboardAction(actionListener, "회원가입", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0), JComponent.WHEN_FOCUSED);
		passwordTextField.registerKeyboardAction(actionListener, "회원가입", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0), JComponent.WHEN_FOCUSED);
		PasswordCField.registerKeyboardAction(actionListener, "회원가입", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0), JComponent.WHEN_FOCUSED);
		mTextField.registerKeyboardAction(actionListener, "회원가입", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0), JComponent.WHEN_FOCUSED);
		nTextField.registerKeyboardAction(actionListener, "회원가입", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0), JComponent.WHEN_FOCUSED);
		nameTextField.registerKeyboardAction(actionListener, "회원가입", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0), JComponent.WHEN_FOCUSED);

		JButton outButton = new JButton("나가기");
		outButton.setBackground(SystemColor.textHighlightText);
		outButton.setToolTipText("나가기");
		outButton.setBorderPainted(false);
		outButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PMain pMain;
				try {
					pMain = new PMain();
					setVisible(false);
					pMain.setVisible(true);
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		outButton.setBounds(600, 287, 112, 40);
		add(outButton);
	}

	public void show(VPersonalInfo vPersonalInfo) {

		// service
		SPersonalInfo sPersonalInfo = new SPersonalInfo();
		sPersonalInfo.write(vPersonalInfo);

	}



}
