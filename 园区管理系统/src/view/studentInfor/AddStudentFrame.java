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
import model.StudentRoom;
import view.Admin.IndexFrameAdmin;

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
	private StudentInfo tempStudent = null;
	private StudentRoom tempSR = null;

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
				if(tempStudent==null)resetButton();
				else resetEditButton();
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
		String buildingname = this.buildingname.getText();
		if("".equals(username)||username==null) {
			JOptionPane.showMessageDialog(this, "请输入学号");
			return;
		}
		if("".equals(buildingname)||buildingname==null) {
			JOptionPane.showMessageDialog(this, "请输入楼栋名");
			return;
		}
		if("".equals(this.housenumber.getText())||this.housenumber.getText()==null) {
			JOptionPane.showMessageDialog(this, "请输入门牌号");
			return;
		}
		String name = this.name.getText();
		String grade = this.grade.getText();
		String academy = this.academy.getText();
		String sex = this.sex.getText();
		String telephone = this.telephone.getText();
		String major = this.major.getText();
		Integer age;
		Integer housenumber = Integer.parseInt(this.housenumber.getText());
		if("".equals(this.age.getText())||this.age.getText()==null) {
			 age = null;
		}else {
			 age = Integer.parseInt(this.age.getText());
		}
		
		StudentInfo tempStudent = new StudentInfo(username,name,grade,academy,major,sex,age,telephone);
		StudentRoom tempSR = new StudentRoom(housenumber,buildingname,username);	
		StudentInfoDao studentinfodao = new StudentInfoDao();
		if(this.tempStudent ==null)
		{
			JOptionPane.showMessageDialog(this, studentinfodao.addStudentInfo(tempStudent,tempSR));
			setVisible(false);
		}
		else {
			JOptionPane.showMessageDialog(this, studentinfodao.editStuInfo(tempStudent,tempSR));
			setVisible(false);
		}
			
		if(IndexFrameAdmin.listStudentFrame != null) {
			IndexFrameAdmin.listStudentFrame.queryAllStu();
		}
	}

	protected void resetButton() {
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
		this.tempStudent = null;
	}
	protected void resetEditButton() {
		this.username.setText(this.tempStudent.getUsername());
		this.name.setText(this.tempStudent.getName());
		this.grade.setText(this.tempStudent.getGrade());
		this.academy.setText(this.tempStudent.getAcademy());
		this.sex.setText(this.tempStudent.getSex());
		this.age.setText(this.tempStudent.getAge().toString());
		this.major.setText(this.tempStudent.getMajor());
		this.telephone.setText(this.tempStudent.getTelephone());
		
		this.buildingname.setText(this.tempSR.getBuildingname());
		Integer hn = (Integer)this.tempSR.getRoomnumber();
		this.housenumber.setText(hn.toString());
		
	}
	public void editStudentInfo(StudentInfo tempStu,StudentRoom SR) {
		setTitle("正在编辑学生信息......");
		this.tempStudent = tempStu;
		this.tempSR = SR;
		this.username.setText(tempStu.getUsername());
		this.name.setText(tempStu.getName());
		this.grade.setText(tempStu.getGrade());
		this.academy.setText(tempStu.getAcademy());
		this.major.setText(tempStu.getMajor());
		this.age.setText(tempStu.getAge().toString());
		this.telephone.setText(tempStu.getTelephone());
		this.sex.setText(tempStu.getSex());
		
		this.buildingname.setText(SR.getBuildingname());
		Integer housenumber = (Integer)SR.getRoomnumber();
		this.housenumber.setText(housenumber.toString());
		
		
	}
	public void doDefaultCloseAction() {
		setVisible(false);
		resetButton();
	}
}
