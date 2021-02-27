package presentation;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import valueObject.VPersonalInfo;

public class PMain extends JFrame implements KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField textField_password;
	private JTextField textField_id;

	private PSugangsincheong pSugangsincheong;
	private PPersonalInfo pRegistration;

	JButton loginButton = new JButton("로그인");

	public PMain() throws URISyntaxException{

		this.addWindowListener(windowListener);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 919, 520);
		contentPane = new JPanel();

		this.setTitle("수강신청");
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ImageIcon img = new ImageIcon("data/mju.png");
		this.setIconImage(img.getImage());

		textField_id = new JTextField();
		textField_id.setBounds(637, 264, 96, 21);
		textField_id.setToolTipText("id 입력");
		textField_id.addKeyListener(this);
		contentPane.add(textField_id);
		textField_id.setColumns(10);

		textField_password = new JTextField();
		textField_password.setBounds(637, 295, 96, 21);
		textField_password.setToolTipText("password 입력");
		textField_password.addKeyListener(this);
		contentPane.add(textField_password);
		textField_password.setColumns(10);


		final URI uri = new URI("https://www.mju.ac.kr/sites/mjukr/intro/intro.html");
		class OpenUrlAction implements ActionListener {
			@Override public void actionPerformed(ActionEvent e) {
				open(uri);
			}
		}
		JButton linkButton = new JButton();
		linkButton.setText("<HTML>명지대학교 링크 <FONT color=\"#000099\"><U>link</U></FONT>"
				+ "</HTML>");
		linkButton.setHorizontalAlignment(SwingConstants.LEFT);
		linkButton.setBorderPainted(false);
		linkButton.setOpaque(false);
		linkButton.setBackground(Color.WHITE);
		linkButton.setToolTipText(uri.toString());
		linkButton.addActionListener(new OpenUrlAction());
		linkButton.setBounds(140, 300, 200, 200);
		contentPane.add(linkButton);


		JLabel idLabel = new JLabel("Id");
		idLabel.setBackground(new Color(240, 248, 255));
		idLabel.setBounds(483, 267, 106, 15);
		idLabel.setToolTipText("Id");
		contentPane.add(idLabel);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBackground(new Color(240, 248, 255));
		passwordLabel.setBounds(483, 298, 69, 15);
		passwordLabel.setToolTipText("Password");
		contentPane.add(passwordLabel);

		JButton searchId = new JButton("아이디 찾기");
		searchId.setBackground(new Color(240, 248, 255));
		searchId.setBorderPainted(false);
		searchId.setToolTipText("아이디 찾기");
		searchId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PSearchId pSearchId = new PSearchId();
				contentPane.setVisible(false);
				setContentPane(pSearchId);
			}
		});
		searchId.setBounds(483, 361, 106, 23);
		contentPane.add(searchId);

		JButton searchPW = new JButton("비밀번호 찾기");
		searchPW.setBackground(new Color(240, 248, 255));
		searchPW.setBorderPainted(false);
		searchPW.setToolTipText("비밀번호 찾기");
		searchPW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PSearchPw pSearchPw = new PSearchPw();
				contentPane.setVisible(false);
				setContentPane(pSearchPw);
			}
		});
		searchPW.setBounds(624, 361, 109, 23);
		contentPane.add(searchPW);

		JButton JoinButton = new JButton("회원가입");
		JoinButton.setBackground(new Color(240, 248, 255));
		JoinButton.setBorderPainted(false);
		JoinButton.setToolTipText("회원가입");
		JoinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				pRegistration = new PPersonalInfo();
				contentPane.setVisible(false);
				setContentPane(pRegistration);
			}
		});
		JoinButton.setBounds(760, 361, 91, 23);
		contentPane.add(JoinButton);

		ImageIcon img2 = new ImageIcon("data/mju.png");
		JLabel mjLabel = new JLabel("",img2,JLabel.CENTER);
		mjLabel.setBounds(53, 37, 331, 295);
		contentPane.add(mjLabel);


		loginButton.setBackground(new Color(240, 248, 255));
		loginButton.setForeground(new Color(0, 0, 0));
		loginButton.setBounds(760, 264, 91, 56);
		loginButton.setToolTipText("로그인");
		loginButton.setBorderPainted(false);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PLogin pLogin = new PLogin();
				VPersonalInfo vPersonalInfo = pLogin.show(textField_id.getText(), textField_password.getText());
				if(vPersonalInfo==null) {
					JOptionPane.showMessageDialog(null, "이이디나 비밀번호가 일치하지 않습니다.");
				} else {
					// 로그인 성공 
					JOptionPane.showMessageDialog(null, "로그인 되었습니다.");
					System.out.println(vPersonalInfo.id);
					PGangjwaSeonTaek pGangjwaSeonTaek = new PGangjwaSeonTaek();
					pSugangsincheong = new PSugangsincheong(vPersonalInfo);
					contentPane.setVisible(false);
					setContentPane(pSugangsincheong);
				}
			}
		});
		contentPane.add(loginButton);

	}
	private static void open(URI uri) {
		if (Desktop.isDesktopSupported()) {
			try {
				Desktop.getDesktop().browse(uri);
			} catch (IOException e) { /* TODO: error handling */ }
		} else { /* TODO: error handling */ }
	}


	WindowListener windowListener = new WindowListener() {
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);	
		}

		public void windowClosed(WindowEvent e) {	}
		public void windowOpened(WindowEvent e) {}
		public void windowIconified(WindowEvent e) {}
		public void windowDeiconified(WindowEvent e) {}
		public void windowActivated(WindowEvent e) {	}
		public void windowDeactivated(WindowEvent e) {}

	};

	public void keyPressed(KeyEvent e) {		
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_ENTER) {
			loginButton.doClick();
		}
	}

	public void keyTyped(KeyEvent e) {	}
	public void keyReleased(KeyEvent e) {	}



}


