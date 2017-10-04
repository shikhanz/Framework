package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class Database {
	
		
	
			static private Connection connect=null;
			static private Statement statement = null;
			static private ResultSet resultSet = null;
			String user1="root";
			String pass="";
			
			
			public List<String> executeQuery(String Query,String cols) throws ClassNotFoundException, SQLException {
			
				Class.forName("com.mysql.jdbc.Driver");
				connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/database1?user="+user1+"&password="+pass);

			      // Statements allow to issue SQL queries to the database
			      statement = connect.createStatement();
			      // Result set get the result of the SQL query
			      resultSet = statement.executeQuery(Query);
			      List<String> data=new ArrayList<String>();
			      while(resultSet.next()){
			    	  data.add(resultSet.getString(cols));
			      }
				return data;
			     }

			}




