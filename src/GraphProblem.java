import java.util.*;

class GraphProblem {

    //mapa susjedstva, cvor te mapa njegovih susjeda sa cijenama prijelaza
    Map<Node, Map<Node, Double>> successors;
    Set<Node> nodes = new HashSet<>();

    GraphProblem(Map<Node, Map<Node, Double>> successors){
        this.successors = successors;
        this.nodes.addAll(successors.keySet());
        for(Map<Node, Double> map : successors.values()){
            nodes.addAll(map.keySet());
        }

    }

    Map<Node, Double> successors(Node n) {
        return successors.get(n);
    }

    Set<Node> getNodes(){
        return this.nodes;
    }
}
