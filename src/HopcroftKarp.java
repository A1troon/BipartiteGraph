import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HopcroftKarp {
    static final int NIL = 0;
    static final int INF = Integer.MAX_VALUE;
    public  static List<Integer>[] edgesL;
    public  static List<Integer>[] edgesR;
    public static Queue<Integer> Q;
    public  static int[] dist;
    public static int pairU[];
    public static int pairV[];
    public static long start(){
            Q= new LinkedList<>();
            pairU=new int[GraphGenerator.getInstance().getL()+1];
            pairV=new int[GraphGenerator.getInstance().getN()-GraphGenerator.getInstance().getL()+1];
            dist=new int[GraphGenerator.getInstance().getL()+1];
            edgesL=GraphGenerator.getInstance().addOneToListEdge();

            Arrays.fill(pairU, NIL);
            Arrays.fill(pairV, NIL);
            long start = System.currentTimeMillis();
            while(bfs()==true){
                for(int u=1;u<GraphGenerator.getInstance().getL()+1;u++) {
                    if (pairU[u]==NIL)
                        dfs(u);
                }
            }
            long timeWorkCode = System.currentTimeMillis() - start;
            return timeWorkCode;

    }
    public static boolean bfs(){
        for(int u=1;u<GraphGenerator.getInstance().getL()+1;u++) {
            if (pairU[u]==NIL) {
                dist[u] = 0;
                Q.add(u);
            } else {
                dist[u] = INF;
            }
        }
            dist[NIL]=INF;
            while(!Q.isEmpty()) {
                int u = Q.poll();

                if (dist[u] <dist[NIL])
                    for (int v:edgesL[u]) {
                        if (dist[pairV[v]]==INF) {
                            dist[pairV[v]] = dist[u] + 1;
                            Q.add(pairV[v]);
                        }
                    }
            }
            return (dist[NIL] != INF);
        }
        public static boolean dfs(int u){
            if (u!=NIL){
                for (int v:edgesL[u]) {
                    if (dist[pairV[v]] == dist[u] + 1)
                        if (dfs(pairV[v])) {
                            pairV[v] = u;
                            pairU[u] = v;
                            return true;
                        }
                }
                dist[u] = INF;
                return false;
            }
            return true;
    }

}

