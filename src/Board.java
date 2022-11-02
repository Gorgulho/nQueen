import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Board implements Ilayout, Cloneable {

    private static final int dim = 3;
    private int board[][];
    private int zeroI;
    private int zeroJ;

    public Board() {
        board = new int[dim][dim];
    }

    public Board(String str) throws IllegalStateException {
        if (str.length() != dim * dim) throw new
                IllegalStateException("Invalid arg in Board constructor");
        board = new int[dim][dim];
        int si = 0;
        for (int i = 0; i < dim; i++)
            for (int j = 0; j < dim; j++)
                board[i][j] = Character.getNumericValue(str.charAt(si++));
    }

    public String matrixToString(){
        String string = "";
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                string += this.board[i][j];
            }
        }
        return string;
    }

    private Board changePosition (int i, int j) {
        Board nova = new Board(matrixToString());

        int position = nova.board[zeroI+i][zeroJ+j];
        nova.board[zeroI+i][zeroJ+j] = 0;
        nova.board[zeroI][zeroJ] = position;
        return nova;
    }

    private void findzero () {
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (this.board[i][j] == 0) {
                    zeroI = i;
                    zeroJ = j;
                    return;
                }
            }
        }
    }

    @Override
    public List<Ilayout> children() {
        List<Ilayout> child = new ArrayList<>();
        findzero();

        if (zeroJ-1 >= 0) {
            child.add(changePosition(0, -1));
        }
        if (zeroI-1 >= 0) {
            child.add(changePosition( -1, 0));
        }
        if (zeroJ+1 < dim) {
            child.add(changePosition( 0, 1));
        }
        if (zeroI+1 < dim) {
            child.add(changePosition( 1, 0));
        }



        return child;
    }

    @Override
    public boolean isGoal(Ilayout l) {
        return equals(l);
    }

    @Override
    public double getG() {
        return 1;
    }
    //... TO BE COMPLETED

    public String toString() {
        String a = "";
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (board[i][j] == 0)
                    a += " ";
                else
                    a+=String.valueOf(board[i][j]);
            }
            a += "\n";
        }
        return a;
    }

    public boolean equals(Object o) {
        if(o == null) return false;
        if(this.getClass() != o.getClass()) return false;
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if(this.board[i][j] != ((Board) o).board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.deepHashCode(board);
        return result;
    }
}