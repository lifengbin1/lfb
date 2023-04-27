package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dbutil.Dbconn;
import entity.User;

public class Model {

	public static List<User> getAllUsers() {
		Connection connection = null;

		PreparedStatement preparedStatement = null;

		ResultSet resultSet = null;

		try {

			// 获取数据库连接对象
			connection = Dbconn.getConnection();
			// 定义数据库SQL语句
			String sql = "select * from user order by uid desc";
			// 获取SQL执行对象
			preparedStatement = connection.prepareStatement(sql);
			// 获取数据集
			resultSet = preparedStatement.executeQuery();

			List<User> users = new ArrayList<User>();
			while (resultSet.next()) {
				Integer uid = resultSet.getInt("uid");
				String uname = resultSet.getString("uname");
				String uphone = resultSet.getString("uphone");
				int uage = resultSet.getInt("uage");
				Timestamp timestamp = resultSet.getTimestamp("utime");

				DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

				String utime = format.format(timestamp);

				String usex = resultSet.getString("usex");
				User user = new User(uid, uname, uphone, uage, utime, usex);
				users.add(user);
			}

			return users;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			Dbconn.close(connection, preparedStatement, resultSet);
		}

		return null;
	}

	public static User getByID(Integer id) {
		Connection connection = null;

		PreparedStatement preparedStatement = null;

		ResultSet resultSet = null;

		try {

			// 获取数据库连接对象
			connection = Dbconn.getConnection();
			// 定义数据库SQL语句
			String sql = "select * from user where uid = ?";
			// 获取SQL执行对象
			preparedStatement = connection.prepareStatement(sql);
			// 设置参数值
			preparedStatement.setInt(1, id);
			// 获取数据集
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Integer uid = resultSet.getInt("uid");
				String uname = resultSet.getString("uname");
				String uphone = resultSet.getString("uphone");
				int uage = resultSet.getInt("uage");
				Timestamp timestamp = resultSet.getTimestamp("utime");

				DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

				String utime = format.format(timestamp);
				String usex = resultSet.getString("usex");
				return new User(uid, uname, uphone, uage, utime, usex);
			}

			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			Dbconn.close(connection, preparedStatement, resultSet);
		}

		return null;
	}
	
	public static boolean deleByID(Integer id) {
		Connection connection = null;

		PreparedStatement preparedStatement = null;

		ResultSet resultSet = null;

		try {

			// 获取数据库连接对象
			connection = Dbconn.getConnection();
			// 定义数据库SQL语句
			String sql = "delete from user where uid = ?";
			// 获取SQL执行对象
			preparedStatement = connection.prepareStatement(sql);
			// 设置参数值
			preparedStatement.setInt(1, id);
			

			int flag = preparedStatement.executeUpdate();
			
			if(flag > 0) return true;
			
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			Dbconn.close(connection, preparedStatement, resultSet);
		}

		return false;
	}

	public static User getByPhone(String phone) {
		Connection connection = null;

		PreparedStatement preparedStatement = null;

		ResultSet resultSet = null;

		try {

			// 获取数据库连接对象
			connection = Dbconn.getConnection();
			// 定义数据库SQL语句
			String sql = "select * from user where uphone = ?";
			// 获取SQL执行对象
			preparedStatement = connection.prepareStatement(sql);
			// 设置参数值
			preparedStatement.setString(1, phone);
			// 获取数据集
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Integer uid = resultSet.getInt("uid");
				String uname = resultSet.getString("uname");
				String uphone = resultSet.getString("uphone");
				int uage = resultSet.getInt("uage");
				Timestamp timestamp = resultSet.getTimestamp("utime");

				DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

				String utime = format.format(timestamp);
				String usex = resultSet.getString("usex");
				return new User(uid, uname, uphone, uage, utime, usex);
			}

			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			Dbconn.close(connection, preparedStatement, resultSet);
		}

		return null;
	}

	public static boolean insertUser(String uname, String uphone, String usex, int uage) {
		Connection connection = null;

		PreparedStatement preparedStatement = null;

		ResultSet resultSet = null;

		try {

			connection = Dbconn.getConnection();
			String sql = "insert into user(uname, uphone, usex, uage) values(?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, uname);
			preparedStatement.setString(2, uphone);
			preparedStatement.setString(3, usex);
			preparedStatement.setInt(4, uage);

			int flag = preparedStatement.executeUpdate();

			if (flag > 0)
				return true;

			return false;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause
			Dbconn.close(connection, preparedStatement, resultSet);
		}

		return false;
	}
	
	public static boolean updateByID(Integer uid, String uname, String uphone, String usex, int uage) {
		Connection connection = null;

		PreparedStatement preparedStatement = null;

		ResultSet resultSet = null;

		try {

			connection = Dbconn.getConnection();
			String sql = "update user set uname = ?, uphone = ?,  usex = ?, uage = ? where uid = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, uname);
			preparedStatement.setString(2, uphone);
			preparedStatement.setString(3, usex);
			preparedStatement.setInt(4, uage);
			preparedStatement.setInt(5, uid);

			int flag = preparedStatement.executeUpdate();

			if (flag > 0)
				return true;

			return false;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause
			Dbconn.close(connection, preparedStatement, resultSet);
		}

		return false;
	}

}
