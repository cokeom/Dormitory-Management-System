package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Admin;
import model.UserType;
import view.systemManage.RevisePassword;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IndexFrame extends JFrame {

	private JPanel contentPane;
	JDesktopPane desktopPane;
	
	/**
	 * Launch the application.
	 */
	private RevisePassword revisePassword = null;
	public static UserType userType;
	public static Admin admin;

	/**
	 * Create the frame.
	 */
	public IndexFrame(UserType userType,Admin admin) {
		
		this.userType = userType;
		this.admin = admin;
		setTitle("园区管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 966, 702);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("系统管理");
		mnNewMenu.setIcon(new ImageIcon(IndexFrame.class.getResource("/image/系统管理.png")));
		mnNewMenu.setFont(new Font("微软雅黑", Font.BOLD, 15));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("修改密码");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				revisePassword(ae);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(IndexFrame.class.getResource("/image/修改密码.png")));
		mntmNewMenuItem.setFont(new Font("微软雅黑", Font.BOLD, 15));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("退出系统");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon(IndexFrame.class.getResource("/image/退出.png")));
		mntmNewMenuItem_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
		mnNewMenu.add(mntmNewMenuItem_1);
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
			revisePassword = new RevisePassword();
			desktopPane.add(revisePassword);
		}
		//revisePassword.setBounds(1000-revisePassword.getWidth()/2,(700-revisePassword.getHeight())/2,450,300);
		revisePassword.setVisible(true);
	}

}
