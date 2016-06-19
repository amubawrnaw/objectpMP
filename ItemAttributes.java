public class ItemAttributes
{
	private int stock;
	private double price;
	private String name;
	
	public ItemAttributes()
	{
		stock = 0;
		price = 0;
		name = "Empty";
	}
	public void restock (int stock)
	{
		if (stock > 0)
			this.stock = stock;
	}
	public void setName(String name);
	{
		if (name.length() > 0)
			this.name = name;
	}
	public void rePrice(double price)
	{
		if (price > 0)
			this.price = price;
	}
	public void bought()
	{
		if (stock >0)
			stock--;
		else System.out.println("Not Available!");
	}
}