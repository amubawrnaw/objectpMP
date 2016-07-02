import java.util.*;

public class RegularVM
{
	public RegularVM()
	{
		for (int i = 0 ; i < 8 ; i ++ )
		{
			symbols[i][0] = 'E';
			symbols[i][1] = 'E';
		}
	}
	public boolean checkSlot(int tray, int slot)
	{
		if (tray >= 8)
			tray-=8;
		if (symbols [tray][slot] != 'E')//if slot is filled
			return true;
		else return false;
	}
	public int toIndex(char x, int y)
	{
		int index = 0;
		switch (Character.toUpperCase(x))
		{
			case 'A':index = 0;break;
			case 'B':index = 1;break;
			case 'C':index = 2;break;
			case 'D':index = 3;break;
			case 'E':index = 4;break;
			case 'F':index = 5;break;
			case 'G':index = 6;break;
			case 'H':index = 7;
		}
		return index;
	}
	public void setSlot(int index, int slot_num, ItemAttributes product, int stock){
		if (index >= 8)
			index-=8;
		for (int i = 0; i < stock ; i++)
			items[index][slot_num][i] = product;
		symbols [index][slot_num] = 'X';
		data[index][slot_num] = product;
	}
	public String m_getProfit()
	{
		return maint.getProfit(currency);
	}
	public void m_restock_currency(int amount, int peso)
	{
		maint.restock_currency ( currency, amount, peso);
	}
	public void m_restock_items(int tray, int slot, int count)
	{
		int x = retSize(tray, slot);
		if (tray >=8)
			tray-=8;
		maint.Restock(tray, slot, data[tray][slot], items, count , x);
	}
	public void setName(String name)
	{
		vName = name;
	}
	public String getName()
	{
		return vName;
	}
	public String cutString(String cut)
	{
		if (cut == null)
			return "";
		if (cut.length() <= 13)
			return cut;
		return cut.substring(0,14);
	}
	public String createSpace(String cut,int space)
	{
		int limit = space - cut.length();
		String s = "";
		for (int i= 0;i < limit; i++)
			s = s + " ";
		return s;
	}
	public String cHistory(StringBuilder sb)
	{
		sb.append("\t"+currency.cHistory() + "\n");
		sb.append("\t************\n");
		return sb.toString();
	}
	public String sHistory(StringBuilder sb)
	{
		for (int i = 0 ; i < 8 ; i ++)
		{
			sb.append("\t" + data[i][0].getName() + ": " + retSize(i,0) + createSpace(data[i][0].getName(), 5) + "| " );
			sb.append(data[i][1].getName() + ": " + retSize(i,1)+ "\n");
		}
		sb.append("\t**********************\n");
		return sb.toString();
	}
	public int retSize(int tray, int slot)
	{
		if (tray >= 8)
			tray -= 8;
		for (int i = 9 ; i >= 0; i--)
			if (items[tray][slot][i] != null)
				return i + 1;
		return 0;
	}
	public void setPay(int pay, int denom)
	{
		currency.addProfit(pay, denom);
	}
	public ItemAttributes getData(int tray, int slot)
	{
		if (tray>=8)
			tray-=8;
		return data[tray][slot];
	}
	public ItemAttributes getSupply(int tray, int slot)
	{
		if (tray >= 8)
			tray-=8;
		return items[tray][slot][0];
	}
	public String get_profit()
	{
		return maint.getProfit(currency);
	}
	public boolean setChange(int money)
	{
		int x = money;
		return currency.set_change(x);
	}
	public void printChange()
	{
		currency.prtChange();
	}
	public String printItemNames(int x,int y)
	{
		return cutString(data[x][y].getName()) + createSpace(data[x][y].getName(),13);
	}
	public void reduce_stock(int tray, int slot)
	{
		if (tray >= 8)
			tray -= 8;
		items[tray][slot][retSize(tray,slot) - 1] = null;
	}
	public void printCreateLayout()
	{
		System.out.println("\t+-----------------+-----------------+");
		System.out.println("\t|                                   |");
		System.out.println("\t+-----------------+-----------------+");
		System.out.println("\t| A1:             | A1[" +symbols [0][0]+"]     A2[" +symbols [0][1]+"] |");
		System.out.println("\t| A2:             |                 |");
		System.out.println("\t| B1:             | B1[" +symbols [1][0]+"]     B2[" +symbols [1][1]+"] |");
		System.out.println("\t| B2:             |                 |");
		System.out.println("\t| C1:             | C1[" +symbols [2][0]+"]     C2[" +symbols [2][1]+"] |");
		System.out.println("\t| C2:             |                 |");
		System.out.println("\t| D1:             | D1[" +symbols [3][0]+"]     D2[" +symbols [3][1]+"] |");
		System.out.println("\t| D2:             |                 |");
		System.out.println("\t| E1:             | E1[" +symbols [4][0]+"]     E2[" +symbols [4][1]+"] |");
		System.out.println("\t| E2:             |                 |");
		System.out.println("\t| F1:             | F1[" +symbols [5][0]+"]     F2[" +symbols [5][1]+"] |");
		System.out.println("\t| F2:             |                 |");
		System.out.println("\t| G1:             | G1[" +symbols [6][0]+"]     G2[" +symbols [6][1]+"] |");
		System.out.println("\t| G2:             |                 |");
		System.out.println("\t| H1:             | H1[" +symbols[7][0]+ "]     H2[" +symbols[7][1]+"] |");
		System.out.println("\t| H2:             |                 |");
		System.out.println("\t+-----------------+-----------------+");
	}
	public void printTestLayout()
	{
		System.out.println("\t+-----------------+-----------------+");
		System.out.println("\t|              "+ vName + createSpace(vName,21)+"|");
		System.out.println("\t+-----------------+-----------------+");
		System.out.println("\t| A1:"+ printItemNames(0,0) +"|                 |");
		System.out.println("\t| A2:"+ printItemNames(0,1) +"|                 |");
		System.out.println("\t| B1:"+ printItemNames(1,0) +"+-----------------+");
		System.out.println("\t| B2:"+ printItemNames(1,1) +"|                 |");
		System.out.println("\t| C1:"+ printItemNames(2,0) +"|  1. Maintenance |");
		System.out.println("\t| C2:"+ printItemNames(2,1) +"|                 |");
		System.out.println("\t| D1:"+ printItemNames(3,0) +"+-----------------+");
		System.out.println("\t| D2:"+ printItemNames(3,1) +"|                 |");
		System.out.println("\t| E1:"+ printItemNames(4,0) +"|  2. Buy item    |");
		System.out.println("\t| E2:"+ printItemNames(4,1) +"|                 |");
		System.out.println("\t| F1:"+ printItemNames(5,0) +"+-----------------+");
		System.out.println("\t| F2:"+ printItemNames(5,1) +"|                 |");
		System.out.println("\t| G1:"+ printItemNames(6,0) +"|  3. Back        |");
		System.out.println("\t| G2:"+ printItemNames(6,1) +"|                 |");
		System.out.println("\t| H1:"+ printItemNames(7,0) +"+-----------------+");
		System.out.println("\t| H2:"+ printItemNames(7,1) +"|                 |");
		System.out.println("\t+-----------------+-----------------+");
	}
	public void printPayOptions(int sum, int[] array)
	{
		System.out.println("\t+------------+");
		System.out.println("\tP50 : " + array[0]);
		System.out.println("\tP20 : " + array[1]);
		System.out.println("\tP10 : " + array[2]);
		System.out.println("\tP5 : " + array[3]);
		System.out.println("\tP1 : " + array[4]);
		System.out.println("\t+------------+");
		System.out.println("\t     Total: " + sum );
	}	
	public void printBuyOptions()
	{
		System.out.println("\t+-----------------------+");
		System.out.println("\t A1:"+ printItemNames(0,0) +" : P"+ data[0][0].getPrice());
		System.out.println("\t A2:"+ printItemNames(0,1) +" : P"+ data[0][1].getPrice());
		System.out.println("\t B1:"+ printItemNames(1,0) +" : P"+ data[1][0].getPrice());
		System.out.println("\t B2:"+ printItemNames(1,1) +" : P"+ data[1][1].getPrice());
		System.out.println("\t C1:"+ printItemNames(2,0) +" : P"+ data[2][0].getPrice());
		System.out.println("\t C2:"+ printItemNames(2,1) +" : P"+ data[2][1].getPrice());
		System.out.println("\t D1:"+ printItemNames(3,0) +" : P"+ data[3][0].getPrice());
		System.out.println("\t D2:"+ printItemNames(3,1) +" : P"+ data[3][1].getPrice());
		System.out.println("\t E1:"+ printItemNames(4,0) +" : P"+ data[4][0].getPrice());
		System.out.println("\t E2:"+ printItemNames(4,1) +" : P"+ data[4][1].getPrice());
		System.out.println("\t F1:"+ printItemNames(5,0) +" : P"+ data[5][0].getPrice());
		System.out.println("\t F2:"+ printItemNames(5,1) +" : P"+ data[5][1].getPrice());
		System.out.println("\t G1:"+ printItemNames(6,0) +" : P"+ data[6][0].getPrice());
		System.out.println("\t G2:"+ printItemNames(6,1) +" : P"+ data[6][1].getPrice());
		System.out.println("\t H1:"+ printItemNames(7,0) +" : P"+ data[7][0].getPrice());
		System.out.println("\t H2:"+ printItemNames(7,1) +" : P"+ data[7][1].getPrice());
		System.out.println("\t+-----------------------+");
	}
	public void printMaintOptions()
	{
		System.out.println("\t+------------------------------+");
		System.out.println("\t|                              |");
		System.out.println("\t| 1. Restock items             |");
		System.out.println("\t| 2. Restock change            |");
		System.out.println("\t| 3. View Stock History        |");
		System.out.println("\t| 4. View Transaction History  |");
		System.out.println("\t| 5. Collect Money             |");
		System.out.println("\t| 6. Check Stocks              |");
		System.out.println("\t| 7. Back                      |");
		System.out.println("\t|                              |");
		System.out.println("\t+------------------------------+");
	}
	public void viewStocks()
	{
		System.out.println("Item Stock:");
		for (int i = 0 ; i < 8 ; i ++)
		{
			System.out.print("\t" + data[i][0].getName() + ": " + retSize(i,0) + createSpace(data[i][0].getName(), 5) + "| " );
			System.out.print(data[i][1].getName() + ": " + retSize(i,1)+ "\n");
		}
		System.out.println("--------------");
		System.out.println("Currency Stock:");
		System.out.println(currency.cHistory());
	}
	public void printItems()
	{
		int i;
		char c;
		System.out.println("\t----------------------------");
		for (i = 0, c = 'A'; i < 8 ; i++, c++)
			System.out.println("\t" + c + "1 :"+ data[i][0].getName() + createSpace(data[i][0].getName(),20) +"| " + retSize(i,0) + "\n\t" + c + "2 :" + data[i][1].getName()+createSpace(data[i][1].getName(),20) + "| " +retSize(i,1));
		System.out.println("\t----------------------------");
	}
	private Maintenance maint = new Maintenance();
	private Currency currency = new Currency();
	private String vName;
	private ItemAttributes[][] data = new ItemAttributes[8][2];
	private ItemAttributes[][][] items = new ItemAttributes[8][2][10];
	private char symbols[][] = new char[8][2];
}