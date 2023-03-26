import java.util.*;

public class GraphBFS {
    public static void main(String[] args) {
        int n = 10;
        int[][] edges = {{1,2},{1,3},{1,4},{4,5},{4,6},{5,8},{6,9},{4,7},{7,10}};
        List<List<Integer>> adjlist = new ArrayList<>();
        for(int i = 0;i<=n;i++){
            adjlist.add(new ArrayList<>());
        }
        for(int[] row : edges){
            adjlist.get(row[0]).add(row[1]);
            adjlist.get(row[1]).add(row[0]);
        }
        System.out.println("Adjacency List is: "+adjlist);

        boolean[] visited = new boolean[n+1];
        Arrays.fill(visited,false);

        bfs(adjlist,visited);

    }

    static void bfs(List<List<Integer>> adjlist,boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 1;i<=len;i++){
                int node = q.poll();
                if(!visited[node]){

                    int l = adjlist.get(node).size();
                    for(int j = 0;j<l;j++){
                        q.add(adjlist.get(node).get(j));
                    }
                    visited[node]=true;
                }
            }
            System.out.println("Queue: "+q);
        }
    }

}
