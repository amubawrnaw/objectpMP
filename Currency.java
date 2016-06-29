public class Currency 
{	
	public Currency()
	{
		Profit = 0;
		Pesos_1 = 0;
		Pesos_5 = 0;
		Pesos_10 = 0;
		Pesos_20 = 0;
		Pesos_50 = 0;
	}
	
	public boolean check_supply (int money)
	{
		int Pesos;
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
	
	public void set_change (int money)//calls change class
	{
		int i;//im sorry giselle xd
		for (i = 0;Pesos_50 > 0 && money > 50;i++, money-=50);
		if (i!=0) change.setChange(i,50);
		for (i = 0;Pesos_20 > 0 && money > 20;i++, money-=20);
		if (i!=0) change.setChange(i,20);
		for (i = 0;Pesos_10 > 0 && money > 10;i++, money-=10);
		if (i!=0) change.setChange(i,10);
		for (i = 0;Pesos_5 > 0 && money > 5;i++, money-=5);
		if (i!=0) change.setChange(i,5);
		for (i = 0;Pesos_1 > 0 && money > 1;i++, money-=1);
		if (i!=0) change.setChange(i,1);
		if (money > 0)
			System.out.println("Not enough change!");
	}
	
	public int getMoney()//returns profit
	{
		return Profit;
	}
	public void printChange()
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
	
	private int Pesos_1;
	private int Pesos_5;
	private int Pesos_10;
	private int Pesos_20;
	private int Pesos_50;
	private int profit;
	private Change change;
}



















