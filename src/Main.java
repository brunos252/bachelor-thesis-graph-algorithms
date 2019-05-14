import java.util.List;

public class Main {

    public static void main(String[] args) {
        Problem[] problems = Reader.getProblems();
        GraphSearchAlgorithm bfs = new BFS();
        GraphSearchAlgorithm dfs = new DFS();

        try {
            List<Node> path = dfs.run((SearchProblem) problems[0]);
            System.out.println("put do cvora je: ");
            for(Node n : path){
                System.out.println(n);
            }
            //System.out.println(path.get(path.size() - 1).getCost());
        } catch(Exception e){
            System.out.println("jebaja" + e);
        }
    }
}
