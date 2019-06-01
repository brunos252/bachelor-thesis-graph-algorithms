import java.util.LinkedList;
import java.util.List;

class Node implements Comparable{

    private String name;
    private Node parent;
    private boolean isRootNode;
    private Double cost;
    private Double heuristic = 0.;
    private Mark mark;

    //konstruktor za algoritme bez heuristika i osnovni konstruktor koji svi pozivaju
    public Node(String name, boolean isRootNode){
        this.name = name;
        this.isRootNode = isRootNode;
        if(isRootNode)
            cost = 0.;
        mark = Mark.NONE;
    }

    //ako nije root node ne treba se navesti
    public Node(String name){
        this(name, false);
    }

    //konstruktor za A_star
    public Node(String name, boolean isRootNode, Double heuristic){
        this(name, isRootNode);
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
        return isRootNode;
    }

    public void setParent(Node parent){
        this.parent = parent;
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

    public void setMark(Mark mark){
        this.mark = mark;
    }

    public Mark getMark(){
        return mark;
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
