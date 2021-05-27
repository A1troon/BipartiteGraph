import java.util.ArrayDeque;
import java.util.Queue;


public class EdmondsKarp {

    private int[][] flow; //max flow beetween i and j verticles
    private int[][] capacity; // edge capacity
    private int[] parent; //parent
    private boolean[] visited; //just for checking if visited
    @SuppressWarnings("unused")
    private int n, m;

    public EdmondsKarp(int numOfVerticles, int numOfEdges,int[][] capacity) {
        this.n = numOfVerticles;
        this.m = numOfEdges;
        this.flow = new int[n][n];
        this.capacity = capacity;
        this.parent = new int[n];
        this.visited = new boolean[n];
    }




    public int getMaxFlow(int s, int t) {
        while (true) {
            final Queue<Integer> Q = new ArrayDeque<Integer>();
            Q.add(s);

            for (int i = 0; i < this.n; ++i)
                visited[i] = false;
            visited[s] = true;

            boolean check = false;
            int current;
            while (!Q.isEmpty()) {
                current = Q.peek();
                if (current == t) {
                    check = true;
                    break;
                }
                Q.remove();
                for (int i = 0; i < n; ++i) {
                    if (!visited[i] && capacity[current][i] > flow[current][i]) {
                        visited[i] = true;
                        Q.add(i);
                        parent[i] = current;
                    }
                }
            }
            if (check == false)
                break;

            int temp = capacity[parent[t]][t] - flow[parent[t]][t];
            for (int i = t; i != s; i = parent[i])
                temp = Math.min(temp, (capacity[parent[i]][i] - flow[parent[i]][i]));

            for (int i = t; i != s; i = parent[i]) {
                flow[parent[i]][i] += temp;
                flow[i][parent[i]] -= temp;
            }
        }

        int result = 0;
        for (int i = 0; i < n; ++i)
            result += flow[s][i];
        return result;
    }
    public static long start(){
        int numOfEdges=0;
        int capacity[][] = GraphGenerator.getInstance().addStartEnd();
        int numOfVerticles=(int)capacity.length;
        for(int i=0;i<capacity.length;i++)
            for(int j=0;j<capacity.length;j++)
                if(capacity[i][j]==1)
                    numOfEdges++;

        EdmondsKarp edmondsKarp=new EdmondsKarp(numOfVerticles,numOfEdges,capacity);
        long start = System.currentTimeMillis();
        edmondsKarp.getMaxFlow(0,GraphGenerator.getGraphGenerator().getN()+1);

        long timeWorkCode = System.currentTimeMillis() - start;
        return timeWorkCode;
    }
}