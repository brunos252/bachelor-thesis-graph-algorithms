import java.util.LinkedList;
import java.util.List;

class Node implements Comparable{

    private String name;
    private Node parent;
    private Double cost;
    private Double heuristic = 0.;

    //konstruktor za algoritme bez heuristika
    public Node(String name, Node parent){
        this.name = name;
        this.parent = parent;
        if(parent == null)
            cost = 0.;
    }

    //konstruktor za A_star
    public Node(String name, Node parent, Double heuristic){
        this(name, parent);
        this.heuristic = heuristic;
    }

    List<Node> path() {
        List<Node> list;
        if(parent == null) {
            list = new LinkedList<>();
        } else {
            list = parent.path();
        }
        list.add(this);
        return list;
    }

    public boolean isRootNode() {
        return parent == null;
    }

    public Node getParent() {
        return parent;
    }

    public String getName(){
        return name;
    }

    public boolean setCost(Double cost){
        //radi li BFS i DFS bez ovoga?
        /*if(this.cost == null || this.cost > cost) {
            this.cost = cost;
            return true;
        } else
            return false;*/
        this.cost = cost;
        return true;
    }

    public Double getCost(){
        return cost;
    }

    public Double getHeuristic(){
        return heuristic;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Node){
            Node other = (Node) o;
            if(this.cost + this.heuristic < other.getCost() + other.getHeuristic()){
                return -1;
            } else if(this.cost + this.heuristic > other.getCost() + other.getHeuristic()){
                return 1;
            } else{
                return 0;
            }
        } else{
            throw new ClassCastException("");
        }
    }
}
