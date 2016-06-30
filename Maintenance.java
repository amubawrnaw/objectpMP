/**Maintenance Class
 * This class will carry out the maintenance for
 * the Regular Vending Machine - Halo Halo
 * MP Phase 1
 *@author: Amiel Bornales
 *@author: Giselle Nodalo
 *@date: June 22, 2016
 *Section: S17B
 */

public class Maintenance
{
	/**This method will reprice an item
	  *in the vending machine.
	  *@param item contains the item price to be modified
	  *@param newPrice is the new price of the item
	  */
	public void Reprice(ItemAttributes item, double newPrice){
		item.setPrice(newPrice);
	}
	
	/**This method will restock an item
	  *of the vending machine.
	  * @param prod is the item to be restock
	  * @param stock is the items that are going to be added
	  * @param count is the amount of the item to be added
	  */
	public void Restock(ItemAttributes prod, ItemAttributes[10] stock, int count){
		do{
			if((stock.length + count) <= 10){
				for(int i = stock.length -1; i < stock.length + count; i++)
					stock[i] = prod;
	
			}
			else{ //too much restock supply
				System.out.println("Too much for restocking.");
				System.out.println("Can fit" + (10 - stock.length) + " " +
						prod.getName() + " items.");
				for(int j = stock.length -1; j < 10; i++)
					stock[j] = prod;
			}
		}while(stock.length <= 10);	
	}

}
