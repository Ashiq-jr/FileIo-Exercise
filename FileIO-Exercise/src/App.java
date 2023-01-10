import java.io.FileNotFoundException;
import java.util.HashMap;

import product.Product;

public class App {

	public static void main(String[] args) {
		
		// Loading the File Data into HashMap(Product Id, Product).
		
		HashMap<Integer, Product> tm = new HashMap<Integer, Product>();
		Product p = new Product();
		try {
			tm = p.loadData();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// Testing the HashMap For Data.
		
		for(Integer x : tm.keySet())
		{
			Product p1 = tm.get(x);
			System.out.println (x + " " + p1.getName() + " " + p1.getCategory() + " " + p1.getUnitPrice() + " " + p1.getTaxSlab() + " " + p1.getStatus());
		}
		

	}

}
