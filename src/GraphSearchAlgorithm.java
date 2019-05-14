import java.util.*;

abstract class GraphSearchAlgorithm {

    public List<Node> run(SearchProblem problem) throws Exception {
        Node node = problem.startState();
        AbstractCollection<Node> open = initOpen();
        open.add(node);
        //Set<Node> closed = new HashSet<>();
        List<String> closed = new LinkedList<>();
        while(! open.isEmpty()){
            node = nextNode(open);
            System.out.println("posjecujem: " + node);
            if(closed.contains(node.toString())){
                continue;
            }

            closed.add(node.toString());

            if(problem.isGoalState(node)){
                return node.path();
            }
            //toString samo ako je closed List<String>!!
            Map<Node, Double> succ = problem.successors(node);
            if(succ != null) {
                for (Node m : succ.keySet()) {
                    //if(m.getCost() == null || m.getCost() > node.getCost() + succ.get(m)){
                    //ovo je u python kodu za a_star ali izgleda nepotrebno:
                    //if(!closed.contains(m.toString())){
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
