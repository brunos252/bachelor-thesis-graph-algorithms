import java.util.List;
import java.util.Map;

class Problem {

    Map<Node, Map<Node, Double>> successors;

    Problem(Map<Node, Map<Node, Double>> successors){
        this.successors = successors;
    }

    boolean isGoalState(Node n) {
        return n.isRootNode();
    }

    Map<Node, Double> successors(Node n) {
        return successors.get(n);
    }
    //!!!!pospremaj svako stanje jednom u memoriju za svaki par stanje-roditelj, da se moze koristiti path()
    //da vrati put do stanja
}
