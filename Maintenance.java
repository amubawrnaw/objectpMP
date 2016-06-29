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
	
	public void Restock(ItemAttributes prod, ItemAttributes[] stock, int count)

}