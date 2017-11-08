/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

/**
 *
 * @author Steven
 * @version 2011.9.26
 */
public class MyVector implements Cloneable {
    
    private static final int INITIAL_CAPACITY = 100;
    private Object[] data;
    private int size;
    
    /**
     * Constructor for MyVector
     * Initialize size and Object[] fields
     */
    public MyVector()
    {
        data = new Object[INITIAL_CAPACITY];
        size = 0;
    }
    
    /**
     * Append the element to the end of the vector
     * @param element : The Object to be added to the vector
     */
    public void append(Object element)
    {
        if(size == data.length)
            extend();
        data[size++] = element;
    }
    
    /**
     * Extend the size of the array to a larger capacity
     */
    public void extend()
    {
        Object[] temp = new Object[data.length*2];
        for(int i = 0; i<size; ++i){
            temp[i] = data[i];
        }
        data = temp;
    }
    
    /**
     * Make the vector collection empty
     */
    public void clear()
    {
        for(int i = 0; i<size; ++i){
            data[i] = null;
            size = 0;
        }
    }
    
    /**
     * Check to see whether or not the vector contains the provided element
     * @param element : The element being tested
     * @return true if it does contain it, false if not
     */
    public boolean contains(Object element)
    {
        for(int i=0; i<size; ++i){
            if(data[i].equals(element))
            return true;
        }
        return false;
    }
    
    /**
     * Find Element at given index
     * @param index : The index being accessed
     * @return the element at the given index
     */
    public Object elementAt(int index)
    {
        if(index<0 || index > size)
            return null;
        return data[index];
    }
    
    /**
     * Find index value of a given element
     * @param element : the element to be searched for
     * @return the index where the element is located
     */
    public int indexOf(Object element)
    {
        for(int i=0; i<size; ++i){
            if(data[i].equals(element))
                return i;
        }
        return -1;
    }
    
    /**
     * Insert a given element at a given index
     * @param index: the index at which to insert the element at
     * @param element: the element to insert at the index]
     * @return true if item was added, false if not
     */
    public boolean insertAt(int index, Object element)
    {
        if(index<0 || index >= size)
            return false;
        if(size==data.length)
            extend();
        for(int i=size; i>index; --i){
            data[i] = data[i-1];
        }
        data[index] = element;
        ++size;
        return true;
    }
    
    /**
     * Check to see whether the current vector is empty
     * @return true if the vector is empty, false if it is not
     */
    public boolean isEmpty()
    {
        if(data[0] == null && size == 0)
            return true;
        return false;
    }
    
    /**
     * Remove an element from the given index
     * @param index: the location of the element to be removed
     * @return the object being removed
     */
    public Object removeAt(int index)
    {
        if(index<0 || index >= size)
            return null;
        Object value = data[index];
        for(int i=index; i<size-1; ++i){
            data[i] = data[i+1];
        }
        data[size-1] = null;
        size--;
        return value;
    }
    
    /**
     * Remove the given element from the vector
     * @param element: The element you want to remove from the vector
     * @return the index where it was located
     */
    public int remove(Object element)
    {
        int index =0;
        for(int i=0; i<size; ++i){
            if(data[i].equals(element))
                index = i;
            break;
        }
        removeAt(index);
        return index;
    }
        
    /**
     * Replace an object in a given index with another given object
     * @param index: location of element to be replaced
     * @param element: element that is to replace other element in vector
     */
    public void replace(int index, Object element)
    {
        if(index<0 || index >= size)
            return;
        data[index] = element;
    }
    
    /**
     * @return the number of elements in the vector
     */
    public int size()
    {
        return size;
    }
    
    /**
     * Make sure the vector gets at least the given capacity
     * @param minCapacity: The minimum amount which the vector should hold
     */
    public void ensureCapacity(int minCapacity)
    {
        if(minCapacity < data.length)
            return;
        Object[] temp = new Object[minCapacity];
        for(int i = 0; i<size; ++i){
            temp[i] = data[i];
        }
        data = temp;
    }
    
    /**
     * @returns a cloned copy of this vector
     * @override clone method in Cloneable()
     */
    public MyVector clone()
    {
        MyVector copy = new MyVector();
        copy.ensureCapacity(size);
        for(int i=0; i<size; ++i){
            copy.data[i]=data[i];
        }
        copy.size = size;
        return copy;
    }
    
    /**
     * Remove the values in the given range of indexes
     */
    public void removeRange(int fromIndex, int toIndex)
    {
        if(fromIndex > size && toIndex > size)return;
        if(fromIndex > toIndex){
            int temp = fromIndex;
            fromIndex = toIndex;
            toIndex = temp;
        }
        if(fromIndex < 0)fromIndex = 0;
        if(toIndex > size) toIndex = size;
        int diff = toIndex - fromIndex;
        for(int i=fromIndex; i<size-diff; ++i){
            data[i] = data[i+diff];
        }
        for(int i=size-diff; i<size; ++i){
            data[i] = null;
        }
        size -= diff;                   
    }    
    
    /**
     * @return a string representation of the vector (Print out 
     * all the elements of the vector, with corresponding index)
     * @override toSting method of Object
     */
    public String toString()
    {
        String str = "Collection size = " + size + "\n" + "Contents: \n";
        for(int i=0; i<size; ++i){
            str += "" + i + " : " + data[i] + "\n";
        }
        str += "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
        return str;
    }
    
    /**
     * Take the elements of the vector and reverse them
     */
    public void reverse()
    {
        Object temp = null;
        for(int i = 0; i <size/2; ++i){
            temp = data[i];
            data[i] = data[size-1-i];
            data[size-1-i] = temp;
        }
    }
    
    /**
     * Add elements in vector2 to the elements in the current vector
     * @param vector2: the vector which has the elements to be added to the
     * other vector
     */
    public void merge(MyVector vector2)
    {
        int q =0;
        int num = size+vector2.size();
        for(int i=size; i<num; ++i){
            append(vector2.elementAt(q++));
        }
    }
}
