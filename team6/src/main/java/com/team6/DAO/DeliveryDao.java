package com.team6.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.naming.*;

import com.team6.bean.DeliveryBean;
import com.team6.util.JDBCutil;







public class DeliveryDao {
	Connection connection;
	 //新增
		public boolean Insertd(DeliveryBean deliveryBean) {
		Connection connection = JDBCutil.getConnection();
		String sql = "insert into delivery ( cname,phone,product,price,address)  VALUES (?,?,?,?,?)";
		PreparedStatement stm = null;
			
		boolean isSuccess = false;
			
	try {
		stm = connection.prepareStatement(sql);
		stm.setString(1, deliveryBean.getCname());
		stm.setString(2, deliveryBean.getPhone());
		stm.setString(3, deliveryBean.getProduct());
		stm.setInt(4, deliveryBean.getPrice());
		stm.setString(5, deliveryBean.getAddress());
		stm.execute();
				
		isSuccess = true;
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCutil.closeResourse(connection,stm);
		}
			return isSuccess;
	}

		public boolean Update(DeliveryBean deliveryBean) {
			Connection connection = JDBCutil.getConnection();
			String sql = "UPDATE delivery SET cname = ?,phone = ?,product = ?,price = ?,address = ? WHERE id = ?";
			PreparedStatement preparedStatement = null;
			boolean isSuccess = false;
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(6, deliveryBean.getId());
				preparedStatement.setString(1, deliveryBean.getCname());
				preparedStatement.setString(2, deliveryBean.getPhone());
				preparedStatement.setString(3, deliveryBean.getProduct());
				preparedStatement.setInt(4, deliveryBean.getPrice());
				preparedStatement.setString(5, deliveryBean.getAddress());
				preparedStatement.execute();
				
				isSuccess = true;
				
			} catch (SQLException e) {
			System.out.println("b");
				e.printStackTrace();
			}finally {
				JDBCutil.closeResourse(connection, preparedStatement);
			}
			return isSuccess;
		}

	// 刪除
	public boolean Deleted(int id) {
		Connection connection = JDBCutil.getConnection();
		String sql = "DELETE FROM Delivery WHERE id = ?";
		PreparedStatement stm = null;
		boolean isSuccess = false;
		try {
			stm = connection.prepareStatement(sql);
			stm.setInt(1, id);
			stm.execute();
			isSuccess = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCutil.closeResourse(connection, stm);
		}
		return isSuccess;
	}

	//查詢單筆
	public DeliveryBean SelectOne(int id) {
		Connection connection = JDBCutil.getConnection();
		String sql = "SELECT * FROM  Delivery WHERE id = ?";
		PreparedStatement stm = null;
		ResultSet rs = null;
		DeliveryBean deliveryBean = new DeliveryBean();
		
		try {
			stm = connection.prepareStatement(sql);
			stm.setInt(1, id);
			rs = stm.executeQuery();
			if (rs.next()) {
				deliveryBean.setId(rs.getInt("id"));
				deliveryBean.setCname(rs.getString("cname"));
				deliveryBean.setPhone(rs.getString("phone"));
				deliveryBean.setProduct(rs.getString("product"));
				deliveryBean.setPrice(rs.getInt("price"));
				deliveryBean.setAddress(rs.getString("address"));
				deliveryBean.setTime(rs.getString("time"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCutil.closeResourse(connection,stm);
		}
			return deliveryBean;
		}
	public List<DeliveryBean>SelectName(String string) {
		Connection connection = JDBCutil.getConnection();
		String sql = "SELECT * FROM  delivery WHERE cname like ? ";
		
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		List<DeliveryBean> deliveryBeans = new ArrayList<>();
		DeliveryBean deliveryBean = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,"%" + string + "%");
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				deliveryBean = new DeliveryBean();
				deliveryBean.setId(rs.getInt("id"));
				deliveryBean.setCname(rs.getString("cname"));
				deliveryBean.setPhone(rs.getString("phone"));
				deliveryBean.setProduct(rs.getString("product"));
				deliveryBean.setAddress(rs.getString("address"));
				deliveryBean.setTime(rs.getString("time"));
				deliveryBeans.add(deliveryBean);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCutil.closeResourse(connection, preparedStatement, rs);
		}
		return deliveryBeans;
	}

	
	//查尋全部
	public List<DeliveryBean> SelectAll() {
		Connection connection = JDBCutil.getConnection();
		
		String sql = "SELECT * FROM  Delivery";
		
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		List<DeliveryBean> deliveryBeans = new ArrayList<>();
		DeliveryBean deliveryBean = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				deliveryBean = new DeliveryBean();
				deliveryBean.setId(rs.getInt("id"));
				deliveryBean.setCname(rs.getString("cname"));
				deliveryBean.setPhone(rs.getString("phone"));
				deliveryBean.setProduct(rs.getString("product"));
				deliveryBean.setAddress(rs.getString("address"));
				deliveryBean.setTime(rs.getString("time"));
				deliveryBeans.add(deliveryBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return deliveryBeans;
	}

	
	
	
}

