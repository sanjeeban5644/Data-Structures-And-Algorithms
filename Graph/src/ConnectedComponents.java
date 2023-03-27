import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConnectedComponents {
    public static void main(String[] args) {
        int n = 13;
        int[][] edges = {{1,2},{1,3},{1,4},{4,5},{4,6},{5,8},{6,9},{4,7},{7,10},{11,12},{12,13}};
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
        int ans = 0;
        for(int i = 1;i<=n;i++){
            if(visited[i]==false){

                dfs(adjlist,visited,i);
                ans++;
            }
        }
        System.out.println("The total no.of connected components are: "+ans);

    }

    static void dfs(List<List<Integer>> adjlist,boolean[] visited,int i){
        visited[i]=true;
        for(Integer neighbour : adjlist.get(i)){
            if(!visited[neighbour]){
                dfs(adjlist,visited,neighbour);
            }
        }
    }



}
