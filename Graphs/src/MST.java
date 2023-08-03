import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MST {

    static class Edge{
        int src;
        int dest;
        int cost;

        Edge(int src,int dest,int cost){
            this.src=src;
            this.dest=dest;
            this.cost=cost;
        }
    }

    static void createGraph(ArrayList<Edge> graph[],int V){
        for(int i = 0;i<V;i++){
            graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,2,15));
        graph[0].add(new Edge(0,3,30));

        graph[1].add(new Edge(1,3,40));
        graph[1].add(new Edge(1,0,10));

        graph[2].add(new Edge(2,0,15));
        graph[2].add(new Edge(2,3,50));

        graph[3].add(new Edge(3,1,40));
        graph[3].add(new Edge(3,0,30));
        graph[3].add(new Edge(3,2,50));
    }

    static class Pair implements Comparable<Pair>{
        int node;
        int cost;
        Pair(int node,int cost){
            this.node = node;
            this.cost = cost;
        }
        @Override
        public int compareTo(Pair p) {
            return this.cost-p.cost;
        }
    }

    static void KruskalsAlgo(ArrayList<Edge> graph[],int V,int start){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[V];
        //pq.add(new Pair(0,0));
        int minCost = 0;
        for(int i = 0;i<V;i++){
            for(int j = 0;j<graph[i].size();j++){
                Edge curr = graph[i].get(j);
                pq.add(new Pair(curr.dest,curr.cost));
            }
        }
        visited[start]=true;
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            if(!visited[curr.node]){
                visited[curr.node]=true;
                minCost+=curr.cost;

                for(int i = 0;i<graph[curr.node].size();i++){
                    Edge e = graph[curr.node].get(i);
                }
            }
        }
        System.out.println("The Minimal Cost through Kruskal's Algo is: "+minCost);
    }

    static void PrimsAlgo(ArrayList<Edge> graph[],int V){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[V];
        pq.add(new Pair(0,0));
        int minCost = 0;

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            if(!visited[curr.node]){
                visited[curr.node]=true;

                minCost+=curr.cost;

                for(int i = 0;i<graph[curr.node].size();i++){
                    Edge e = graph[curr.node].get(i);
                    if(!visited[e.dest]){
                        pq.add(new Pair(e.dest,e.cost));
                    }
                }
            }
        }
        System.out.println("The Minimal Cost through Prim's Algo is: "+minCost);
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph,V);
        PrimsAlgo(graph,V);
        KruskalsAlgo(graph,V,0);
    }
}
