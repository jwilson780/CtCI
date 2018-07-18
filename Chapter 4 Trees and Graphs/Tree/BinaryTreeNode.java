/**
 * Generic Node class for graphs and trees
 */

 public class BinaryTreeNode<T> implements Comparable<BinaryTreeNode>{

   public T data;
   public BinaryTreeNode left;
   public BinaryTreeNode right;
   public boolean visited = false;

   public BinaryTreeNode(T data){
     data = data;
     left = null;
     right = null;
   }

   public BinaryTreeNode(T data, BinaryTreeNode left, BinaryTreeNode right){
     data = data;
     left = left;
     right = right;
   }

   public int compareTo(BinaryTreeNode btn){
     if((Integer)this.data == (Integer)btn.data){
       return 0;
     }else if((Integer)this.data > (Integer)btn.data){
       return -1;
     }else{
       return 1;
     }
   }


 }
