import java.util.Iterator;
import java.util.Scanner;

public class Main {

public static void main (String [] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    HillClimbing s = new HillClimbing();
    Board b = new Board(sc.nextInt());
    Iterator<HillClimbing.State> it = s.solve(b);

    if (it==null) System.out.println("no solution found");
    else {
        while(it.hasNext()) {
            HillClimbing.State i = it.next();

            if (!it.hasNext()) {
                System.out.println((int) i.getG());
            }
        }
    }
    sc.close();

}
}