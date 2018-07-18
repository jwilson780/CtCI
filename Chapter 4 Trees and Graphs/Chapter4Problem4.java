public class Chapter4Problem4{

    /**
     * used to run and test the problem
     *
     */
      public static void main(String[] args){

      }

      /**
      * Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of
      * this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
      * node never differ by more than one.
      */
      public void problemFour(BinaryTree bt){
        //you just need to check the subtree recursively and compare right to left
        //they can't be more than 1 apart
        bt.isBalanced(bt);
      }

}
