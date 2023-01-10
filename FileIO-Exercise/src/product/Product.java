package product;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Product {
		
	String id;
	String name;
	String category;
	String unitPrice;
	String taxSlab;
	String status;

	
	public String getId() {
		return id.trim();
	}
	public String getName() {
		return name.trim();
	}
	public String getCategory() {
		return category.trim();
	}
	public String getUnitPrice() {
		return unitPrice.trim();
	}	
	public String getTaxSlab() {
		return taxSlab.trim();
	}
	public String getStatus() {
		return status.trim();
	}

	
	
	public Product() {
		
	}
	
	
	public Product(String id, String name, String category, String unitPrice, String taxSlab, String status) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.unitPrice = unitPrice;
		this.taxSlab = taxSlab;
		this.status = status;
	}
	
	public HashMap<Integer, Product> loadData() throws FileNotFoundException
	{
		HashMap<Integer, Product> hm = new HashMap<Integer, Product>();
		String path = "C:\\Users\\ashiq\\git\\FileIo-Repository\\FileIO-Exercise\\src\\resources\\product.txt";
		File file = new File(path);
		Scanner sc = new Scanner(file);
		while(sc.hasNext())
		{
			String[] temp = sc.nextLine().split("\\|");
			Product p = new Product(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5]);
			String idTemp = p.getId();
			int id = Integer.parseInt(idTemp.trim());
			hm.put(id, p);
		}
		sc.close();
		return hm;

	}
	
	
	public Product getProductUsingId(int id)
	{
		HashMap<Integer, Product> tm = new HashMap<Integer, Product>();
		Product product = new Product();
		try {
			tm = product.loadData();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for(Integer x : tm.keySet())
		{
			if(tm.containsKey(id))
			{
				if(id == x)
				{
					product = tm.get(x);
				}
			}
		}
		
		return product;
		
	}
	
	public Product getProductUsingName(String name)
	{
		HashMap<Integer, Product> tm = new HashMap<Integer, Product>();
		Product product = new Product();
		Product tempProduct = new Product();
		try {
			tm = product.loadData();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for(Integer x : tm.keySet())
		{
			product = tm.get(x);
			
			if(product.getName().equals(name))
			{
				tempProduct = product;
			}
		}
		return tempProduct;	
		
		
	}
		
	
	@Override
	public String toString()
	{
		return this.id +  " " + this.name + " " + this.category + " " + this.unitPrice + " " + this.taxSlab + " " + this.status;
	}
	
	


	
}
