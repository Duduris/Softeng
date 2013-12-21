import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class TestDBClass {
	
	public static java.sql.Date getCurrentJavaSqlDate() {
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Date(today.getTime());
	  }
	
	public static void main(String[] args) {
		
		final String name = "vbsjkdhdjkbvh"; //Name
		final String surname = "vbsjkdhdjkbv"; //Surname
		final String address = "vbsjkdhdjkbv"; //Address
		final int tk = 13245; //Postal Code
		final String xwra = "vbsjkdhdjkbv"; //Country
		final int phone = 1234564; // Phone
		final String comment = "vbsjkdhdjkbvgubv"; //Comment
		
		/*Kanonika einai etsi sto IpalilosPanel
		final String name = frmtdtxtfldFdjkj.getText(); //Name
		final String surname = frmtdtxtfldFsdfsdfsdfsdf.getText(); //Surname
		final String address = frmtdtxtfldFsdfsdDfsfs.getText(); //Address
		final int tk = Integer.parseInt(formattedTextField_3.getText()); //Postal Code
		final String xwra = frmtdtxtfldFsdfsdfsf.getText(); //Country
		final int phone = Integer.parseInt(formattedTextField_5.getText()); // Phone
		final String comment = txtrSdfsbfgdsbefgvtreg.getText(); //Comment
		*/
		
		
		try{
			
			//elegxos gia tixon null sta Jtextboxes
			//grafw sti vasi
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			String url = "jdbc:mysql://83.212.112.80/foo";
			String username = "root";
			String pass = "1234";
			
			Connection conn = DriverManager.getConnection(url, username, pass);
			
			Statement stm = conn.createStatement();
			
			
			//tyxaio tracking number Elegxos me epanalipsi an yparxei eidh
			int min = 0000000;
			int max = 9999999;
			Random r = new Random();
			int trackingnumber = r.nextInt(max - min + 1) + min;
			
			//Arxiki katastasi (Mi paradomeno)
			int katastasi = 0;
			
			//fragile
			boolean checkbox = true;//Kanonika einai etsi: final boolean checkbox = chckbxNewCheckBox.isSelected(); sto ipalilosPanel
			int ckeck = 0;
			if (checkbox) {
				ckeck = 1;
			}
			
			
			int id = 6; // kanonika den ginete etsi gia testarisma tou exw valei statheri timh
			String sqlgrapsimo = "insert into demata values(?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sqlgrapsimo);
			
			ps.setInt(1, id);
			ps.setInt(2, trackingnumber);
			ps.setString(3, name);
			ps.setString(4, surname);
			ps.setString(5, address);
			ps.setInt(6, tk);
			ps.setString(7, xwra);
			ps.setInt(8, phone);
			ps.setInt(9, ckeck);
			ps.setString(10, comment);
			ps.setInt(11, katastasi);
			java.sql.Date date = getCurrentJavaSqlDate();
		    ps.setDate(12, date);
			ps.executeUpdate();
			
			
			//Diavasma Vasis
			String sqldiavasma = "select * from demata";
			ResultSet rs = stm.executeQuery(sqldiavasma);
			while(rs.next()){
				int id2 = rs.getInt("id");
				int trackingnumber2 = rs.getInt("trackingnumber");
				String name2 = rs.getString("onoma");
				String surname2 = rs.getString("epitheto");
				String address2 = rs.getString("address");
				int tk2 = rs.getInt("TK");
				String xwra2 = rs.getString("xwra");
				int phone2 = rs.getInt("phone");
				int fragile = rs.getInt("fragile");
				String comment2 = rs.getString("comment");
				int katastasi2 = rs.getInt("katastasi");
				String date2 = rs.getString("Date");
				System.out.println(id2 + " " + trackingnumber2 + " " + name2 + " " + surname2 + " " + address2 + " " + tk2 + " " + xwra2 + " " + phone2 + " " + fragile + " " + comment2 + " " + katastasi2 + " " + date2);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
















/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDBClass {

	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			String url = "jdbc:mysql://83.212.112.80/foo";
			String username = "root";
			String pass = "1234";
			
			Connection conn = DriverManager.getConnection(url, username, pass);
			
			Statement stm = conn.createStatement();
			
			String sql = "select * from demata";
			
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()){
				int id = rs.getInt("id");
				int trackingnumber = rs.getInt("trackingnumber");
				String onoma = rs.getString("onoma");
				String epitheto = rs.getString("epitheto");
				String address = rs.getString("address");
				int tk = rs.getInt("TK");
				String xwra = rs.getString("xwra");
				int phone = rs.getInt("phone");
				int fragile = rs.getInt("fragile");
				String comment = rs.getString("comment");
				int katastasi = rs.getInt("katastasi");
				System.out.println(id + " " + trackingnumber + " " + onoma + " " + epitheto + " " + address + " " + tk + " " + xwra + " " + phone + " " + fragile + " " + comment + " " + katastasi);
			}
			
			sql = "update students set surname='Papa' where surname='Lee'";
			stm.executeUpdate(sql);
			
			int ids = 4;
			String myname = "Nick";
			String mysurname = "Papas";
			
			//sql = "inset into students values (" + ids + ",'" + myname + "','" +  mysurname + "')"; 
			
			sql = "insert into students values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, ids);
			ps.setString(2, myname);
			ps.setString(3, mysurname);
			ps.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}*/