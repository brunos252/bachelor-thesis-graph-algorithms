import java.util.List;
import java.util.Map;

class SearchProblem extends Problem {

    SearchProblem(Map<Node, Map<Node, Double>> successors, Node s0, Node goal) {
        super(successors, s0, goal);
    }
}
