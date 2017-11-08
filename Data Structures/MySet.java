/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

/**
 *
 * @author Steven
 * @version 2011.10.8
 */
public class MySet {
    
    private MyVector vec;
    
    /**
     * Constructor for MySet
     */
    public MySet(){
        vec = new MyVector();
    }
    
    /**
     * @return the number of elements in the list
     */
    public int cardinality()
    {
        return vec.size();
    }
    
    /**
     * Makes the set empty
     */
    public void clear()
    {
        vec.clear();
    }
    
    /**
     * Returns the set that contains the values from the current set
     * minus the given set
     * @param B: the set to be subtracted from the current set
     * @return the set containing "current set - B" elements
     */
    public MySet complement(MySet B)
    {
        MySet temp = new MySet();
        for(int i=0; i<vec.size(); ++i){
            if(!B.contains(vec.elementAt(i)))
            {
                temp.insert(vec.elementAt(i));
            }
            
        }
        return temp;
    }
    
    /**
     * Checks to see whether the set contains a certain value
     * @param element: the element to be searched for
     * @return whether or not the value is in the set
     */
    public boolean contains(Object element)
    {
        for(int i=0; i<vec.size(); i++){
            if(vec.elementAt(i).equals(element))
                return true;
        }
        return false;
    }
    
    /**
     * Add a new element to the set
     * @param element: The element to be added to the set
     * @return whether or not the element was added
     */
    public boolean insert(Object element)
    {
        if(contains(element)!=true){
            vec.append(element);
            return true;
        }
        return false;
    }
    
    /**
     * @param B: The set to be intersected with the current set
     * @return the set that is the intersection of the current set and
     * the given set
     */
    public MySet intersection(MySet B)
    {
        MySet temp = new MySet();
        for(int i=0; i<vec.size(); ++i){
            for(int j=0; j<B.vec.size(); ++j){
                if(vec.elementAt(i).equals(B.vec.elementAt(j)))
                    temp.insert(this.vec.elementAt(i));
            }
        }
        return temp;
    }
    
    /**
     * @return Whether or not the set is empty
     */
    public boolean isEmpty()
    {
        return vec.isEmpty();
    }
    
    /**
     * Remove the given element from the set
     * @param element: the element to be removed from the set
     */
    public void remove(Object element)
    {
        vec.remove(element);
    }
    
    /**
     * Check to see whether the given set is a subset of the current set
     * @param B: the set to be checked
     * @return whether or not the given set is a subset
     */
    public boolean subsetOf(MySet B)
    {
        int i=0;
        boolean[] ba = new boolean[B.vec.size()];       
        for(i=0; i<B.vec.size(); ++i){
            for(int j=0; j<this.vec.size(); ++j){
                if(this.vec.elementAt(j).equals(B.vec.elementAt(i)))
                    ba[i] = true;
                if(ba[i] != true && contains(B.vec.elementAt(i)) != true)
                    ba[i] = false;
            }
        }
        for(int s=0; s<ba.length; ++s){
            if(ba[s] == false)
                return false;
        }
        return true;
    }
    
    /**
     * Find symmetric difference between the current set and the given set
     * @param B: The set to be symmetrically subtracted from the current set
     * @return (this set – B) union (B – this set)
     */
    public MySet symmetricDifference(MySet B)
    {
        return this.union(B).complement(this.intersection(B));
    }
    
    /**
     * @param B: the set to be combined with the current set
     * @return The union of the current set and the given set
     */
    public MySet union(MySet B)
    {
        MySet temp = new MySet();
        for(int i=0; i<this.vec.size();++i){
            temp.insert(this.vec.elementAt(i));
        }
        for(int i=0; i<B.vec.size();++i){
            temp.insert(B.vec.elementAt(i));
        }
        return temp;
    }
    
    /**
     * @return a String representation of the Set
     * @override Object's toString method
     */
    public String toString()
    {
        return this.vec.toString();
    }
}
