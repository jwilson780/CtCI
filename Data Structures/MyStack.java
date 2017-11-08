/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

/**
 *
 * @author Steven
 * @version 2011.4.11
 */
public class MyStack {
    private SLListNode top;
    /**
     * Constructor for MyStack
     */
    public MyStack()
    {
        top=null;
    }
    /**
     * Clear the stack
     */
    public void clear()
    {
        top=null;
    }
    /**
     * @return if the stack is empty
     */
    public boolean isEmpty()
    {
        return top==null;
    }
    /**
     * Remove and use the topmost element of the stack
     * @return The object on the top of the stack
     */
    public Object pop()
    {
        if(top==null)
            return null;
        Object temp = top.data;
        top=top.next;
        return temp;
    }
    /**
     * Put the given element onto the top of the stack
     * @param element: The element to be put at the top of the stack
     */
    public void push(Object element)
    {
        top=new SLListNode(element,top);
    }
    /**
     * @return The value at the top of the stack
     */
    public Object top()
    {
        if(top==null)
            return null;
        return top.data;
    }
    /**
     * @return A string representation of the stack
     * @overrides Object's toString method
     */
    public String toString()
    {
        String str = "Stack Contains: \n [";
        SLListNode temp = top;
        while(temp!=null){
            str+=","+temp.data;
            temp=temp.next;
        }
        str+="]";
        return str.replaceFirst(",", "");
    }
}