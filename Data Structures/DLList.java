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
public class DLList {
    public DLListNode head,tail;
    /**
     * Constructor for 
     * @param element: data to be added to list
     * @param h: head node
     * @param t: tail node
     */
    public DLList()
    {
        head=tail=null;
    }
    /**
     * @return If the DLList is empty
     */
    public boolean isEmpty()
    {
        return head==null;
    }
    /**
     * Clear the DLList
     */
    public void clear()
    {
        head=tail=null;
    }
    /**
     * Add given element to end of DLList
     * @param element: element to be added
     */
    public void append(Object element)
    {
        if(head==null){
            head=tail=new DLListNode(element,null,null);return;
        }
        tail=new DLListNode(element,tail,null);
        tail.prev.next=tail;
    }
    /**
     * Insert an element to the front of the DLList
     * @param element: element to be inserted
     */
    public void insert(Object element)
    {
        if(head==null){
            head=tail=new DLListNode(element,null,null);return;
        }
        head=new DLListNode(element,null,head);
        head.next.prev=head;
    }
    /**
     * Remove a given element
     * @param element: the element to be removed 
     */
    public void remove(Object element)
    {
        if(head==null)return;
        if(((Comparable)head.data).compareTo((Comparable)element)==0){
            if(head==tail){
                head=tail=null;
            }
            else{
                head=head.next;
                head.prev=null;
            }
            return;
        }
        if(head==tail)return;
        DLListNode ref = head.next;
        while(ref!=tail){
            if(((Comparable)ref.data).compareTo((Comparable)element)==0){
                ref.prev.next=ref.next;
                ref.next.prev=ref.prev;
                return;
            }
            ref=ref.next;
        }
        if(((Comparable)tail.data).compareTo((Comparable)element)==0){
            tail=tail.prev;
            tail.next=null;
        }
    }
    /**
     * @return A String representation of the DLList
     * @override Object's toString() method
     */
    public String toString()
    {
        String out = "DLList contains: \n";
        DLListNode ref = head;
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
