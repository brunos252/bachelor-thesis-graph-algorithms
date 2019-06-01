/*
 * 2-obojivost, graf je bipartitan ako mu se vrhovi mogu podijeliti u dva neovisna skupa, takva da se svaki vrh iz
 * jednog skupa se spaja sa jednim vrhom iz drugog
 * bipartitan graf nema ciklusa neparne duljine
 * svaki brid mora povezivati dva vrha razlicite boje!
 */

import java.util.*;

public class BipartitenessTest {

    public boolean run(SearchProblem problem) throws Exception {
        Node node = problem.startState();
        AbstractCollection<Node> open = initOpen();
        open.add(node);
        //Set<Node> closed = new HashSet<>();
        //List<String> closed = new LinkedList<>();
        while(! open.isEmpty()){
            node = nextNode(open);
            System.out.print("posjecujem: " + node);
            if(node.isRootNode()){
                node.setMark(Mark.TEMPMARK);
            } else if(node.getMark() == Mark.NONE){
                node.setMark(node.getParent().getMark() == Mark.TEMPMARK ? Mark.PERMMARK : Mark.TEMPMARK);
            } else if (node.getMark() == node.getParent().getMark()){
                return false;
            }
            System.out.println(" boja: " + node.getMark());

            Map<Node, Double> succ = problem.successors(node);
            if(succ != null) {
                for (Node m : succ.keySet()) {
                    if(m.getParent() != null && m.getParent() != node){
                        if(m.getParent().getMark() != node.getMark()){
                            return false;
                        }
                    }
                    m.setParent(node);
                    open.add(m);
                }
            }

        }
        return true;
    }

    AbstractCollection<Node> initOpen() {
        return new Stack<>();
    }

    Node nextNode(AbstractCollection open) throws Exception {
        if(open instanceof Stack) {
            return ((Stack<Node>)open).pop();
        } else{
            throw new Exception("Krivog tipa je open");
        }
    }
}
