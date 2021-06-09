package view.DorManage;

import java.awt.EventQueue;
import java.util.List;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;



import dao.RoomDao;
import model.Room;
import model.StudentInfo;
import view.Admin.IndexFrameAdmin;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListRoomStuFrame extends JInternalFrame {
	private JTable table;
	private JTextField Bname;
	private JTextField Rnumber;
	
	private DefaultTableModel dtm = null;
	

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public ListRoomStuFrame() {
		setTitle("宿舍查询");
		setBounds(100, 100, 900, 601);
		getContentPane().setLayout(null);
		setClosable (true);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 868, 432);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5B66\u53F7", "\u59D3\u540D", "\u6210\u7EE9", "\u5B66\u9662", "\u4E13\u4E1A", "\u6027\u522B", "\u5E74\u9F84", "\u7535\u8bdd"
			}
		){
			public boolean isCellEditable(int row,int column) {
				return false;
			}
		}
				);
		table.getTableHeader().setReorderingAllowed(false);
		table.setRowHeight(25);
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class,r);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("楼栋名");
		lblNewLabel.setBounds(34, 472, 58, 15);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("寝室号");
		lblNewLabel_1.setBounds(34, 531, 58, 15);
		getContentPane().add(lblNewLabel_1);
		
		Bname = new JTextField();
		Bname.setBounds(92, 469, 85, 21);
		getContentPane().add(Bname);
		Bname.setColumns(10);
		
		Rnumber = new JTextField();
		Rnumber.setBounds(92, 528, 85, 21);
		getContentPane().add(Rnumber);
		Rnumber.setColumns(10);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conditionSelect(e);
			}
		});
		btnNewButton.setBounds(331, 503, 97, 23);
		getContentPane().add(btnNewButton);
		
		this.dtm = (DefaultTableModel)table.getModel();
		
		queryRoom();

	}
	
	protected void conditionSelect(ActionEvent e) {
		// TODO Auto-generated method stub
		String Bname = this.Bname.getText();
		String Rnumber = this.Rnumber.getText();
		
		dtm.setRowCount(0);
		
		RoomDao roomDao = new RoomDao();
		
		List<StudentInfo> allStudent = roomDao.ConQueryRoom(Bname,Rnumber); 
		
		for(StudentInfo si : allStudent) {
			Vector v = new Vector();
			v.add(si.getUsername());
			v.add(si.getName());
			v.add(si.getGrade());
			v.add(si.getAcademy());
			v.add(si.getMajor());
			v.add(si.getSex());
			v.add(si.getAge());
			v.add(si.getTelephone());
			dtm.addRow(v);
		}
		
	}

	public void queryRoom() {
		dtm.setRowCount(0);
		RoomDao roomDao = new RoomDao();
		List<StudentInfo> allStudent = roomDao.queryRoom(); 
		
		for(StudentInfo si : allStudent) {
			Vector v = new Vector();
			v.add(si.getUsername());
			v.add(si.getName());
			v.add(si.getGrade());
			v.add(si.getAcademy());
			v.add(si.getMajor());
			v.add(si.getSex());
			v.add(si.getAge());
			v.add(si.getTelephone());
			dtm.addRow(v);
		}
	}
	public void doDefaultCloseAction() {
		setVisible(false);
		IndexFrameAdmin.listRoomStuFrame=null;
	}
}
