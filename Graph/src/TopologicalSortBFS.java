import java.util.*;

public class TopologicalSortBFS {
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{6,3},{6,2},{2,3},{3,1},{2,1},{5,1},{1,4},{5,4}};
        List<List<Integer>> adjlist = new ArrayList<>();
        for(int i = 0;i<=n;i++){
            adjlist.add(new ArrayList<>());
        }
        for(int[] row : edges){
            adjlist.get(row[0]).add(row[1]);
        }
        System.out.println("Adjacency List is: "+adjlist);

        int[] arr = new int[n+1];
        Arrays.fill(arr,0);
        for(List<Integer> l : adjlist){
            for(Integer i : l){
                arr[i]++;
            }
        }

        System.out.println(Arrays.toString(arr));
        List<Integer> ans = bfs(adjlist,arr);
        System.out.println("Topological Sorting is: "+ans);

    }

    static List<Integer> bfs(List<List<Integer>> adjlist,int[] arr){
        List<Integer> temp = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1;i<=6;i++){
            if(arr[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            temp.add(curr);

            for(int neighbour : adjlist.get(curr)){
                if(--arr[neighbour]==0){
                    q.add(neighbour);
                }
            }
        }


        return temp;
    }

}
