import java.util.Iterator;
import java.util.Scanner;

public class Main {
//    public static void main(String[] args) throws Exception {
//        Scanner sc = new Scanner(System.in);
//        //HillClimbing s = new HillClimbing();
//        Board b = new Board(sc.nextInt());
//        System.out.println(b);
//        System.out.println(b.attack());
//        //Ilayout solution = s.solve(new Board(sc.nextInt()));
//        //if (it == null) System.out.println("no solution found");
//        //else {}
//        sc.close();
//    }
public static void main (String [] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    HillClimbing s = new HillClimbing();
    Board b = new Board(sc.nextInt());
    long startTime1 = System.nanoTime();
    Iterator<HillClimbing.State> it = s.solve(b);
    long endTime1 = System.nanoTime();
    System.out.println((float) (endTime1 - startTime1) / 1000000000 + " seconds");
    if (it==null) System.out.println("no solution found");
    else {
        while(it.hasNext()) {
            HillClimbing.State i = it.next();
            //System.out.println(i.toString());
            //System.out.println(i.getH(b));
            //System.out.println(i.toString());
            if (!it.hasNext()) {
                System.out.println((int) i.getG());
            }
        }
    }
    sc.close();

}
}