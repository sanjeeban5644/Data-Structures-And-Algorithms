import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TopologicalSortDFS {
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{6,3},{6,2},{2,3},{3,1},{2,1},{5,1},{1,4},{4,5}};
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

        Stack<Integer> st = new Stack<>();

        for(int i = 1;i<=n;i++){
            if(!visited[i]){
                dfs(adjlist,visited,i,st);
            }

        }
        int[] arr = new int[n];
        int k = 0;
        while(!st.isEmpty()){
            arr[k]=st.pop();
            k++;
        }
        System.out.println(Arrays.toString(arr));
    }


    static void dfs(List<List<Integer>> adjlist,boolean[] visited,int curr,Stack<Integer> st){
        visited[curr]= true;
        for(Integer neighbour : adjlist.get(curr)){
            if(!visited[neighbour]){
                dfs(adjlist,visited,neighbour,st);
            }
        }
        st.push(curr);
    }





}
