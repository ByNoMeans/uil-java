import java.util.*;

public class IndividualPrac1 {
    public static void main(String[] args) {
        Object[] j = {6.667};
        //System.out.println(j[0]);
        // Substring starts at beginIndex
        //System.out.printf("%,5.7f", 5472.12);
        Structure s = new Structure();
        s.add(12, 5);
        s.add(5, 12);
        s.add(17, 13);
        s.add(5, 7);
        System.out.print( s.remove() );
        System.out.print( " " + s.remove() );
    }
    public static class Structure {
        private List<Pair> con;
        public Structure(){
            con = new ArrayList<Pair>();
        }
        public Object get(){
            return con.get(0).value();
        }
        public Object remove(){
            return con.remove(0).value();
        }
        public void add(int x, Object obj){
            int pos = 0;
            while(pos < con.size()

                    && x < con.get(pos).num() ) {

                pos++;
            }
            Pair p = new Pair(x, obj);
            con.add(pos, p);
        }
        public boolean empty(){
            return con.size() == 0;
        }
        private static class Pair {
            private int n;
            private Object obj;
            public Pair(int num, Object val){
                n = num;
                obj = val;
            }
            public int num() { return n; }
            public Object value() { return obj; }
        }
    }
}
