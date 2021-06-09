package view.Canteen;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.CanteenDao;

public class UpdateSeatFrame extends JInternalFrame {
	private JTextField seatNumText;
	private JTextField CnameText;
	/**
	 * Create the frame.
	 */
	public UpdateSeatFrame() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		setClosable (true);

		JLabel lblNewLabel_1 = new JLabel("座位数");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
		lblNewLabel_1.setBounds(53, 88, 97, 20);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("食堂名字");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.BOLD, 15));
		lblNewLabel_2.setBounds(53, 130, 75, 20);
		getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("确认");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				confirmButton(ae);
			}
		});
		btnNewButton.setBounds(169, 225, 97, 23);
		getContentPane().add(btnNewButton);
		
		
		seatNumText = new JTextField();
		seatNumText.setBounds(160, 90, 171, 23);
		getContentPane().add(seatNumText);
		seatNumText.setColumns(10);
		
		CnameText = new JTextField();
		CnameText.setColumns(10);
		CnameText.setBounds(160, 131, 171, 23);
		getContentPane().add(CnameText);
		
		JLabel lblNewLabel = new JLabel("食堂座位数修改");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lblNewLabel.setBounds(169, 27, 127, 20);
		getContentPane().add(lblNewLabel);
		setVisible(true);
	}
	protected void confirmButton(ActionEvent ae) {
		// TODO Auto-generated method stub
		String seatNum = this.seatNumText.getText();
		String Cname = this.CnameText.getText();
		if("".equals(seatNum)||seatNum==null) {
			JOptionPane.showMessageDialog(this, "请输入座位数");
			return;
		}
		if("".equals(Cname)||Cname==null) {
			JOptionPane.showMessageDialog(this, "请输入食堂名字");
			return;
		}
		CanteenDao canteenDao = new CanteenDao();
		JOptionPane.showMessageDialog(this,canteenDao.updateSeatNum(Cname,seatNum));
		setVisible(false);
	}
	public void doDefaultCloseAction() {
		setVisible(false);
	}

}
