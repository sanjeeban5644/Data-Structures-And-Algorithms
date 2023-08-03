import java.util.*;

public class GraphAlgorithms1 {

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

    static void createGraph(ArrayList<Edge> graph[], int v){
        for(int i = 0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,1,2));
        graph[2].add(new Edge(2,0,-12));
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,7));
        graph[2].add(new Edge(2,4,3));
        graph[4].add(new Edge(4,3,2));
        graph[3].add(new Edge(3,5,1));
        graph[4].add(new Edge(4,5,5));
    }

    public static class Pair implements Comparable<Pair>{
        int node;
        int dist;

        Pair(int node,int dist){
            this.node = node;
            this.dist = dist;
        }
        @Override
        public int compareTo(Pair p) {
            return this.dist-p.dist; //ascending
        }
    }

    static void djikstra(ArrayList<Edge> graph[],int V,int src){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] distance = new int[V];
        for(int i = 0;i<distance.length;i++){
            if(i!=src){
                distance[i]=Integer.MAX_VALUE;
            }
        }
        boolean[] visited = new boolean[V];

        pq.add(new Pair(0,0));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            if(!visited[curr.node]){
                visited[curr.node]=true;

                for(int i = 0;i<graph[curr.node].size();i++){
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    if(distance[u]+e.cost<distance[v]){
                        distance[v]=distance[u]+e.cost;
                        pq.add(new Pair(v,distance[v]));
                    }
                }
            }
        }
        System.out.println("Shortest Path through Djikstra is: ");
        for(int i = 0;i<distance.length;i++){
            System.out.println(i+" : "+distance[i]);
        }
    }

    static void bellmanFord(ArrayList<Edge> graph[],int V,int src){
        int[] distance = new int[V];
        for(int i = 0;i<distance.length;i++){
            if(i!=src){
                distance[i]=Integer.MAX_VALUE;
            }
        }

        for(int k = 0;k<V-1;k++){
            for(int i = 0;i<V;i++){
                for(int j = 0;j<graph[i].size();j++){
                    Edge e = graph[i].get(j);
                    int u = e.src;
                    int v= e.dest;

                    if(distance[u]+e.cost<distance[v]){
                        distance[v]=distance[u]+e.cost;
                    }
                }
            }
        }
        System.out.println("Shortest Path through BellMan-Ford is: ");
        for(int i = 0;i<distance.length;i++){
            System.out.println(i+" : "+distance[i]);
        }
        // Checking for -ve edge cycle
        for(int i = 0;i<V;i++){
            for(int j = 0;j<graph[i].size();j++){
                Edge e = graph[i].get(j);
                int u = e.src;
                int v= e.dest;

                if(distance[u]+e.cost<distance[v]){
                    System.out.println("There is -ve weight cycle");
                }
            }
        }
    }

    public static void main(String[] args) {
        //Map<Integer, List<Integer>> graph = new HashMap<>();
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph,v);
        djikstra(graph,v,0);
        bellmanFord(graph,v,0);
    }
}
