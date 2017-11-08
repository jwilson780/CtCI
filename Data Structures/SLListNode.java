/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

/**
 *
 * @author Steven
 * @version 2011.10.31
 */
public class SLListNode {
    public Object data;
    public SLListNode next;
    
    public SLListNode(Object d, SLListNode n)
    {
        data = d;
        next = n;
    }
}
