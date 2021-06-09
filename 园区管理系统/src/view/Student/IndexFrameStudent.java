package view.Student;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Student;
import model.UserType;
import view.Canteen.ListCanteenFrame;
import view.DorManage.ListRoomStuFrame;
import view.Pbuilding.ListPbuildingFrame;
import view.Student.RevisePasswordStudent;
import view.StudentInfor.ListStudentFrame;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IndexFrameStudent extends JFrame {

	private JPanel contentPane;
	JDesktopPane desktopPane;
	
	/**
	 * Launch the application.
	 */
	private RevisePasswordStudent revisePassword = null;
	private ListCanteenFrame listCanteen = null;
	private ListRoomStuFrame listRoom = null;
	private ListPbuildingFrame listPbuilding = null;	
	private ListStudentFrame listStudent = null;	
	public static UserType userType;
	public static Student student;

	/**
	 * Create the frame.
	 */
	public IndexFrameStudent(UserType userType,Student student) {
		
		this.userType = userType;
		this.student = student;
		setTitle("园区管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 966, 702);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		//---系统管理---
		JMenu mnNewMenu_2 = new JMenu("系统管理");
		mnNewMenu_2.setIcon(new ImageIcon(IndexFrameStudent.class.getResource("/image/系统管理.png")));
		mnNewMenu_2.setFont(new Font("微软雅黑", Font.BOLD, 15));
		menuBar.add(mnNewMenu_2);
		//修改密码
		JMenuItem mntmNewMenuItem_2_1 = new JMenuItem("修改密码");
		mntmNewMenuItem_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				revisePassword(e);
			}
		});
		mntmNewMenuItem_2_1.setIcon(new ImageIcon(IndexFrameStudent.class.getResource("/image/修改密码.png")));
		mntmNewMenuItem_2_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
		mnNewMenu_2.add(mntmNewMenuItem_2_1);
		//退出系统
		JMenuItem mntmNewMenuItem_2_2 = new JMenuItem("退出系统");
		mntmNewMenuItem_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmNewMenuItem_2_2.setIcon(new ImageIcon(IndexFrameStudent.class.getResource("/image/退出.png")));
		mntmNewMenuItem_2_2.setFont(new Font("微软雅黑", Font.BOLD, 15));
		mnNewMenu_2.add(mntmNewMenuItem_2_2);
		
		//---查询----
		JMenu mnNewMenu_1 = new JMenu("查询功能");
		mnNewMenu_1.setIcon(new ImageIcon(IndexFrameStudent.class.getResource("/image/查询.png")));
		mnNewMenu_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
		menuBar.add(mnNewMenu_1);
		//楼栋信息查询
		JMenuItem mntmNewMenuItem_1_2 = new JMenuItem("楼栋信息查询");
		mntmNewMenuItem_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListPbuilding(e);
			}
		});		
		mntmNewMenuItem_1_2.setIcon(new ImageIcon(IndexFrameStudent.class.getResource("/image/楼栋.png")));
		mntmNewMenuItem_1_2.setFont(new Font("微软雅黑", Font.BOLD, 15));
		mnNewMenu_1.add(mntmNewMenuItem_1_2);
		//食堂信息查询
		JMenuItem mntmNewMenuItem_1_4 = new JMenuItem("食堂信息查询");
		mntmNewMenuItem_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListCanteen(e);
			}
		});		
		mntmNewMenuItem_1_4.setIcon(new ImageIcon(IndexFrameStudent.class.getResource("/image/食堂.png")));
		mntmNewMenuItem_1_4.setFont(new Font("微软雅黑", Font.BOLD, 15));
		mnNewMenu_1.add(mntmNewMenuItem_1_4);
		
		//宿舍信息查询
		JMenuItem mntmNewMenuItem_1_3 = new JMenuItem("宿舍信息查询");
		mntmNewMenuItem_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListRoom(e);
			}
		});	
		mntmNewMenuItem_1_3.setIcon(new ImageIcon(IndexFrameStudent.class.getResource("/image/宿舍.png")));
		mntmNewMenuItem_1_3.setFont(new Font("微软雅黑", Font.BOLD, 15));
		mnNewMenu_1.add(mntmNewMenuItem_1_3);

		//学生信息查询
		JMenuItem mntmNewMenuItem_1_5 = new JMenuItem("学生信息查询");
		mntmNewMenuItem_1_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListStudent(e);
			}
		});
		mntmNewMenuItem_1_5.setIcon(new ImageIcon(IndexFrameStudent.class.getResource("/image/学生.png")));
		mntmNewMenuItem_1_5.setFont(new Font("微软雅黑", Font.BOLD, 15));
		mnNewMenu_1.add(mntmNewMenuItem_1_5);		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
	    desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		

		
	}


	protected void revisePassword(ActionEvent e) {
		// TODO Auto-generated method stub
		if(revisePassword == null)
			{
			revisePassword = new RevisePasswordStudent();
			desktopPane.add(revisePassword);
		}
		revisePassword.setVisible(true);
	}
	
	protected void ListRoom(ActionEvent e) {
		// TODO Auto-generated method stub
		if(listRoom == null)
			{
			listRoom = new ListRoomStuFrame();
			desktopPane.add(listRoom);
		}
		listRoom.setVisible(true);
		
	}
	
	protected void ListPbuilding(ActionEvent e) {
		// TODO Auto-generated method stub
		if(listPbuilding == null)
			{
			listPbuilding = new ListPbuildingFrame();
			desktopPane.add(listPbuilding);
		}
		listPbuilding.setVisible(true);		
	}	
	protected void ListCanteen(ActionEvent e) {
		// TODO Auto-generated method stub
		if(listCanteen == null)
			{
			listCanteen = new ListCanteenFrame();
			desktopPane.add(listCanteen);
		}
		listCanteen.setVisible(true);
		
	}	
	protected void ListStudent(ActionEvent e) {
		// TODO Auto-generated method stub
		if(listStudent== null)
		{
			listStudent = new ListStudentFrame();
		desktopPane.add(listStudent);
		}
		listStudent.setVisible(true);
	}
	
}
