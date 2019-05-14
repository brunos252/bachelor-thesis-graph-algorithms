import java.util.AbstractCollection;
import java.util.PriorityQueue;

public class A_Star extends GraphSearchAlgorithm{
    @Override
    AbstractCollection<Node> initOpen() {
        return new PriorityQueue<>();
    }

    @Override
    Node nextNode(AbstractCollection open) throws Exception {
        if(open instanceof PriorityQueue) {
            return ((PriorityQueue<Node>)open).remove();
        } else{
            throw new Exception("Krivog tipa je open");
        }
    }
}
