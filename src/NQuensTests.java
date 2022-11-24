import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class NQuensTests {

    @Test
    public void testConstructor() {
        Board b1 = new Board(4);
        Board b2 = new Board(8);
        Board b3 = new Board(16);

        int[] a1 = {0, 3, 1, 2};
        int[] a2 = {0, 7, 1, 6, 2, 5, 3, 4};
        int[] a3 = {0, 15, 1, 14, 2, 13, 3, 12, 4, 11, 5, 10, 6, 9, 7, 8};

        assertArrayEquals(b1.getBoard(), a1);
        assertArrayEquals(b2.getBoard(), a2);
        assertArrayEquals(b3.getBoard(), a3);
    }

    @Test
    public void testSomeValues() {
        HillClimbing alg = new HillClimbing();
        long startTime1 = System.nanoTime();
        Iterator<HillClimbing.State> it1 = alg.solve(new Board(4));
        long endTime1 = System.nanoTime();
        long startTime2 = System.nanoTime();
        Iterator<HillClimbing.State> it2 = alg.solve(new Board(10));
        long endTime2 = System.nanoTime();
        long startTime3 = System.nanoTime();
        Iterator<HillClimbing.State> it3 = alg.solve(new Board(20));
        long endTime3 = System.nanoTime();
        long startTime4 = System.nanoTime();
        Iterator<HillClimbing.State> it4 = alg.solve(new Board(30));
        long endTime4 = System.nanoTime();
        long startTime5 = System.nanoTime();
        Iterator<HillClimbing.State> it5 = alg.solve(new Board(40));
        long endTime5 = System.nanoTime();
        long startTime6 = System.nanoTime();
        Iterator<HillClimbing.State> it6 = alg.solve(new Board(50));
        long endTime6 = System.nanoTime();
        long startTime7 = System.nanoTime();
        Iterator<HillClimbing.State> it7 = alg.solve(new Board(60));
        long endTime7 = System.nanoTime();

        long startTime8 = System.nanoTime();
        Iterator<HillClimbing.State> it8 = alg.solve(new Board(70));
        long endTime8 = System.nanoTime();
        long startTime9 = System.nanoTime();
        Iterator<HillClimbing.State> it9 = alg.solve(new Board(80));
        long endTime9 = System.nanoTime();
        long startTime10 = System.nanoTime();
        Iterator<HillClimbing.State> it10 = alg.solve(new Board(90));
        long endTime10 = System.nanoTime();
        long startTime11 = System.nanoTime();
        Iterator<HillClimbing.State> it11 = alg.solve(new Board(100));
        long endTime11 = System.nanoTime();
        long startTime12 = System.nanoTime();
        Iterator<HillClimbing.State> it12 = alg.solve(new Board(110));
        long endTime12 = System.nanoTime();

        long startTime13 = System.nanoTime();
        Iterator<HillClimbing.State> it13 = alg.solve(new Board(120));
        long endTime13 = System.nanoTime();
        long startTime14 = System.nanoTime();
        Iterator<HillClimbing.State> it14 = alg.solve(new Board(130));
        long endTime14 = System.nanoTime();
        long startTime15 = System.nanoTime();
        Iterator<HillClimbing.State> it15 = alg.solve(new Board(140));
        long endTime15 = System.nanoTime();
        long startTime16 = System.nanoTime();
        Iterator<HillClimbing.State> it16 = alg.solve(new Board(150));
        long endTime16 = System.nanoTime();

        System.out.println((float) (endTime1 - startTime1) / 1000000000 + " Board 4x4");
        System.out.println((float) (endTime2 - startTime2) / 1000000000 + " Board 10x10");
        System.out.println((float) (endTime3 - startTime3) / 1000000000 + " Board 20x20");
        System.out.println((float) (endTime4 - startTime4) / 1000000000 + " Board 30x30");
        System.out.println((float) (endTime5 - startTime5) / 1000000000 + " Board 40x40");
        System.out.println((float) (endTime6 - startTime6) / 1000000000 + " Board 50x50");
        System.out.println((float) (endTime7 - startTime7) / 1000000000 + " Board 60x60");

        System.out.println((float) (endTime8 - startTime8) / 1000000000 + " Board 70x70");
        System.out.println((float) (endTime9 - startTime9) / 1000000000 + " Board 80x80");
        System.out.println((float) (endTime10 - startTime10) / 1000000000 + " Board 90x90");
        System.out.println((float) (endTime11 - startTime11) / 1000000000 + " Board 100x100");
        System.out.println((float) (endTime12 - startTime12) / 1000000000 + " Board 110x110");
        System.out.println((float) (endTime13 - startTime13) / 1000000000 + " Board 120x120");
        System.out.println((float) (endTime14 - startTime14) / 1000000000 + " Board 130x130");
        System.out.println((float) (endTime15 - startTime15) / 1000000000 + " Board 140x140");
        System.out.println((float) (endTime16 - startTime16) / 1000000000 + " Board 150x150");

        while (it1.hasNext()) {
            HillClimbing.State i = it1.next();
            if (!it1.hasNext()) {
                System.out.println(i.getG());
                ///assertEquals(28, (int) i.getG());
            }
        }
        while (it2.hasNext()) {
            HillClimbing.State i = it2.next();
            if (!it2.hasNext()) {
                System.out.println(i.getG());
                //assertEquals(38, (int) i.getG());
            }
        }
        while (it3.hasNext()) {
            HillClimbing.State i = it3.next();
            if (!it3.hasNext()) {
                System.out.println(i.getG());
                //(45, (int) i.getG());
            }
        }
        while (it4.hasNext()) {
            HillClimbing.State i = it4.next();
            if (!it4.hasNext()) {
                System.out.println(i.getG());
                //assertEquals(45, (int) i.getG());
            }
        }
        while (it5.hasNext()) {
            HillClimbing.State i = it5.next();
            if (!it5.hasNext()) {
                System.out.println(i.getG());
                //assertEquals(46, (int) i.getG());
            }
        }
        while (it6.hasNext()) {
            HillClimbing.State i = it6.next();
            if (!it6.hasNext()) {
                System.out.println(i.getG());
                //assertEquals(46, (int) i.getG());
            }
        }

        while (it7.hasNext()) {
            HillClimbing.State i = it7.next();
            if (!it7.hasNext()) {
                System.out.println(i.getG());
                //assertEquals(46, (int) i.getG());
            }
        }

        while (it8.hasNext()) {
            HillClimbing.State i = it8.next();
            if (!it8.hasNext()) {
                System.out.println(i.getG());
                //assertEquals(46, (int) i.getG());
            }
        }

        while (it9.hasNext()) {
            HillClimbing.State i = it9.next();
            if (!it9.hasNext()) {
                System.out.println(i.getG());
                //assertEquals(46, (int) i.getG());
            }
        }

        while (it10.hasNext()) {
            HillClimbing.State i = it10.next();
            if (!it10.hasNext()) {
                System.out.println(i.getG());
                //assertEquals(46, (int) i.getG());
            }
        }

        while (it11.hasNext()) {
            HillClimbing.State i = it11.next();
            if (!it11.hasNext()) {
                System.out.println(i.getG());
                //assertEquals(46, (int) i.getG());
            }
        }

        while (it12.hasNext()) {
            HillClimbing.State i = it12.next();
            if (!it12.hasNext()) {
                System.out.println(i.getG());
                //assertEquals(46, (int) i.getG());
            }
        }

        while (it13.hasNext()) {
            HillClimbing.State i = it13.next();
            if (!it13.hasNext()) {
                System.out.println(i.getG());
                //assertEquals(46, (int) i.getG());
            }
        }

        while (it14.hasNext()) {
            HillClimbing.State i = it14.next();
            if (!it14.hasNext()) {
                System.out.println(i.getG());
                //assertEquals(46, (int) i.getG());
            }
        }

        while (it15.hasNext()) {
            HillClimbing.State i = it15.next();
            if (!it15.hasNext()) {
                System.out.println(i.getG());
                //assertEquals(46, (int) i.getG());
            }
        }

        while (it16.hasNext()) {
            HillClimbing.State i = it16.next();
            if (!it16.hasNext()) {
                System.out.println(i.getG());
                //assertEquals(46, (int) i.getG());
            }
        }

    }


}