package view.systemManage;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

import dao.AdminDao;
import view.IndexFrameAdmin;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class RevisePassword extends JInternalFrame {
	private JTextField oldPasswordText;
	private JTextField newPasswordText;
	private JTextField againPasswordText;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public RevisePassword() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		setClosable (true);
		JLabel lblNewLabel = new JLabel("当前用户");
		lblNewLabel.setIcon(new ImageIcon(RevisePassword.class.getResource("/image/用户.png")));
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
		lblNewLabel.setBounds(59, 38, 105, 20);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("旧密码");
		lblNewLabel_1.setIcon(new ImageIcon(RevisePassword.class.getResource("/image/密码.png")));
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
		lblNewLabel_1.setBounds(59, 88, 105, 20);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("新密码");
		lblNewLabel_2.setIcon(new ImageIcon(RevisePassword.class.getResource("/image/密码2.png")));
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 15));
		lblNewLabel_2.setBounds(59, 129, 75, 20);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("确认密码");
		lblNewLabel_3.setIcon(new ImageIcon(RevisePassword.class.getResource("/image/密码2.png")));
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.BOLD, 15));
		lblNewLabel_3.setBounds(59, 171, 91, 20);
		getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("确认");
		btnNewButton.setIcon(new ImageIcon(RevisePassword.class.getResource("/image/确认-充值成功.png")));
		btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				confirmButton(ae);
			}
		});
		btnNewButton.setBounds(67, 238, 97, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.setIcon(new ImageIcon(RevisePassword.class.getResource("/image/重置.png")));
		btnNewButton_1.setFont(new Font("微软雅黑", Font.BOLD, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetButton();
			}
		});
		btnNewButton_1.setBounds(234, 238, 97, 23);
		getContentPane().add(btnNewButton_1);
		
		oldPasswordText = new JTextField();
		oldPasswordText.setBounds(160, 90, 141, 21);
		getContentPane().add(oldPasswordText);
		oldPasswordText.setColumns(10);
		
		newPasswordText = new JTextField();
		newPasswordText.setColumns(10);
		newPasswordText.setBounds(160, 131, 141, 21);
		getContentPane().add(newPasswordText);
		
		againPasswordText = new JTextField();
		againPasswordText.setColumns(10);
		againPasswordText.setBounds(160, 173, 141, 21);
		getContentPane().add(againPasswordText);
		
		String userTypeStr = IndexFrameAdmin.userType.getName();
		String adminNameStr = IndexFrameAdmin.admin.getName();
		JLabel lblNewLabel_4 = new JLabel("【"+userTypeStr+"】"+adminNameStr);
		lblNewLabel_4.setBounds(160, 40, 141, 20);
		getContentPane().add(lblNewLabel_4);

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
		if("管理员".equals(IndexFrameAdmin.userType.getName())) {
			AdminDao adminDao = new AdminDao();
			JOptionPane.showMessageDialog(this, adminDao.revisePassword(IndexFrameAdmin.admin, newPassword));
			this.oldPasswordText.setText("");
			this.newPasswordText.setText("");
			this.againPasswordText.setText("");
			setVisible(false);
			return;
		}
		if("学生".equals(IndexFrameAdmin.userType.getName())) {
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
