import java.util.*;

public class BFS extends GraphSearchAlgorithm{

    @Override
    AbstractCollection<Node> initOpen() {
        return new LinkedList<>();
    }

    @Override
    Node nextNode(AbstractCollection open) throws Exception {
        if(open instanceof Queue) {
            return ((Queue<Node>)open).remove();
        } else{
            throw new Exception("Krivog tipa je open");
        }
    }
}
