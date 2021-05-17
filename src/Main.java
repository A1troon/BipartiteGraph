

public class Main {


    public static void main(String[] args) {

    int counter=0;
    for (int i=0;i<100;i++) {
        GraphGenerator.getInstance().newRandomGraph(1000);

        if (FordFulkerson.start()== Kuhn.start())
            counter++;
    }
        System.out.println(counter);


    }

}
