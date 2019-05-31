import java.util.*;

class GraphProblem {

    //mapa susjedstva, cvor te mapa njegovih susjeda sa cijenama prijelaza
    Map<Node, Map<Node, Double>> successors;
    Set<Node> nodes = new HashSet<>();

    GraphProblem(Map<Node, Map<Node, Double>> successors){
        this.successors = successors;
        this.nodes = successors.keySet();
    }

    Map<Node, Double> successors(Node n) {
        return successors.get(n);
    }
}
