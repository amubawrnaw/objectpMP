public class ItemAttributes
{
	public ItemAttributes()
	{
		price = 0;
		name = "Empty";
		calories = 0;
	}
	public void setCalories(int calories)
	{
		if (calories > 0)
			this.calories = calories;
	}
	public void setName(String name)
	{
		if (name.length() > 0)
			this.name = name;
	}
	public void setPrice(double price)
	{
		if (price > 0)
			this.price = price;
	}
	public int getCal()
	{
		return calories;
	}
	public String getName()
	{
		return name;
	}
	public double getPrice()
	{
		return price;
	}
	
	
	private double price;
	private String name;
	private int calories;
}