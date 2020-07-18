import java.io.*;
import java.util.*;

public class BitPacking
{
	static final int TYPE_BITS 		= 5;
	static final int SUBTYPE_BITS 	= 6;
	static final int INVENTORY_BITS	= 12;
	
	static final int TYPE_MASK = 0x1F << (INVENTORY_BITS + SUBTYPE_BITS);
	static final int SUBTYPE_MASK = 0x3F << INVENTORY_BITS;
	static final int INVENTORY_MASK = 0xFFF;
	
	public static void main(String args[]) throws IOException {
    	Scanner kb = new Scanner(new File("bitpacking.dat"));
    	
    	/*
    	int g;
    	g = 2 << (INVENTORY_BITS + SUBTYPE_BITS) | 3 << (INVENTORY_BITS) | 263;
    	System.out.println(g);
    	
    	g = 25 << (INVENTORY_BITS + SUBTYPE_BITS) | 29 << (INVENTORY_BITS) | 10;
    	System.out.println(g);
    	
    	g = 12 << (INVENTORY_BITS + SUBTYPE_BITS) | 1 << (INVENTORY_BITS) | 1253;
    	System.out.println(g);
    	
    	g = 15 << (INVENTORY_BITS + SUBTYPE_BITS) | 50 << (INVENTORY_BITS) | 1;
    	System.out.println(g);
    	
    	g = 20 << (INVENTORY_BITS + SUBTYPE_BITS) | 53 << (INVENTORY_BITS) | 3000;
    	System.out.println(g);
    	
    	g = 9 << (INVENTORY_BITS + SUBTYPE_BITS) | 61 << (INVENTORY_BITS) | 999;
    	System.out.println(g);
    	
    	System.out.println();
    	*/
    	
    	int nLines = Integer.parseInt(kb.nextLine().trim());
    	for (int n = 0; n < nLines; ++n) {
    		int val = Integer.parseInt(kb.nextLine().trim());
    		
    		int type = (val & TYPE_MASK) >> (INVENTORY_BITS + SUBTYPE_BITS);
    		int subType = (val & SUBTYPE_MASK) >> INVENTORY_BITS;
			int inventory = val & INVENTORY_MASK;
			
			System.out.printf("Type: %c | Sub Type: %s | Inventory: %d\n", 
								(char)(type + 'A' - 1),
								subType > 52 ? new Integer(subType - 52).toString() 
											 : subType > 26 ? new StringBuffer().append((char)(subType + 'a' - 1 - 26)).toString()
													 		: new StringBuffer().append((char)(subType + 'A' - 1)).toString(),
								inventory);
    	}
    }
}
