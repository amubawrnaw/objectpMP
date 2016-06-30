/*This is the driver class to create and test a 
 *regular vending machine for Halo Halo products
 *@author: Amiel Bornales
 *@author: Giselle Nodalo
 *Date Created: June 29, 2016
 *Section: S17B
 */

import java.util.*;

public class RVMDriver
{
	public ItemAttirbutes createStock(Scanner sc){
		double Price;
		String product;
		int cal;
		ItemAttributes temp = new ItemAttributes();
		
		do{
			System.out.print("Enter Product Name: ");
			Product = sc.nextLine();
		}while(Product.length() == 0);
		
		
		do{
			System.out.print("Enter Product Price: ");
			Price = sc.nextDouble();
		}while(Price < 0);
	
		do{
			System.out.print("Enter Product Calories: ");
			cal = sc.nextInt();
		}while(cal < 0);
		
		temp.setName(Product);
		temp.setPrice(Price);
		temp.setCalories(cal);
	
	}
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		ItemAttributes item = new ItemAttributes();
		RegularVM rvm = new RegularVM();
		
		//Getting input for tray, slot and product
		int i, slot, tray;
		for(i = 0; i < 16){
			do{
				System.out.print("Enter Tray A-H: ");
				tray = s.nextLine().charAt(0);
				System.out.print("Enter Slot [1] or [2]: ");
				slot = s.nextInt();
			}while(rvm.checkSlot(tray, slot));
		
			//Set slot 
			
			
			
		}
		
		
	}
}
