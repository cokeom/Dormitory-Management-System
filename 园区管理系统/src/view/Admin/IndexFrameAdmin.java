package view.Admin;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Admin;
import model.UserType;
import view.Canteen.ListCanteenFrame;
import view.Canteen.UpdateDishFrame;
import view.Canteen.UpdateCanNameFrame;
import view.Canteen.UpdateSeatFrame;
import view.DorManage.ListRoomFrame;
import view.DorManage.ListRoomStuFrame;
import view.DorManage.WaterFee;
import view.Pbuilding.ListPbuildingFrame;
import view.Pbuilding.UpdatePdNameFrame;
import view.StudentInfor.AddStudentFrame;
import view.StudentInfor.DelStudentFrame;
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

public class IndexFrameAdmin extends JFrame {

	private JPanel contentPane;
	public static JDesktopPane desktopPane;
	
	/**
	 * Launch the application.
	 */
	private RevisePasswordAdmin revisePassword = null;
	private DelStudentFrame delStudentFrame = null;
	public static AddStudentFrame addStudentFrame = null;
	public static ListStudentFrame listStudentFrame = null;
	public static ListRoomFrame listRoomFrame =null;
	private WaterFee waterFee=null;
	public static ListRoomStuFrame listRoomStuFrame=null;
	private UpdatePdNameFrame updatePdNameFrame = null;	
	public static ListPbuildingFrame listPbuildingFrame = null;	
	private UpdateCanNameFrame updateCanNameFrame = null;
	private UpdateDishFrame updateDishFrame = null;
	private UpdateSeatFrame updateSeatFrame = null;
	public static ListCanteenFrame listCanteenFrame = null;
	public static UserType userType;
	public static Admin admin;

	/**
	 * Create the frame.
	 */
	public IndexFrameAdmin(UserType userType,Admin admin) {
		
		this.userType = userType;
		this.admin = admin;
		setTitle("园区管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 966, 702);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("系统管理");
		mnNewMenu.setIcon(new ImageIcon(IndexFrameAdmin.class.getResource("/image/系统管理.png")));
		mnNewMenu.setFont(new Font("微软雅黑", Font.BOLD, 15));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("修改密码");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				revisePassword(ae);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(IndexFrameAdmin.class.getResource("/image/修改密码.png")));
		mntmNewMenuItem.setFont(new Font("微软雅黑", Font.BOLD, 15));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("退出系统");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon(IndexFrameAdmin.class.getResource("/image/退出.png")));
		mntmNewMenuItem_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		//---学生---
		JMenu mnNewMenu_1 = new JMenu("人员管理");
		mnNewMenu_1.setIcon(new ImageIcon(IndexFrameAdmin.class.getResource("/image/管理.png")));
		mnNewMenu_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("增加人员");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				addStudent(ae);
			}
		});
		mntmNewMenuItem_2.setIcon(new ImageIcon(IndexFrameAdmin.class.getResource("/image/增加人员.png")));
		mntmNewMenuItem_2.setFont(new Font("微软雅黑", Font.BOLD, 15));
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_1_1 = new JMenuItem("删除人员");
		mntmNewMenuItem_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				deleteStudent(ae);
			}
		});
		mntmNewMenuItem_1_1.setIcon(new ImageIcon(IndexFrameAdmin.class.getResource("/image/删除人员.png")));
		mntmNewMenuItem_1_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
		mnNewMenu_1.add(mntmNewMenuItem_1_1);
		
		JMenuItem mntmNewMenuItem_1_1_1 = new JMenuItem("查看人员");
		mntmNewMenuItem_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listStudent(e);
			}
		});
		mntmNewMenuItem_1_1_1.setIcon(new ImageIcon(IndexFrameAdmin.class.getResource("/image/查看人员.png")));
		mntmNewMenuItem_1_1_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
		mnNewMenu_1.add(mntmNewMenuItem_1_1_1);
		
		//---宿舍---
		JMenu mnNewMenu_1_1 = new JMenu("宿舍管理");
		mnNewMenu_1_1.setIcon(new ImageIcon(IndexFrameAdmin.class.getResource("/image/床.png")));
		mnNewMenu_1_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
		menuBar.add(mnNewMenu_1_1);
		
		JMenuItem mntmNewMenuItem_2_1 = new JMenuItem("电费管理");
		mntmNewMenuItem_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				manageWater(ae);
			}
		});
		mntmNewMenuItem_2_1.setIcon(new ImageIcon(IndexFrameAdmin.class.getResource("/image/水费 (1).png")));
		mntmNewMenuItem_2_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
		mnNewMenu_1_1.add(mntmNewMenuItem_2_1);
		
		JMenuItem mntmNewMenuItem_1_1_1_1 = new JMenuItem("查看人员信息");
		mntmNewMenuItem_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentList(e);
			}
		});
		mntmNewMenuItem_1_1_1_1.setIcon(new ImageIcon(IndexFrameAdmin.class.getResource("/image/查看.png")));
		mntmNewMenuItem_1_1_1_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
		mnNewMenu_1_1.add(mntmNewMenuItem_1_1_1_1);
		
		JMenuItem mntmNewMenuItem_1_1_1_1_3 = new JMenuItem("查看宿舍信息");
		mntmNewMenuItem_1_1_1_1_3.setIcon(new ImageIcon(IndexFrameAdmin.class.getResource("/image/宿舍.png")));
		mntmNewMenuItem_1_1_1_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RoomList(e);
			}
		});
		mntmNewMenuItem_1_1_1_1_3.setFont(new Font("微软雅黑", Font.BOLD, 15));
		mnNewMenu_1_1.add(mntmNewMenuItem_1_1_1_1_3);
		
		//---楼栋---
		JMenu mnNewMenu_1_1_1 = new JMenu("楼栋管理");
		mnNewMenu_1_1_1.setIcon(new ImageIcon(IndexFrameAdmin.class.getResource("/image/楼房.png")));
		mnNewMenu_1_1_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
		menuBar.add(mnNewMenu_1_1_1);
		
		JMenuItem mntmNewMenuItem_2_1_1 = new JMenuItem("修改名称");
		mntmNewMenuItem_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePbuildingName(e);
			}
		});			
		mntmNewMenuItem_2_1_1.setIcon(new ImageIcon(IndexFrameAdmin.class.getResource("/image/修改名称.png")));
		mntmNewMenuItem_2_1_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
		mnNewMenu_1_1_1.add(mntmNewMenuItem_2_1_1);
		
		JMenuItem mntmNewMenuItem_1_1_1_1_1 = new JMenuItem("查看信息");
		mntmNewMenuItem_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listPbuilding(e);
			}
		});		
		mntmNewMenuItem_1_1_1_1_1.setIcon(new ImageIcon(IndexFrameAdmin.class.getResource("/image/查看.png")));
		mntmNewMenuItem_1_1_1_1_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
		mnNewMenu_1_1_1.add(mntmNewMenuItem_1_1_1_1_1);
		//---食堂---
		JMenu mnNewMenu_1_1_2 = new JMenu("食堂管理");
		mnNewMenu_1_1_2.setIcon(new ImageIcon(IndexFrameAdmin.class.getResource("/image/食堂.png")));
		mnNewMenu_1_1_2.setFont(new Font("微软雅黑", Font.BOLD, 15));
		menuBar.add(mnNewMenu_1_1_2);
		
		JMenuItem mntmNewMenuItem_2_1_2 = new JMenuItem("修改名字");
		mntmNewMenuItem_2_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateCanteenName(e);
			}
		});
		mntmNewMenuItem_2_1_2.setIcon(new ImageIcon(IndexFrameAdmin.class.getResource("/image/修改名称.png")));
		mntmNewMenuItem_2_1_2.setFont(new Font("微软雅黑", Font.BOLD, 15));
		mnNewMenu_1_1_2.add(mntmNewMenuItem_2_1_2);
		
		JMenuItem mntmNewMenuItem_1_1_2_2 = new JMenuItem("修改特色菜");
		mntmNewMenuItem_1_1_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateDishName(e);
			}
		});
		mntmNewMenuItem_1_1_2_2.setIcon(new ImageIcon(IndexFrameAdmin.class.getResource("/image/菜.png")));
		mntmNewMenuItem_1_1_2_2.setFont(new Font("微软雅黑", Font.BOLD, 15));
		mnNewMenu_1_1_2.add(mntmNewMenuItem_1_1_2_2);
		
		JMenuItem mntmNewMenuItem_1_1_1_1_2 = new JMenuItem("修改座位数");
		mntmNewMenuItem_1_1_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateSeatName(e);
			}
		});
		mntmNewMenuItem_1_1_1_1_2.setIcon(new ImageIcon(IndexFrameAdmin.class.getResource("/image/座位.png")));
		mntmNewMenuItem_1_1_1_1_2.setFont(new Font("微软雅黑", Font.BOLD, 15));
		mnNewMenu_1_1_2.add(mntmNewMenuItem_1_1_1_1_2);
		
		JMenuItem mntmNewMenuItem_1_1_1_1_2_1 = new JMenuItem("查看信息");
		mntmNewMenuItem_1_1_1_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListCanteen(e);
			}
		});		
		mntmNewMenuItem_1_1_1_1_2_1.setIcon(new ImageIcon(IndexFrameAdmin.class.getResource("/image/查看.png")));
		mntmNewMenuItem_1_1_1_1_2_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
		mnNewMenu_1_1_2.add(mntmNewMenuItem_1_1_1_1_2_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
	    desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		contentPane.add(desktopPane, BorderLayout.CENTER);
	}


	protected void revisePassword(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(revisePassword == null)
			{
			revisePassword = new RevisePasswordAdmin();
			desktopPane.add(revisePassword);
		}
		revisePassword.setVisible(true);
	}



	
	//学生
	protected void listStudent(ActionEvent e) {
		// TODO Auto-generated method stub
		if(listStudentFrame == null) {
			listStudentFrame = new ListStudentFrame();		
			desktopPane.add(listStudentFrame);
		}
		listStudentFrame.setVisible(true);
	}



	protected void deleteStudent(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(delStudentFrame == null) {
			delStudentFrame = new DelStudentFrame();
			desktopPane.add(delStudentFrame);
		}
		delStudentFrame.setVisible(true);
	}

	protected void addStudent(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(addStudentFrame == null) {
			addStudentFrame = new AddStudentFrame();		
			desktopPane.add(addStudentFrame);
		}
		addStudentFrame.setVisible(true);
	}
	//宿舍
	
	protected void RoomList(ActionEvent e) {
		// TODO Auto-generated method stub
		if(listRoomFrame == null) {
			listRoomFrame = new ListRoomFrame();		
			desktopPane.add(listRoomFrame);
		}
		listRoomFrame.setVisible(true);
	}
	
	protected void StudentList(ActionEvent e) {
		// TODO Auto-generated method stub
		if(listRoomStuFrame==null) {
			listRoomStuFrame = new ListRoomStuFrame();
			
			desktopPane.add(listRoomStuFrame);
		}
		listRoomStuFrame.setVisible(true);
	}

	protected void manageWater(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(waterFee == null) {
			waterFee = new WaterFee();
			
			desktopPane.add(waterFee);
		}
		waterFee.setVisible(true);
	}

	//楼栋
	protected void updatePbuildingName(ActionEvent e) {
		// TODO Auto-generated method stub
		if(updatePdNameFrame == null)
		{
			updatePdNameFrame = new UpdatePdNameFrame();
		desktopPane.add(updatePdNameFrame);
		}
		updatePdNameFrame.setVisible(true);			
	}
	protected void listPbuilding(ActionEvent e) {
		// TODO Auto-generated method stub
		if(listPbuildingFrame == null)
		{
			listPbuildingFrame = new ListPbuildingFrame();
		desktopPane.add(listPbuildingFrame);
		}
		listPbuildingFrame.setVisible(true);		
	}
	
	//食堂
	protected void updateCanteenName(ActionEvent e) {
		// TODO Auto-generated method stub
		if(updateCanNameFrame == null)
		{
			updateCanNameFrame = new UpdateCanNameFrame();
		desktopPane.add(updateCanNameFrame);
		}
		updateCanNameFrame.setVisible(true);		
	}
	protected void updateDishName(ActionEvent e) {
		// TODO Auto-generated method stub
		if(updateDishFrame == null)
		{
			updateDishFrame = new UpdateDishFrame();
		desktopPane.add(updateDishFrame);
		}
		updateDishFrame.setVisible(true);		
	}
	protected void updateSeatName(ActionEvent e) {
		// TODO Auto-generated method stub
		if(updateSeatFrame == null)
		{
			updateSeatFrame = new UpdateSeatFrame();
		desktopPane.add(updateSeatFrame);
		}
		updateSeatFrame.setVisible(true);		
	}
	protected void ListCanteen(ActionEvent e) {
		// TODO Auto-generated method stub
		if(listCanteenFrame == null)
		{
			listCanteenFrame = new ListCanteenFrame();
		desktopPane.add(listCanteenFrame);
		}
		listCanteenFrame.setVisible(true);		
	}

}
