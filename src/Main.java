import java.util.HashMap;

public class Main {


    public static void main(String[] args) {
        int[][] a = GraphGenerator.getInstance().newRudenGraph(6,3);
        for (int i = 0; i < a.length; i++) {
            System.out.println(" ");
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[i][j] + " ");
            }
        }

    }


}
