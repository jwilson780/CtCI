/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

/**
 *
 * @author Steven
 * @version 2011.11.4
 */
public class MyQueue {
    private SLListNode front;
    private SLListNode rear;
    /**
     * Constructor for MyQueue 
     */
    public MyQueue()
    {
        front=rear=null;
    }
    /**
     * Clear the queue
     */
    public void clear()
    {
        front=rear=null;
    }
    /**
     * @return if the queue is empty
     */
    public boolean isEmpty()
    {
        return front==null;
    }
    /**
     * Insert an element onto the back of the queue
     * @param element: The element to be added
     */
    public void insertBack(Object element)
    {
        if(front==null){
            front=rear=new SLListNode(element,null);
            return;
        }
        rear=rear.next=new SLListNode(element,null);
    }
    /*
     * @return The object being removed from the front of the queue
     */
    public Object removeFront()
    {
        if(front==null)
            return null;
        Object temp = front.data;
        if(front==rear){
            front=rear=null;
            return temp;
        }
        front = front.next;
        return temp;
    }
    /**
     * @return The element at the front of the queue
     */
    public Object front()
    {
        if(front==null)
            return null;
        return front.data;
    }
    /**
     * @return A string representation of the Queue
     * @overides Object's toString method
     */
    public String toString()
    {
        String str = "Queue Contains: \n [";
        SLListNode temp = front;
        while(temp!=null){
            str+=","+temp.data;
            temp=temp.next;
        }
        str+="]";
        return str.replaceFirst(",", "");
    }
    /**
     * @return A clone of the current queue
     */
    public MyQueue clone()
    {
        MyQueue cloneQueue = new MyQueue();
        SLListNode temp = front;
        while(temp!=null){
            cloneQueue.insertBack(temp.data);
            temp=temp.next;
        }
        return cloneQueue;
    }
}

