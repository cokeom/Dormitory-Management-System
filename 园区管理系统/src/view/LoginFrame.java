package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.AdminDao;
import dao.StudentDao;
import model.Admin;
import model.Student;
import model.UserType;
import view.Admin.IndexFrameAdmin;
import view.Pbuilding.UpdatePdNameFrame;
import view.Student.IndexFrameStudent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField adminName;
	private JPasswordField adminPsd;
	private JComboBox adminTypeComb;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public LoginFrame() {
		setTitle("园区管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("园区管理系统");
		lblNewLabel.setFont(new Font("΢���ź� Light", Font.BOLD, 30));
		lblNewLabel.setBounds(117, 0, 199, 60);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("用户名");
		lblNewLabel_1.setIcon(new ImageIcon(LoginFrame.class.getResource("/image/\u7528\u6237\u540D.png")));
		lblNewLabel_1.setBounds(66, 70, 58, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("密码");
		lblNewLabel_2.setIcon(new ImageIcon(LoginFrame.class.getResource("/image/\u5BC6\u78012.png")));
		lblNewLabel_2.setBounds(66, 111, 58, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("用户类型");
		lblNewLabel_3.setIcon(new ImageIcon(LoginFrame.class.getResource("/image/\u7528\u6237\u7C7B\u578B_\u753B\u677F 1.png")));
		lblNewLabel_3.setBounds(66, 153, 85, 15);
		contentPane.add(lblNewLabel_3);
		
		adminName = new JTextField();
		adminName.setBounds(193, 67, 131, 21);
		contentPane.add(adminName);
		adminName.setColumns(10);
		
		adminTypeComb = new JComboBox();
		adminTypeComb.setModel(new DefaultComboBoxModel(new UserType [] {UserType.ADMIN,UserType.STUDENT}));
		adminTypeComb.setBounds(193, 149, 131, 23);
		contentPane.add(adminTypeComb);
		
		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.setIcon(new ImageIcon(LoginFrame.class.getResource("/image/重置 (1).png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetButton(ae);
			}
		});
		btnNewButton_1.setBounds(49, 230, 97, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("登录");
		btnNewButton_2.setIcon(new ImageIcon(LoginFrame.class.getResource("/image/登录.png")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				confirmButton(ae);
			}
		});
		btnNewButton_2.setBounds(173, 230, 97, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("取消");
		btnNewButton_3.setIcon(new ImageIcon(LoginFrame.class.getResource("/image/取消.png")));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_3.setBounds(299, 230, 97, 23);
		contentPane.add(btnNewButton_3);
		
		btnNewButton_1.setFocusable(false);
		btnNewButton_2.setFocusable(false);
		btnNewButton_3.setFocusable(false);
		
		adminPsd = new JPasswordField();
		adminPsd.setBounds(191, 108, 133, 21);
		contentPane.add(adminPsd);
	}

	protected void confirmButton(ActionEvent ae) {
		// TODO Auto-generated method stub
		String name1 = this.adminName.getText();
		String password1 = this.adminPsd.getText();
		System.out.println(name1);
		System.out.println(password1);
		UserType userType = (UserType)this.adminTypeComb.getSelectedItem();
		
		if("管理员".equals(userType.getName())) {
			AdminDao adminDao = new AdminDao();
			Admin admin = adminDao.selectAdmin(name1, password1);
			
			//System.out.println(admin);
			if (admin == null) {
				JOptionPane.showMessageDialog(this, "用户名或密码错误");
				return;
			}
			IndexFrameAdmin indexFrame = new IndexFrameAdmin(userType,admin);
			indexFrame.setVisible(true);
			this.dispose();
		}else {
			StudentDao studentDao = new StudentDao();
			Student student = studentDao.selectStudent(name1, password1);
			
			//System.out.println(student);
			if (student == null) {
				JOptionPane.showMessageDialog(this, "用户名或密码错误");
				return;
			}
			IndexFrameStudent indexFrame = new IndexFrameStudent(userType,student);
			indexFrame.setVisible(true);
			this.dispose();			
		}
	}

	protected void resetButton(ActionEvent ae) {
		// TODO Auto-generated method stub
		this.adminName.setText("");
		this.adminPsd.setText("");
		this.adminTypeComb.setSelectedIndex(0);
	}
}
