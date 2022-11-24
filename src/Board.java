import java.util.ArrayList;
import java.util.List;

class Board implements Ilayout, Cloneable {

    private int dim;
    private int board[];

    public int posAval;

    public Board() {
        board = new int[dim];
    }

    public Board(int n) {
        this.posAval = 0;
        dim = n;
        this.board = new int[dim];
        for (int i = 0; i < dim; i++) {
            //i -> coluna; board[i] -> linha
            if (i%2 == 0) {
                this.board[i] = i/2;
            }
            else {
                this.board[i] = n - 1 - i/2;
            }
        }
    }

    private Board cloneBoard() {
        Board clone = new Board();
        if (dim >= 0) System.arraycopy(this.board, 0, clone.board, 0, dim);
        return clone;
    }

    //will check how many pieces are attacking and being attacked
    public int attack(){
        int result = 0;
        for(int i = 0; i < dim-1; i++)
            for(int j = i+1; j < dim; j++)
                if(Math.abs(i-j) == Math.abs(board[i]-board[j]) || board[i] == board[j])
                    result++;
        return result;
    }

    private Ilayout changePostion (int x, int y) {
        Board novo = cloneBoard();
        int pos = novo.board[x];
        novo.board[x] = novo.board[y];
        novo.board[y] = pos;
        return novo;
    }

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

    //pode se mudar para quando tivermos o checkColumn no state, se o checkColumn der return a n, chegamos a resposta
    @Override
    public boolean isGoal() {
        return (attack()==0);
    }

    @Override
    public double getG() {
        return 1;
    }

    @Override
    public double getH() {
        return attack();
    }

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

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        //result = prime * result + Arrays.deepHashCode(board);
        return result;
    }

    public int[] getBoard() {
        return board;
    }
}