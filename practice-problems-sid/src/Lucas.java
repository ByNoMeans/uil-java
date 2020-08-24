import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;

public class Lucas {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 31; i++) {
            System.out.println(lucas(i));
        }
    }

    public static int lucas(int n) {
        if (n==0) return 2;
        if (n==1) return 1;
        if (n > 1)
            return lucas(n-1) + lucas(n-2);
        return 0;
    }
}