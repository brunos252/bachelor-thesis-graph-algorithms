import java.util.*;

abstract class GraphSearchAlgorithm {

    public List<Node> run(Node s0, SearchProblem problem) throws Exception {
        Node node = s0;
        AbstractCollection<Node> open = initOpen();
        open.add(node);
        Set<Node> closed = new HashSet<>();
        while(! open.isEmpty()){
            node = nextNode(open);
            if(problem.isGoalState(node)){
                return node.path();
            }
            if(!closed.contains(node)){
                closed.add(node);
                Map<Node, Double> succ = problem.successors(node);
                for(Node m : succ.keySet()){
                    //if(m.getCost() == null || m.getCost() > node.getCost() + succ.get(m)){
                    m.setCost(node.getCost() + succ.get(m));
                    open.add(m);
                }
            }
        }
        return null;
    }

    abstract AbstractCollection<Node> initOpen();

    abstract Node nextNode(AbstractCollection open) throws Exception;

}
