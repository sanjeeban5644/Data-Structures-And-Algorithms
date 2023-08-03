

public class GraphAlgorithms2 {

    static final int INF = Integer.MAX_VALUE/2;

    public static void main(String[] args) {
        int V = 4;
        int[][] graph = {{0,3,INF,7},{8,0,2,INF},{5,INF,0,1},{2,INF,INF,0}};
        floydWarshall(graph,V);
    }

    static void floydWarshall(int[][] graph,int V){
        for(int k = 0;k<V;k++){
            for(int i = 0;i<V;i++){
                for(int j = 0;j<V;j++){
                    graph[i][j] = Math.min(graph[i][j],graph[i][k]+graph[k][j]);
                }
            }
        }

        System.out.println("Final Matrix is: ");
        for(int i = 0;i<V;i++){
            for(int j = 0;j<V;j++){
                System.out.print(" "+graph[i][j]);
            }
            System.out.println();
        }
    }
}
