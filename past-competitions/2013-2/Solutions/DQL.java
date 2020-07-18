import java.io.*;
import java.util.*;

public class DQL
{
	public static boolean evaluateWhereClause(String[] headers, String[] dbLine, String whereCol, String whereOp, String whereCmp) {
		boolean bInclude = true;
		
		for (int c = 0; c < headers.length; ++c) {
			if (headers[c].equals(whereCol)) {
				if (whereOp.equals("=")) {
					bInclude = dbLine[c].equals(whereCmp);
				}
				else if (whereOp.equals("<")) {
					bInclude = Integer.parseInt(dbLine[c]) < Integer.parseInt(whereCmp);
				}
				else if (whereOp.equals(">")) {
					bInclude = Integer.parseInt(dbLine[c]) > Integer.parseInt(whereCmp);
				}
				else if (whereOp.equals("<=")) {
					bInclude = Integer.parseInt(dbLine[c]) <= Integer.parseInt(whereCmp);
				}
				else if (whereOp.equals(">=")) {
					bInclude = Integer.parseInt(dbLine[c]) >= Integer.parseInt(whereCmp);
				}
			}
		}
		
		return bInclude;
	}
	
	public static void main(String args[]) throws IOException {
    	Scanner kb = new Scanner(new File("dql.dat"));
    	
    	String[] tokens = kb.nextLine().trim().split(" ");
    	int cols = Integer.parseInt(tokens[0]);
    	int rows = Integer.parseInt(tokens[1]);
    	
    	String[] headers = kb.nextLine().trim().split(" ");
    	String[][] db = new String[rows][cols];
    	for (int r = 0; r < rows; ++r) {
    		tokens = kb.nextLine().trim().split(" ");
    		for (int c = 0; c < cols; ++c) {
    			db[r][c] = tokens[c];
    		}
    	}
    	
    	int numQueries = Integer.parseInt(kb.nextLine().trim());
    	for (int n = 0; n < numQueries; ++n) {
    		String[] queryTokens = kb.nextLine().trim().split("[ ,]");
    		
    		// First token should always be SELECT, so sanity check my own problem :)
    		if (!queryTokens[0].equals("SELECT")) {
    			System.out.println("BAD QUERY!");
    			continue;
    		}
    		
    		ArrayList<String> selectors = new ArrayList<String>();
    		String whereCol = "";
    		String whereOp = "";
    		String whereCmp = "";
    		boolean bWhereClause = false;
    		
    		for (int q = 1; q < queryTokens.length; ++q) {
    			String tok = queryTokens[q];
    			if (tok.equals("WHERE")) {
    				bWhereClause = true;
    			}
    			else if (bWhereClause) {
    				for (int s = 0; s < tok.length(); ++s) {
    					char ch = tok.charAt(s);
    					if (ch == '<' || ch == '>' || ch == '=') {
    						whereOp += ch;
    					}
    					else if (whereOp.isEmpty()) {
    						whereCol += ch;
    					}
    					else {
    						whereCmp += ch;
    					}
    				}
    			}
    			else {
    				selectors.add(tok);
    			}
    		}
    		
    		ArrayList<String> dataOut = new ArrayList<String>();
    		for (int r = 0; r < rows; ++r) {
    			if (evaluateWhereClause(headers, db[r], whereCol, whereOp, whereCmp)) {
    				String rowOut = "";
    				for (int c = 0; c < cols; ++c) {
        				for (int s = 0; s < selectors.size(); ++s) {
        					String selector = selectors.get(s);
        					if (selector.equals("*") || selector.equals(headers[c])) {
        						rowOut += db[r][c];
            					rowOut += " ";
        					}
        				}
        			}
    				
    				if (!rowOut.isEmpty()) {
        				dataOut.add(rowOut);
        			}
    			}
    		}
    		
    		System.out.printf("Query #%d\n", n + 1);
    		if (dataOut.size() == 0) {
    			System.out.println("NONE");
    		}
    		else {
	    		for (int i = 0; i < dataOut.size(); ++i) {
	    			System.out.println(dataOut.get(i).trim());
	    		}
    		}
    		System.out.println();
    	}
    }
}
