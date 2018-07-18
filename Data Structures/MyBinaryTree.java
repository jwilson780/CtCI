/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

/**
 *
 * @author Steven
 * @version 2011.11.21
 */
public abstract class MyBinaryTree {
    public MyBinaryTreeNode root;
    public String preorder;
    /**
     * Clear the binary tree
     */
    public void clear()
    {
        root = null;
    }
    /**
     * @return The size(number of nodes) in the binary tree
     */
    public int size()
    {
        return sizeHelper(root);
    }
    /**
     * Method to help the size method calculate the number of nodes in the tree
     * @param The root node of this iteration of the recursive method
     * @return eventually returns the size of the tree
     */
    private int sizeHelper(MyBinaryTreeNode rt)
    {
        if(rt==null)
            return 0;
        return sizeHelper(rt.left) + sizeHelper(rt.right)+1;
    }
    /**
     * @return The height of the tree
     */
    public int height()
    {
        return heightHelper(root, -1);
    }
    /**
     * Method that calculates the height of the tree
     * @param rt: the root of the recursive method's iteration
     * @param ht: the height of the recursive method's iteration
     * @return eventually returns the height
     */
    private int heightHelper(MyBinaryTreeNode rt, int ht)
    {
        if(rt==null) return ht;
        return Math.max(heightHelper(rt.left,ht+1),heightHelper(rt.right,ht+1));
    }
//    /**
//     * Method that prints a preorder traversal of a binary search tree
//     */
//    public void preorderTraversal()
//    {
//        System.out.println("Preorder:");
//        preorder(root);
//        System.out.println();
//    }
//    /**
//     * Recursive helper method which contains the logic for the
//     * preorderTraversal method
//     * @param rt: current root node
//     */
//    private void preorder(MyBinaryTreeNode rt)
//    {
//        if(rt==null)return;
//        System.out.print("\t"+rt.data);
//        preorder(rt.left);
//        preorder(rt.right);
//    }

    /**
     * Method that prints a preorder traversal of a binary expression tree
     */
    public String preorderTraversal()
    {
        String temp=preorder;
        preorder = "";
        String str = temp;
        preorder(root);
        return str;
    }
    /**
     * Recursive helper method which contains the logic for the
     * preorderTraversal method
     * @param rt: current root node
     */
    private void preorder(MyBinaryTreeNode rt)
    {
        if(rt == null){
          return;
        }
        System.out.print("\t" + rt.data);
        preorder(rt.left);
        preorder(rt.right);
    }


    /**
     * Method that prints a inorder traversal of a binary search tree
     */
    public void inorderTraversal()
    {
        System.out.println("Inorder:");
        inorder(root);
        System.out.println();
    }
    /**
     * Recursive helper method which contains the logic for the
     * inorderTraversal method
     * @param rt: current root node
     */
    private void inorder(MyBinaryTreeNode rt)
    {
        if(rt==null)return;
        inorder(rt.left);
        System.out.print("\t"+rt.data);
        inorder(rt.right);
    }
    /**
     * Method that prints a postorder traversal of a binary search tree
     */
    public void postorderTraversal()
    {
        System.out.println("Postorder:");
        postorder(root);
        System.out.println();
    }
    /**
     * Recursive helper method which contains the logic for the
     * postorderTraversal method
     * @param rt: current root node
     */
    private void postorder(MyBinaryTreeNode rt)
    {
        if(rt==null)return;
        postorder(rt.left);
        postorder(rt.right);
        System.out.print("\t"+rt.data);
    }
}
