import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetectCycleInUndirectedGraph {
    public static void main(String[] args) {
        int n = 10;
        int[][] edges = {{1,2},{1,3},{1,4},{4,5},{4,6},{5,8},{6,9},{4,7},{7,10},{2,4}};
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

        boolean hasCycle = dfs(adjlist,visited,0,1);
        System.out.println("Does Graph has Cycle: "+hasCycle);

    }

    static boolean dfs(List<List<Integer>> adjlist,boolean[] visited,int parent,int currnode){
        visited[currnode]=true;
        for(Integer neighbour : adjlist.get(currnode)){
            if(!visited[neighbour]){
                if(dfs(adjlist,visited,currnode,neighbour)) return true;
            }else if(parent!=neighbour){
                return true;
            }
        }
        return false;
    }


}
