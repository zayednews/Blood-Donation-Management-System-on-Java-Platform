public class DBAccess {
	
	String query;
	Connection con;
	Statement st;
	ResultSet rs;
	
	public DBAccess() {
		createTable();
	}
	
	public void connectToDB()
	{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			st = con.createStatement();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createTable()
	{
		connectToDB();
		query = "SELECT * FROM 	dba_tables where table_name = 'DONATORS'";
		try {
			rs = st.executeQuery(query);
			if(rs.next()) {
			}
			else {
				query = "CREATE TABLE DONATORS"
					  + "(MOB			VARCHAR2(50),"
					  + "NAME			VARCHAR2(50),"
					  + "EMAIL			VARCHAR2(50),"
					  + "AGE			VARCHAR2(50),"
					  + "ADRS			VARCHAR2(50),"
					  + "B_GROUP		VARCHAR2(50))";
				st.executeUpdate(query);
			}
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void addToDB(String mob, String name, String email, String age, String adrs, String b_group) {
		connectToDB();
		try {
			query = "INSERT INTO DONATORS"
					+ "(MOB, NAME, EMAIL, AGE, ADRS, B_GROUP) "
					+ "VALUES"
					+ "('"+mob+"', '"+name+"', '"+email+"', '"+age+"', '"+adrs+"', '"+b_group+"')";
			st.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Donator Added!", "Success", JOptionPane.INFORMATION_MESSAGE);
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Vector<Vector<String>> getData(String b_group) {
		Vector<Vector<String>> vss = new Vector<Vector<String>>();
		connectToDB();
		try {
			query = "SELECT * FROM DONATORS WHERE B_GROUP = '"+b_group+"'";
			rs = st.executeQuery(query);
			if(!rs.next()) {
				JOptionPane.showMessageDialog(null, "No Donator Found!", "Empty", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				rs.close();
				rs = st.executeQuery(query);
				while(rs.next()) {
					Vector<String> vc = new Vector<String>();
					for(int i=1; i<=6; i++) {
						vc.add(rs.getString(i));
					}
					vss.add(vc);
				}
			}
		} catch (Exception e) {
		}
		return vss;
	}
	
}
