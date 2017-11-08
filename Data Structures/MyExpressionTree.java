/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

import java.lang.Character;

/**
 *
 * @author Steven
 * @version 2011.12.12
 */
public class MyExpressionTree extends MyBinaryTree {
    private String inorder ="";
    private String preorder ="";
    private String postorder ="";
    /**
     * Default constructor for MyExpressionTree
     */
    public MyExpressionTree()
    {
        root=null;
    }
    /**
     * Constructor for MyExpressionTree
     * @param rt: the root node
     */
    public MyExpressionTree(MyBinaryTreeNode rt)
    {
        root = rt;
    }
    /**
     * Take String representation of Postfix expression and convert it into a 
     * Binary expression tree.
     * @param postfix
     * @return Binary expression tree
     */
    public MyBinaryTreeNode postToExpressionTree(String postfix)
    {
        MyStack stack = new MyStack();
        MyDeque deque = new MyDeque();
        InToPostfixTranslator trans = new InToPostfixTranslator();
        
        int size = postfix.length();
        for(int i = 0; i< size; ++i){
            deque.append(new MyBinaryTreeNode(postfix.charAt(i)));
        }
        while(!deque.isEmpty()){
            MyBinaryTreeNode yo = (MyBinaryTreeNode)deque.front();
            if(Character.isDigit((Character)yo.data)){
                stack.push(deque.removeFront());
                continue;
            }
            if(trans.isValidOperator((Character)yo.data)){
                root = (MyBinaryTreeNode)deque.removeFront();
                root.right = (MyBinaryTreeNode)stack.pop();
                root.left = (MyBinaryTreeNode)stack.pop();
                stack.push(root);
            }
        }
        return root;
    }
    /**
     * Method that solves the expression tree
     * @return the integer value answer
     */
    public int evaluate()
    {
        if(evaluateHelper(root)==-1)
            System.out.println("Answer may be incorrect");
        return evaluateHelper(root);
    }
    /**
     * Method that traverses and evaluates the tree recursively
     * @return The answer to the solved expression tree, in integer form
     * @param rt: the root node of the expression tree
     */
    public int evaluateHelper(MyBinaryTreeNode rt)
    {
        Character yo = (Character)rt.data;
        if(rt==null)return -1;
        if(Character.isDigit(yo))return Character.getNumericValue(yo);
        switch(yo){
            case '+': return evaluateHelper(rt.left) + evaluateHelper(rt.right);
            case '-': return evaluateHelper(rt.left) - evaluateHelper(rt.right);
            case '*': return evaluateHelper(rt.left) * evaluateHelper(rt.right);
            case '/': return evaluateHelper(rt.left) / evaluateHelper(rt.right); 
            case '%': return evaluateHelper(rt.left) % evaluateHelper(rt.right);
        }
        return -1;
    }
    
    /**
     * Method that prints a preorder traversal of a binary expression tree
     * @return string representation of preorder traversal
     * @param x: Just used to make the method signature different
     */
    public String preorderTraversal(boolean x)
    {
        preorder ="";
        preorder(root);
        return preorder;
    }
    /**
     * Recursive helper method which contains the logic for the 
     * preorderTraversal method
     * @param rt: current root node
     */
    private void preorder(MyBinaryTreeNode rt)
    {
        if(rt==null)return;
        preorder += rt.data;
        preorder(rt.left);
        preorder(rt.right);
    }
    /**
     * Method that prints an inorder traversal of a binary expression tree
     * @return string representation of inorder traversal
     * @param x: Just used to make the method signature different
     */
    public String inorderTraversal(boolean x)
    {
        inorder = "";
        inorder(root);
        return inorder;
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
        inorder += rt.data;
        inorder(rt.right);
    }
    /**
     * Method that prints a postorder traversal of a binary expression tree
     * @return string representation of postorder traversal
     * @param x: Just used to make the method signature different
     */
    public String postorderTraversal(boolean x)
    {
        postorder = "";
        postorder(root);
        return postorder;
    }
    /**
     * Recursive helper method which contains the logic for the 
     * inorderTraversal method
     * @param rt: current root node
     */
    private void postorder(MyBinaryTreeNode rt)
    {
        if(rt==null)return;
        postorder(rt.left);
        postorder(rt.right);
        postorder += rt.data;
    }
}