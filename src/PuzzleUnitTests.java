import org.junit.jupiter.api.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuzzleUnitTests {
    @Test
    public void testConstructor() {
        Board b = new Board("023145678");
        StringWriter writer = new StringWriter();
        PrintWriter pw = new PrintWriter ( writer ) ;
        pw.println(" 23");
        pw.println("145");
        pw.println("678");
        assertEquals(b.toString(), writer.toString());
        pw.close();
    }
    @Test
    public void testConstructor2() {
        Board b = new Board("123485670");
        StringWriter writer = new StringWriter();
        PrintWriter pw = new PrintWriter(writer) ;
        pw.println("123");
        pw.println("485");
        pw.println("67 ");
        assertEquals(b.toString(), writer.toString());
        pw.close();
    }
}