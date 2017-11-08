/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

/**
 *
 * @author Steven
 * @version 2011.11.16
 */
public class DLListNode {
    public Object data;
    public DLListNode prev;
    public DLListNode next;
    /**
     * Constructor for DLListNode
     * @param d: data
     * @param p: prev
     * @param n: next
     */
    public DLListNode(Object d, DLListNode p, DLListNode n)
    {
        data=d;
        prev=p;
        next=n;
    }
}
