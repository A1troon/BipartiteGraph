import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GraphGenerator {
    private  static GraphGenerator graphGenerator;
    private int[][] graph;
    private List<Integer>[] listEdgeL; //хранит для левых вершин список связанных с ним из правых
    private int N;  //всего вершин
    private int L;  //вершин слева от 0 до L-1
    private int V; //кол-во ребер
    private GraphGenerator(){
    }
    public static GraphGenerator getInstance(){
        if(graphGenerator==null)
            graphGenerator=new GraphGenerator();
        return graphGenerator;
    }
    public GraphGenerator newRandomGraph(int n){
        V=0;
        this.N=n;
        graph=new int[n][n];
        Random random=new Random();
        L=n*(random.nextInt(10)+40)/100;
        listEdgeL =new ArrayList[L];
        for(int i=0;i<L;i++) {
            listEdgeL[i]=new ArrayList();
            for (int j = L; j < n; j++)
                if (random.nextBoolean()) {
                    V++;
                    listEdgeL[i].add(j-this.L);
                    graph[i][j] = 1;
                    graph[j][i] = 1;
                }
        }
        return graphGenerator;
    }
    public void printGraph() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(graph[i][j] + ", ");
            System.out.print("\n");

        }

    }

    public int[][] getGraph() {
        return graph;
    }

    public void setGraph(int[][] graph) {
        this.graph = graph;
    }

    public List[] getListEdgeL() {
        return listEdgeL;
    }

    public void setListEdgeL(List[] listEdgeL) {
        this.listEdgeL = listEdgeL;
    }

    public int getN() {
        return N;
    }

    public void setN(int n) {
        N = n;
    }

    public int getL() {
        return L;
    }

    public void setL(int l) {
        L = l;
    }

    public int getV() {
        return V;
    }

    public void setV(int v) {
        V = v;
    }

    public static GraphGenerator getGraphGenerator() {
        return graphGenerator;
    }

    public static void setGraphGenerator(GraphGenerator graphGenerator) {
        GraphGenerator.graphGenerator = graphGenerator;
    }


    public List<Integer>[] addOneToListEdge(){
        List<Integer>[] newList=new ArrayList[L+1];;
        for(int i=1;i<newList.length;i++){
            newList[i]=new ArrayList<>();
            for(int j=0;j<listEdgeL[i-1].size();j++)
                newList[i].add(listEdgeL[i-1].get(j)+1);
        }
        return newList;
    }
    public int[][] addStartEnd(){
        int mas[][]=new int[N+2][N+2];
        for(int i=1;i<L+1;i++)
            mas[0][i]=1;
        for(int i=1;i<N+1;i++){
            if(i>=L+1) {
                mas[i][N+1] = 1;
                continue;
            }
            for(int j=1;j<N+1;j++){
                mas[i][j]=graph[i-1][j-1];

            }
        }

    return mas;
    }
}
