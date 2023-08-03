import java.util.*;

public class DirectedGraph {

    static boolean isCycle(Map<Integer, List<Integer>> adjList,boolean[] visited,boolean[] recur,int curr){
        visited[curr]=true;
        recur[curr]=true;
        for(int i = 0;i<adjList.get(curr).size();i++){
            int neighbour = adjList.get(curr).get(i);
            if(recur[neighbour]==true){
                return true;
            }else if(visited[neighbour]==false){
                if(isCycle(adjList,visited,recur,neighbour)){
                    return true;
                }
            }
        }
        recur[curr]=false;
        return false;
    }

    static void createAdjList(int n,int[][] edges,Map<Integer, List<Integer>> adjList){
        for(int i = 0;i<n;i++){
            adjList.put(i,new ArrayList<>());
        }
        for(int[] row : edges){
            adjList.get(row[0]).add(row[1]);
        }
        System.out.println(adjList);
    }
    static void calcIndegree(int n, int[] indegree,Map<Integer, List<Integer>> adjList){
        for(int i = 0;i<n;i++){
            for(int j = 0;j<adjList.get(i).size();j++){
                indegree[adjList.get(i).get(j)]++;
            }
        }
    }

    static void topologicalSort(int n, int[] indegree,Map<Integer, List<Integer>> adjList,List<Integer> list){
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        System.out.print("Topological Sort is: ");
        while(!q.isEmpty()){
            int val = q.poll();
            list.add(val);
            for(int i = 0;i<adjList.get(val).size();i++){
                int neighbour = adjList.get(val).get(i);
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    q.add(neighbour);
                }
            }
        }
        System.out.println(list);
    }

    public static void main(String[] args) {
        int n = 10; // total no.of vertices
        int[][] edges = {{0,1},{0,2},{6,2},{2,3},{1,4},{1,5},
                {3,4},{3,7},{4,8},{5,8},{7,6},{7,9},{8,9}};
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        createAdjList(n,edges,adjList);
        boolean[] visited = new boolean[n];
        boolean[] recur = new boolean[n];
        System.out.println("Cycle Present: "+isCycle(adjList,visited,recur,0));
        int[] inDegree = new int[n];
        calcIndegree(n,inDegree,adjList);
        System.out.println(Arrays.toString(inDegree));
        topologicalSort(n,inDegree,adjList,new ArrayList<>());
    }
}
