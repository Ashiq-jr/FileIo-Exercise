package product;


public class Product {
		
	String id;
	String name;
	String category;
	String unitPrice;
	String taxSlab;
	String status;
	
	public Product(String id, String name, String category, String unitPrice, String taxSlab, String status) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.unitPrice = unitPrice;
		this.taxSlab = taxSlab;
		this.status = status;
	}

	
	public String getId() {
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
	public String getTaxSlab() {
		return taxSlab;
	}
	public String getStatus() {
		return status;
	}




}
