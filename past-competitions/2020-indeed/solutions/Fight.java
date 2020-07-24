import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class Fight {

	public static void main(String[] args) throws Throwable {
		Scanner kb = new Scanner(new File("fight.dat"));
		while(kb.hasNext())
		{
			Random r =  new Random(kb.nextLong());
			int thorhp = 200;
			int noobhp = 200;
			int turn = 0;
			while(thorhp > 0 && noobhp > 0)
			{
				int g = r.nextInt(200);
				if(turn == 0)
				{
					noobhp-=g;
				}
				else
				{
					thorhp-=g;
				}
				turn = ~turn;
			}
			System.out.println(thorhp < 0 ? "Noobslayer69 wins!" : "Thor wins!");
		}
	}
}