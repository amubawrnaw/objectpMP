/**The "Change" class will store how much change
  *is to be returned in Peso. It will also display the
  *change breakdown after customer payment.
  *@author Amiel Bornales and Giselle Nodalo
  *Date Created: June 27, 2016
  *Section: S17B
  */
  
public class Change
{
	/**This constuctor will set the amount of coins and 
	  *bills to default values
	  */ 
	public Change(){
		Coin_1 = 0;
		Coin_5 = 0;
		Coin_10 = 0;
		Bill_20 = 0;
		Bill_50 = 0; 
	}
	
	/**setChange method will will set amount 
	  *to be returned as change after customer
	  *payment.
	  *@param amount is the quantity of denomination
	  *@param Peso is the value of the denomination
	  */
	
	public void setChange(int amount, int Peso){
		switch(Peso)
		{
			case 50: Bill_50 = amount;
				break;
			case 20: Bill_20 = amount;
				break;
			case 10: Coin_10 = amount;
				break;
			case  5: Coin_5 = amount;
				break;
			case  1: Coin_1 = amount;
		}
	}

	public void printChange(){
		if(Coin_1 == 0 && Coin_5 == 0 && Coin_10 == 0 && Bill_20 == 0 && Bill_50 == 0)
			System.out.println("Thank you for giving exact amountz.");
		else
		{
			int money = (Bill_50 * 50) + (Bill_20 * 20) + (Coin_10 * 10) + (Coin_5 * 5) + Coin_1;
			System.out.println("\n\tDispensing Change...\n");
			if(Bill_50 != 0)
				System.out.println("\tP50.00: " + Bill_50);
			if(Bill_20 != 0)
				System.out.println("\tP20.00: " + Bill_20);
			if(Coin_10 != 0)
				System.out.println("\tP10.00: " + Coin_10);
			if(Coin_5 != 0)
				System.out.println("\tP5.00 : " + Coin_5);
			if(Coin_1 != 0)
				System.out.println("\tP1.00 : " + Coin_1);
			System.out.println("\tTotal : P" + money + "\n");
		}
	}
	private int Coin_1;
	private int Coin_5;
	private int Coin_10;
	private int Bill_20;
	private int Bill_50;
}