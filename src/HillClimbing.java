import java.util.*;

public class HillClimbing {

    private Map<Ilayout, State> fechados;
    private State actual;

    static class State {
        private Ilayout layout;
        private State father;
        private double g;

        private double h;

        /**
         * State constructor, it takes an Ilayout object and State obeject (father).
         * @param l - Ilayout object to be stored in this State
         * @param n - father of the board represented by parameter l
         */
        public State(Ilayout l, State n) {
            layout = l;
            father = n;
            if (father != null)
                g = father.g + l.getG();
            else g = 0.0;

            h = l.getH();
        }

        /**
         * @return - A string representing the object
         */
        public String toString() {
            return layout.toString();
        }

        /**
         * @return - Gets the G value calculated in the constructor
         */
        public double getG() {
            return g;
        }

        /**
         * @return - Gets the H value calculated in the constructor
         */
        public double getH() {
            return h;
        }

        /**
         * @return
         */
        public int hashCode() {
            return toString().hashCode();
        }

        /**
         * Indicates whether some other object is "equal to" this one.
         * @param o – the reference object with which to compare.
         * @return - true if this object is the same as the o argument; false otherwise.
         */
        public boolean equals(Object o) {
            if (o == null) return false;
            if (this.getClass() != o.getClass()) return false;
            State n = (State) o;
            return this.layout.equals(n.layout);
        }
    }

    /**
     * Thaking the State n passed as argument, it generates all the possible childes and keeps only the most promissing one (Hill Climbing algorithm),
     * the one that has the least amount of attacks in comparation with the father State
     * @param n - State from which will be generated their successors
     * @return - State that contains the least amount of attacks comparing with the father
     */
    final private State sucessores(State n) {
        Queue<State> sucs = new PriorityQueue<>(10, (s1, s2) -> (int) Math.signum(s1.getG() + s1.getH() - (s2.getG() + s2.getH())));
        List<Ilayout> children = n.layout.children(); // children will make the children of the board we pass as argument
        for (Ilayout e : children) {
            if ((n.father == null || !e.equals(n.father.layout))) {
                State nn = new State(e, n);
                if (!fechados.containsKey(nn.layout)) {
                    sucs.add(nn);
                }
                else if (((n = fechados.get(nn.layout)) != null) && (n.getG() + n.getH() > nn.getG() + nn.getH())) {
                    sucs.add(nn);
                    fechados.replace(n.layout, n, nn);
                }
            }
        }
        return sucs.poll();
    }

    /**
     * Thakes the intial Ilayout object (Board) and resolves the puzzle using the Hill Climbing algorithm
     * @param s - Initial Ilayout object (Board), from with the method will start resolving the puzzle
     * @return - Iterator that contains all the States needed until the final one with the result
     */
    final public Iterator<State> solve(Ilayout s) {
        List<State> solution = new ArrayList<>();
        fechados = new HashMap<>();
        actual = new State(s, null);
        fechados.put(actual.layout, actual);
        State neighbor;

        while (true) {
            if (actual == null) System.exit(0);
            neighbor = sucessores(actual);
            solution.add(actual);
            if (neighbor.getH() >= actual.getH()) {
                break;
            }
            actual = neighbor;
        }

        return solution.iterator();
    }
}
