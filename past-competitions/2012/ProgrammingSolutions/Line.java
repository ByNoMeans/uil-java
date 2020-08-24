package _UTCS_2012;

import java.io.*;
import java.util.*;

public class Line {
    public static void main(String[] args) throws IOException{

        Scanner s = new Scanner(new File("UTCS_12\\sample\\line.dat"));
        int numSets = s.nextInt();
        s.nextLine();

        for(int i = 1; i <= numSets; i++){
            int numCards = s.nextInt();
            assert 1 <= numCards && numCards <= 30;
            s.nextLine();
            String[] data = s.nextLine().trim().split("\\s+");
            assert numCards == data.length : "improper data. Wrong number of cards";
            ArrayList<Card> cards = new ArrayList<Card>();
            for(int j = 0; j < data.length; j++) {
                String temp = data[j];
                int indexSep = temp.indexOf("-");
                assert indexSep > 0 : "no dash or dash in wrong spot";
                String left = temp.substring(0, indexSep);
                assert left.length() > 0;
                String right = temp.substring(indexSep + 1);
                assert right.length() > 0;
                cards.add(new Card(left, right));
            }
            int best = findLongestLine(cards, null, cards.size());
            System.out.println(best);
        }
        s.close();
    }


    private static int findLongestLine(ArrayList<Card> cards, Card lastCard, int maxPossible) {
        if(cards.size() == 0)
            return 0;
        int best = 0;
        for(int i = 0; i < cards.size(); i++) {
            // take out a card
            Card tempCard = cards.remove(i);
            if(lastCard == null || tempCard.left.equals(lastCard.right)) {
                // matches. go on!
                int tempLength = 1 + findLongestLine(cards, tempCard, maxPossible);
                if(tempLength > best)
                    best = tempLength;
                // if used them all stop!
                if(best == maxPossible)
                    return best;
            }
            // put card back so we can use it later
            cards.add(i, tempCard);
        }
        return best;
    }
    
    public static class Card {
        String left;
        String right;
        
        Card(String l, String r) {
            left = l;
            right = r;
        }
        
        public String toString(){
            return left + "-" + right;
        }
    }

}
