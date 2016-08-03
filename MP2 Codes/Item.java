/** This class will get the information for an item in the vending machine.
 * @author: Giselle Nodalo
 * @author: Amiel Bornales
 * @ Version: 1.0
 * Date Created: July 31, 2016
 */

public class Item
{
	
	
	public Item(Item prod){
		this(prod); 
	}
	public Item(String prod, int cost, int cal)
	{
		setName(prod);
		setPrice(cost);
		setCalories(cal);
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setPrice(int price){
		if(price > 0)
			this.price = price;
		else 
			this.price = 0; 
	}
	
	public int getPrice(){
		return price; 
	}
	
	public void setCalories(int cal){
		if(cal >= 0)
			calories = cal;
		else
			calories = 0; 
	}
	
	public int getCal(){
		return calories; 
	}
	
	private String name;
	private int price;
	private int calories;
} 