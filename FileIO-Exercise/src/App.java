import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import product.Product;

public class App {

	public static void main(String[] args) throws IOException {
		
		Product product = new Product();
//		
//		
//		// Loading the File Data into HashMap(Product Id, Product).
//		
//		HashMap<Integer, Product> tm = new HashMap<Integer, Product>();
//		try {
//			tm = product.loadData();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		
//		// Testing the HashMap For Data.
//		
//		for(Integer x : tm.keySet())
//		{
//			product = tm.get(x);
//			System.out.println(product);
//		}
//		
//		
//		// Method to Return Product Object Given Product Id As Input		
//		
//		product = product.getProductUsingId(118);
//		if(product.getName() != null)
//		{
//			System.out.println(product);
//		}
//		else
//		{
//			System.out.println("Invalid Id");
//		}		
//		
//		
//		// Method to Return Product Object Given Product Name As Input
//				
//		product = product.getProductUsingName("iphone-13");
//		if(product.getName() != null)
//		{
//			System.out.println(product);
//		}			
//		else
//		{
//			System.out.println("Invalid Product Name ");
//		}
//		
//		
//		// Method to Return Product List 
//		
//		List<Product> list = product.getProductList();
//		
//		for(Product x : list)
//		{
//			System.out.println(x);
//		}
//		
//		// Method to Add Product
//		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter Name : ");
//		String name = sc.nextLine();
//		System.out.println("Enter Category : ");
//		String category = sc.nextLine();
//		System.out.println("Enter Unit Price : ");
//		String price = sc.nextLine();
//		System.out.println("Enter Tax Slab : ");
//		String tax = sc.nextLine();
//		
//		if(product.doesTheNameExists((name)))
//		{
//			System.out.println("Product Already Exists");
//			
//		}
//		else
//		{
//			System.out.println("product added");
//			product.addProduct(name, category, price, tax);
//		}
//		
//		
//		//Method to Edit UnitPrice and Tax Slab
//		
//		if(product.doesTheIdExists(120) && product.doesTheTaxSlabExists("High"))
//		{
//			product.editUnitPriceAndTaxSlab(120, "35", "High");
//			System.out.println("Unit Price and Tax Slab Updated.");
//		}
//		else
//		{
//			System.out.println("Invalid Id/Slab");
//		}
//		
//		
//		// To Check And Update the Status of The Product
//		
//		String status = product.checkStatusUsingId(120);
//		System.out.println(status);
//		if(status.equals("Active"))
//		{
//			System.out.println("press 1 to DisContinue Product");
//		}
//		else if(status.equals("DisContinued"))
//		{
//			System.out.println("press 1 to Activate Product");
//		}
//		else
//		{
//			System.out.println("Invalid ID");
//		}
//		if(sc.nextInt() == 1)
//		{
//			product.updateTheStatus(120);
//			System.out.println("Updated the Status of the Product ");
//		}
//		sc.close();
//		
//		
//		// Methods to Get The Name List of Active Products and List of DisContinued Products
//		
//		List<String> actList= product.getActiveProductsList();
//		
//		System.out.println(actList);
//		
//		List<String> disConList= product.getDisContinuedProductsList();
//		
//		System.out.println(disConList);
		

		
		

	}

}
