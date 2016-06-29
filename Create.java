/*This class will assign inputs to vending machine 
 *slots to for creating the Regular Vending Machine.
 *@author: Amiel Bornales
 *@author: Giselle Nodalo
 *Date Created: June 29, 2016
 *Version. 1.0.
 *Section S17B
 */

public class Create{
	

	
	/**This method will set the product
	  *for a slot in the svending Machine
	  *@param tray_num is the 
	  *@param slot_num is the colunm number the product is stored in
	  *@param product is the name of the product
	  */
	public void setSlot(int tray_num, int slot_num, ItemAttributes product){
		items[tray_num][slot_num] = product;
	}
	
	private int slot; //column of the vending machine
	private int tray; // row of the vending machine
	private ItemAttributes[][] items[]ssss;
}