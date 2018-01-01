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
 * jdbc��������
 * @author Administrator
 *
 */
public class DBUtils {
	//��ȡ�����ļ��е�¼����Ϣ
	private static Properties pro = new Properties();
	static{
		//��ȡ�ļ���ȡ��
		InputStream is = DBUtils.class.getResourceAsStream("jdbc.properties");
		try {
			//����properties�ļ��е�����
			pro.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * ���������ļ��е����ݷ���һ������
	 * @return
	 */
	public static Connection getConnection(){
		//��ȡ���ӵ�url��
		String url=pro.getProperty("url");
		//��ȡ��Ҫ�������ݿ���û���
		String name=pro.getProperty("name");
		//��ȡ���ӵ��û�����
		String password=pro.getProperty("password");
		//��ȡ���ӵ��������ȫ����
		String driver = pro.getProperty("driver");
		
		Connection conn = null ;
		try {
			//����������
			Class.forName(driver);
			//��������
			conn = DriverManager.getConnection(url, name, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * ͨ��һ��sql����ȡһ��list����
	 * @param sql �����ѯ��sql���
	 * @return
	 */
	public static List<Map> queryData(String sql){
		List<Map> list = new ArrayList<Map>();
		//��ȡһ������
		Connection conn = DBUtils.getConnection();
		PreparedStatement ps;
		try {
			//��ȡִ��sql����prepareStatement��
			ps = conn.prepareStatement(sql);
			//��ȡһ�������
			ResultSet rs = ps.executeQuery();
			//��ȡ���б���Ϣ
			ResultSetMetaData rsd = rs.getMetaData();
			Map map;
			while(rs.next()){
				map = new HashMap();
				//����ÿ���в��ҽ��е����ݴ��뵽map������
				for(int i=1; i<=rsd.getColumnCount();i++){
					//��ȡ����
					String key = rsd.getColumnName(i);
					//��ȡ���е�ֵ
					String value = rs.getString(i);
					//��ֵ����map������
					map.put(key, value);
				}
				//��map��ӵ�list��
				list.add(map);
			}
			//�ر�����
			conn.close();
			//ִ��sql��������
			ps.close();
			//�رս��������
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	/**
	 * ͨ��һ��sql����ȡִ�и�sql�����Ӱ�������
	 * @param sql ����ִ�е�sql���
	 * @return
	 */
	public static int execute(String sql){
		//��ȡһ������
		Connection conn = DBUtils.getConnection();
		PreparedStatement ps;
		int line = 0;
		try {
			//��ȡִ��sql����prepareStatement��
			ps = conn.prepareStatement(sql);
			//��ȡһ�������
			line = ps.executeUpdate();
			
			//�ر�����
			conn.close();
			//ִ��sql��������
			ps.close();
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return line;
	}
}
