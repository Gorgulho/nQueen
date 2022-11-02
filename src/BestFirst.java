import java.util.*;

public class BestFirst {

    protected Queue<State> abertos;
    private Map<Ilayout, State> fechados;
    private State actual;
    private Ilayout objective;

    static class State {
        private Ilayout layout;
        private State father;
        private double g;

        public State(Ilayout l, State n) {
            layout = l;
            father = n;
            if (father != null)
                g = father.g + l.getG();
            else g = 0.0;
        }

        public String toString() {
            return layout.toString();
        }

        public double getG() {
            return g;
        }

        public int hashCode() {
            return layout.hashCode();
        }

        public boolean equals(Object o) {
            if (o == null) return false;
            if (this.getClass() != o.getClass()) return false;
            State n = (State) o;
            return this.layout.equals(n.layout);
        }
    }

    final private List<State> sucessores(State n) {
        List<State> sucs = new ArrayList<>();
        List<Ilayout> children = n.layout.children(); // children will make the children of the board we pass as argument
        for (Ilayout e : children) {
            if (n.father == null || !e.equals(n.father.layout)) {
                State nn = new State(e, n);
                if (!fechados.containsKey(nn.layout)) sucs.add(nn);
            }
        }
        return sucs;
    }

    final public Iterator<State> solve(Ilayout s, Ilayout goal) {
        objective = goal;
        abertos = new PriorityQueue<>(10, (s1, s2) -> (int) Math.signum(s1.getG() - s2.getG()));

        fechados = new HashMap<>();
        abertos.add(new State(s, null));
        List<State> sucs;

        while (true) {
            actual = abertos.poll();
            if (actual == null) System.exit(0);
            if (actual.layout.isGoal(objective)) break;
            fechados.put(actual.layout, actual);
            sucs = sucessores(actual);


            abertos.addAll(sucs);

            /*for (State st : sucs) {
                if (!fechados.containsValue(st)) abertos.add(st);
            }*/
        }

        List<State> solution = new ArrayList<>();

        while (actual != null) {
            solution.add(actual);
            actual = actual.father;
        }

        Collections.reverse(solution);

        return solution.iterator();
    }
}
