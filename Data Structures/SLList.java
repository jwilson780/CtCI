/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

/**
 * Singly Linked List Node collection
 * @author Steven
 * @version 2011.10.31
 */
public class SLList 
{
    private SLListNode head;
    private SLListNode tail;
    
    /**
     * Constructor for SLList class
     */
    public SLList()
    {
        head = tail = null;
    }
    /**
     * Add a node with the given element to the end of the list
     * @param element: the element you want to add to the list
     */
    public void append(Object element)
    {
        if(head==tail){
            head=tail=new SLListNode(element,null);
            return;
        }
        tail=tail.next=new SLListNode(element,null);
    }
    /**
     * Insert a node with the given element at the beginning of the list
     * @param element: the element to be added to the list
     */
    public void insert(Object element)
    {
        if(head==null){
            head=tail=new SLListNode(element,head);
            return;
        }
        head=new SLListNode(element,head);
    }
    /**
     * Clear the list
     */
    public void clear()
    {
        head=tail=null;
    }
    /**
     * @return If the list is empty
     */
    public boolean isEmpty()
    {
        return head==null;
    }
    /**
     * Prints a string representation of the list
     * @overrides Objects toString method
     * @return string representation of list
     */
    public String toString()
    {
        String out = "SLList contains: \n";
        SLListNode ref = head;
        if(isEmpty())
            return out + "0 Nodes";
        else
            out+="head :" + ref.data +"\n";
        int j =1;
        while(ref.next!=null){
            
            out+=ref.data + "\t->\t";
            if(j%5 ==0)
                out+="\n";
            ref=ref.next;
            ++j;
        }
        out+=ref.data + "\t->\tnull";
        return out;
    }
    /**
     * Remove the given element from the list
     * @param element: the element to be removed
     * @return if the element was removed
     */
    public boolean remove(Object element)
    {
        if(head==null)return false;
        if(((Comparable)(head.data)).compareTo((Comparable)element)==0){
            if(head==tail){
                head=tail=null;
                return true;
            }
            head=head.next;
            return true;
        }
        if(head==tail)return false;
        SLListNode ref = head;
        while(ref.next != tail){
            if(((Comparable)(ref.next.data)).compareTo(element)==0){
                ref.next = ref.next.next;
                return true;
            }
            ref=ref.next;
        }
        if(((Comparable)(tail.data)).compareTo(element)==0){
            ref.next=null;
            tail=ref;
            return true;
        }
        return false;
    }
}
