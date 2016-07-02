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
	public void cls(String clear)
	{
			System.out.println(clear);
	}
	public ItemAttributes createStock(Scanner sc, int i){
		double Price;
		String product;
		int cal;
		ItemAttributes temp = new ItemAttributes();
		sc.nextLine();
		do{
			System.out.print("\tEnter Product Name #" + (i + 1) + " : ");
			product = sc.nextLine();
		}while(product.length() == 0);
		
		
		do{
			System.out.print("\tEnter Product Price: P");
			Price = sc.nextDouble();
		}while(Price < 0 || Price > 50);
		
		do{
			System.out.print("\tEnter Product Calories: ");
			cal = sc.nextInt();
		}while(cal < 0);
		
		temp.setName(product);
		temp.setPrice(Price);
		temp.setCalories(cal);
		return temp;
	}
	public void buyItem(Scanner sc, RegularVM rvm, RVMDriver d, String clear, StringBuilder sHist, StringBuilder cHist)
	{
		int input, i,sum = 0,slot, change, trayNum;
		int [] temp = new int[5];
		for (i=0;i<5;i++)
			temp[i]= 0;
		char tray;
		boolean done = false, enough;
		String itemName;
		do{
			rvm.printPayOptions(sum,temp);
			System.out.print("\tEnter number of P50 bills: ");
			input = sc.nextInt();
			while (input < 0){
				System.out.print("\n\tInvalid amount!: ");
				input = sc.nextInt();
			}temp[0] = input;
			sum += 50*input;
			
			d.cls(clear);
			rvm.printPayOptions(sum,temp);
			
			System.out.print("\tEnter number of P20 bills: ");
			input = sc.nextInt();
			while (input < 0){
				System.out.print("\n\tInvalid amount!: ");
				input = sc.nextInt();
			}temp[1] = input;
			sum += 20*input;
			
			d.cls(clear);
			rvm.printPayOptions(sum,temp);
			
			System.out.print("\tEnter number of P10 coins: ");
			input = sc.nextInt();
			while (input < 0){
				System.out.print("\n\tInvalid amount!: ");
				input = sc.nextInt();
			}temp[2] = input;
			sum += 10*input;
			
			d.cls(clear);
			rvm.printPayOptions(sum,temp);
			
			System.out.print("\tEnter number of P5 coins: ");
			input = sc.nextInt();
			while (input < 0){
				System.out.print("\n\tInvalid amount!: ");
				input = sc.nextInt();
			}temp[3] = input;;
			sum += 5*input;
			
			d.cls(clear);
			rvm.printPayOptions(sum,temp);
			
			System.out.print("\tEnter number of P1 coins: ");
			input = sc.nextInt();
			while (input < 0){
				System.out.print("\n\tInvalid amount!: ");
				input = sc.nextInt();
			}temp[4] = input;
			sum += input;
			
			d.cls(clear);
			rvm.printPayOptions(sum,temp);
			sc.nextLine();
			sc.nextLine();
			d.cls(clear);
			
			rvm.printBuyOptions();
			System.out.print("\n\tEnter Tray Letter: ");
			tray = sc.next().charAt(0);
			while (Character.toUpperCase(tray) >'H' || Character.toUpperCase(tray) <'A'){
				System.out.print("\n\tInvalid Tray Letter!: ");
				tray = sc.next().charAt(0);
			}
			System.out.print("\n\tEnter Tray number: ");
			slot = sc.nextInt();
			while (slot != 1 && slot != 2){
				System.out.print("\n\tInvalid Tray number!: ");
				slot = sc.nextInt();
			}
			trayNum = rvm.toIndex(tray,slot-1);
			if (rvm.retSize(trayNum, slot-1) != 0)
			{
				d.cls(clear);
				itemName = rvm.getData(trayNum, slot-1).getName();
				change = sum - (int)rvm.getData(trayNum, slot-1).getPrice();
				if (change < 0){
					System.out.println("\tInsufficient funds! you lack P" + (change * -1) +"!");
					System.out.println("\n Returned:");
					if (temp[0] != 0) System.out.println("P50 : "+ temp[0]);
					if (temp[1] != 0) System.out.println("P20 : "+ temp[1]);
					if (temp[2] != 0) System.out.println("P10 : "+ temp[2]);
					if (temp[3] != 0) System.out.println("P5 : "+ temp[3]);
					if (temp[4] != 0) System.out.println("P1 : "+ temp[4]); 
				}
				else {
						if (change > 0)
					{
						System.out.println("\tDispensing " + itemName + "...");
						System.out.println("\t" + itemName + " Dispensed!" );
							enough = rvm.setChange(change);
							rvm.printChange();
							if (!enough)
								System.out.println("\tSorry we dont have enough change!");
					}
					if (change == 0)
					{
						System.out.println("\tThank you for giving the exact amount!");
						rvm.reduce_stock(trayNum, slot-1);
					}
					rvm.sHistory(sHist);
					rvm.cHistory(cHist);
					rvm.setPay(temp[0],50);
					rvm.setPay(temp[1],20);
					rvm.setPay(temp[2],10);
					rvm.setPay(temp[3],5);
					rvm.setPay(temp[4],1);
					rvm.reduce_stock(trayNum,slot-1);
				}
					sum = 0;
					for (i = 0; i < 5; i++)
						temp[i] = 0;
			}
			else System.out.println("\tThis item is currently out of stock!");
			System.out.println("\tWould you like anything else?: \n\t 1. Yes \n\t 2. No");
			input = sc.nextInt();
			while(input != 1 && input != 2){
				System.out.println("\tInvalid Option! :");
				input = sc.nextInt();
			}
			if (input == 2)
				done = true;
			
		}while (!done);
	}
	public void maint(Scanner sc, RegularVM rvm, RVMDriver d, String clear, StringBuilder sHist, StringBuilder cHist)
	{
		int input, qty, denom, tray, slot;
		boolean exit = false;
		char c;
		do{
			rvm.printMaintOptions();
			input = sc.nextInt();
			while(input < 0 || input > 7)
			{
				System.out.println("\tInvalid input!");
				input = sc.nextInt();
			}
			d.cls(clear);
			switch (input)
			{
				case 1: 
						rvm.printItems();
						System.out.println("Enter Tray letter: ");
						c = sc.next().charAt(0);
						while (Character.toUpperCase(c) >'H' || Character.toUpperCase(c) <'A'){
							System.out.println("Invalid tray letter!: ");
							c = sc.next().charAt(0);
						}
						System.out.println("Enter Tray num: ");
						slot = sc.nextInt();
						while (slot!= 1 && slot!= 2){
							System.out.println("Invalid tray num!");
							slot = sc.nextInt();
						}
						System.out.println("Enter quantity: ");
						qty = sc.nextInt();
						while ( qty  < 0 || qty > 10){
							System.out.println("Invalid Quantity!: ");
							qty = sc.nextInt();
						}
						rvm.m_restock_items(rvm.toIndex(c,slot-1),slot-1,qty); 
						rvm.sHistory(sHist);
						System.out.println("Restocking Successful!");
						break;
				case 2: 
						System.out.println("Enter denomination to be replenished(1-5-10-20-50): ");
						denom = sc.nextInt();
						while (denom !=1 && denom != 5 && denom != 10 && denom != 20 && denom != 50){
							System.out.println("Invalid denomination!: ");
							denom = sc.nextInt();
						}
						System.out.println("Enter quantity of P" + denom + " to be added");
						qty = sc.nextInt();
						while (qty < 0){
							System.out.println("Invalid quantity!");
							qty = sc.nextInt();
						}
						rvm.m_restock_currency(qty,denom); 
						System.out.println("Restocking Successful!");
						rvm.cHistory(cHist);
						break;
				case 3: 
						System.out.println(rvm.sHistory(sHist).toString());
						break;
				case 4: 
						System.out.println(rvm.cHistory(cHist).toString());
						break;
				case 5: 
						System.out.println(rvm.get_profit());
						break;
				case 6: 
						rvm.viewStocks();
						break;
				case 7: exit = true;
			}
			sc.nextLine();
			sc.nextLine();
			d.cls(clear);
		}while(!exit);
	}
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		ItemAttributes item = new ItemAttributes();
		RegularVM rvm = new RegularVM();
		RVMDriver d = new RVMDriver ();
		StringBuilder sb = new StringBuilder();
		StringBuilder cHist = new StringBuilder();
		StringBuilder sHist = new StringBuilder();
		//Getting input for tray, slot and product
		int i, slot,stock,tray_index, menu, testSelect, input;
		boolean exit = false;
		for (i=0; i <55; i++)
			sb.append("\n");
		
		char tray;
		String name,clear = sb.toString();
		do{
			for (i=0; i < 18 ; i++)
				if (i == 0 || i == 17)
					System.out.print("+");
				else System.out.print("-");
			System.out.println("");
			for (i=0; i < 18 ; i++)
				if (i == 0 || i == 17)
					System.out.print("|");
				else System.out.print(" ");
			System.out.println("");
			System.out.println("|  1. Create VM  |");
			System.out.println("|  2. Test VM    |");
			System.out.println("|  3. Exit       |");
			for (i=0; i < 18 ; i++)
				if (i == 0 || i == 17)
					System.out.print("|");
				else System.out.print(" ");
			System.out.println("");
			for (i=0; i < 18 ; i++)
				if (i == 0 || i == 17)
					System.out.print("+");
				else System.out.print("-");
			System.out.println("");
			menu = s.nextInt();
			d.cls(clear);
			if (menu == 1)
			{
				//start of initializing of items
				for(i = 0; i < 16; i++){
					
					d.cls(clear);
					rvm.printCreateLayout();
					item = d.createStock ( s , i );
					do{
						s.nextLine();
						System.out.print("\tEnter Tray A-H: ");
							tray = s.nextLine().charAt(0);
						while(!(Character.toUpperCase(tray)>= 'A' && Character.toUpperCase(tray) <= 'H'))
						{
							System.out.print("\n\tInvalid Tray : ");
							tray = s.nextLine().charAt(0);
						}
						System.out.println("\tEnter Slot [1] or [2]: ");
						
							slot = s.nextInt();
						while(slot!=1&&slot!=2)
						{
							System.out.print("\n\tInvalid Slot : ");
							slot = s.nextInt();
						}
					}while(rvm.checkSlot(rvm.toIndex(tray, slot-1), slot-1));
					System.out.println("\tEnter how much of the item to be stocked (1-10): ");
					do{
						stock = s.nextInt();
					}while(stock > 10 || stock <= 0);
					
					tray_index = rvm.toIndex(tray, slot-1);
					rvm.setSlot(tray_index, slot-1, item, stock);
				}
				//end of initializing of items
				
				System.out.print("\tEnter quantity of P50 bills (0-50): ");
				input = s.nextInt();
				while (input <0 || input >50){
					System.out.print("\n\t Invalid quantity!\n Try again: ");
					input = s.nextInt();
				}rvm.m_restock_currency(input , 50);
			
				System.out.print("\tEnter quantity of P20 bills (0-50): ");
				input = s.nextInt();
				while (input <0 || input >50){
					System.out.print("\n\t Invalid quantity!\n Try again: ");
					input = s.nextInt();
				}
				rvm.m_restock_currency(input , 20);
				
				System.out.print("\tEnter quantity of P10 coins (0-50): ");
				input = s.nextInt();
				while (input <0 || input >50){
					System.out.print("\n\t Invalid quantity!\n Try again: ");
					input = s.nextInt();
				}
				rvm.m_restock_currency(input , 10);
			
				System.out.print("\tEnter quantity of P5 coins (0-50): ");
				input = s.nextInt();
				while (input <0 || input >50){
					System.out.print("\n\t Invalid quantity!\n Try again: ");
					input = s.nextInt();
				}
				rvm.m_restock_currency(input , 5);

				System.out.print("\tEnter quantity of P1 coins (0-50): ");
				input = s.nextInt();
				while (input <0 || input >50){
					System.out.print("\n\t Invalid quantity!\n Try again: ");
					input = s.nextInt();
				}
				rvm.m_restock_currency(input , 1);
			
				System.out.println("\tEnter name of the vending machine: ");
				s.nextLine();
			
					name = s.nextLine();
				while(name.length() == 0)
				{
					System.out.println("\tPlease Enter a name: ");
					name = s.nextLine();
				}
				rvm.setName(name);
				
				d.cls(clear);
				rvm.sHistory(sHist);
				rvm.cHistory(cHist);
				System.out.println("\tVending Machine " + rvm.getName() + " successfuly created!");
				
				
			}
			else if (menu == 2)
			{
				if (rvm.getName() == null)
					System.out.println("\tCreate a vending machine first!");
				else 
				{
					System.out.println("\tSelect vending machine: ");
					System.out.println("\t1. " + rvm.getName());
					System.out.println("\t2. Back");
					testSelect = s.nextInt();
					while(testSelect > 2 || testSelect < 1)
					{
						System.out.println("\tSelect 1 or 2: ");
						testSelect = s.nextInt();
					}
					if (testSelect == 1)
					{
						do{
							d.cls(clear);
							rvm.printTestLayout();
							input = s.nextInt();
							while ( input > 3 || input < 1)
							{
								System.out.print("\n\t Wrong input: ");
								input = s.nextInt();
							}
							d.cls(clear);
							if ( input == 1 )
								d.maint(s, rvm, d, clear, sHist, cHist);
							else if( input == 2 )
								d.buyItem(s, rvm, d, clear, sHist, cHist);
							else if( input == 3 )
								exit = true ; 
							
						}while (!exit);
					}
					d.cls(clear);
				}
			}
		}while (menu != 3);
	}
}