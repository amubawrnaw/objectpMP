/**Maintenance Class
 * This class will carry out the maintenance for
 * the Regular Vending Machine - Halo Halo
 * MP Phase 1
 *@author: Amiel Bornales
 *@author: Giselle Nodalo
 *@version 1.0 06/22/16
 *Section: S17B
 */

public class Maintenance
{
	/**This method will reprice an item
	  *in the vending machine.
	  *@param item 		the item price to be modified
	  *@param newPrice 	the new price of the item
	  */
	  
	public void Reprice(ItemAttributes item, double newPrice){
		item.setPrice(newPrice);
	}
	
	/**This method will restock an item
	  *of the vending machine.
	  * @param prod		the item to be restock
	  * @param stock 	the items that are going to be added
	  * @param count	the amount of the item to be added
	  */
	
	public void Restock(int tray, int slot, ItemAttributes prod, ItemAttributes[][][] stock, int count, int size){
		if((size + count) <= 10){
			
			if (size == 0){
				size++;
				count--;
			}	
			for(int i = size - 1; i < size + count; i++)
				stock[tray][slot][i] = prod;

		}
		else{ //too much restock supply
			System.out.println("Too much for restocking.");
			System.out.println("Can fit " + (10 - size) + " " +
					prod.getName() + " items.");
			for(int j = size -1; j < 10; j++)
				stock[tray][slot][j] = prod;
		}
	}
	public String getProfit(Currency currency)
	{
		System.out.println("Retrieving money...");
		return currency.returnProfit();
	}
	
	public void restock_currency(Currency currency,int amount, int peso)
	{
		currency.restock_money(amount,peso);
	}
}