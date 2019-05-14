import java.util.List;
import java.util.Map;

class Problem {

    //mapa susjedstva, cvor te mapa njegovih susjeda sa cijenama prijelaza
    Map<Node, Map<Node, Double>> successors;
    Node s0, goal;

    Problem(Map<Node, Map<Node, Double>> successors, Node s0, Node goal){
        this.successors = successors;
        this.s0 = s0;
        this.goal = goal;
    }

    boolean isGoalState(Node n) {
        return n.getName().equals(goal.getName());
    }

    Node startState(){
        return s0;
    }

    Map<Node, Double> successors(Node n) {
        return successors.get(n);
    }
}
