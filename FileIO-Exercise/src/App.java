import java.io.FileNotFoundException;
import java.util.HashMap;

import product.Product;

public class App {

	public static void main(String[] args) {
		
		// Loading the File Data into HashMap(Product Id, Product).
		
//		HashMap<Integer, Product> tm = new HashMap<Integer, Product>();
//		Product p = new Product();
//		try {
//			tm = p.loadData();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		
		// Testing the HashMap For Data.
		
//		for(Integer x : tm.keySet())
//		{
//			Product p1 = tm.get(x);
//			System.out.println(p1);
//		}
//		
		
		// Method to Return Product Object Given Product Id As Input
		
//		Product product = new Product();
//		
//		try {
//			product = product.getProductUsingId(104);
//			if(product.getName() != null)
//			{
//				System.out.println(product);
//			}
//			
//		} catch (NullPointerException e) {
//			System.out.println("Invalid Key");
//		}
		
		
		// Method to Return Product Object Given Product Name As Input
		
		Product product = new Product();
		
		try {
			product = product.getProductUsingName("Lays");
			if(product.getName() != null)
			{
				System.out.println(product);
			}			
		} catch (NullPointerException e) {
			System.out.println("Invalid Product Name ");
		}
		

	}

}
