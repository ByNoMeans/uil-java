import java.awt.Point;
import java.io.File;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Escape {
	public static char[][] m;
	public static void main(String[] args) throws Throwable {
		Scanner kb = new Scanner(new File("escape.dat"));
		int times = kb.nextInt();
		
		while(times-->0)
		{
			int r = kb.nextInt();
			int c = kb.nextInt();
			kb.nextLine();
			m = new char[r][c];
			for(int x = 0; x < r; x++)
			{
				m[x] = kb.nextLine().toCharArray();
			}
			Point end = new Point(kb.nextInt(),kb.nextInt());
			Point start = new Point(kb.nextInt(),kb.nextInt());
			PriorityQueue<Move> pq = new PriorityQueue<>();
			pq.add(new Move(start.x,start.y,end.x,end.y));
			m[start.x][start.y] = '*'; 
			while(!pq.isEmpty())
			{
				if(m[end.x][end.y] == '*')
					break;
				Move temp = pq.poll();
				check(temp.x+1,temp.y,pq,end);
				check(temp.x-1,temp.y,pq,end);
				check(temp.x,temp.y+1,pq,end);
				check(temp.x,temp.y-1,pq,end);
			}
			if(m[end.x][end.y] == '*')
				System.out.println("Escaped");
			else
				System.out.println("Trapped");
		}
	}
	private static void check(int x, int y, PriorityQueue<Move> pq, Point p)
	{
		if(x < 0 || y < 0 || x >= m.length || y >= m[0].length)
			return;
		if(m[x][y] != '.')
			return;
		m[x][y] = '*';
		pq.add(new Move(x,y,p.x,p.y));
	}
}
class Move implements Comparable<Move> {
	int x;
	int y;
	double dist;
	public Move(int x, int y, int ex, int ey)
	{
		this.x = x;
		this.y = y;
		dist = Math.sqrt(Math.pow(x-ex, 2)+Math.pow(y-ey, 2));
	}
	@Override
	public int compareTo(Move o) {
		return Double.compare(dist, o.dist);
	} 
}