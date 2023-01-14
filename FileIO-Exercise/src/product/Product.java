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
		
	int id;
	String name;
	String category;
	String unitPrice;
	TaxSlab taxSlab;
	Status status;	
	
	static String path = "C:\\Users\\ashiq\\git\\FileIo-Repository\\FileIO-Exercise\\src\\resources\\product.txt\\";
	static HashMap<Integer, Product> hMap = new HashMap<Integer, Product>();
	static List<Product> prodList = new ArrayList<Product>();
	static List<String> nameList = new ArrayList<String>();
	static List<Integer> idList = new ArrayList<Integer>();
	static List<String> actList = new ArrayList<String>();
	static List<String> disConList = new ArrayList<String>();
	

	//Getter for Fields
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getCategory() {
		return category;
	}
	public String getUnitPrice() {
		return unitPrice;
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


	
	//Constructors
	
	public Product() {
		
	}
		
	public Product(int id, String name, String category, String unitPrice, TaxSlab taxSlab, Status status) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.unitPrice = unitPrice;
		this.taxSlab = taxSlab;
		this.status = status;
	}
	
	
	//Method to Load Data From File into A HashMap
	
	public HashMap<Integer, Product> loadData() throws FileNotFoundException
	{
		File file = new File(path);
		Scanner sc = new Scanner(file);
		while(sc.hasNext())
		{
			String[] temp = sc.nextLine().split("\\|");
			Product p = new Product(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3], TaxSlab.valueOf(temp[4]), Status.valueOf(temp[5]));
			int id = p.getId();
			hMap.put(id, p);
		}
		sc.close();
		return hMap;

	}
	
	//Method to Get Object of A Particular Product Using the Product Id.
	
	public Product getProductUsingId(int id)
	{
		Product product = new Product();
		try {
			hMap = product.loadData();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for(Integer x : hMap.keySet())
		{
			if(hMap.containsKey(id))
			{
				if(id == x)
				{
					product = hMap.get(x);
				}
			}
		}
		
		return product;
		
	}
	
	//Method to Get Object of A Particular Product Using the Name.
	
	public Product getProductUsingName(String name)
	{
		Product product = new Product();
		Product tempProduct = new Product();
		try {
			hMap = product.loadData();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for(Integer x : hMap.keySet())
		{
			product = hMap.get(x);
			
			if(product.getName().equals(name))
			{
				tempProduct = product;
			}
		}
		return tempProduct;	
				
	}
	
	// Method to Load List of Product Objects 
	
	public List<Product> getProductList()
	{
		Product product = new Product();
		try {
			hMap = product.loadData();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for(Integer x : hMap.keySet())
		{
			product = hMap.get(x);
			prodList.add(product);
		}
		
		return prodList;
	}
	
	// Method to Add New Product
	
	public void addProduct(String name, String category, String unitPrice, String taxSlab) throws IOException
	{
		if(!this.doesTheNameExists(name))
		{
			String status = "Active";
			int id = this.generateNewProductID();
			FileWriter writer = new FileWriter(path,true);
			writer.write("\n" + id + "|" + name + "|" + category + "|" + unitPrice + "|" + TaxSlab.valueOf(taxSlab) + "|" + Status.valueOf(status));
			writer.close();
		}		
				
	}
	
	// Method to Get the Name List of All the Products
	
	public List<String> getNameList()
	{
		prodList.clear();
		prodList = this.getProductList();
		
		for(Product x : prodList)
		{
			nameList.add(x.getName());			
		}
		
		return nameList;
	}
	
	// Method to Get the Id List of All the Products
	
	public List<Integer> getIdList()
	{	
		prodList.clear();
		prodList = this.getProductList();
		for(Product x : prodList)
		{
			idList.add(x.getId());			
		}
		
		idList.sort(null);
		return idList;
	}
	
	// Method to Check if a Product Name Exists
	
	public boolean doesTheNameExists(String name)
	{
		nameList.clear();
		nameList = this.getNameList();
		for(String x : nameList)
		{
			if(x.equals(name))
			{
				return true;
			}
		}
		return false;
	}
	
	// Method to Check if a Product Id Exists
	
	public boolean doesTheIdExists(int id)
	{
		idList.clear();
		idList = this.getIdList();
		for(int x : idList)
		{
			if(x == id)
			{
				return true;
			}
		}
		return false;
	}
	
	// Method to Check if the Given Tax Slab Exists
	
	public boolean doesTheTaxSlabExists(String taxSlab)
	{
		TaxSlab[] tList = TaxSlab.values();
		for(TaxSlab x : tList)
		{
			if(x.toString().equals(taxSlab))
			{
				return true;
			}
		}
		return false;
	}
	
	// Method to Check if the Given Status Exists
	
	public boolean doesTheStatusExists(String status)
	{
		Status[] sList = Status.values();
		for(Status x : sList)
		{
			if(x.toString().equals(status))
			{
				return true;
			}
		}
		return false;
	}
	
	// Method to Generate New Product Id Based on the Existing Ones.
	
	public int generateNewProductID()
	{
		int id = 0;
		idList.clear();
		idList = this.getIdList();
		for(int x : idList)
		{
			if(x > id)
			{
				id = x;	
			}
					
		}
		id++;
		return id;
		
	}	
	
	// Method to Edit The Tax Slab And Unit Price of A Existing Product.
	
	public void editUnitPriceAndTaxSlab(int id, String unitPrice, String taxSlab) throws IOException
	{
		if(this.doesTheIdExists(id) && this.doesTheTaxSlabExists(taxSlab))
		{
			String newDetails = "";		
			Path path1 = Paths.get(path);
			List<String> lines = Files.readAllLines(path1);
		
			Product pr = this.getProductUsingId(id);
			newDetails += pr.getId() + "|" + pr.getName() + "|" + pr.getCategory() + "|" + unitPrice + "|" + taxSlab + "|" + pr.getStatus();
			newDetails = newDetails.trim();
			lines.set(id-101, newDetails);
			
			StringBuffer buffer = new StringBuffer();
			FileWriter writer = new FileWriter(path);
			for(int i = 0; i < lines.size(); i++)
			{			
				buffer.append(lines.get(i) + System.lineSeparator());								
			}
			String temp = buffer.toString().trim();
			writer.write(temp);
			writer.close();
			
			
		}
		
	}
	
	// Method to Check the Current Status of A Product Given its Id.
	
	public String checkStatusUsingId(int id)
	{
		String status = "";
		prodList.clear();
		prodList = this.getProductList();
		
		for(Product x : prodList)
		{
			if(x.getId() == id)
			{
				status = x.getStatus().toString();
			}
		}
		
		return status;
	}
	
	// Method to Update the Current Status of A Product Given Its Id.
	
	public void updateTheStatus(int id) throws IOException
	{
		if(this.doesTheIdExists(id))
		{
			String status = this.checkStatusUsingId(id);
			status = status.equals("Active") ? "DisContinued" : "Active";
			
			String newDetails = "";					
			Path path1 = Paths.get(path);
			List<String> lines = Files.readAllLines(path1);
		
			Product pr = this.getProductUsingId(id);
			newDetails += pr.getId() + "|" + pr.getName() + "|" + pr.getCategory() + "|" + pr.getUnitPrice() + "|" + pr.getTaxSlab() + "|" + status;
			newDetails = newDetails.trim();
			lines.set(id-101, newDetails);			

			FileWriter writer = new FileWriter(path);
			StringBuffer buffer = new StringBuffer();
			for(int i = 0; i < lines.size(); i++)
			{			
				buffer.append(lines.get(i) + System.lineSeparator());								
			}
			String temp = buffer.toString().trim();
			writer.write(temp);
			writer.close();
			
		}
		
	}
	
	// Method to Get the List Of Products that is Currently Active.
	
	public List<String> getActiveProductsList()
	{
		prodList.clear();
		prodList = this.getProductList();		
		for(Product x : prodList)
		{
			if(x.getStatus().toString().equals("Active"))
			{
				actList.add(x.getName());
			}
		}
		return actList;
	}
	
	// Method to Get the List Of Products that are DisContinued.
	
	public List<String> getDisContinuedProductsList()
	{
		prodList.clear();
		prodList = this.getProductList();
		for(Product x : prodList)
		{
			if(x.getStatus().toString().equals("DisContinued"))
			{
				disConList.add(x.getName());
			}
		}
		return disConList;
	}
	
	
	
	
	
	@Override
	public String toString()
	{
		return this.id +  " " + this.name + " " + this.category + " " + this.unitPrice + " " + this.taxSlab + " " + this.status;
	}
	
	


	
}
