import java.sql.*;
public class Login {

	public static boolean validate (String n,String p) 
	{
		boolean status=false;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1998");
			PreparedStatement ps=con.prepareStatement("select * from loginCredentials where UserName=? and password=?");
			ps.setString(1,n);
			ps.setString(2,p);
			
			ResultSet rs=ps.executeQuery();
			status=rs.next();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;

	
	}

}
