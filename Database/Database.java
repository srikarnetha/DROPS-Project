package com.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.User;

public class Database {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/drops", "root", "root");
		return conn;
	}
	
	public static int register(User user) throws ClassNotFoundException, SQLException {

		Connection conn = Database.getConnection();
		String sql = "insert into user values(0,?,?,?,?,?,?,?)";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, user.getName());
		ps.setString(2, user.getEmail());
		ps.setString(3, user.getPassword());
		ps.setString(4, user.getMobile());
		ps.setString(5, user.getGender());
		ps.setString(6, user.getAddress());
		ps.setString(7, "enabled");
		

		int i = ps.executeUpdate();
		return i;

	}

	public static ResultSet Login(User user) throws ClassNotFoundException, SQLException {

		Connection conn = Database.getConnection();
		String sql = "select * from user where email=? and password=?";

		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, user.getEmail());
		ps.setString(2, user.getPassword());
		
		
		ResultSet rs=ps.executeQuery();
		return rs;
		
		

	}
	
	public static int node1(String fid,String id,String data1,String hash) throws ClassNotFoundException, SQLException {

		Connection conn = Database.getConnection();
		String sql = "insert into node1 values(?,?,?,?)";

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, fid);
		ps.setString(2, id);
		ps.setString(3, data1);
		ps.setString(4, hash);

		int i = ps.executeUpdate();
		return i;

	}
	public static int node2(String fid,String id,String data1, String hash) throws ClassNotFoundException, SQLException {

		Connection conn = Database.getConnection();
		String sql = "insert into node2 values(?,?,?,?)";

		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, fid);
		ps.setString(2, id);
		ps.setString(3, data1);
		ps.setString(4, hash);
		int i = ps.executeUpdate();
		return i;

	}
	public static int node3(String fid,String id,String data1, String hash) throws ClassNotFoundException, SQLException {

		Connection conn = Database.getConnection();
		String sql = "insert into node3 values(?,?,?,?)";

		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, fid);
		ps.setString(2, id);
		ps.setString(3, data1);
		ps.setString(4, hash);

		int i = ps.executeUpdate();
		return i;

	}
	public static int node4(String fid,String id,String data1,String hash) throws ClassNotFoundException, SQLException {

		Connection conn = Database.getConnection();
		String sql = "insert into node4 values(?,?,?,?)";

		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, fid);
		ps.setString(2, id);
		ps.setString(3, data1);
		ps.setString(4, hash);

		int i = ps.executeUpdate();
		return i;

	}
	public static int node5(String fid,String id,String data1, String hash) throws ClassNotFoundException, SQLException {

		Connection conn = Database.getConnection();
		String sql = "insert into node5 values(?,?,?,?)";

		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, fid);
		ps.setString(2, id);
		ps.setString(3, data1);
		ps.setString(4, hash);

		int i = ps.executeUpdate();
		return i;

	}
	
	public static List<String> getUFile(String sql) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = Database.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				lt.add(rs.getString(2));
				lt.add(rs.getString(3));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
	
	public static String getName(String sql) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String name ="";
		Connection con = Database.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				name = rs.getString(1);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;

	}
	
	public static boolean getData(String sql) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		boolean b = false;
		Connection con = Database.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			b = rs.next();
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	public static int sendRKeys(String sql, com.bean.KeyReqBean kb) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = Database.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, kb.getFid());
			ps.setString(2, kb.getOwn());
			ps.setString(3, kb.getEmail());
			ps.setString(4, "pending");
			ps.setString(5, kb.getDa());
			i = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
}
	
	public static List<String> getAkey(String sql) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = Database.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				lt.add(rs.getString(2));
				lt.add(rs.getString(3));
				lt.add(rs.getString(5));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
	public static int update(String sql) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = Database.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			i = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public static List<String> getFid(String sql) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = Database.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
	public static List<String> getUKeys(String sql) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = Database.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(3));
				lt.add(rs.getString(4));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
	
	public static List<String> getKeys(String sql) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = Database.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(6));
				lt.add(rs.getString(7));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
	
	public static int getCount(String sql) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = Database.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				i = rs.getInt(1);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public static int setAttack(String sql, com.bean.AttackBean ab) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = Database.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ab.getFid());
			ps.setString(2, ab.getOwn());
			ps.setString(3, ab.getEmail());
			ps.setString(4, ab.getIp());
			ps.setString(5, ab.getDa());
			ps.setInt(6, ab.getFcount());
			i = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public static ResultSet getUp() throws SQLException, ClassNotFoundException
	{
		Connection con=Database.getConnection();
		java.sql.Statement s=con.createStatement();
		ResultSet rs=(ResultSet) s.executeQuery("select * from upload");
		return rs;
	}
	
	public static List<String> getAttack(String sql) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = Database.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				lt.add(rs.getString(2));
				lt.add(rs.getString(3));
				lt.add(rs.getString(4));
				lt.add(rs.getString(5));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
	public static List<String> getUserDetails(String sql) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = Database.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				lt.add(rs.getString(2));
				lt.add(rs.getString(3));
				lt.add(rs.getString(6));
				lt.add(rs.getString(7));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
	public static List<String> getUploadDetails(String sql) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = Database.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				lt.add(rs.getString(2));
				lt.add(rs.getString(3));
				
				lt.add(rs.getString(7));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
}
