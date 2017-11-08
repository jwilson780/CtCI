package collection;

/**
 *
 * @author Steven Moon
 * @version 2011.10.2
 */
public class MySearch {
    
    /**
     * Constructor for MySearch
     */
    private MySearch(){}
    
    /**
     * Binary Search. Search a sorted vector for a specific target value
     * @param vec: The sorted vector to be searched
     * @param target: The value to be searched for
     * @return the index where the value was found
     */
    public static int binarySearch(MyVector vec, Comparable target)
    {
        int first = 0;
        int last = vec.size()-1;
        int middle;
        while(last>=first){
            middle = (first + last)/2;
            if(target.compareTo(vec.elementAt(middle))<0)
                last = middle-1;
            else if(target.compareTo(vec.elementAt(middle))>0)
                first = middle+1;
            else
                return middle;
        }
        return -1;
        
    }
    
    /**
     * Linear Search on sorted elements.
     * @param vec: The sorted vector to be searched
     * @param target: The value to be searched for
     * @return the index where the value was found
     */
    public static int linearSearchSorted(MyVector vec, Comparable target)
    {
        int i;
        for(i=0; i<vec.size() && target.compareTo(vec.elementAt(i))>0;++i);
            if(i<vec.size() && target.compareTo(vec.elementAt(i))==0)
                return i;
        return -1;
    }
}
