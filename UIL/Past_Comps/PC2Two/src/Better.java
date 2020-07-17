import java.io.*;
import java.util.*;

public class Better {

    public static void main (String[] args) throws IOException {
        Scanner scan = new Scanner (new File("better.dat"));
        int lines = scan.nextInt();
        for (int i = 0; i < lines; i++) {
            int firstNum = scan.nextInt();
            int secondNum = scan.nextInt();
            int firstNumSum = String.valueOf(firstNum).chars().map(n -> n- '0').sum();
            int secondNumSum = String.valueOf(secondNum).chars().map(Character::getNumericValue).sum();

            if (firstNum == secondNum) {
                System.out.println(firstNum + " is same as " + secondNum);
            } else {
                if (firstNumSum > secondNumSum) {
                    System.out.println(firstNum + " is better than " + secondNum);
                } else if (secondNumSum == firstNumSum) {
                    if (secondNum > firstNum) {
                        System.out.println(firstNum + " is better than " + secondNum);
                    } else {
                        System.out.println(secondNum  + " is better than " + firstNum);
                    }
                } else {
                    System.out.println(secondNum + " is better than " + firstNum);
                }
            }
        }
    }
}
