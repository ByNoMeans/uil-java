import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class llcms {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("LLCMS.dat"));
        int cases = scan.nextInt(); scan.nextLine();
        for (int i = 0; i < cases; i++) {
            scan.nextInt();
            int numGroups = scan.nextInt();
            scan.nextLine();
            Integer[] nums = toIntegerArr(Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray());
            int[] branch = new int[numGroups];
            HashSet<ArrayList<Integer>> hashSet = new HashSet<>();
            hashSet = combine(nums, numGroups, 0, branch, 0, hashSet);
        }
    }

    public static long LCM(ArrayList<Integer> arr) {
        long lcm = 1;
        int divisor = 2;

        while (true) {
            int counter = 0;
            boolean divisible = false;

            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i) == 0)
                    return 0;
                else if (arr.get(i) < 0)
                    arr.set(i, arr.get(i) * -1);
                if (arr.get(i) == 1)
                    counter++;
                if (arr.get(i) % divisor == 0) {
                    divisible = true;
                    arr.set(i, arr.get(i) / divisor);
                }
            }
            if (divisible)
                lcm *= divisor;
            else
                divisor++;
            if (counter == arr.size())
                return lcm;
        }
    }

    public static HashSet<ArrayList<Integer>> combine(Integer[] arr, int numGroups, int startId, int[] branch, int numElem, HashSet<ArrayList<Integer>> arrSet) {
        if (numElem == numGroups) {
            ArrayList<Integer> mySet = new ArrayList<Integer>();
            for (int value : branch) mySet.add(value);
            arrSet.add(mySet);
            return arrSet;
        }

        for (int i = startId; i < arr.length; ++i) {
            branch[numElem++]=arr[i];
            combine(arr, numGroups, ++startId, branch, numElem--, arrSet);
        }
        return arrSet;
    }

    public static Integer[] toIntegerArr(int[] arr) {
        Integer[] ret = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ret[i] = arr[i];
        }
        return ret;
    }
}
