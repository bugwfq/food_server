package cn.fuqiang.food.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * jdbc的连接类
 * @author Administrator
 *
 */
public class DBUtils {
	//获取配置文件中登录的信息
	private static Properties pro = new Properties();
	static{
		//获取文件读取流
		InputStream is = DBUtils.class.getResourceAsStream("jdbc.properties");
		try {
			//加载properties文件中的内容
			pro.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 根据配置文件中的内容返回一个连接
	 * @return
	 */
	public static Connection getConnection(){
		//获取连接的url、
		String url=pro.getProperty("url");
		//获取需要连接数据库的用户名
		String name=pro.getProperty("name");
		//获取连接的用户密码
		String password=pro.getProperty("password");
		//获取链接的驱动类的全类名
		String driver = pro.getProperty("driver");
		
		Connection conn = null ;
		try {
			//加载驱动类
			Class.forName(driver);
			//创建连接
			conn = DriverManager.getConnection(url, name, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 通过一个sql语句获取一个list集合
	 * @param sql 传入查询的sql语句
	 * @return
	 */
	public static List<Map> queryData(String sql){
		List<Map> list = new ArrayList<Map>();
		//获取一个连接
		Connection conn = DBUtils.getConnection();
		PreparedStatement ps;
		try {
			//获取执行sql语句的prepareStatement类
			ps = conn.prepareStatement(sql);
			//获取一个结果集
			ResultSet rs = ps.executeQuery();
			//获取所有表信息
			ResultSetMetaData rsd = rs.getMetaData();
			Map map;
			while(rs.next()){
				map = new HashMap();
				//遍历每个列并且将列的内容存入到map集合中
				for(int i=1; i<=rsd.getColumnCount();i++){
					//获取列名
					String key = rsd.getColumnName(i);
					//获取列中的值
					String value = rs.getString(i);
					//将值加入map集合中
					map.put(key, value);
				}
				//将map添加到list中
				list.add(map);
			}
			//关闭连接
			conn.close();
			//执行sql语句的连接
			ps.close();
			//关闭结果集的流
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	/**
	 * 通过一个sql语句获取执行该sql语句所影响的行数
	 * @param sql 传入执行的sql语句
	 * @return
	 */
	public static int execute(String sql){
		//获取一个连接
		Connection conn = DBUtils.getConnection();
		PreparedStatement ps;
		int line = 0;
		try {
			//获取执行sql语句的prepareStatement类
			ps = conn.prepareStatement(sql);
			//获取一个结果集
			line = ps.executeUpdate();
			
			//关闭连接
			conn.close();
			//执行sql语句的连接
			ps.close();
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return line;
	}
}
