package view.Student;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

import dao.StudentDao;
import view.Student.IndexFrameStudent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class RevisePasswordStudent extends JInternalFrame {
	private JPasswordField oldPasswordText;
	private JPasswordField newPasswordText;
	private JPasswordField againPasswordText;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public RevisePasswordStudent() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		setClosable (true);
		JLabel lblNewLabel = new JLabel("当前用户");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
		lblNewLabel.setBounds(75, 38, 75, 20);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("旧密码");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
		lblNewLabel_1.setBounds(75, 88, 75, 20);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("新密码");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 15));
		lblNewLabel_2.setBounds(75, 129, 75, 20);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("确认密码");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.BOLD, 15));
		lblNewLabel_3.setBounds(75, 171, 75, 20);
		getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("确认");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				confirmButton(ae);
			}
		});
		btnNewButton.setBounds(67, 238, 97, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetButton();
			}
		});
		btnNewButton_1.setBounds(234, 238, 97, 23);
		getContentPane().add(btnNewButton_1);
		
		String userTypeStr = IndexFrameStudent.userType.getName();
		String studentNameStr = IndexFrameStudent.student.getName();
		JLabel lblNewLabel_4 = new JLabel("【"+userTypeStr+"】"+studentNameStr);
		lblNewLabel_4.setBounds(160, 40, 141, 20);
		getContentPane().add(lblNewLabel_4);
		
		oldPasswordText = new JPasswordField();
		oldPasswordText.setBounds(160, 90, 141, 23);
		getContentPane().add(oldPasswordText);
		
		newPasswordText = new JPasswordField();
		newPasswordText.setBounds(160, 131, 141, 23);
		getContentPane().add(newPasswordText);
		
		againPasswordText = new JPasswordField();
		againPasswordText.setBounds(160, 173, 141, 23);
		getContentPane().add(againPasswordText);

		setVisible(true);
	}
	protected void confirmButton(ActionEvent ae) {
		// TODO Auto-generated method stub
		String oldPassword =  this.oldPasswordText.getText();
		String newPassword = this.newPasswordText.getText();
		String againPassword = this.againPasswordText.getText();
		if("".equals(oldPassword)||oldPassword==null) {
			JOptionPane.showMessageDialog(this, "请输入密码");
			return;
		}
		if("".equals(newPassword)||newPassword==null) {
			JOptionPane.showMessageDialog(this, "请输入新密码");
			return;
		}
		if("".equals(againPassword)||againPassword==null) {
			JOptionPane.showMessageDialog(this, "请再次输入密码");
			return;
		}
		if("学生".equals(IndexFrameStudent.userType.getName())) {
			StudentDao studentDao = new StudentDao();
			JOptionPane.showMessageDialog(this, studentDao.revisePassword(IndexFrameStudent.student, newPassword));
			this.oldPasswordText.setText("");
			this.newPasswordText.setText("");
			this.againPasswordText.setText("");
			setVisible(false);
			return;
		}
		if("管理员".equals(IndexFrameStudent.userType.getName())) {
			return;
		}
		
	}
	protected void resetButton() {
		// TODO Auto-generated method stub
		this.oldPasswordText.setText("");
		this.newPasswordText.setText("");
		this.againPasswordText.setText("");
	}
	public void doDefaultCloseAction() {
		setVisible(false);
		resetButton();
	}
}
