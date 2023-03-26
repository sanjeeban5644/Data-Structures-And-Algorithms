import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphDFS {
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
        int source = 1;
        dfs(adjlist,visited,1);

    }

    static void dfs(List<List<Integer>> adjlist,boolean[] visited,int src){
        //if(visited[src]) return;
        visited[src]=true;
        System.out.print(" "+src);
        for(Integer neighbour : adjlist.get(src)){
            if(!visited[neighbour]){
                dfs(adjlist,visited,neighbour);
            }
        }




//        for(int i = 0;i<len;i++){
//            src = adjlist.get(src).get(i);
//            System.out.println(src);
//            dfs(adjlist,visited,src);
//
//        }
    }

}
