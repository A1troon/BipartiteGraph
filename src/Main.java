

public class Main {


    public static void main(String[] args) {
        int n=10;             //n-сколько итераций
        for(int i=0;i<n;i++) {
            GraphGenerator.getInstance().newRandomGraph(1000);   //1000-сколько вершин в графе
            System.out.println(Kuhn.start() + "Кун");
            System.out.println(HopcroftKarp.start() + "Хопкрофт Карп");
            System.out.println(FordFulkerson.start() + "Форд Фалкерсон");
            System.out.println(EdmondsKarp.start() + "Едмондс Карп");
        }

    }

}
