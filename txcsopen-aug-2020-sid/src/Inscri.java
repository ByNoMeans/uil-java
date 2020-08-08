import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Inscri {
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "Inscri".toLowerCase() + ".dat";
        
        Scanner scan = new Scanner(new File(fileName));

        int lines = scan.nextInt();

        for (int i = 0; i < lines; i++) {
            int first = scan.nextInt();
            int second = scan.nextInt();
            //scan.nextLine();
            double area = 1.0*first*first;

            for(int j = 0; j < second; j++)
            {
                if(j%2 == 0)
                    area /= 1.0/(0.25*Math.PI);
                else
                    area /= (Math.PI/2);
            }
            System.out.printf("%.2f", area);
            //System.out.println(area);
        }
    }

    public static double getCircle(double radius) {
        return Math.PI * radius * radius;
    }
}
