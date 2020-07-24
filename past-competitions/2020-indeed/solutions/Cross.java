import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*;

public class Cross
{
	public static void main(String[] args) throws IOException
	{
		int i,j,k,a,b,c,d,min;
		String s,word1,word2;
		char ch;
		String[]t;
		char [][] mat;
				
		Scanner input = new Scanner(new File("cross.dat"));
		PrintWriter output = new PrintWriter(new File("cross.out"));		
		
		a=Integer.parseInt(input.nextLine().trim());
								
		for(i=0;i<a;i++)
		{			
			s=input.nextLine().trim();
			t=s.split("\\s+");
			word1=t[0];
			word2=t[2];
			
			min=word1.length();
			b=word1.length();
			
			for(j=0;j<word1.length();j++)
			{
				ch=word1.charAt(j);
				if(word2.contains(""+ch))
				{
					min=j;
					b=word2.indexOf(""+ch);
					break;
				}							
			}
			//out.println("b="+b+"j="+j);			
			
			if(j==word1.length())
			{
				out.println("none");
				output.println("none");
			}
			else
			{
				//out.println(j+" "+b);
				mat=new char[word2.length()][word1.length()];
				for(c=0;c<mat.length;c++)
				{
					for(d=0;d<mat[0].length;d++)
					{
						mat[c][d]=' ';
					}
				}
				for(c=0;c<mat[0].length;c++)
				{
					mat[b][c]=word1.charAt(c);
				}
				for(d=0;d<mat.length;d++)
				{
					mat[d][j]=word2.charAt(d);
				}				
				for(c=0;c<mat.length;c++)
				{
					for(d=0;d<mat[0].length;d++)
					{
						out.print(mat[c][d]);
						output.print(mat[c][d]);
					}
					out.println();
					output.println();
				}				
			}			
					
			out.println();
			output.println();			  
		}		
			
	input.close();
	output.close();	
	}
}