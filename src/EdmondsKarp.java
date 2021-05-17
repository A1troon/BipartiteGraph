
import java.lang.*;
import java.util.LinkedList;

class EdmondsKarp {
    static int V;
    public EdmondsKarp(int v) {
        this.V=v;
    }


    boolean bfs(int rGraph[][], int s, int t, int parent[])
    {
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; ++i)
            visited[i] = false;

        LinkedList<Integer> queue
                = new LinkedList<Integer>();
        queue.add(s);
        visited[s] = true;
        parent[s] = -1;

        while (queue.size() != 0) {
            int u = queue.poll();

            for (int v = 0; v < V; v++) {
                if (visited[v] == false
                        && rGraph[u][v] > 0) {
                    if (v == t) {
                        parent[v] = u;
                        return true;
                    }
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }
        return false;
    }

    int fordFulkerson(int graph[][], int s, int t)
    {
        int u, v;

        int rGraph[][] = new int[V][V];

        for (u = 0; u < V; u++)
            for (v = 0; v < V; v++)
                rGraph[u][v] = graph[u][v];

        int parent[] = new int[V];

        int max_flow = 0; // There is no flow initially

        while (bfs(rGraph, s, t, parent)) {

            int path_flow = Integer.MAX_VALUE;
            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                path_flow
                        = Math.min(path_flow, rGraph[u][v]);
            }


            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                rGraph[u][v] -= path_flow;
                rGraph[v][u] += path_flow;
            }

            max_flow += path_flow;
        }


        return max_flow;
    }

    public static long start()
    {
        int graph[][] = GraphGenerator.getInstance().addStartEnd();
        EdmondsKarp m = new EdmondsKarp(GraphGenerator.getGraphGenerator().getN()+2);
        long start = System.currentTimeMillis();
        m.fordFulkerson(graph, 0, GraphGenerator.getGraphGenerator().getN()+1);
        long timeWorkCode = System.currentTimeMillis() - start;
        return timeWorkCode;

    }
}