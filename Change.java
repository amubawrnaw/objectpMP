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
		System.out.println("Dispensing Change...");
		if(Bill_50 != 0)
			System.out.println("50.00: " + Bill_50);
		else if(Bill_20 != 0)
			System.out.println("20.00: " + Bill_20);
		else if(Coin_10 != 0)
			System.out.println("10.00: " + Coin_10);
		else if(Coin_5 != 0)
			System.out.println("5.00: " + Coin_5);
		else if(Coin_1 != 0)
			System.out.println("1.00: " + Coin_1);
		else
			System.out.println("Thank you for giving exact amount.");
	}
	private int Coin_1;
	private int Coin_5;
	private int Coin_10;
	private int Bill_20;
	private int Bill_50;
	private int Customer_ch;
}