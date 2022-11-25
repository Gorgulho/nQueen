import java.util.ArrayList;
import java.util.List;

class Board implements Ilayout, Cloneable {

    private static int dim;
    private int board[];


    /**
     * prepares board
     */
    public Board() {
        board = new int[dim];
    }

    /**
     * prepares board; each queen in a different column and row
     * @param n
     */
    public Board(int n) {
        dim = n;
        this.board = new int[dim];
        for (int i = 0; i < dim; i++) {
            //i -> column; board[i] -> line
            if (i%2 == 0) {
                this.board[i] = i/2;
            }
            else {
                this.board[i] = n - 1 - i/2;
            }
        }
    }

    /**
     *clones the receiver
     * @return object of type Board
     */
    private Board cloneBoard() {
        Board clone = new Board();
        if (dim >= 0) System.arraycopy(this.board, 0, clone.board, 0, dim);
        return clone;
    }

    /**
     * will check how many mutual attacks exist between queens
     * @return int representing the number of attacks
     */
    public int attack(){
        int result = 0;
        for(int i = 0; i < dim-1; i++)
            for(int j = i+1; j < dim; j++)
                if(Math.abs(i-j) == Math.abs(board[i]-board[j]) || board[i] == board[j])
                    result++;
        return result;
    }

    /**
     *
     * @param x line passed from method children()
     * @param y column passed from method children()
     * @return list of successors,
     */
    private Ilayout changePostion (int x, int y) {
        Board novo = cloneBoard();
        int pos = novo.board[x];
        novo.board[x] = novo.board[y];
        novo.board[y] = pos;
        return novo;
    }

    /**
     * @inhertDoc
     */
    @Override
    public List<Ilayout> children() {
        List<Ilayout> child = new ArrayList<>();
        for (int i = 0; i < dim-1; i++) {
            for (int j = i+1; j < dim; j++) {
                child.add(changePostion(i, j));
            }
        }
        return child;
    }

    /**
     * @hineritDoc
     */
    @Override
    public boolean isGoal() {
        return (attack()==0);
    }

    /**
     * @hineritDoc
     */
    @Override
    public double getG() {
        return 1;
    }

    /**
     * @hineritDoc
     */
    @Override
    public double getH() {
        return attack();
    }

    /**
     * queens are represented by '1'
     * @return a string representation of the object.
     */
    public String toString() {
        StringBuilder a = new StringBuilder();
        for (int i = 0; i < dim; i++) {
            for(int j = 0; j < dim; j++){
                if(board[j] == i) a.append("1");
                else a.append("0");
            }
            a.append("\n");
        }
        return a.toString();
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * @param o the reference object with which to compare
     * @return true if this object is the same as the o argument; false otherwise
     */
    public boolean equals(Object o) {
        if(o == null) return false;
        if(this.getClass() != o.getClass()) return false;
        for (int i = 0; i < dim; i++) {
                if(this.board[i] != ((Board) o).board[i]) {
                    return false;
                }
        }
        return true;
    }

    /**
     * @return a hash code value for this object
     */
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        //result = prime * result + Arrays.deepHashCode(board);
        return result;
    }

    /**
     * used in unit tests
     * @return object's board
     */
    public int[] getBoard() {
        return board;
    }
}