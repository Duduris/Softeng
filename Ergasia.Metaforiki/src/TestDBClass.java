

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDBClass {

	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			String url = "jdbc:mysql://weblab.teipir.gr/lessons2";
			String username = "web_mon45";
			String pass = "w13011d863";
			
			Connection conn = DriverManager.getConnection(url, username, pass);
			
			/*Statement stm = conn.createStatement();
			
			String sql = "select * from lessons2";
			
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String surname = rs.getString("surname");
				System.out.println(id + " " + name + " " + surname);
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
			*/
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}