package com.db.cartsystem;
import java.util.Scanner;

public class CartApp {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerDAO customerDAO=new CustomerDAO();
		ItemDAO itemDAO=new ItemDAO();
		System.out.println("Cart App");
		
		String option;
		try {
			do {
				System.out.println("\nMenu");
				System.out.println("1-Add Customer");
				System.out.println("2-Find Customer By Id");
				System.out.println("3-Remove Customer By Id");
				System.out.println("4-Add Item");
				System.out.println("5-Display All Items");
				System.out.println("6-Remove Item By Id");
				System.out.println("7-Show all customers");
				System.out.println("0-To Exit the program");
				Scanner sc=new Scanner(System.in);
				option=sc.next();
				switch (option) {
				case "1":
					Customer c=new Customer();
					System.out.println("Enter an email");
					c.setEmail(sc.next());
					System.out.println("Enter First Name");
					c.setFname(sc.next());
					System.out.println("Enter Last Name");
					c.setLname(sc.next());
					customerDAO.addCustomer(c);
					break;

				case "2":
					System.out.println("Enter the id of customer");
					Customer customer=customerDAO.getCustomerById(sc.nextInt());
					if (customer==null) {
						System.out.println("Does not exists");
					}
					else {
						System.out.printf("%-10s%-5s%-10s%n",customer.getFname(),customer.getLname(),customer.getEmail());
					}
					
					break;
				case "3":
					System.out.println("Enter an id of customer");
					customerDAO.removeCustomerById(sc.nextInt());
					break;
				case "4":
					Item item=new Item();
					System.out.println("Enter name");
					item.setName(sc.next());
					System.out.println("Enter Price");
					item.setPrice(sc.nextFloat());
					itemDAO.addItem(item);
					break;
				case "5":
					java.util.List<Item> items=itemDAO.getAllItems();
					System.out.printf("%-10s%-10s%-10s%n","Id","Name","Price");
					for (Item item2 : items) {
						System.out.printf("%-10s%-10s%-10s%n",item2.getId(),item2.getName(),item2.getPrice());
					}
					break;
				case "6":
					System.out.println("Enter an id");
					itemDAO.removeById(sc.nextInt());
					break;
				case "7":
					java.util.List<Customer> customers=customerDAO.getAllCustomers();
					System.out.printf("%-10s %-20s %-20s %n","Id","Email","Name");
					for (Customer customer2 : customers) {
						System.out.printf("%-10s %-20s %-10s %-5s %n",customer2.getId(),customer2.getEmail(),customer2.getFname(),customer2.getLname());
					}
					break;
				default:
					if (option.equals("0")) {
						System.out.println("Program Closed");
					}
					else {
						System.out.println("Invalid Input");
					}
					
					break;
				}
			} while (!option.equals("0"));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
