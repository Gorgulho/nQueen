import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BestFirst s = new BestFirst();

        Iterator<BestFirst.State> it = s.solve(new Board(sc.next()), new Board(sc.next()));
        if (it == null) System.out.println("no solution found");
        else {
            while (it.hasNext()) {
                BestFirst.State i = it.next();
                System.out.println(i);
                if (!it.hasNext()) System.out.println((int) i.getG());
            }
        }
        sc.close();
    }
}