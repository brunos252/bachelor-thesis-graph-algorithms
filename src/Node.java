import java.util.LinkedList;
import java.util.List;

class Node implements Comparable{

    private String name;
    private Node parent;
    private Double cost;

    public Node(String name, Node parent){
        this.name = name;
        this.parent = parent;
        if(parent == null)
            cost = 0.;
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
        if(this.cost == null || this.cost > cost) {
            this.cost = cost;
            return true;
        } else
            return false;
    }

    public Double getCost(){
        return cost;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Node){
            if(this.cost < ((Node) o).cost){
                return -1;
            } else if(this.cost > ((Node) o).cost){
                return 1;
            } else{
                return 0;
            }
        } else{
            throw new ClassCastException("");
        }
    }
}
