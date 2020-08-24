package _UTCS_2012;

import java.io.*;
import java.util.*;

public class Stones {
    public static void main(String[] args) throws IOException{

        Scanner s = new Scanner(new File("UTCS_12\\sample\\stones.dat"));
        int numSets = s.nextInt();
        s.nextLine();

        for(int i = 1; i <= numSets; i++){
            System.out.print(i + " ");
            int cuts = s.nextInt();
            int numJewels = s.nextInt();
            s.nextLine();
            String[] data = s.nextLine().trim().split("\\s+");
            assert data.length == numJewels : "wrong number of jewels";
            int[] jewels = convert(data);
            int goal = possible(jewels, cuts);
            if(goal != -1)
                tryToCut(jewels, cuts, goal);
            else
                System.out.println("WHOLE");
        }
        s.close();
    }

    private static void tryToCut(int[] data, int cuts, int goal) {
        // System.out.println(Arrays.toString(data));
        ArrayList<Integer> jewels = new ArrayList<Integer>();
        String result = "WHOLE";
        for(int j : data)
            jewels.add(j);
        for(int i = 0; i < jewels.size(); i++) {
            int[] segments = new int[cuts];
            int cut = 0;
            for(int j = 0; j < jewels.size(); j++) {
                // System.out.println("i: " + i + ", j: " + j + ", segments: " + Arrays.toString(segments) + ", goal: " + goal);
                segments[cut] += jewels.get(j);
                if(segments[cut] == goal) {
                    cut++;
                    if(cut == cuts)
                        break;
                }
                else if(segments[cut] > goal)
                    break;
            }
            // System.out.println(Arrays.toString(segments));
            if(allEqual(segments, goal)) {
                result = "CUT";
                break;
            }
            Collections.rotate(jewels, 1);
        }
        System.out.println(result);
    }

    private static boolean allEqual(int[] segments, int goal) {
        for(int i = 0; i < segments.length; i++)
            if(segments[i] != goal)
                return false;
        return true;
    }

    private static int possible(int[] jewels, int cuts) {
        int total = 0;
        for(int j : jewels)
            total += j;
        return total % cuts == 0 ? total / cuts : -1;
    }

    private static int[] convert(String[] data) {
        int[] result = new int[data.length];
        for(int i = 0; i < data.length; i++)
            result[i] = Integer.parseInt(data[i]);
        return result;
    }
}