package view.DorManage;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;

import dao.RoomDao;
import view.Admin.IndexFrameAdmin;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class WaterFee extends JInternalFrame {
	private JTextField Dnumber;
	private JTextField waterFee;
	private JComboBox<String> Bname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WaterFee frame = new WaterFee();
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
	public WaterFee() {
		setTitle("电费提交");
		setBounds(100, 100, 657, 390);
		getContentPane().setLayout(null);
		setClosable (true);
		JLabel lblNewLabel = new JLabel("楼栋名：");
		lblNewLabel.setBounds(61, 41, 58, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("房间号：");
		lblNewLabel_1.setBounds(61, 154, 58, 15);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("提交金额：");
		lblNewLabel_2.setBounds(61, 257, 72, 15);
		getContentPane().add(lblNewLabel_2);
		
		Dnumber = new JTextField();
		Dnumber.setBounds(130, 151, 86, 21);
		getContentPane().add(Dnumber);
		Dnumber.setColumns(10);
		
		waterFee = new JTextField();
		waterFee.setBounds(130, 254, 86, 23);
		getContentPane().add(waterFee);
		waterFee.setColumns(10);
		
		Bname = new JComboBox<String>();
		Bname.addItem("思学斋");
		Bname.addItem("自达斋");
		Bname.addItem("广圣斋");
		Bname.addItem("思贤斋");
		Bname.addItem("明道斋");
		Bname.addItem("格物斋");
		Bname.addItem("进德斋");
		Bname.addItem("厚德斋");
		Bname.addItem("笃志斋");
		Bname.addItem("崇德债");
		Bname.addItem("致和斋");
		Bname.addItem("诚明斋");
		Bname.addItem("日新斋");
		Bname.addItem("务实斋");
		Bname.addItem("济民斋");
		Bname.setBounds(129, 37, 86, 23);
		getContentPane().add(Bname);
		
		JButton btnNewButton = new JButton("提交");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				payWater(ae);
			}
		});
		btnNewButton.setBounds(275, 305, 97, 23);
		getContentPane().add(btnNewButton);
		
	}

	//提交按钮
	protected void payWater(ActionEvent ae) {
		// TODO Auto-generated method stub
		String Bname = this.Bname.getSelectedItem().toString();
		String Dnumber = this.Dnumber.getText();
		String waterFee = this.waterFee.getText();
		
		
		
		RoomDao roomDao = new RoomDao();
		String str=null;
		try {
			JOptionPane.showMessageDialog(this,roomDao.payWater(Bname, Dnumber, waterFee));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void doDefaultCloseAction() {
		setVisible(false);
		IndexFrameAdmin.listPbuildingFrame=null;
	}
}
