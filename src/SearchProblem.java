import java.util.Map;

class SearchProblem extends GraphProblem {

    Node s0, goal;

    SearchProblem(Map<Node, Map<Node, Double>> successors, Node s0, Node goal) {
        super(successors);
        this.s0 = s0;
        this.goal = goal;
    }

    boolean isGoalState(Node n) {
        return n.getName().equals(goal.getName());
    }

    Node startState(){
        return s0;
    }
}
