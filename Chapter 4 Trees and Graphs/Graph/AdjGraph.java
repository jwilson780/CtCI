import java.util.Random;
import java.util.Deque;
import java.util.ArrayDeque;
/**
 * Graph class for solving problems in the Chapter
 * Marty Robbins and it should handle loopbacks
 */


 public class AdjGraph{

   private int vertices;
   private int edges;
   private boolean[][] adjMatrix;

   /**
    * Creates an empty graph with v vertices
    */
   public AdjGraph(int v){
     if(v < 0){
       throw new RuntimeException("Can't have negative vertices");
     }
     vertices = v;
     edges = 0;
     adjMatrix = new boolean[v][v];
   }

   /**
    * Creates a randomly populated graph (mostly for testing)
    * "Goodbye is all we got left to say"
    */
    public AdjGraph(int v, int e){
      if(v < 0){
        throw new RuntimeException("Number of edges cant be neg");
      }
      if(e > v*(v-1)+v){
        throw new RuntimeException("Not enough vertices for edges");
      }

      vertices = v;
      edges = 0;
      adjMatrix = new boolean[v][v];

      while(edges != e){
        Random rand = new Random();
        int x = rand.nextInt(v);
        int y = rand.nextInt(v);
        addEdge(x,y);
      }
    }

    public boolean addEdge(int x, int y){
      if(!adjMatrix[x][y]){
        edges++;
        adjMatrix[x][y] = true;
        //adjMatrix[y][x] = true; //for undirected graph
        return true;
      }
      return false;
    }

    public boolean contains(int x, int y){
      return adjMatrix[x][y];
    }

    public void depthFirstSearch(int node){
      boolean[] visited = new boolean[vertices];
      depthFirstSearchHelper(node, visited);
    }

    private void depthFirstSearchHelper(int node, boolean[] visited){
      visited[node] = true;
      System.out.println(node + " ");
      for(int x = 0; x < vertices; ++x){
        if(contains(node, x) && !visited[x]){//contains my node and it hasn't been visited
          depthFirstSearchHelper(x, visited);
        }
      }
    }

    public void breadthFristSearch(int node){
      Deque<Integer> dq = new ArrayDeque<Integer>();
      boolean[] visited = new boolean[vertices];
      dq.add(node);
      while(dq.size() != 0){
        int n = (int)dq.remove();
        visited[n] = true; //visited the node
        System.out.print(n + " ");
        for(int i = 0; i < vertices; ++i){
          if(contains(n, i)){
            if(!visited[i]){//havent visited it before
              dq.add(i);
            }
          }
        }
      }

    }

    public void adjMatrixToString(){
      for(int i = 0; i < vertices; ++i){
        for(int x = 0; x < vertices; ++x){
            System.out.print(adjMatrix[i][x] + "\t");
        }
        System.out.print("\n");
      }
    }
    public static void main(String[] args){
      AdjGraph ad = new AdjGraph(6);
      ad.addEdge(0,1);
      ad.addEdge(1,2);
      ad.addEdge(1,5);
      ad.addEdge(2,3);
      ad.addEdge(3,4);
      ad.adjMatrixToString();
      //ad.breadthFristSearch(0);
      ad.depthFirstSearch(0);
    }
 }
