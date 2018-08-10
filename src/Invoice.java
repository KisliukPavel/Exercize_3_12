public class Invoice {
	private String partNumber;
	private String partDescription;
	private Integer quantity_Of_The_Item_Being_Purchased;
	private Double price_Per_Item;

	public Invoice(String partNumber, String partDescription, Integer quantity_Of_The_Item_Being_Purchased, Double price_Per_Item)
	{
		this.partNumber = partNumber;
		this.partDescription = partDescription;
		this.quantity_Of_The_Item_Being_Purchased = (quantity_Of_The_Item_Being_Purchased >= 0) ? quantity_Of_The_Item_Being_Purchased : 0;
		this.price_Per_Item = (price_Per_Item >= 0) ? price_Per_Item : 0.0;
	}

	public Invoice()
	{
		this(null, null, 0, 0.0);
	}

	//set methods
	public void setpartNumber(String partNumber)
	{
		this.partNumber = partNumber;
	}

	public void setpartDescription(String partDescription)
	{
		this.partDescription = partDescription;
	}

	public void setquantity_Of_The_Item_Being_Purchased(Integer quantity_Of_The_Item_Being_Purchased)
	{
		this.quantity_Of_The_Item_Being_Purchased = quantity_Of_The_Item_Being_Purchased;
	}

	public void setprice_Per_Item(Double price_Per_Item)
	{
		this.price_Per_Item = price_Per_Item;
	}

	//get methods
	public String getpartNumber()
	{
		return this.partNumber;
	}

	public String getpartDescription()
	{
		return this.partDescription;
	}

	public Integer getquantity_Of_The_Item_Being_Purchased()
	{
		return this.quantity_Of_The_Item_Being_Purchased;
	}

	public Double getprice_Per_Item()
	{
		return this.price_Per_Item;
	}

	//in addition calculates the invoice amount (i.e., multiplies the quantity by the price per item)
	public Double getInvoiceAmount()
	{
		return this.quantity_Of_The_Item_Being_Purchased * this.price_Per_Item;
	}
}
