import java.util.LinkedList;
import java.util.List;

class Node {

    private String name;
    private Node parent;
    private boolean isRootNode;
    private Double cost;

    public Node(String name, Node parent, boolean isRootNode){
        this.name = name;
        this.parent = parent;
        this.isRootNode = isRootNode;
    }

    List<Node> path() {
        List<Node> list;
        if(isRootNode) {
            list = new LinkedList<>();
        } else {
            list = parent.path();
        }
        list.add(0, this);
        return list;
    }

    public boolean isRootNode() {
        return isRootNode;
    }

    public Node getParent() {
        return parent;
    }

    public String getName(){
        return name;
    }

    public void setCost(Double cost){
        this.cost = cost;
    }

    public Double getCost(){
        return cost;
    }

    @Override
    public String toString() {
        return name;
    }
}
