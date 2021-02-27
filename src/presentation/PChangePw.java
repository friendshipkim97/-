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
		this.setTitle("��й�ȣ ����");
		contentPane.setBackground(Color.WHITE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel pwLabel = new JLabel("���� ��й�ȣ");
		pwLabel.setBounds(60, 200, 130, 21);
		pwLabel.setForeground(SystemColor.activeCaption);
		contentPane.add(pwLabel);

		JTextField pwTextField = new JTextField();
		pwTextField.setBounds(202, 200, 96, 21);
		pwTextField.setToolTipText("���� ��й�ȣ �Է�");
		contentPane.add(pwTextField);
		pwTextField.setColumns(10);

		JLabel changePwLabel = new JLabel("������ ��й�ȣ �Է�");
		changePwLabel.setBounds(60, 249, 130, 21);
		changePwLabel.setForeground(SystemColor.activeCaption);
		contentPane.add(changePwLabel);

		JTextField changePwTextField = new JTextField();
		changePwTextField.setBounds(202, 246, 96, 21);
		changePwTextField.setToolTipText("������ ��й�ȣ �Է�");
		contentPane.add(changePwTextField);
		changePwTextField.setColumns(10);

		JLabel changePwLabel2 = new JLabel("������ ��й�ȣ Ȯ��");
		changePwLabel2.setBounds(60, 300, 130, 21);
		changePwLabel2.setForeground(SystemColor.activeCaption);
		contentPane.add(changePwLabel2);

		JTextField changePwTextField2 = new JTextField();
		changePwTextField2.setBounds(202, 300, 96, 21);
		changePwTextField.setToolTipText("������ ��й�ȣ Ȯ��");
		contentPane.add(changePwTextField2);
		changePwTextField2.setColumns(10);

		JButton changePwButton = new JButton("��й�ȣ ����");
		changePwButton.setBounds(354, 287, 112, 40);
		changePwButton.setBackground(SystemColor.textHighlightText);
		changePwButton.setToolTipText("��й�ȣ ����");
		changePwButton.setBorderPainted(false);
		changePwButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SSearchPersonalInfo sSearchPersonalInfo = new SSearchPersonalInfo();


				if(vPersonalInfo.password.equals(pwTextField.getText())) {
					if((!changePwTextField.getText().equals("")) || (!changePwTextField2.getText().equals(""))) {	

						if(changePwTextField.getText().equals(changePwTextField2.getText())) {
							VPersonalInfo vPersonalInfo = sSearchPersonalInfo.changePw(pwTextField.getText(), changePwTextField.getText());

							if(vPersonalInfo==null) {
								JOptionPane.showMessageDialog(null, "�ش��ϴ� ���̵� �����ϴ�.");
							}
							else {
								JOptionPane.showMessageDialog(null, "�ٲۺ�й�ȣ��" + vPersonalInfo.password + "�Դϴ�.");

							}
						}
						else
							JOptionPane.showMessageDialog(null, "�ٲ� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
					}
					else {
						JOptionPane.showMessageDialog(null, "�ٲ� ��й�ȣ�� �Է��ϼ���.");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "���� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
				}
			}
		});
		add(changePwButton);

		JButton outButton = new JButton("������");
		outButton.setBackground(SystemColor.textHighlightText);
		outButton.setToolTipText("������");
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
