
/**
 * Graph class for solving problems in the Chapter
 * Marty Robbins and it should handle loopbacks
 */


 public class BinaryTree<T>{

   private BinaryTreeNode root;

   public BinaryTree(){
     this.root = null;
   }

   /**
    * Creates a BinarySearchTree with a root node
    */
   public BinaryTree(T data){
     this.root = new BinaryTreeNode<T>(data);
     System.out.print(this.root.data);
   }

   /**
    * Creates a BinarySearchTree from a sorted list
    * "Goodbye is all we got left to say" Problem 2 (Days of the New)
    */
    public BinaryTree(int[] inputArray){
      //Need the middle of the array, then middle of subarray
      arrayCreater(inputArray, 0, inputArray.length);
    }

    /**
     * Creates a BinaryTree by splitting a list
     */
    private void arrayCreater(int[] array, int start, int end){
      if(start == end){//single node
        addNodeFromNode(new BinaryTreeNode<Integer>(array[start]));
        return;
      }
      int middle = (end-start)/2 + start;
      addNodeFromNode(new BinaryTreeNode<Integer>(array[middle]));
      arrayCreater(array, start, middle);//lower half
      arrayCreater(array, middle + 1, end);//upper half
    }

    /**
     * Adds a node based on its data
     *
     */
    public void addNodeFromData(T data){
      BinaryTreeNode<T> btn = new BinaryTreeNode<T>(data);
      addNodeHelper(this.root, btn);
    }

    /**
     * Adds an exisiting node to the tree
     */
    public void addNodeFromNode(BinaryTreeNode btn){
      System.out.println("btn data " + btn.data);
      addNodeHelper(this.root, btn);
    }

    /**
     * Recurisve method that actually does the adding of the nodes
     */
    private BinaryTreeNode addNodeHelper(BinaryTreeNode rt, BinaryTreeNode target){
      if(rt == null){
          this.root = target;
          System.out.println("Got here to create node");
          System.out.println("Data: " + target.data);
          return target;
      }
      if(target.compareTo(rt) < 0){
          System.out.println("Compare to the left works");
          rt.left = addNodeHelper(rt.left, target);
      }else{
          System.out.println("Compare to the right works");
          rt.right = addNodeHelper(rt.right, target);
      }
      return rt;
    }

    /**
     * @return The height of the tree
     */
    public int height(){
        return heightHelper(this.root, -1);
    }
    /**
     * Method that calculates the height of the tree
     * @param rt: the root of the recursive method's iteration
     * @param ht: the height of the recursive method's iteration
     * @return eventually returns the height
     */
    private int heightHelper(BinaryTreeNode rt, int ht){
        if(rt==null) return ht;
        return Math.max(heightHelper(rt.left,ht+1),heightHelper(rt.right,ht+1));
    }

    public void preorderTraversal(){
        System.out.println("Preorder:");
        preorder(this.root);
        System.out.println();
    }

    private void preorder(BinaryTreeNode rt){
        if(rt == null){
          return;
        }
        System.out.print("\t" + rt.data);
        preorder(rt.left);
        preorder(rt.right);
    }


    /**
    * Solves problem 3 you have to adjust the depth (set to 10 origionally)
    */
    public LinkedList<BinaryTreeNode>[] generateLevelLists(){
      Stack st = new Stack();
      LinkedList<BinaryTreeNode>[] list = new LinkedList[10];
      LinkedList<BinaryTreeNode>[] finished = generateListsHelper(st, this.root, list, 0);
      return finished;
    }

    private LinkedList<BinaryTreeNode>[] generateListsHelper(Stack st, BinaryTreeNode rt, LinkedList<BinaryTreeNode>[] list, int counter){
        if(rt.right == null && rt.left == null){//its a leaf so we put into the bottom list
          rt.visited = true;
          list[counter--].add(st.pop());
        }else if(rt.right.visted && rt.left.visited){//not a leaf but needs added
          rt.visited = true;
          list[counter--].add(st.pop());
        }else if(rt = root){
          list[counter].add(st.pop());
          return list;
        }
        stack.push(rt);
        generateListsHelper(st, rt.left, list, ++counter);
        generateListsHelper(st, rt.right, list, ++counter);
    }

    /*
     * Solves problem 4
     */
     public boolean isBalanced(BinaryTree bt){
       if(isBalancedHelper(bt.root, 0, 0) == 1 || isBalancedHelper(bt.root, 0, 0) == 0){
         return true;
       }else{
         return false;
       }
     }

     private int isBalancedHelper(BinaryTreeNode rt, int right, int left){
       if(rt == null){
         return 0;
       }
       isBalancedHelper(rt.right, right++, left);//go down left tree
       isBalancedHelper(rt.left, right, left++);//go down right
       return Math.abs(right - left);
       //all rights and all left branches should equal out or have a difference of 1
     }

     public boolean isBinarySearchTree(BinaryTree bt){
       isBinarySearchTreeHelper(bt.root);
     }

     private boolean isBinarySearchTreeHelper(BinaryTreeNode rt){
       if(rt.right.data > rt.data || rt.left.data < rt.data){
         return false;
       }
       isBinarySearchTreeHelper(rt.right);
       isBinarySearchTreeHelper(rt.left);
       return true;
     }

    public static void main(String[] args){
      BinaryTree<Integer> btTest = new BinaryTree<Integer>(4);
      //btTest.addNodeFromNode(new BinaryTreeNode<Integer>(4));
      System.out.println(btTest.root.data);
      //btTest.addNodeFromNode(new BinaryTreeNode<Integer>(3));
      //btTest.addNodeFromNode(new BinaryTreeNode<Integer>(5));
      //btTest.addNodeFromNode(new BinaryTreeNode<Integer>(7));
      //System.out.println(btTest.height());
      //btTest.preorderTraversal();
    }
 }
