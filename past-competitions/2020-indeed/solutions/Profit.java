import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Profit {

	public static void main(String[] args) throws Throwable {
		Scanner kb = new Scanner(new File("profit.dat"));
		int times = kb.nextInt();
		double taxrate = kb.nextDouble()/100;
		System.out.println("      Price     *       Tax      *     Profit     *");
		System.out.println("***************************************************");
		double totalprice = 0;
		double totaltax = 0;
		double totalprofit = 0;
		while(times-->0)
		{
			double price = kb.nextDouble();
			double tax = price*taxrate;
			double profit = price-tax;
			System.out.print(print(price,tax,profit));
			totalprice+=price;
			totaltax+=tax;
			totalprofit+=profit;
		}
		System.out.println("***************************************************");
		System.out.println(print(totalprice,totaltax,totalprofit));
	}
	public static String print(double price,double tax,double profit)
	{
		String temp = String.format("%,14.2f *%,14.2f *%,14.2f *%n",price,tax,profit);
		String out = "";
		boolean d = false;
		for(int x = 0; x < temp.length(); x++)
		{
			if(!d && Character.isDigit(temp.charAt(x)))
			{
				d = true;
				out+="$";
			}
			if(temp.charAt(x) == '*')
				d =false;
			out+=temp.charAt(x);
		}
		return out;
	}
}
