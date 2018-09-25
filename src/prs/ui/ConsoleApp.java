package prs.ui;

import java.util.ArrayList;
import java.util.List;

import prs.business.Product;
import prs.business.ProductDB;
import prs.util.Console;

public class ConsoleApp {

	public static void main(String[] args) {

		System.out.println("Welcome to te PRS Console App = JDBC");
		ProductDB pdb = new ProductDB();
		String command = "";
		while (!command.equals("9")) {
			displayMenu();
			command = Console.getString("Enter a command: ");
			if (command.equals("1")) {
				List<Product> products = pdb.getAll();

				for (Product p : products) {
					System.out.println(p);
				}
			}
			else if (command.equals("2")) {
				int pid = Console.getInt("Enter product ID: ");
				Product product = pdb.getProduct(pid);

				if (product != null) {
					System.out.println(product);
				} else {
					System.out.println("No product matching id: " + pid);
				}
			}
			else if (command.equals("3")) {
				// Get vendorID, partNumber, name, price from user
				int vendorID = Console.getInt("Enter vendor ID: ");
				String partNumber = Console.getString("Enter part number: ");
				String name = Console.getString("Enter part name: ");
				double price = Console.getDouble("Enter price: ");	
				Product product = new Product(vendorID, partNumber, name, price);
				
				if (pdb.add(product)) {
						System.out.println("Product added successfully.");
				}
				else {
					System.out.println("Error adding product");
				}

			}
//			System.out.println("Result of search:");
//			for (Product p : products) {
//				System.out.println(p);

			System.out.println("bye");
		}
	}

	private static void displayMenu() {
		StringBuilder sb = new StringBuilder("Command Menu:\n");
		sb.append("1 - List all Products\n");
		sb.append("2 - Get a Product\n");
		sb.append("3 - Add a Product\n");
		sb.append("4 - Update a Product\n");
		sb.append("5 - Remove a Product\n");
		sb.append("9 - Exit\n");
		System.out.println(sb.toString());

	}

}
