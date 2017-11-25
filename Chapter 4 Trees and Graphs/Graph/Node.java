/**
 * Generic Node class for graphs and trees
 */

 public class Node{

   private T data;
   private Node[] children;
   public boolean visited = false;
   public Node(T data){
     data = data;
   }

   public Node(T data, Node[] children){
     data = data;
     children = children;
   }


 }
