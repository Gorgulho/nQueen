import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        //BestFirst s = new BestFirst();
        Board b = new Board(sc.nextInt());
        System.out.println(b);
        System.out.println(b.attack());
        //Ilayout solution = s.solve(new Board(sc.nextInt()));
        //if (it == null) System.out.println("no solution found");
        //else {}
        sc.close();
    }
}