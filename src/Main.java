import java.util.HashMap;

public class Main {


    public static void main(String[] args) {
        HashMap<Integer,Long> hashmap=new HashMap();
        int v=GraphGenerator.getInstance().newRandomGraph(10).getV();
        hashmap.put(v,HopcroftKarp.start());
        hashmap.forEach((i,j)-> System.out.println(i+"ребер"+j+"мс"));

    }


}
