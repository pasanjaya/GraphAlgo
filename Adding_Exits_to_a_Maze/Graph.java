import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;


public class Graph{

    private int numVerties;
    private LinkedList<Integer> adjList[];
    private boolean visited[];
    private int ccnum[];
    private int cc = 0;

    Graph(int verties){
        this.numVerties = verties;
        adjList = new LinkedList[verties];
        visited = new boolean[verties];
        ccnum = new int[verties];

        for(int i = 0; i < verties; i++){
            adjList[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int src, int dest){
        adjList[src].add(dest);

        adjList[dest].add(src); // due to an Undirected graph
        
    }

    public void display(){
        for(int i = 0; i < numVerties; i++){
            System.out.print("Vertex "+ (i) +" is connected to: ");
            for(int j = 0; j < adjList[i].size(); j++){
                System.out.print(adjList[i].get(j) + " ");
            }
            System.out.println();
        }
    }

    public void explore(int vertex){
        visited[vertex] = true;
        ccnum[vertex] = cc;

        Iterator iterator = adjList[vertex].listIterator();
        while(iterator.hasNext()){
            int adj = (int)iterator.next();
            if(!visited[adj]){
                explore(adj);
            }
        }
    }

    public void DFS(){
        for(int i = 0; i< numVerties; i++){
            visited[i] = false;
        }
        // int cc = 1;
        
        for(int i = 0; i < numVerties; i++){
            if(!visited[i]){
                explore(i);
                cc += 1;
            }
        }
        System.out.println("CC count: " + cc);


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Graph g = new Graph(n);

        while(m > 0){
            int u = sc.nextInt();
            int v = sc.nextInt();
            g.addEdge(u, v);
            m--;
        }
        sc.close();

        g.display();
        g.DFS();
        
    }
}