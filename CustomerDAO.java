package com.db.cartsystem;

import java.util.ArrayList;
import java.util.List;



public class CustomerDAO extends AbstractDAO{
	@SuppressWarnings("finally")
	public Customer getCustomerById (int id) {
		Customer customer=new Customer();
		try {
			this.connect();
			ps=connection.prepareStatement("select * from customer where id=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if (rs.next()) {
				customer.setId(rs.getInt(1));
				customer.setEmail(rs.getString(2));
				customer.setFname(rs.getString(3));
				customer.setLname(rs.getString(4));
			}
			else {
				customer=null;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			this.dispose();
			return customer;
		}
	}
	@SuppressWarnings("finally")
	public List<Customer> getAllCustomers() {
		List<Customer> customers=new ArrayList<Customer>();
		try {
			this.connect();
			ps=connection.prepareStatement("select * from customer");
			rs=ps.executeQuery();
			while (rs.next()) {
				Customer customer=new Customer();
				customer.setId(rs.getInt(1));
				customer.setEmail(rs.getString(2));
				customer.setFname(rs.getString(3));
				customer.setLname(rs.getString(4));
				customers.add(customer);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			this.dispose();
			return customers;
		}
	}
	public void addCustomer (Customer c) {
		try {
			this.connect();
			ps=connection.prepareStatement("insert into customer(email,fname,lname) values (?,?,?)");
			ps.setString(1, c.getEmail());
			ps.setString(2, c.getFname());
			ps.setString(3, c.getLname());
			int i=ps.executeUpdate();
			if (i>0) {
				System.out.println("Added new customer");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			this.dispose();
		}
	}
	public void removeCustomerById(int id) {
		try {
			this.connect();
			ps=connection.prepareStatement("delete from customer where id=?");
			ps.setInt(1, id);
			int i=ps.executeUpdate();
			if (i>0) {
				System.out.println("Deleted successfully");
			}
			else {
				System.out.println("Does not exist");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			this.dispose();
		}
	}
}
