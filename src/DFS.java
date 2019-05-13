import java.util.AbstractCollection;
import java.util.Stack;

public class DFS extends GraphSearchAlgorithm{

    @Override
    AbstractCollection<Node> initOpen() {
        return new Stack<>();
    }

    @Override
    Node nextNode(AbstractCollection open) throws Exception {
        if(open instanceof Stack) {
            return ((Stack<Node>)open).pop();
        } else{
            throw new Exception("Krivog tipa je open");
        }
    }
}
