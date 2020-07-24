import java.io.File;
import java.util.Scanner;

public class Blast {
	public static void main(String[] args) throws Throwable
	{
		Scanner kb = new Scanner(new File("blast.dat"));
		while(kb.hasNext())
		{
			char[][] c = new char[10][10];
			for(int x = 0; x < 10; x++)
				c[x] = kb.nextLine().toCharArray();
			Spot[][] m = new Spot[10][10];
			int sx = 0,sy = 0,ex = 0, ey = 0;
			for(int x = 0; x < 10; x++)
			{
				for(int y = 0; y < 10; y++)
				{
					switch(c[x][y])
					{
					case 'X': m[x][y] = new Spot(-1); break;
					case '.': m[x][y] = new Spot(1); break;
					case '*': m[x][y] = new Spot(5); break;
					case 'E': m[x][y] = new Spot(1); 
					ex = x;
					ey = y;
					m[x][y].v = Integer.MAX_VALUE;
					break;
					case 'S': m[x][y] = new Spot(0); 
					sx = x;
					sy = y;
					break;
					}
				}
			}
			flood(sx,sy,m);
			int n = kb.nextInt();
			kb.nextLine();
			System.out.println(m[ex][ey].v <= n ? "Escaped!" : "Impossible");
		}
	}

	private static void flood(int x, int y, Spot[][] m) {
		try
		{
			if(m[x-1][y].c > 0)
			{
				if(m[x-1][y].v == 0 || m[x-1][y].v > m[x][y].v+m[x-1][y].c)
				{
					m[x-1][y].v = m[x][y].v+m[x-1][y].c;
					flood(x-1,y,m);
				}
			}
			
		}catch(Exception e) {}
		try
		{
			if(m[x+1][y].c > 0)
			{
				if(m[x+1][y].v == 0 || m[x+1][y].v > m[x][y].v+m[x+1][y].c)
				{
					m[x+1][y].v = m[x][y].v+m[x+1][y].c;
					flood(x+1,y,m);
				}
			}
			
		}catch(Exception e) {}
		try
		{
			if(m[x][y-1].c > 0)
			{
				if(m[x][y-1].v == 0 || m[x][y-1].v > m[x][y].v+m[x][y-1].c)
				{
					m[x][y-1].v = m[x][y].v+m[x][y-1].c;
					flood(x,y-1,m);
				}
			}
			
		}catch(Exception e) {}
		try
		{
			if(m[x][y+1].c > 0)
			{
				if(m[x][y+1].v == 0 || m[x][y+1].v > m[x][y].v+m[x][y+1].c)
				{
					m[x][y+1].v = m[x][y].v+m[x][y+1].c;
					flood(x,y+1,m);
				}
			}
			
		}catch(Exception e) {}
	}
}
class Spot {
	int v;
	int c;
	public Spot(int c)
	{
		this.c = c;
	}
}