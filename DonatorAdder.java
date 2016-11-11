public class DonatorAdder extends JFrame {

	private JPanel panel;
	private JLabel labelForm, labelMob, labelName, labelAge, labelBlood, labelEmail, labelAdrs;
	private JTextField textMob, textName, textEmail, textAge, textAdrs;
	private JComboBox comboBlood;
	private JButton buttonAdd;
	
	public DonatorAdder() {
		this.initializeComponents();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private void initializeComponents()	{
		
		this.panel = new JPanel();
		this.panel.setLayout(null);
		this.setTitle("Add New Donator");
		this.setSize(450, 350);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.labelForm = new JLabel("Donator Details");
		this.labelForm.setBounds(150, 10, 250, 20);
		this.panel.add(this.labelForm);
		
		this.labelMob = new JLabel("Mobile Number");
		this.labelMob.setBounds(20, 50, 180, 20);
		this.panel.add(this.labelMob);
		
		this.textMob = new JTextField();
		this.textMob.setBounds(200, 50, 180, 20);
		this.panel.add(this.textMob);
		
		this.labelName = new JLabel("Name");
		this.labelName.setBounds(20, 80, 180, 20);
		this.panel.add(this.labelName);
		
		this.textName = new JTextField();
		this.textName.setBounds(200, 80, 180, 20);
		this.panel.add(this.textName);
		
		this.labelEmail = new JLabel("Email");
		this.labelEmail.setBounds(20, 110, 180, 20);
		this.panel.add(this.labelEmail);
		
		this.textEmail = new JTextField();
		this.textEmail.setBounds(200, 110, 180, 20);
		this.panel.add(this.textEmail);
		
		this.labelAge = new JLabel("Age");
		this.labelAge.setBounds(20, 140, 180, 20);
		this.panel.add(this.labelAge);
		
		this.textAge = new JTextField();
		this.textAge.setBounds(200, 140, 180, 20);
		this.panel.add(this.textAge);
		
		this.labelAdrs = new JLabel("Address");
		this.labelAdrs.setBounds(20, 170, 180, 20);
		this.panel.add(this.labelAdrs);
		
		this.textAdrs = new JTextField();
		this.textAdrs.setBounds(200, 170, 180, 20);
		this.panel.add(this.textAdrs);

		this.labelBlood = new JLabel("Blood Group");
		this.labelBlood.setBounds(20, 200, 180, 20);
		this.panel.add(this.labelBlood);

		String dept[] = new String[] {"A +ve", "A -ve", "B +ve", "B -ve", "O +ve", "O -ve", "AB +ve", "AB -ve"};
		
		this.comboBlood = new JComboBox(dept);
		this.comboBlood.setBounds(200, 200, 180, 20);
		this.panel.add(this.comboBlood);
		
		this.buttonAdd = new JButton("Add");
		this.buttonAdd.setBounds(180, 240, 60, 40);
		this.panel.add(this.buttonAdd);
		
		this.add(this.panel);
		
		this.buttonAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String mob, name, email, age, adrs, b_group;
				mob = textMob.getText();
				name = textName.getText();
				email = textEmail.getText();
				age = textAge.getText();
				adrs = textAdrs.getText();
				b_group = comboBlood.getSelectedItem().toString();
				
				DBAccess db = new DBAccess();
				db.addToDB(mob, name, email, age, adrs, b_group);
			}
		});
	}
}
