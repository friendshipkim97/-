package presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import service.SSearchPersonalInfo;
import valueObject.VPersonalInfo;

public class PSearchPw extends JPanel{

	public PSearchPw() {
		setBackground(Color.white);
		setBounds(100, 100, 500, 500);
		setFont(new Font("�ü�", Font.BOLD, 14));
		setForeground(SystemColor.activeCaption);
		setLayout(null);

		JLabel label = new JLabel("��й�ȣ ã��");
		label.setBounds(147, 49, 130, 50);
		label.setFont(new Font("�ü�", Font.BOLD, 14));
		add(label);

		JLabel idLabel = new JLabel("���̵�");
		idLabel.setForeground(SystemColor.activeCaption);
		idLabel.setBounds(98, 155, 74, 21);
		add(idLabel);

		JTextField idTextField = new JTextField();
		idTextField.setColumns(10);
		idTextField.setToolTipText("���̵� �Է�");
		idTextField.setBounds(202, 155, 96, 21);
		add(idTextField);

		JLabel nameLabel = new JLabel("�̸�");
		nameLabel.setBounds(98, 200, 74, 21);
		nameLabel.setForeground(SystemColor.activeCaption);
		add(nameLabel);

		JTextField nameTextField = new JTextField();
		nameTextField.setBounds(202, 200, 96, 21);
		nameTextField.setToolTipText("�̸� �Է�");
		add(nameTextField);
		nameTextField.setColumns(10);

		JLabel nTextLabel = new JLabel("�а�");
		nTextLabel.setBounds(98, 249, 50, 15);
		nTextLabel.setForeground(SystemColor.activeCaption);
		add(nTextLabel);

		JTextField mTextField = new JTextField();
		mTextField.setBounds(202, 246, 96, 21);
		mTextField.setToolTipText("�а� �Է�");
		add(mTextField);
		mTextField.setColumns(10);

		JLabel majorLabel = new JLabel("�й�");
		majorLabel.setBounds(98, 300, 50, 15);
		majorLabel.setForeground(SystemColor.activeCaption);
		add(majorLabel);

		JTextField nTextField = new JTextField();
		nTextField.setBounds(202, 300, 96, 21);
		nTextField.setToolTipText("�й� �Է�");
		add(nTextField);
		nTextField.setColumns(10);

		JButton searchIdButton = new JButton("��й�ȣ ã��");
		searchIdButton.setBounds(354, 287, 112, 40);
		searchIdButton.setToolTipText("��й�ȣ ã��");
		searchIdButton.setBackground(SystemColor.textHighlightText);
		searchIdButton.setBorderPainted(false);
		searchIdButton.setActionCommand("��й�ȣ ã��");

		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SSearchPersonalInfo sSearchPersonalInfo = new SSearchPersonalInfo();
				VPersonalInfo vPersonalInfo = sSearchPersonalInfo.searchPw(idTextField.getText(), nameTextField.getText(), 
						mTextField.getText(), nTextField.getText());
				if(vPersonalInfo==null) {
					JOptionPane.showMessageDialog(null, "�ش� ������ �����ϴ�.");
				}
				else {
					JOptionPane.showMessageDialog(null, "��й�ȣ��" + vPersonalInfo.password + "�Դϴ�.");
				}
			} 
		};
		searchIdButton.addActionListener(actionListener);
		add(searchIdButton);

		idTextField.registerKeyboardAction(actionListener, "��й�ȣ ã��", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0), JComponent.WHEN_FOCUSED);
		nameTextField.registerKeyboardAction(actionListener, "��й�ȣ ã��", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0), JComponent.WHEN_FOCUSED);
		mTextField.registerKeyboardAction(actionListener, "��й�ȣ ã��", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0), JComponent.WHEN_FOCUSED);
		nTextField.registerKeyboardAction(actionListener, "��й�ȣ ã��", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0), JComponent.WHEN_FOCUSED);

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
		outButton.setBounds(500, 287, 112, 40);
		add(outButton);
	}

}
