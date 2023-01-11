package product;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;



enum TaxSlab
{
	No(0), Low(5), Mid(12), High(18), Lux(28);

	private int amount;
	
	TaxSlab(int amount) {
		
		this.amount = amount;
	}
	
	public int getAmount()
	{
		return this.amount;
	}
		        
}

enum Status
{
	Active(0), DisContinued(1);
	
	private int key;

	Status(int key) {
		
		this.key = key;	
	}
	
	public int getKey()
	{
		return this.key;
	}
}


public class Product {
		
	String id;
	String name;
	String category;
	String unitPrice;
	TaxSlab taxSlab;
	Status status;
	
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
	public TaxSlab getTaxSlab() {
		return taxSlab;
	}	
	public Status getStatus() {
		return status;
	}
	public int getTaxSlabAmount(String taxSlab) {
		return TaxSlab.valueOf(taxSlab).getAmount();
	}


	
	
	public Product() {
		
	}
		
	public Product(String id, String name, String category, String unitPrice, TaxSlab taxSlab, Status status) {
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
			Product p = new Product(temp[0], temp[1], temp[2], temp[3], TaxSlab.valueOf(temp[4]), Status.valueOf(temp[5]));
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
	
	
	public List<Product> getProductList()
	{
		HashMap<Integer, Product> tm = new HashMap<Integer, Product>();
		List<Product> prodlist = new ArrayList<Product>();
		Product product = new Product();
		try {
			tm = product.loadData();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for(Integer x : tm.keySet())
		{
			product = tm.get(x);
			prodlist.add(product);
		}
		
		return prodlist;
	}
	
	
	public void addProduct(String name, String category, String unitPrice, String taxSlab) throws IOException
	{
		String path = "C:\\Users\\ashiq\\git\\FileIo-Repository\\FileIO-Exercise\\src\\resources\\product.txt";	
		if(!this.doesTheNameExists(name))
		{
			String status = "Active";
			String id = this.generateNewProductID();
			FileWriter writer = new FileWriter(path,true);
			writer.write("\n" + id + "|" + name + "|" + category + "|" + unitPrice + "|" + TaxSlab.valueOf(taxSlab) + "|" + Status.valueOf(status));
			writer.close();
		}
		
				
	}
	
	
	public List<String> getNameList()
	{
		List<String> nameList = new ArrayList<String>();
		List<Product> prodList = this.getProductList();
		
		for(Product x : prodList)
		{
			nameList.add(x.getName());			
		}
		
		return nameList;
	}
	
	public List<String> getIdList()
	{
		List<String> idList = new ArrayList<String>();
		List<Product> prodList = this.getProductList();
		
		for(Product x : prodList)
		{
			idList.add(x.getId());			
		}
		
		return idList;
	}
	
	
	public boolean doesTheNameExists(String name)
	{
		List<String> nameList = this.getNameList();
		for(String x : nameList)
		{
			if(x.equals(name))
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean doesTheIdExists(int id)
	{
		List<String> idList = this.getIdList();
		for(String x : idList)
		{
			if(x.equals(String.valueOf(id)))
			{
				return true;
			}
		}
		return false;
	}
	
	
	public String generateNewProductID()
	{
		List<Product> prodList = this.getProductList();
		String id = "";
		
		for(Product x : prodList)
		{
			id = x.getId();			
		}
		String tempId = String.valueOf(Integer.parseInt(id) + 1);
		return tempId;
		
	}	
	
	public void editUnitPriceAndTaxSlab(int id, String unitPrice, String taxSlab) throws IOException
	{
		if(this.doesTheIdExists(id))
		{
			String newDetails = "";		
			Path path = Paths.get("C:\\Users\\ashiq\\git\\FileIo-Repository\\FileIO-Exercise\\src\\resources\\product.txt");
			List<String> lines = Files.readAllLines(path);
		
			Product pr = this.getProductUsingId(id);
			newDetails += pr.getId() + "|" + pr.getName() + "|" + pr.getCategory() + "|" + unitPrice + "|" + taxSlab + "|" + pr.getStatus();
			lines.set(id-101, newDetails);
			
			Files.write(path, lines);
		}
		
	}
	
	
	
	@Override
	public String toString()
	{
		return this.id +  " " + this.name + " " + this.category + " " + this.unitPrice + " " + this.taxSlab + " " + this.status;
	}
	
	


	
}
