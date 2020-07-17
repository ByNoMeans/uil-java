import java.util.function.DoubleToIntFunction;

public class Poly_Test_Child extends Poly_Test {
    private int z;
    public Poly_Test_Child() {
        super();
        z = 0;
    }
    public void printTest() {
        System.out.println("Printing overridden printTest() from child");
        //printTest(); --> would call this print test here, because overrides method in parent
        //AND that method is not public anyway (you might've changed this fact later)
        System.out.println("Printing printTest() from parent using super");
        super.printTest();
    }
    public void getZ() {
        System.out.println("Z:" + z);
    }
    public String toString() {
        return "Printing from Poly_Test_Child, z >> " + z;
    }
}

