package com.db.cartsystem;

import java.util.ArrayList;
import java.util.List;



public class ItemDAO extends AbstractDAO{
	@SuppressWarnings("finally")
	public List<Item> getAllItems() {
		List<Item> items=new ArrayList<Item>();
		try {
			this.connect();
			ps=connection.prepareStatement("select * from item");
			rs=ps.executeQuery();
			while (rs.next()) {
				Item item=new Item();
				item.setId(rs.getInt(1));
				item.setName(rs.getString(2));
				item.setPrice(rs.getFloat(3));
				items.add(item);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			this.dispose();
			return items;
		}
	}
	public void addItem(Item i) {
		try {
			this.connect();
			ps=connection.prepareStatement("insert into item(name,price) values(?,?)");
			ps.setString(1, i.getName());
			ps.setFloat(2, i.getPrice());
			int c=ps.executeUpdate();
			if (c>0) {
				System.out.println("Item Added");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			this.dispose();
		}
	}
	public void removeById(int id) {
		try {
			this.connect();
			ps=connection.prepareStatement("delete from item where id=?");
			ps.setInt(1, id);
			int c=ps.executeUpdate();
			if (c>0) {
				System.out.println("Item Deleted");
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
