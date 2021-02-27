package presentation;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import service.SSearchPersonalInfo;
import valueObject.VPersonalInfo;

public class PChangePw extends JFrame{

	private static final long serialVersionUID = 1L;

	public PChangePw(VPersonalInfo vPersonalInfo) {

		setBounds(100, 100, 919, 494);
		JPanel contentPane = new JPanel();
		this.setTitle("비밀번호 변경");
		contentPane.setBackground(Color.WHITE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel pwLabel = new JLabel("현재 비밀번호");
		pwLabel.setBounds(60, 200, 130, 21);
		pwLabel.setForeground(SystemColor.activeCaption);
		contentPane.add(pwLabel);

		JTextField pwTextField = new JTextField();
		pwTextField.setBounds(202, 200, 96, 21);
		pwTextField.setToolTipText("현재 비밀번호 입력");
		contentPane.add(pwTextField);
		pwTextField.setColumns(10);

		JLabel changePwLabel = new JLabel("변경할 비밀번호 입력");
		changePwLabel.setBounds(60, 249, 130, 21);
		changePwLabel.setForeground(SystemColor.activeCaption);
		contentPane.add(changePwLabel);

		JTextField changePwTextField = new JTextField();
		changePwTextField.setBounds(202, 246, 96, 21);
		changePwTextField.setToolTipText("변경할 비밀번호 입력");
		contentPane.add(changePwTextField);
		changePwTextField.setColumns(10);

		JLabel changePwLabel2 = new JLabel("변경할 비밀번호 확인");
		changePwLabel2.setBounds(60, 300, 130, 21);
		changePwLabel2.setForeground(SystemColor.activeCaption);
		contentPane.add(changePwLabel2);

		JTextField changePwTextField2 = new JTextField();
		changePwTextField2.setBounds(202, 300, 96, 21);
		changePwTextField.setToolTipText("변경할 비밀번호 확인");
		contentPane.add(changePwTextField2);
		changePwTextField2.setColumns(10);

		JButton changePwButton = new JButton("비밀번호 변경");
		changePwButton.setBounds(354, 287, 112, 40);
		changePwButton.setBackground(SystemColor.textHighlightText);
		changePwButton.setToolTipText("비밀번호 변경");
		changePwButton.setBorderPainted(false);
		changePwButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SSearchPersonalInfo sSearchPersonalInfo = new SSearchPersonalInfo();


				if(vPersonalInfo.password.equals(pwTextField.getText())) {
					if((!changePwTextField.getText().equals("")) || (!changePwTextField2.getText().equals(""))) {	

						if(changePwTextField.getText().equals(changePwTextField2.getText())) {
							VPersonalInfo vPersonalInfo = sSearchPersonalInfo.changePw(pwTextField.getText(), changePwTextField.getText());

							if(vPersonalInfo==null) {
								JOptionPane.showMessageDialog(null, "해당하는 아이디가 없습니다.");
							}
							else {
								JOptionPane.showMessageDialog(null, "바꾼비밀번호는" + vPersonalInfo.password + "입니다.");

							}
						}
						else
							JOptionPane.showMessageDialog(null, "바꿀 비밀번호가 일치하지 않습니다.");
					}
					else {
						JOptionPane.showMessageDialog(null, "바꿀 비밀번호를 입력하세요.");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "현재 비밀번호가 일치하지 않습니다.");
				}
			}
		});
		add(changePwButton);

		JButton outButton = new JButton("나가기");
		outButton.setBackground(SystemColor.textHighlightText);
		outButton.setToolTipText("나가기");
		outButton.setBorderPainted(false);
		outButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				setVisible(false);	
			}
		});
		outButton.setBounds(500, 287, 112, 40);
		contentPane.add(outButton);
	}

}
