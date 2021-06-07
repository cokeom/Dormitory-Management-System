package view.studentInfor;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import dao.StudentInfoDao;
import model.Room;
import model.StudentInfo;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	 * Create the frame.
	 */
	public AddStudentFrame() {
		setTitle("增加学生");
		setBounds(100, 100, 647, 408);
		getContentPane().setLayout(null);
		setClosable (true);
		setIconifiable(true);
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				addStudentButton(ae);
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 13));
		btnNewButton.setBounds(314, 330, 97, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetButton(ae);
			}
		});
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

	protected void addStudentButton(ActionEvent ae) {
		// TODO Auto-generated method stub
		String username = this.username.getText();
		String name = this.name.getText();
		String grade = this.grade.getText();
		String academy = this.academy.getText();
		String sex = this.sex.getText();
		String buildingname = this.buildingname.getText();
		int housenumber = Integer.parseInt(this.housenumber.getText());
		int age = Integer.parseInt(this.age.getText());
		String telephone = this.telephone.getText();
		String major = this.major.getText();
		
		
		StudentInfo tempStudent = new StudentInfo(username,name,grade,academy,major,sex,age,telephone);
		Room tempRoom = new Room(buildingname,housenumber,1,1,1);
		
		
		StudentInfoDao studentinfodao = new StudentInfoDao();
		JOptionPane.showMessageDialog(this, studentinfodao.addStudentInfo(tempStudent, tempRoom));
	}

	protected void resetButton(ActionEvent ae) {
		// TODO Auto-generated method stub
		this.username.setText("");
		this.name.setText("");
		this.grade.setText("");
		this.academy.setText("");
		this.sex.setText("");
		this.buildingname.setText("");
		this.housenumber.setText("");
		this.age.setText("");
		this.telephone.setText("");
		this.major.setText("");
	}
}
