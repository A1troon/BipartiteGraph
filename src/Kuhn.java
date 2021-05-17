import java.util.List;

public class Kuhn {
    public  static List<Integer>[] edgesL;
    public  static int [] edgeR;
    public  static boolean[] used;
    public static long start(){
        edgesL=GraphGenerator.getInstance().getListEdgeL();
        edgeR=new int[GraphGenerator.getInstance().getN()-GraphGenerator.getInstance().getL()];
        for (int i=0;i<edgeR.length;i++) {
            edgeR[i]=-1;
        }
        used=new boolean[GraphGenerator.getInstance().getL()];
        int size=GraphGenerator.getInstance().getL();
        long start = System.currentTimeMillis();
        for (int i=0;i<size;++i) {
            for (int j=0;j<used.length ; j++)
                used[j]=false;
            dfs(i);
        }
        long timeWorkCode = System.currentTimeMillis() - start;
        return timeWorkCode;
    }
    public static boolean dfs(int i){
        if (used[i])
            return false;
        used[i]=true;
        for (int j:edgesL[i]) {
            if (edgeR[j]==-1||dfs(edgeR[j])){
                edgeR[j]=i;
                return true;
            }
        }
        return false;
    }

}
