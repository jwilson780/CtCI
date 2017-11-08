/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

/**
 * Sorted Singly Linked List
 * @author Steven
 * @version 2011.10.31
 */
public class SortedSLList {
    private int size;
    private SLListNode head;
    private SLListNode tail;
    
    /**
     * Clear the list
     */
    public void clear()
    {
        head=tail=null;
        size=0;
    }
    /**
     * @return If the list is empty
     */
    public boolean isEmpty()
    {
        return head==null;
    }
    /**
     * @return The size of the list
     */
    public int size()
    {
        return size;
    }
    /**
     * Insert the given element into the list
     * @param element: the element to be added to the list
     */
    public void insert(Object element)
    {
        SLListNode ref = head;
        SLListNode newNode = new SLListNode(element,null);
        if(head == null){
            head=tail=newNode;
            ++size;
            return;
        }
        if(((Comparable)(ref.data)).compareTo(element)>=0){
            head=newNode;
            newNode.next=ref;
            ++size;
            return;
        }
        while(ref.next!=null){
            if(((Comparable)(ref.next.data)).compareTo(element)>=0){
                newNode.next = ref.next;
                ref.next=newNode;
                ++size;
                return;
            }
            ref=ref.next;
        }
        tail.next=newNode;
        tail=tail.next;
        ++size;
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
        while((ref.next != tail)&&((Comparable)(ref.next.data)).compareTo(element)<=0){
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
    /**
     * @return String representation of the List
     * @overrides Object's toString method
     */
    public String toString()
    {
        String out = "Sorted SLList contains: \n";
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
}
