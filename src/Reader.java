import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class Reader {
    static GraphProblem[] getProblems(){
        GraphProblem[] problems = new GraphProblem[5];

        //!!!!pospremaj svako stanje jednom u memoriju za svaki par stanje-roditelj, da se moze koristiti path()
        //da vrati put do stanja
        Map<Node, Map<Node, Double>> succ = new HashMap<>();
        Node A = new Node("A", true);
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");
        Node G = new Node("G");
        Node H = new Node("H");
        Node I = new Node("I");
        Map<Node, Double> succA = new LinkedHashMap<>();
        Map<Node, Double> succB = new LinkedHashMap<>();
        Map<Node, Double> succC = new LinkedHashMap<>();
        succA.put(B, 1.);
        succA.put(C, 1.);
        succB.put(D, 1.);
        succB.put(E, 1.);
        succB.put(F, 1.);
        succC.put(G, 1.);
        succC.put(H, 1.);
        succC.put(I, 1.);
        succ.put(A, succA);
        succ.put(B, succB);
        succ.put(C, succC);
        GraphProblem zad1 = new SearchProblem(succ, A, G);
        problems[0] = zad1;

        //primjer za topolosko sortiranje
        Map<Node, Map<Node, Double>> succ2 = new HashMap<>();
        Node n5 = new Node("5", true);
        Node n7 = new Node("7", true);
        Node n3 = new Node("3", true);
        Node n11 = new Node("11");
        Node n8 = new Node("8");
        Node n2 = new Node("2");
        Node n9 = new Node("9");
        Node n10 = new Node("10");
        Map<Node, Double> succ5 = new LinkedHashMap<>();
        Map<Node, Double> succ7 = new LinkedHashMap<>();
        Map<Node, Double> succ3 = new LinkedHashMap<>();
        Map<Node, Double> succ11 = new LinkedHashMap<>();
        Map<Node, Double> succ8 = new LinkedHashMap<>();
        succ5.put(n11, 1.);
        succ7.put(n11, 1.);
        succ7.put(n8, 1.);
        succ3.put(n8, 1.);
        succ3.put(n10, 1.);
        succ11.put(n2, 1.);
        succ11.put(n9, 1.);
        succ11.put(n10, 1.);
        succ8.put(n9, 1.);
        succ2.put(n5, succ5);
        succ2.put(n7, succ7);
        succ2.put(n3, succ3);
        succ2.put(n11, succ11);
        succ2.put(n8, succ8);
        GraphProblem zad2 = new SearchProblem(succ2, n5, null);
        problems[1] = zad2;

        //kod inicijalizacije za problem A_star treba za nodeove pozvati konstruktor sa taman izracunatom heuristikom
        //ne implementiram heuristicke algoritme jer jedino o nodeovima znam prijelaze.

        return problems;
    }
}
