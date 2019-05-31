/*
 * topoloski sort usmjerenog grafa, linearno rasporeduje vrhove grafa tako da za svaki usmjereni brid uv,
 * u je prije v u rasporedu
 *
 * topoloski sort je moguc samo ako graf nema usmjerenih ciklusa, tj on je usmjeren aciklicni graf (DAG)
 *
 * koristi osnovni razred GraphProblem koji samo zna
 */

import java.util.HashSet;
import java.util.Set;

public class TopologicalSort {

    public void run(GraphProblem problem){
        Set<Node> S = new HashSet<>();

        for(Node n : problem.nodes){
            if(n.isRootNode()){
                S.add(n);
            }
        }
        for(Node n : S){
            System.out.println(n);
        }
    }

}
