package view.Canteen;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dao.CanteenDao;
import model.Canteen;
import view.Admin.IndexFrameAdmin;

import java.util.List;
import java.util.Vector;

public class ListCanteenFrame extends JInternalFrame {
	private JTable canListTable;

	private DefaultTableModel dtm = null;

	/**
	 * Create the frame.
	 */
	public ListCanteenFrame() {
		setBounds(100, 100, 848, 594);
		getContentPane().setLayout(null);
		setClosable (true);
		setIconifiable(true);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 816, 545);
		getContentPane().add(scrollPane);
		
		canListTable = new JTable();
		canListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u98df\u5802\u540d\u5b57","\u56ed\u533a\u540d\u5b57", "\u7279\u8272\u83dc", "\u5ea7\u4f4d\u6570"
			}
		)
		{
			public boolean isCellEditable(int row,int column) {
				return false;
			}
		});
		
		canListTable.getTableHeader().setReorderingAllowed(false);
		canListTable.setRowHeight(25);
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		canListTable.setDefaultRenderer(Object.class,r);
		
		canListTable.getColumnModel().getColumn(2).setPreferredWidth(53);
		canListTable.getColumnModel().getColumn(3).setPreferredWidth(116);
		scrollPane.setViewportView(canListTable);
		this.dtm = (DefaultTableModel) canListTable.getModel();
		queryAllCan();
	}

	public void queryAllCan() {
		dtm.setRowCount(0);
		CanteenDao canteenDao =new CanteenDao();
		List<Canteen> allCanteenList = canteenDao.queryAllCan();
		for(Canteen can : allCanteenList) {
			Vector v = new Vector();
			v.add(can.getCname());
			v.add(can.getDorName());
			v.add(can.getDishes());
			v.add(can.getSeat());
			dtm.addRow(v);
		}
	}
	public void doDefaultCloseAction() {
		setVisible(false);
		IndexFrameAdmin.listCanteenFrame=null;
	}
}
