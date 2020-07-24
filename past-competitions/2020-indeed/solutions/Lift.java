import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.DoubleConsumer;

public class Lift {

	public static void main(String[] args) throws Throwable
	{
		Scanner kb = new Scanner(new File("lift.dat"));
		int times = kb.nextInt();
		
		while(times-->0)
		{
			int i = kb.nextInt();
			int[] w = new int[i];
			int[] v = new int[i];
			for(int x = 0; x < i; x++)
				w[x] = kb.nextInt();
			for(int x = 0; x < i; x++)
				v[x] = kb.nextInt();
			ArrayList<Item> list = new ArrayList<>();
			for(int x = 0; x < i; x++)
				list.add(new Item(v[x],w[x]));
			Collections.sort(list);
			Collections.reverse(list);
			int max = kb.nextInt();
			double b = 0;
			for(int x = 0; x < list.size(); x++)
			{
				if(list.get(x).weight <= max)
				{
					b+=list.get(x).value;
					max-=list.get(x).weight;
				}
				else
				{
					b+=list.get(x).value*((double)max/list.get(x).weight);
					max-=(double)max/list.get(x).weight*list.get(x).weight;
					break;
				}
			}
			System.out.printf("$%.2f%n",b);
		}
	}
}
class Item implements Comparable<Item> {
	int value;
	int weight;
	double ratio;
	public Item(int v, int w)
	{
		value = v;
		weight = w;
		ratio = (double)v/w;
	}
	@Override
	public int compareTo(Item o) {
		return Double.compare(ratio,o.ratio);
	}
	public String toString()
	{
		return value+" "+weight;
	}
}