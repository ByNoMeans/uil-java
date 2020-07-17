public class pushups {
    public static void main(String[] args) {
        int x = 1; int z = 1;
        System.out.println("On day 1 do " + z + " pushup every day for " + z + " day."  );
        while (x != 40) {
            if (z % 2 == 0) {
                x++;
                System.out.println("On day " + z + " do " + x+ " pushups every day for " + x + " days.");
            }
            z += x;
        }
    }
}