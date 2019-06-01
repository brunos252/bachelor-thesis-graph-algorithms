/*
 * topoloski sort usmjerenog grafa, linearno rasporeduje vrhove grafa tako da za svaki usmjereni brid uv,
 * u je prije v u rasporedu
 *
 * topoloski sort je moguc samo ako graf nema usmjerenih ciklusa, tj on je usmjeren aciklicni graf (DAG)
 *
 * koristi osnovni razred GraphProblem koji samo zna
 */

import java.util.*;

public class TopologicalSort {

    List<Node> L = new LinkedList<>();
    GraphProblem problem;
    Random rand = new Random();

    public List<Node> run(GraphProblem problem){
        this.problem = problem;

        //open = withoutPermMark
        List<Node> open = new ArrayList<>();
        List<String> closed = new LinkedList<>();
        open.addAll(problem.getNodes());
        while(!open.isEmpty()){
          visit(open.remove(rand.nextInt(open.size())));
        }
        /*Node node;
        while(!open.isEmpty()){
            node = nextNode(open);
            System.out.println("posjecujem" + node);
            //closed je ovdje perm mark
            if(closed.contains(node.toString())){
                continue;
            }
            //sad ne postavljamo tempmark -> nema provjere za DAG

            Map<Node, Double> succ = problem.successors(node);
            if(succ != null) {
                for (Node m : succ.keySet()) {
                    m.setCost(node.getCost() + succ.get(m));
                    //nije kompatibilno sa GraphSearchAlgorithm i ne radi sa nextNode random
                    ((List<Node>)open).add(0, m);
                    //visit(m);
                }
            }
            closed.add(node.toString());

        }*/

        return L;
    }

    private Node nextNode(AbstractCollection<Node> open){
        return ((List<Node>)open).remove(rand.nextInt(open.size()));
    }

    private void visit(Node n){
        if(n.getMark() == Mark.PERMMARK)
            return;
        else if(n.getMark() == Mark.TEMPMARK){
            //znaci da nije DAG, baciti iznimku
            System.exit(1);
        }
        n.setMark(Mark.TEMPMARK);
        Map<Node, Double> succ = problem.successors(n);
        if(succ != null) {
            for (Node m : succ.keySet()) {
                visit(m);
            }
        }
        n.setMark(Mark.PERMMARK);
        L.add(0, n);
    }

}
