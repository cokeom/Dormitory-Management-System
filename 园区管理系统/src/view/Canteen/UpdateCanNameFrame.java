package view.Canteen;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import dao.CanteenDao;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class UpdateCanNameFrame extends JInternalFrame {
	private JTextField oldNameText;
	private JTextField newNameText;

	/* Create the frame.
	 */
	public UpdateCanNameFrame() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		setClosable (true);

		JLabel lblNewLabel_1 = new JLabel("旧名字");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
		lblNewLabel_1.setBounds(75, 88, 75, 20);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("新名字");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 15));
		lblNewLabel_2.setBounds(75, 129, 75, 20);
		getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("确认");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				confirmButton(ae);
			}
		});
		btnNewButton.setBounds(169, 225, 97, 23);
		getContentPane().add(btnNewButton);
		
		
		oldNameText = new JTextField();
		oldNameText.setBounds(160, 90, 171, 23);
		getContentPane().add(oldNameText);
		oldNameText.setColumns(10);
		
		newNameText = new JTextField();
		newNameText.setColumns(10);
		newNameText.setBounds(160, 131, 171, 23);
		getContentPane().add(newNameText);
		
		JLabel lblNewLabel = new JLabel("食堂名字修改");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lblNewLabel.setBounds(169, 27, 97, 20);
		getContentPane().add(lblNewLabel);
		setVisible(true);
	}
	protected void confirmButton(ActionEvent ae) {
		// TODO Auto-generated method stub
		String oldName = this.oldNameText.getText();
		String newName = this.newNameText.getText();
		if("".equals(oldName)||oldName==null) {
			JOptionPane.showMessageDialog(this, "请输入旧名字");
			return;
		}
		if("".equals(newName)||newName==null) {
			JOptionPane.showMessageDialog(this, "请输入新名字");
			return;
		}
		CanteenDao canteenDao = new CanteenDao();
		JOptionPane.showMessageDialog(this,canteenDao.updateName(oldName,newName));
		setVisible(false);
	}
	public void doDefaultCloseAction() {
		setVisible(false);
	}
}
