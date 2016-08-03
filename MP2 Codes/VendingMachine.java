/**This class is the general parent class for the Features of the Vending Machine
 *@author: Giselle Nodalo
 *@author: Amiel Bornales
 *@version: 1.0
 *Date Created: July 31, 2016
 */
 
import java.util.*;
public class VenndingMachine
{
	public void addItems(Item product, int amount){
		for(i = 0; i < amount; i++){
			items[ind][i] = new Item(product);
		}
		ind++;
	}
	
	public Item getItemInfo(){
		return items;
	}
	
	public void dispenseItem(Item product){
		if()
	}
	
	public CoinBox getCoinBox(){
		return money; 
	}
	
	public void restockItem(int amount, int index){
		
		items[index][]
	}
	
	
	
	
	
	private Item[] shelf;
	private Stack<Item> items;
	private CoinBox money;
	private ArrayList<Item> transactions;
	private int pay; 
	private int ind = 0; 
}