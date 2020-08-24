package _UTCS_2012;

public class Dell {
    
    public static void main(String[] args) {
        System.out.println("1");
        bottomFloor();
        for(int floor = 2; floor <= 5; floor++) {
            System.out.println(floor);
            int numFloors = floor - 1;
            for(int i = 0; i < numFloors; i++) {
                normalFloor();
            }
            bottomFloor();
        }
        System.out.println(6);
        topFloor();
        for(int i = 1; i < 5; i++)
            normalFloor();
        bottomFloor();
        
    }
    
    public static void topFloor() {
        roof();
        sep();
        floor();
        floor();
    }
    
    public static void normalFloor() {
        sep();
        floor();
    }
    
    public static void bottomFloor() {
        sep();
        floor();
        floor();
        floor();
    }
    
    public static void roof() {
        System.out.println(")()()()(--))()()()(");
    }
    
    public static void floor() {
        System.out.println(" |||.|..|.|..|.|||");
    }
    
    public static void sep() {
        System.out.println("-------------------");
    }
}
