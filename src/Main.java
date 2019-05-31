import java.util.List;

public class Main {

    public static void main(String[] args) {
        GraphProblem[] problems = Reader.getProblems();
        GraphSearchAlgorithm bfs = new BFS();
        GraphSearchAlgorithm dfs = new DFS();
        TopologicalSort ts = new TopologicalSort();

        try {
            /*
            List<Node> path = bfs.run((SearchProblem) problems[0]);
            System.out.println("put do cvora je: ");
            for(Node n : path){
                System.out.println(n);
            }
            */
            ts.run(problems[1]);
            //System.out.println(path.get(path.size() - 1).getCost());
        } catch(Exception e){
            System.out.println("zez" + e);
        }
    }
}
