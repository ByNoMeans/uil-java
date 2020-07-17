public class skip {
    public static void main(String[] args) {
        int currentSpace = 1;
        for (int i = 0; i < 40; i++) {
            int currentNum = 1;
            System.out.print(1 + " ");
            for (int j = 0; j < 9; j++) {
                System.out.print(currentNum + currentSpace + " ");
                currentNum += currentSpace;
            }
            System.out.println();
            currentSpace++;
        }
    }
}
