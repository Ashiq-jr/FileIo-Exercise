import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import product.Product;

public class App {

	public static void main(String[] args) throws IOException {
		
		// Loading the File Data into HashMap(Product Id, Product).
		
//		HashMap<Integer, Product> tm = new HashMap<Integer, Product>();
//		Product p = new Product();
//		try {
//			tm = p.loadData();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		
//		// Testing the HashMap For Data.
//		
//		for(Integer x : tm.keySet())
//		{
//			Product p1 = tm.get(x);
//			System.out.println(p1);
//		}
		
		
		// Method to Return Product Object Given Product Id As Input
		
//		Product product = new Product();
//		
//		try {
//			product = product.getProductUsingId(111);
//			if(product.getName() != null)
//			{
//				System.out.println(product);
//			}
//			
//		} catch (NullPointerException e) {
//			System.out.println("Invalid Key");
//		}
		
		
		// Method to Return Product Object Given Product Name As Input
		
//		Product product = new Product();
//		
//		try {
//			product = product.getProductUsingName("BallPointPen");
//			if(product.getName() != null)
//			{
//				System.out.println(product);
//			}			
//		} catch (NullPointerException e) {
//			System.out.println("Invalid Product Name ");
//		}
//		
		
		// Method to Return Product List 
		
		Product product = new Product();
//		List<Product> list = product.getProductList();
//		
//		for(Product x : list)
//		{
//			System.out.println(x);
//		}
		
		// Method to Add Product
		
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
//		sc.close();
		
		
		
		//Method to Edit UnitPrice and Tax Slab
		
//		if(product.doesTheIdExists(104) && product.doesTheTaxSlabExists("Low"))
//		{
//			product.editUnitPriceAndTaxSlab(104, "5", "Low");
//			System.out.println("Unit Price and Tax Slab Updated.");
//		}
//		else
//		{
//			System.out.println("Invalid Id/Slab");
//		}
//		
		
		// To Check And Update the Status of The Product
		
//		String status = product.checkStatusUsingId(102);
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
//		Scanner sc = new Scanner(System.in);
//		if(sc.nextInt() == 1)
//		{
//			product.updateTheStatus(102);
//			System.out.println("Updated the Status of the Product ");
//		}
//		sc.close();
		
		
		// Methods to Get The Name List of Active Products and List of DisContinued Products
		
		List<String> actList= product.getActiveProductsList();
		
		System.out.println(actList);
		
		List<String> disConList= product.getDisContinuedProductsList();
		
		System.out.println(disConList);
		
	
		
		
		
		
		

		
		

	}

}
