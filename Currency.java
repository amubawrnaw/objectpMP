public class Currency
{
	private int Pesos_1;
	private int Pesos_5;
	private int Pesos_10;
	private int Pesos_20;
	private int Pesos_50;
	
	public Currency()
	{
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

}