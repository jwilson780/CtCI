public class Chapter4Problem2{

    /**
     * used to run and test the problem
     *
     */
      public static void main(String[] args){

      }

      /**
      * Minimal Tree: Given a sorted (increasing order) array with unique
      * integer elements, write an algorithm to create a binary search tree
      * with minimal height.
      */
      public boolean problemTwo(int[] sortedArray){
        BinaryTree bt = new BinaryTree(sortedArray);
        bt.btToString();
      }

}
