package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import valueObject.VPersonalInfo;

public class PDetailed extends JFrame implements MouseListener{

	private static final long serialVersionUID = 1L;
	DefaultTableModel defaultTableModel;
	Vector<String> colName;
	Vector<String> list;
	Vector<String> tempVector;
	JPanel tablePanel;
	JTable jTable;
	String tempLecture;
	PGangjwaSeonTaek pGangjwaSeonTaek;
	boolean check = false;

	public PDetailed(Vector<String> VectorLecture, Vector<String> getSelectedLecture, VPersonalInfo vPersonalInfo) {
		JFrame jFrame = new JFrame();
		tablePanel = new JPanel();
		jFrame.add(tablePanel);
		tempVector = new Vector<String>();
		tempVector = VectorLecture;
		pGangjwaSeonTaek = new PGangjwaSeonTaek();
		//JScrollPane jScrollPane = new JScrollPane();

		this.setTitle("자세히 보기");
		tablePanel.setBackground(Color.white);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setLayout(null);
		setBounds(100, 100, 919, 520);

		colName = new Vector<String>();
		colName.add("강좌번호");
		colName.add("강의이름");
		colName.add("교수이름");
		colName.add("학점");
		colName.add("시간");

		defaultTableModel = new DefaultTableModel(colName, 0) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		for(int i=0; i<VectorLecture.size(); i++) {
			list = new Vector<String>();
			String a = VectorLecture.get(i);
			String[] str = a.split("\\s+");
			for(int j=0; j<str.length; j++) {
				String temp = str[j];
				list.add(temp);

			}
			defaultTableModel.addRow(list);
		}
		jTable = new JTable(defaultTableModel);

		DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcmSchedule = jTable.getColumnModel();
		for (int a = 0; a < tcmSchedule.getColumnCount(); a++) {
			tcmSchedule.getColumn(a).setCellRenderer(tScheduleCellRenderer); //가운데 정렬
		}



		JTableHeader header = jTable.getTableHeader();
		header.setFont(new Font("궁서", Font.BOLD, 11));
		header.setBackground(Color.white);
		header.setForeground(Color.BLUE);

		jTable.setPreferredScrollableViewportSize(new Dimension(600, 300));
		jTable.setBackground(Color.white);
		jTable.setForeground(Color.GRAY);
		jTable.setRowHeight(30);
		jTable.setAutoCreateRowSorter(true);
		jTable.getTableHeader().setReorderingAllowed(false);// 이동 불가
		jTable.getTableHeader().setResizingAllowed(false); // 크기 조절 불가
		jTable.setRowSelectionAllowed(true);
		jTable.addMouseListener(this);


		tablePanel.add (new JScrollPane(jTable) , BorderLayout.CENTER ); 
		this.setContentPane(tablePanel);
		tablePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

		JButton lectureButton = new JButton("수강신청");
		lectureButton.setBackground(SystemColor.textHighlightText);
		lectureButton.setToolTipText("수강신청");
		lectureButton.setBorderPainted(false);
		lectureButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				pGangjwaSeonTaek.setSelectedLecture(getSelectedLecture);
				pGangjwaSeonTaek.selectedLecture(vPersonalInfo);
			}});

		lectureButton.setBounds(721, 500, 91, 23);
		getContentPane().add(lectureButton);

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

		setVisible(true);
	}


	public void mouseClicked(MouseEvent e) {

		int temp = jTable.getSelectedRow();
		check=true;
		if(temp>=0&&check==true) { 
			pGangjwaSeonTaek.setTempLecture(tempVector.get(temp));

		}

	}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {	}
	public void mouseEntered(MouseEvent e) {		}
	public void mouseExited(MouseEvent e) {	}

}
