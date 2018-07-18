public class Chapter4Problem3{

    /**
     * used to run and test the problem
     *
     */
      public static void main(String[] args){

      }

      /**
      * List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes
      * at each depth (e.g., if you have a tree with depth 0, you'll have 0 linked lists).
      */
      public void problemThree(BinaryTree bt){
        //sort of like a post order traversal
        //make a stack, dump values onto stack
        //hit a leaf or (l and r) visited, check size of stack and pop off into that list
        Stack st = new Stack();
        LinkedList<BinaryTreeNode>[] list = bt.generateLevelLists();
        for(int i = 0; i < list.length; ++i){
          for(BinaryTreeNode btn : list[i]){
            System.out.print(btn.data + "\t");
          }
        }
        System.out.print("\n");
      }

}
