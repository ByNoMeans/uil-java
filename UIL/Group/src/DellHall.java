public class DellHall {
    public static void main(String[] args) {

        String floor = "-------------------\n";
        String level = " |||.|..|.|..|.||| \n";
        String printOut = floor + level + level + level;

        for (int i = 0; i < 6; i++) {
            System.out.println(i+1);
            if (i == 4) {
                System.out.print(printOut);
                printOut = ")()()()(--))()()()(\n" + floor + level + level + printOut;

            } else {
                System.out.print(printOut);
                printOut = floor + level + printOut;
            }
        }
    }
}
