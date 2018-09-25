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

	public List<Product> getAll() {
		String sql = "SELECT * FROM  Product";
		List<Product> products = new ArrayList<>();
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Product p = getProductFromResultSet(rs);
				products.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	public Product getProduct(int pid) {
		String sql = "SELECT * FROM  Product WHERE ID =?";
		Product product = null;
		try (Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(sql);) {
			ps.setInt(1, pid);
			ResultSet rs = ps.executeQuery(); // need to move out of try statement when we use a WHERE statement.
			while (rs.next()) {
				product = getProductFromResultSet(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return product;
	}

	private Product getProductFromResultSet(ResultSet rs) throws SQLException {
		int id = rs.getInt(1);
		int vendorID = rs.getInt(2);
		String partNumber = rs.getString(3);
		String name = rs.getString(4);
		double price = rs.getDouble(5);
		String unit = rs.getString(6);
		String photoPath = rs.getString(7);
		Product p = new Product(id, vendorID, partNumber, name, price, unit, photoPath);
		return p;
	}

	public boolean add(Product p) {
		String sql = "INSERT INTO Product (vendorID, partNumber, name, price) " + "VALUES (?, ?, ?, ?)";
		try (Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
			ps.setInt(1, p.getVendorID());
			ps.setString(2, p.getPartNumber());
			ps.setString(3, p.getName());
			ps.setDouble(4, p.getPrice());
			// as unit and photoPath are nullable, you don't necessarily need to include
			// here.
			ps.executeUpdate();
			return true;

		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}
	
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