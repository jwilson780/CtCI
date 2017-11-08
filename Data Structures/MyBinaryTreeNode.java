/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

/**
 * @author Steven
 * @version 2011.11.21
 */
public class MyBinaryTreeNode implements Comparable <MyBinaryTreeNode> {
    public Object data;
    public MyBinaryTreeNode left;
    public MyBinaryTreeNode right;
    /**
     * Constructor for MyBinaryTreeNode 
     * @param d: data associated with the node
     */
    public MyBinaryTreeNode(Object d)
    {
        data = d;
        left = null;
        right = null;
    }
    /**
     * Constructor for MyBinaryTreeNode 
     * @param d: data associated with the node
     * @param l: left child reference
     * @param r: right child reference
     */
    public MyBinaryTreeNode(Object d, MyBinaryTreeNode l, MyBinaryTreeNode r)
    {
        data = d;
        left = l;
        right = r;
    }
    /**
     * @return A String representation of the Binary tree node
     * @override Object's toString method
     */
    public String toString()
    {
        return data.toString();
    }
    /**
     * @param target: The node being searched for
     * @return negative if target is greater than calling value
     *         positive if target is less than calling value
     *         zero if target is equal to calling value
     * @override Comparable's compareTo method
     */
    public int compareTo(MyBinaryTreeNode target)
    {
        return ((Comparable)this.data).compareTo(target.data);
    }
}
