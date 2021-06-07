package view.studentInfor;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AddStudentFrame extends JInternalFrame {
	private JTextField username;
	private JTextField name;
	private JTextField grade;
	private JTextField academy;
	private JTextField sex;
	private JTextField buildingname;
	private JTextField age;
	private JTextField telephone;
	private JTextField major;
	private JTextField housenumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudentFrame frame = new AddStudentFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddStudentFrame() {
		setTitle("增加学生");
		setBounds(100, 100, 647, 408);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("楼栋名*");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 13));
		lblNewLabel.setBounds(23, 281, 58, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("学号*");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 13));
		lblNewLabel_1.setBounds(23, 55, 58, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("姓名");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 13));
		lblNewLabel_2.setBounds(353, 55, 58, 15);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("年级");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.BOLD, 13));
		lblNewLabel_3.setBounds(23, 112, 58, 15);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("学院");
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.BOLD, 13));
		lblNewLabel_4.setBounds(23, 163, 58, 15);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("专业");
		lblNewLabel_5.setFont(new Font("微软雅黑", Font.BOLD, 13));
		lblNewLabel_5.setBounds(353, 220, 58, 15);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("性别");
		lblNewLabel_6.setFont(new Font("微软雅黑", Font.BOLD, 13));
		lblNewLabel_6.setBounds(23, 220, 58, 15);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("年龄");
		lblNewLabel_7.setFont(new Font("微软雅黑", Font.BOLD, 13));
		lblNewLabel_7.setBounds(353, 113, 58, 15);
		getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("电话号码");
		lblNewLabel_8.setFont(new Font("微软雅黑", Font.BOLD, 13));
		lblNewLabel_8.setBounds(353, 163, 58, 15);
		getContentPane().add(lblNewLabel_8);
		
		username = new JTextField();
		username.setBounds(77, 53, 156, 21);
		getContentPane().add(username);
		username.setColumns(10);
		
		name = new JTextField();
		name.setBounds(421, 53, 156, 21);
		getContentPane().add(name);
		name.setColumns(10);
		
		grade = new JTextField();
		grade.setColumns(10);
		grade.setBounds(77, 110, 156, 21);
		getContentPane().add(grade);
		
		academy = new JTextField();
		academy.setColumns(10);
		academy.setBounds(77, 161, 156, 21);
		getContentPane().add(academy);
		
		sex = new JTextField();
		sex.setColumns(10);
		sex.setBounds(77, 218, 156, 21);
		getContentPane().add(sex);
		
		buildingname = new JTextField();
		buildingname.setColumns(10);
		buildingname.setBounds(77, 279, 156, 21);
		getContentPane().add(buildingname);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(421, 110, 156, 21);
		getContentPane().add(age);
		
		telephone = new JTextField();
		telephone.setColumns(10);
		telephone.setBounds(421, 161, 156, 21);
		getContentPane().add(telephone);
		
		major = new JTextField();
		major.setColumns(10);
		major.setBounds(421, 218, 156, 21);
		getContentPane().add(major);
		
		JButton btnNewButton = new JButton("确认");
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 13));
		btnNewButton.setBounds(314, 330, 97, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.setFont(new Font("微软雅黑", Font.BOLD, 13));
		btnNewButton_1.setBounds(464, 331, 97, 23);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_9 = new JLabel("门牌名*");
		lblNewLabel_9.setFont(new Font("微软雅黑", Font.BOLD, 13));
		lblNewLabel_9.setBounds(353, 282, 58, 15);
		getContentPane().add(lblNewLabel_9);
		
		housenumber = new JTextField();
		housenumber.setColumns(10);
		housenumber.setBounds(421, 279, 156, 21);
		getContentPane().add(housenumber);

	}
}
