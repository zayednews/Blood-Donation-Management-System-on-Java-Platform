public class SearchResult extends JFrame {
	
	JTable table;	
	DefaultTableModel model;
	JScrollPane scroll;
	Vector<Vector<String>> vss;
	
	public SearchResult() {
	}
	
	public SearchResult(Vector<Vector<String>> vss) {
		if(vss.isEmpty()) {
			return;
		}
		this.vss = vss;
		initComps();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void initComps() {
		this.setTitle("Donator List");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(800, 500);
		
		Vector<String> columnNames = new Vector<String>();
		columnNames.add("Mobile");
		columnNames.add("Name");
		columnNames.add("Email");
		columnNames.add("Age");
		columnNames.add("Address");
		columnNames.add("Blood Group");
		
		model = new DefaultTableModel(vss, columnNames);
		
		table = new JTable(model);
		
		scroll = new JScrollPane(table);
		
		this.add(scroll);
	}

}
