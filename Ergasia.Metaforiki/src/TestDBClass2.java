import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDBClass2 {

	public static void main(String[] args) {
		try {
			/*
			 * Dokimastiki klasi
			 */
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			String url = "jdbc:mysql://83.212.109.15/db1";
			String username = "root";
			String pass = "36966";

			/*
			 * create table metaforiki (
			 * id int, name varchar(20), surname varchar(20),
			 * address varchar(50), postalcode int, country varchar(20),
			 * phone varchar(10), fragile tinyint(1), tracking varchar(14),
			 * comments tinytext,
			 * status enum('undelivered','delivered','damaged','unavailable','wrong address') not null default 'undelivered'
			 * );
			 */

			Connection conn = DriverManager.getConnection(url, username, pass);

			Statement stm = conn.createStatement();

			String sql = "select * from metaforiki";

			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String surname = rs.getString("surname");
				String address = rs.getString("address");
				int postalcode = rs.getInt("postalcode");
				String country = rs.getString("country");
				String phone = rs.getString("phone");
				boolean fragile = rs.getBoolean("fragile");
				String tracking = rs.getString("tracking");
				String comments = rs.getString("comments");
				String status = rs.getString("status");
				String date = rs.getString("date");
				System.out.println(id + " " + name + " " + surname + " " +address+ " " 
						+postalcode+ " " +country+ " " +phone+ " " +fragile+ " " 
						+ tracking+ " " +comments+ " " +status+" "+date);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
