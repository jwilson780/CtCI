

public class Chapter4Problem1{

    /**
     * used to run and test the problem
     *
     */
      public static void main(String[] args){
          Chapter4Problem1 p1 = new Chapter4Problem1();
          AdjGraph ad = new AdjGraph(6);
          ad.addEdge(0,1);
          ad.addEdge(1,2);
          ad.addEdge(1,5);
          ad.addEdge(2,3);
          ad.addEdge(3,4);
          System.out.println(p1.problemOne(ad, 2, 4, 6));
      }

      /**
      * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
      */
      public boolean problemOne(AdjGraph adjGraph, int nodeA, int nodeB, int numberVerts){
        //do depth first search starting from node a and if we hit node b, we are Good
        //do a bidirectional search, not as easy and could be worse if they both dont touch/have long paths
        boolean[] visits = new boolean[numberVerts];
        problemOneHelper(adjGraph, nodeA, nodeB, visits);
        if(visits[nodeB] == true){
          return true;
        }else{
          return false;
        }
      }

      private void problemOneHelper(AdjGraph adj, int nodeA, int nodeB,  boolean[] visits){
        if(nodeA == nodeB){
          System.out.print(nodeA + " ");
          visits[nodeA] = true;
          return;
        }
        visits[nodeA] = true;
        System.out.print(nodeA + " ");
        for(int i = 0; i < visits.length; i++){
          if(adj.contains(nodeA, i) && !visits[i]){//link exists between them and havent seen it
            problemOneHelper(adj, i, nodeB, visits);//recursive step
          }
        }
      }
}
