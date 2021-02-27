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
		setFont(new Font("�ü�", Font.BOLD, 14));
		setForeground(SystemColor.activeCaption);

		JLabel label = new JLabel("ȸ������");
		label.setFont(new Font("�ü�", Font.BOLD, 14));
		label.setBounds(202, 20, 70, 50);
		add(label);

		JLabel lbLabel = new JLabel("Id");
		lbLabel.setBounds(98, 67, 74, 30);
		lbLabel.setForeground(SystemColor.activeCaption);
		add(lbLabel);

		JTextField idTextField = new JTextField();
		idTextField.setBounds(202, 72, 96, 21);
		idTextField.setToolTipText("id �Է�");
		add(idTextField);
		idTextField.setColumns(10);

		JLabel PasswordLabel = new JLabel("Password");
		PasswordLabel.setBounds(98, 130, 63, 15);
		PasswordLabel.setForeground(SystemColor.activeCaption);
		add(PasswordLabel);

		JTextField passwordTextField = new JTextField();
		passwordTextField.setBounds(202, 127, 96, 21);
		passwordTextField.setToolTipText("password �Է�");
		add(passwordTextField);
		passwordTextField.setColumns(10);

		JLabel passwordCTextField = new JLabel("PasswordȮ��");
		passwordCTextField.setBounds(98, 179, 92, 15);
		passwordCTextField.setForeground(SystemColor.activeCaption);
		add(passwordCTextField);

		JTextField PasswordCField = new JTextField();
		PasswordCField.setBounds(202, 176, 96, 21);
		PasswordCField.setToolTipText("password �ѹ� �� �Է�");
		add(PasswordCField);
		PasswordCField.setColumns(10);

		JLabel nameLabel = new JLabel("�̸�");
		nameLabel.setBounds(98, 260, 74, 21);
		nameLabel.setForeground(SystemColor.activeCaption);
		add(nameLabel);

		JTextField nameTextField = new JTextField();
		nameTextField.setBounds(202, 260, 96, 21);
		nameTextField.setToolTipText("�̸��Է�");
		add(nameTextField);
		nameTextField.setColumns(10);

		JLabel majorLabel = new JLabel("�а�");
		majorLabel.setBounds(98, 304, 50, 15);
		majorLabel.setForeground(SystemColor.activeCaption);
		add(majorLabel);

		JTextField mTextField = new JTextField();
		mTextField.setBounds(202, 301, 96, 21);
		mTextField.setToolTipText("�а��Է�");
		add(mTextField);
		mTextField.setColumns(10);

		JLabel nTextLabel = new JLabel("�й�");
		nTextLabel.setBounds(98, 223, 50, 15);
		nTextLabel.setForeground(SystemColor.activeCaption);
		add(nTextLabel);

		JTextField nTextField = new JTextField();
		nTextField.setBounds(202, 220, 96, 21);
		nTextField.setToolTipText("�й��Է�");
		add(nTextField);
		nTextField.setColumns(10);

		JTextField agree = new JTextField();
		agree.setText("����� �����Ͻʴϱ�?");
		agree.setToolTipText("�������");
		agree.setBounds(332, 222, 150, 30);
		agree.setFont(new Font("�ü�", Font.BOLD, 14));
		agree.setForeground(SystemColor.activeCaption);
		add(agree);
		agree.setColumns(10);

		JCheckBox checkBox = new JCheckBox("�������");
		checkBox.setBounds(333, 259, 133, 23);
		checkBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				checkBoxState = e.getStateChange();
			}
		});
		add(checkBox);

		JButton clearButton = new JButton("���ΰ�ħ");
		clearButton.setBounds(332, 170, 134, 23);
		clearButton.setBackground(SystemColor.textHighlightText);
		clearButton.setToolTipText("���ΰ�ħ");
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



		JButton huiButton = new JButton("ȸ������");
		huiButton.setBounds(332, 300, 134, 23);
		huiButton.setToolTipText("ȸ������");
		huiButton.setActionCommand("ȸ������"); 
		huiButton.setBackground(SystemColor.textHighlightText);
		huiButton.setBorderPainted(false);

		ActionListener actionListener = new ActionListener(){ 
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("ȸ������")) {
					PLogin pLogin = new PLogin();
					VPersonalInfo vPersonalInfo = new VPersonalInfo();
					String temp = pLogin.idCheckShow(idTextField.getText());
					if(idTextField.getText().equals(temp)) {
						JOptionPane.showMessageDialog(null, "�ߺ��� ���̵��Դϴ�.");

					}
					if(passwordTextField.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "��й�ȣ�� �Է��ϼ���.");
					}
					else {
						if(passwordTextField.getText().length()>10 || PasswordCField.getText().length()>10) {
							JOptionPane.showMessageDialog(null, "��й�ȣ�� 10�ڸ� ���Ϸ� �Է��ϼ���.");
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
										JOptionPane.showMessageDialog(null, "ȸ������ �Ͽ����ϴ�.");
										SSaveLecture sSaveLecture = new SSaveLecture();
										sSaveLecture.makeFile(vPersonalInfo);
										setVisible(false);
										pMain.setVisible(true);
									} catch (URISyntaxException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								} else if(nameTextField.getText().equals("")||mTextField.getText().equals("")||nTextField.getText().equals("")) {
									JOptionPane.showMessageDialog(null, "��� ���� �Է��ϼ���.");
								}
								else {
									JOptionPane.showMessageDialog(null, "üũ�ڽ��� ���õ��� �ʾҽ��ϴ�.");
								}
							} else if(!passwordTextField.getText().equals(PasswordCField.getText())){
								JOptionPane.showMessageDialog(null, "��й�ȣ�� Ʋ���ϴ�.");
							}
							else {
								JOptionPane.showMessageDialog(null, "��簪�� �Է��ϼ���.");
							}
						}
					}
				}
			}
		};
		huiButton.addActionListener(actionListener);
		add(huiButton);

		idTextField.registerKeyboardAction(actionListener, "ȸ������", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0), JComponent.WHEN_FOCUSED);
		passwordTextField.registerKeyboardAction(actionListener, "ȸ������", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0), JComponent.WHEN_FOCUSED);
		PasswordCField.registerKeyboardAction(actionListener, "ȸ������", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0), JComponent.WHEN_FOCUSED);
		mTextField.registerKeyboardAction(actionListener, "ȸ������", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0), JComponent.WHEN_FOCUSED);
		nTextField.registerKeyboardAction(actionListener, "ȸ������", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0), JComponent.WHEN_FOCUSED);
		nameTextField.registerKeyboardAction(actionListener, "ȸ������", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0), JComponent.WHEN_FOCUSED);

		JButton outButton = new JButton("������");
		outButton.setBackground(SystemColor.textHighlightText);
		outButton.setToolTipText("������");
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
