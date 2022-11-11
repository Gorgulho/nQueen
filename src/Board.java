import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Board implements Ilayout, Cloneable {

    private static int dim;
    private int board[];


    /*public Board() {
        board = new int[dim];
    }*/

    public Board(int n) {
        dim = n;
        board = new int[dim];
        for (int i = 0; i < dim; i++) {
            board[i]= 0; //i -> coluna; board[i] -> linha
        }
    }



    private Board changePosition (int i, int j) {
        Board nova = new Board(dim);


        return nova;
    }

    public int attack(){
        int result = 0;
        for(int i = 0; i < dim-1; i++)
            for(int j = i+1; j < dim; j++)
                if(i - board[i] == j - board[j] || board[i] == board[j] )result++;
        return result;
    }

    @Override
    public List<Ilayout> children() {
        List<Ilayout> child = new ArrayList<>();


        return child;
    }

    @Override
    public boolean isGoal() {
        return (attack()==0);
    }

    @Override
    public double getG() {
        return 1;
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
}