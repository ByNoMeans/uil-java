package Quick;

import java.util.Arrays;

public class PrintMethods {
    //adding "<T>" to the method signature means a generic is being used in declaration
    //work with non-generics as well, as lists are still a type t
    //sout adds newline; don't worry about it

    //make all methods work for any object

    //  printlner, printer  //
    public static <Type> void pl(Type obj) {    System.out.println(obj);   }
    public static <Type> void p(Type obj) {     System.out.print(obj);  }

    //  newline, nothing //
    public static void pl() { pl(""); }
    public static void p() { p(""); }

    //  array printlner, array printer  //
    public static <Type> void plA(Type[] obj) {
        pl(Arrays.toString(obj));
    }
    public static <Type> void pA(Type[] obj) {
        p(Arrays.toString(obj));
    }

}
