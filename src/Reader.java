import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

class Reader {
    static Problem[] getProblems(){
        Problem[] problems = new Problem[5];

        //!!!!pospremaj svako stanje jednom u memoriju za svaki par stanje-roditelj, da se moze koristiti path()
        //da vrati put do stanja
        Map<Node, Map<Node, Double>> succ = new HashMap<>();
        Node A = new Node("A", null);
        Node B = new Node("B", A);
        Node C = new Node("C", A);
        Node D = new Node("D", B);
        Node E = new Node("E", B);
        Node F = new Node("F", B);
        Node G = new Node("G", C);
        Node H = new Node("H", C);
        Node I = new Node("I", C);
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
        Problem zad1 = new SearchProblem(succ, A, I);
        problems[0] = zad1;

        //kod inicijalizacije za problem A_star treba za nodeove pozvati konstruktor sa taman izracunatom heuristikom
        //ne implementiram heuristicke algoritme jer jedino o nodeovima znam prijelaze.

        return problems;
    }
}
