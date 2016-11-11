public class SearchWindow extends JFrame {
	
	private JPanel panel;
	private JLabel labelForm, labelSearch;
	private JComboBox comboBlood;
	private JButton buttonSearch, buttonAdd;
	
	public SearchWindow() {
		this.initializeComponents();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private void initializeComponents()	{
		
		this.panel = new JPanel();
		this.panel.setLayout(null);
		this.setTitle("Search Blood Donator");
		this.setSize(450, 350);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.labelForm = new JLabel("Search With Blood Group");
		this.labelForm.setBounds(150, 30, 250, 20);
		this.panel.add(this.labelForm);
		
		this.labelSearch = new JLabel("Blood Group");
		this.labelSearch.setBounds(80, 110, 180, 20);
		this.panel.add(this.labelSearch);

		String dept[] = new String[] {"A +ve", "A -ve", "B +ve", "B -ve", "O +ve", "O -ve", "AB +ve", "AB -ve"};
		
		this.comboBlood = new JComboBox(dept);
		this.comboBlood.setBounds(200, 110, 180, 20);
		this.panel.add(this.comboBlood);

		
		this.buttonAdd = new JButton("Add New Donator");
		this.buttonAdd.setBounds(60, 205, 140, 30);
		this.panel.add(this.buttonAdd);
		
		this.buttonSearch  = new JButton("Search");
		this.buttonSearch.setBounds(250, 200, 100, 40);
		this.panel.add(this.buttonSearch);
		
		this.add(this.panel);
		
		this.buttonAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new DonatorAdder();
			}
		});
		
		this.buttonSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DBAccess db = new DBAccess();
				new SearchResult(db.getData(comboBlood.getSelectedItem().toString()));
			}
		});
	}
}
