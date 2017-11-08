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
public class MyDeque extends DLList {
    /**
     * Constructor for MyDeque
     * @param head
     * @param tail 
     */
    public MyDeque()
    {
        super();
    }
    /**
     * @return The front of the Deque
     */
    public Object front()
    {
        if(head==null)return null;
        return head.data;
    }
    /**
     * @return The back of the deque
     */
    public Object back()
    {
        if(head==null)return null;
        return tail.data;
    }
    /**
     * Add an element to the end of the deque
     * @param element 
     */
    public void insertBack(Object element)
    {
        append(element);
    }
    /**
     * Remove the last element of the deque
     * @return the previous last element
     */
    public Object removeBack()
    {
        if(head==null)return null;
        Object temp = back();
        if(head==tail){
            head=tail=null;
            return temp;
        }
        tail=tail.prev;
        tail.next=null;
        return temp;
    }
    /**
     * Insert an element into the front of the deque
     * @param element: The element to insert in the front of the deque
     */
    public void insertFront(Object element)
    {
        insert(element);
    }
    /**
     * Remove the first element of the deque
     * @return the element that was removed
     */
    public Object removeFront()
    {
        if(head==null)return null;
        Object temp=front();
        if(head==tail)
            head=tail=null;
        else{
            head=head.next;
            head.prev=null;
        }
        return temp;
    }
    /**
     * @return A String representation of the Deque
     * @override Object's toString() method
     */
    public String toString()
    {
        String out = "Deque contains: \n";
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
