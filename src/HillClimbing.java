import java.util.*;

public class HillClimbing {

    private Map<Ilayout, State> fechados;
    private State actual;

    static class State {
        private Ilayout layout;
        private State father;
        private double g;

        private double h;

        public State(Ilayout l, State n) {
            layout = l;
            father = n;
            if (father != null)
                g = father.g + l.getG();
            else g = 0.0;

            h = l.getH();
        }

        public String toString() {
            return layout.toString();
        }

        public double getG() {
            return g;
        }

        public double getH() {
            return h;
        }

        public int hashCode() {
            return toString().hashCode();
        }

        public boolean equals(Object o) {
            if (o == null) return false;
            if (this.getClass() != o.getClass()) return false;
            State n = (State) o;
            return this.layout.equals(n.layout);
        }
    }

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
