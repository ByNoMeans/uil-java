import java.util.*;
import java.io.*;

public class Lift
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner scan = new Scanner(new File("lift.dat"));
		int n = scan.nextInt();
		ArrayList<Double> weight = new ArrayList<Double>();
		ArrayList<Double> value = new ArrayList<Double>();
		ArrayList<Double> density = new ArrayList<Double>();
		ArrayList<Double> densityunsorted = new ArrayList<Double>();
		for(int i = 0; i < n; i++)
		{
			double total = 0;
			int x = scan.nextInt();
			weight.clear();
			value.clear();
			density.clear();
			densityunsorted.clear();
			for(int j = 0; j < x; j++)
			{
				weight.add(scan.nextDouble());
			}
			for(int j = 0; j < x; j++)
			{
				value.add(scan.nextDouble());
			}
			double cap = scan.nextInt();
			
			for(int j = 0; j < x; j++)
			{
				densityunsorted.add(value.get(j)/weight.get(j));
				density.add(value.get(j)/weight.get(j));
			}
			Collections.sort(density);
			//System.out.println(density);
			//System.out.println(weight);
			//System.out.println(value+ " " + cap);
			for(int j = density.size()-1; j >= 0; j--)
			{
				if(cap-weight.get(densityunsorted.indexOf(density.get(j))) == 0)
				{
					cap -= weight.get(densityunsorted.indexOf(density.get(j)));
					total += value.get(densityunsorted.indexOf(density.get(j)));
					//System.out.println(cap + " " + total);
					break;
				}
				if(cap-weight.get(densityunsorted.indexOf(density.get(j))) > 0)
				{
					cap -= weight.get(densityunsorted.indexOf(density.get(j)));
					total += value.get(densityunsorted.indexOf(density.get(j)));
					//System.out.println(cap + " " + total);
				} else 
				{
					//System.out.println("ending capacity: " + cap);
					total += (cap)*density.get(j);
					cap = 0;
					//System.out.println(cap + " " +  total);
					break;
				}
			}
			
			
			double val = ((int)(Math.round(total*100)));
			System.out.println(val/100.0);
		}
    }
}
