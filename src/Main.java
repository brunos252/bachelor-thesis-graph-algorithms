import java.util.List;

public class Main {

    public static void main(String[] args) {
        GraphProblem[] problems = Reader.getProblems();
        GraphSearchAlgorithm bfs = new BFS();
        GraphSearchAlgorithm dfs = new DFS();
        TopologicalSort ts = new TopologicalSort();
        BipartitenessTest bt = new BipartitenessTest();

        try {
            //List<Node> path = dfs.run((SearchProblem) problems[0]);
            //List<Node> path = ts.run(problems[2]);
            //System.out.println("put do cvora je: ");
            //for(Node n : path) {
            //    System.out.println(n);
            //}

            boolean bool = bt.run((SearchProblem) problems[0]);
            if(bool){
                System.out.println("bipartitan je");
            } else{
                System.out.println("nije bipartitan");
            }


            //System.out.println(path.get(path.size() - 1).getCost());
        } catch(Exception e){
            System.out.println("zez" + e);
        }
    }
}
