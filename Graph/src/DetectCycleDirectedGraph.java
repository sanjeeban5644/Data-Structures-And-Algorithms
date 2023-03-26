import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetectCycleDirectedGraph {
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{1,2},{2,3},{1,3},{4,5},{5,6},{4,6},{4,3}};
        List<List<Integer>> adjlist = new ArrayList<>();
        for(int i = 0;i<=n;i++){
            adjlist.add(new ArrayList<>());
        }
        for(int[] row : edges){
            adjlist.get(row[0]).add(row[1]);
        }
        System.out.println("Adjacency List is: "+adjlist);

        boolean[] visited = new boolean[n+1];
        Arrays.fill(visited,false);
        boolean[] recursionStack = new boolean[n+1];
        boolean ans=false;
        for(int i=1;i<=n;i++){
            if(visited[i]==false){
                if(dfs(adjlist,visited,recursionStack,i)) ans = true;
            }

        }



        System.out.println("Has Cycle: "+ans);


    }

    static boolean dfs(List<List<Integer>> adjlist,boolean[] visited,boolean[] rS,int curr){
        visited[curr] = true;
        rS[curr] = true;
        for(Integer neighbour : adjlist.get(curr)){
            if(visited[neighbour]==false){
                if(dfs(adjlist,visited,rS,neighbour)) return true;
            }else if(rS[neighbour]==true){
                return true;
            }
        }
        rS[curr]=false;
        return false;
    }

}
