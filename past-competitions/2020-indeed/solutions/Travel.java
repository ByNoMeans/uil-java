import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Travel {

	public static void main(String[] args) throws Throwable {
		Scanner kb = new Scanner(new File("travel.dat"));
		int times = kb.nextInt();
		
		while(times-->0)
		{
			int n = kb.nextInt();
			HashMap<String,Vertice> m = new HashMap<>();
			
			while(n-->0)
			{
				String start = kb.next();
				String finish = kb.next();
				long w = kb.nextLong();
				if(!m.containsKey(start))
				{
					m.put(start, new Vertice(start));
				}
				if(!m.containsKey(finish))
				{
					m.put(finish, new Vertice(finish));
				}
				Vertice v1 = m.get(start);
				Vertice v2 = m.get(finish);
				v1.list.add(new Edge(v1,v2,w));
				v1.list.add(new Edge(v2,v1,w));
			}
			String start = kb.next();
			String end = kb.next();
			PriorityQueue<Vertice> pq = new PriorityQueue<>();
			m.get(start).totaldist = 0;
			pq.add(m.get(start));
			String output = "";
			while(!pq.isEmpty())
			{
				Vertice v = pq.poll();
				if(v.name.equals(end))
				{
					output = v.out.substring(0,v.out.length()-4)+".";
					break;
				}
				for(int x = 0; x < v.list.size(); x++)
				{
					Vertice s = v.list.get(x).source;
					Vertice d = v.list.get(x).dest;
					if(s.totaldist + v.list.get(x).weight < d.totaldist)
					{
						d.totaldist = s.totaldist + v.list.get(x).weight;
						d.out = s.out+d.name+" to ";
						pq.add(d);
					}
				}
			}
			System.out.println(output);
		}
	}
}
class Vertice implements Comparable<Vertice> {
	long totaldist;
	String name;
	String out;
	ArrayList<Edge> list = new ArrayList<>();
	public Vertice(String s)
	{
		name = s;
		out = s+" to ";
		totaldist = Integer.MAX_VALUE;
	}
	@Override
	public int compareTo(Vertice o) {
		return Long.compare(totaldist, o.totaldist);
	}
}
class Edge {
	Vertice source;
	Vertice dest;
	long weight;
	public Edge(Vertice s, Vertice d, long w)
	{
		source = s;
		dest = d;
		weight = w;
	}
}