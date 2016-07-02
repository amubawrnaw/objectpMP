/**This class will conduct the Currency features for the 
  *Maintenance feature of the Vending Machine
  *@author Amiel Bornales
  *@author Giselle Nodalo
  *@version 1.0 06/26/16
*/
import java.util.*;
public class Currency 
{
	/**
	  *This constuctor will set all profits and denomination stock
	  *to default values
	  */
	public Currency()
	{
		Pesos_1 = 0;
		Pesos_5 = 0;
		Pesos_10 = 0;
		Pesos_20 = 0;
		Pesos_50 = 0;
		profit50 = 0;
		profit20 = 0;
		profit10 = 0;
		profit5 = 0;
		profit1 = 0;
	}
	
	/**This method will check the money supply 
	  *for the maintenance features
	  *@param money		the denomination the supply is to be checked
	  *@return true if Peso supply if there is still supply. false if otherwise
	  */
	public boolean check_supply (int money)
	{
		int Pesos = 0;
		switch (money)
		{
			case 1:Pesos = Pesos_1;break;
			case 5:Pesos = Pesos_5;break;
			case 10:Pesos = Pesos_10;break;
			case 20:Pesos = Pesos_20;break;
			case 50:Pesos = Pesos_50;
		}
		if (Pesos > 0)
			return true;
		else return false;
	}
	
	/**This method will receive the calculated change and computes
	  *for the amount of denomination to be returned.
	  *@param money 	the calculated change after payment
	  */
	public boolean set_change (int money)//calls change class
	{
		int i;
		for (i = 0;Pesos_50 > 0 && money > 50;i++, money-=50,Pesos_50--);
		if (i!=0) change.setChange(i,50);
		for (i = 0;Pesos_20 > 0 && money > 20;i++, money-=20,Pesos_20--);
		if (i!=0) change.setChange(i,20);
		for (i = 0;Pesos_10 > 0 && money > 10;i++, money-=10,Pesos_10--);
		if (i!=0) change.setChange(i,10);
		for (i = 0;Pesos_5 > 0 && money > 5;i++, money-=5,Pesos_5--);
		if (i!=0) change.setChange(i,5);
		for (i = 0;Pesos_1 > 0 && money > 1;i++, money-=1,Pesos_1--);
		if (i!=0) change.setChange(i,1);
		if (money > 0)
			return false;
		return true;
	}
	
	/**This method will reduce the quantity of coins and bills
	  *from the supply of the denomination for the change
	  *@param amount	the quantity of the denomination
	  *@param peso 		the denomiantion
	  */
	public void reduceChange(int amount,int peso)
	{
		switch (peso)
		{
			case 50:Pesos_50 -= amount;break;
			case 20:Pesos_20 -= amount;break;
			case 10:Pesos_10 -= amount;break;
			case 5:Pesos_5 -= amount;break;
			case 1:Pesos_1 -= amount;
		}
	}
	public String cHistory()
	{
		return "\tP50 - " + Pesos_50 + "\n" + "\tP20 - " + Pesos_20 + "\n" + "\tP10 - " + Pesos_10 + "\n" + "\tP5 - " +Pesos_5 + "\n\tP1 - " + Pesos_1;
	}
	public void prtChange()
	{
		change.printChange();
	}
	
	public void restock_money(int amount, int Peso)//restock
	{
		switch (Peso)
		{
			case 1:Pesos_1+=amount;break;
			case 5:Pesos_5+=amount;break;
			case 10:Pesos_10+=amount;break;
			case 20:Pesos_20+=amount;break;
			case 50:Pesos_50+=amount;
		}
	}
	public void addProfit(int amount, int peso)
	{
		switch(peso)
		{
			case 50:profit50 += amount;break;
			case 20:profit20 += amount;break;
			case 10:profit10 += amount;break;
			case 5:profit5 += amount;break;
			case 1:profit1 += amount;
		}
	}
	public int getProfit (int money)
	{
		switch (money)
		{
			case 50: return profit50;
			case 20: return profit20;
			case 10: return profit10;
			case 5: return profit5;
			case 1: return profit1;
			default: return 0;
		}
	}
	public String returnProfit()
	{
		StringBuilder s = new StringBuilder();
		s.append("\tP50: " + profit50 + "\n");
		s.append("\tP20: " + profit20 + "\n");
		s.append("\tP10: " + profit10 + "\n");
		s.append("\tP5: " + profit5 + "\n");
		s.append("\tP1: " + profit1 + "\n");
		s.append("\tTotal:" + (int)((profit50 * 50) + (profit20 * 20) + (profit10 * 10) + (profit5 * 5) + profit1) + ".00");
		profit50 = profit20 = profit10 = profit5 = profit1 = 0;
		return s.toString(); 
	}
	
	
	private int Pesos_1;
	private int Pesos_5;
	private int Pesos_10;
	private int Pesos_20;
	private int Pesos_50;
	private int profit1;
	private int profit5;
	private int profit10;
	private int profit20;
	private int profit50;
	private Change change = new Change();
	
}



















