import java.util.*;

public class Graph {

    static void createAdjList(int n,int[][] edges,Map<Integer, List<Integer>> adjList){
        for(int i = 0;i<n;i++){
            adjList.put(i,new ArrayList<>());
        }
        for(int[] row : edges){
            adjList.get(row[0]).add(row[1]);
            adjList.get(row[1]).add(row[0]);
        }
        System.out.println(adjList);
    }

    static void createAdjMat(int n,int[][] edges,int[][] adjMat){
        for(int[] row : edges){
            adjMat[row[0]][row[1]]=1;
            adjMat[row[1]][row[0]]=1;
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                System.out.print(" "+adjMat[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int n = 10; // total no.of vertices
        int[][] edges = {{0,1},{0,2},{2,6},{2,3},{1,4},{1,5},
                          {3,4},{3,7},{4,8},{5,8},{6,7},{7,9},{8,9}};

        // Implementation of Adjacency List
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        createAdjList(n,edges,adjList);

        // Implementation of Adjacency Matrix
        int[][] adjMat = new int[n][n];
        createAdjMat(n,edges,adjMat);

        // Traversing using BFS
        boolean[] visited = new boolean[n];
        Arrays.fill(visited,false);
        bfs(visited,adjList,0);
        bfs(n,visited,adjMat,0);

        // Traversing using DFS
        System.out.println("DFS Traversal is: ");
        dfs(visited,adjList,0);
        dfs(n,visited,adjMat,0);

        printPath(visited,adjList,new ArrayList<>(),1,5);
    }


    static void printPath(boolean[] visited,Map<Integer, List<Integer>> adjList,List<Integer> path,int curr,int target){

        path.add(curr);
        visited[curr]=true;
        if(curr==target){
            System.out.println(path);
            return;
        }

        for(int i =0;i<adjList.get(curr).size();i++){
            int neighbour = adjList.get(curr).get(i);
            if(!visited[neighbour]){
                printPath(visited,adjList,path,neighbour,target);
                path.remove(path.size()-1);
                visited[neighbour]=false;
            }
        }
    }

    static void dfs(int n,boolean[] visited,int[][] adjMat,int curr){
        System.out.print(" "+curr);
        visited[curr]=true;
        for(int i = 0;i<n;i++){
            if(adjMat[curr][i]==1 && visited[i]==false){
                dfs(n,visited,adjMat,i);
            }
        }
    }

    static void dfs(boolean[] visited,Map<Integer, List<Integer>> adjList,int curr){
        System.out.print(" "+curr);
        visited[curr]=true;
        for(int i = 0;i<adjList.get(curr).size();i++){
            if(visited[adjList.get(curr).get(i)]==false){
                dfs(visited,adjList,adjList.get(curr).get(i));
            }
        }
    }

    static void bfs(int n,boolean[] visited,int[][] adjMat,int vertex){
        Queue<Integer> q = new LinkedList<>();
        q.add(vertex);
        visited[vertex]=true;
        System.out.println("BFS Traversal is: ");
        while(!q.isEmpty()){
            int curr = q.poll();
            System.out.print(" "+curr);
            for(int i = 0;i<n;i++){
                if(adjMat[curr][i]==1 && visited[i]==false){
                    q.add(i);
                    visited[i]=true;
                }
            }
        }
    }

    static void bfs(boolean[] visited,Map<Integer, List<Integer>> adjList,int vertex){
         Queue<Integer> q = new LinkedList<>();
         q.add(vertex);
         System.out.println("BFS Traversal is: ");
         while(!q.isEmpty()){
             int curr = q.poll();
             if(visited[curr]==false){
                 System.out.print(" "+curr);
                 visited[curr]=true;
                 for(int i = 0;i<adjList.get(curr).size();i++){
                     q.add(adjList.get(curr).get(i));
                 }
             }
         }
    }
}
