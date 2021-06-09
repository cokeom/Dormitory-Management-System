package view.Pbuilding;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dao.PbuildingDao;
import model.Pbuilding;
import view.Admin.IndexFrameAdmin;

import java.util.List;
import java.util.Vector;

public class ListPbuildingFrame extends JInternalFrame {
	private JTable pbdListTable;

	private DefaultTableModel dtm = null;

	/**
	 * Create the frame.
	 */
	public ListPbuildingFrame() {
		setBounds(100, 100, 848, 594);
		getContentPane().setLayout(null);
		setClosable (true);
		setIconifiable(true);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 816, 519);
		getContentPane().add(scrollPane);
		

		
		pbdListTable = new JTable();
		
		pbdListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u697c\u680b\u540d\u5b57","\u56ed\u533a\u540d\u5b57", "\u697c\u680b\u7f16\u53f7"
			}
		){
			public boolean isCellEditable(int row,int column) {
				return false;
			}
		}
				);
		pbdListTable.getTableHeader().setReorderingAllowed(false);
		pbdListTable.setRowHeight(25);
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		pbdListTable.setDefaultRenderer(Object.class,r);
		pbdListTable.getColumnModel().getColumn(1).setPreferredWidth(53);
		pbdListTable.getColumnModel().getColumn(2).setPreferredWidth(116);
		scrollPane.setViewportView(pbdListTable);
		this.dtm = (DefaultTableModel) pbdListTable.getModel();
		queryAllPbd();
	}

	public void queryAllPbd() {
		dtm.setRowCount(0);
		PbuildingDao pbuildingDao =new PbuildingDao();
		List<Pbuilding> allPbuildingList = pbuildingDao.queryAllPbd();
		for(Pbuilding pbd : allPbuildingList) {
			Vector v = new Vector();
			v.add(pbd.getBname());
			v.add(pbd.getPname());
			v.add(pbd.getBnumber());
			dtm.addRow(v);
		}
	}
	public void doDefaultCloseAction() {
		setVisible(false);
		IndexFrameAdmin.listPbuildingFrame=null;
	}
}
