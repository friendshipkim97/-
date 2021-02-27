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

public class PSearchId extends JPanel {

	public PSearchId() {
		setBackground(Color.white);
		setBounds(100, 100, 500, 500);
		setFont(new Font("궁서", Font.BOLD, 14));
		setForeground(SystemColor.activeCaption);
		setLayout(null);

		JLabel label = new JLabel("아이디 찾기");
		label.setBounds(147, 49, 130, 50);
		label.setFont(new Font("궁서", Font.BOLD, 14));
		add(label);


		JLabel nameLabel = new JLabel("이름");
		nameLabel.setBounds(98, 200, 74, 21);
		nameLabel.setForeground(SystemColor.activeCaption);
		add(nameLabel);

		JTextField nameTextField = new JTextField();
		nameTextField.setBounds(202, 200, 96, 21);
		nameTextField.setToolTipText("이름입력");
		add(nameTextField);
		nameTextField.setColumns(10);

		JLabel nTextLabel = new JLabel("학과");
		nTextLabel.setBounds(98, 249, 50, 15);
		nTextLabel.setForeground(SystemColor.activeCaption);
		add(nTextLabel);

		JTextField mTextField = new JTextField();
		mTextField.setBounds(202, 246, 96, 21);
		mTextField.setToolTipText("학과입력");
		add(mTextField);
		mTextField.setColumns(10);

		JLabel majorLabel = new JLabel("학번");
		majorLabel.setBounds(98, 300, 50, 15);
		majorLabel.setForeground(SystemColor.activeCaption);
		add(majorLabel);

		JTextField nTextField = new JTextField();
		nTextField.setBounds(202, 300, 96, 21);
		nTextField.setToolTipText("학번입력");
		add(nTextField);
		nTextField.setColumns(10);

		JButton searchIdButton = new JButton("아이디 찾기");
		searchIdButton.setBounds(354, 287, 112, 40);
		searchIdButton.setBackground(SystemColor.textHighlightText);
		searchIdButton.setActionCommand("아이디 찾기"); 
		searchIdButton.setToolTipText("아이디 찾기");
		searchIdButton.setBorderPainted(false);

		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SSearchPersonalInfo sSearchPersonalInfo = new SSearchPersonalInfo();
				VPersonalInfo vPersonalInfo = sSearchPersonalInfo.searchId(nameTextField.getText(), mTextField.getText(), nTextField.getText());
				if(vPersonalInfo==null) {
					JOptionPane.showMessageDialog(null, "해당하는 아이디가 없습니다.");
				}
				else {
					JOptionPane.showMessageDialog(null, "아이디는" + vPersonalInfo.id + "입니다.");
				}
			}
		};


		searchIdButton.addActionListener(actionListener);
		add(searchIdButton);

		nameTextField.registerKeyboardAction(actionListener, "아이디 찾기", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0), JComponent.WHEN_FOCUSED);
		mTextField.registerKeyboardAction(actionListener, "아이디 찾기", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0), JComponent.WHEN_FOCUSED);
		nTextField.registerKeyboardAction(actionListener, "아이디 찾기", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0), JComponent.WHEN_FOCUSED);

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
		outButton.setBounds(500, 287, 112, 40);
		add(outButton);
	}

}
