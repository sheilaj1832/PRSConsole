package prs.business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import prs.business.Product;
import prs.util.DBUtil;

public class ProductDB {

	public List<Product> get(String name) {
		String sql = "SELECT * from Product where name = ?";
		List<Product> products = new ArrayList<>();
		Product p = null;
		try (Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				int vendorId = rs.getInt(2);
				String partNumber = rs.getString(3);
				String n = rs.getString(4);
				double price = rs.getDouble(5);
				String unit = rs.getString(6);
				String photoPath = rs.getString(7);
				p = new Product(id, vendorId, partNumber, n, price, unit, photoPath);

				products.add(p);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}

	public List<Product> get(int vendorId) {
		String sql = "SELECT * from Product where vendorId = ?";
		List<Product> products = new ArrayList<>();
		Product p = null;
		try (Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setInt(1, vendorId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				int v = rs.getInt(2);
				String partNumber = rs.getString(3);
				String name = rs.getString(4);
				double price = rs.getDouble(5);
				String unit = rs.getString(6);
				String photoPath = rs.getString(7);
				p = new Product(id, v, partNumber, name, price, unit, photoPath);

				products.add(p);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}

	public List<Product> getAll() {
		String sql = "SELECT * FROM  Product";
		List<Product> products = new ArrayList<>();
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				int id = rs.getInt(1);
				int vendorId = rs.getInt(2);
				String partNumber = rs.getString(3);
				String name = rs.getString(4);
				double price = rs.getDouble(5);
				String unit = rs.getString(6);
				String photoPath = rs.getString(7);
				Product p = new Product(id, vendorId, partNumber, name, price, unit, photoPath);

				products.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	public boolean add(Product p) {
		String sql = "INSERT INTO Product (vendorId, partNumber, name, price, unit, photoPath) "
				+ "VALUES (?, ?, ?, ?, ?)";
		try (Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setInt(1, p.getVendorId());
			ps.setString(2, p.getPartNumber());
			ps.setString(3, p.getName());
			ps.setDouble(4, p.getPrice());
			ps.setString(5, p.getUnit());
			ps.setString(6, p.getPhotoPath());
			ps.executeUpdate();
			return true;

		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}

//	public boolean update(Product p) {
//        String sql = "UPDATE Products SET "
//                + "  Description = ?, "
//                + "  Price = ? "
//                + "WHERE ProductCode = ?";
//		try (Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
//         ps.setString(1, p.getDescription());
//         ps.setDouble(2, p.getPrice());
//         ps.setString(3, p.getCode());
//         ps.executeUpdate();
//         return true;
//     } catch (SQLException e) {
//         System.err.println(e);
//         return false;
	
	public boolean delete(Product p) {
		String sql = "DELETE FROM Products " + "WHERE Name = ?";
		try (Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setString(1, p.getName());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}
}