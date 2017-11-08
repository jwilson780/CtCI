package collection;

/**
 * Class that contains sorting methods
 * @author Steven Moon
 * @version 2011.10.24
 */
public class MySort {
    /**
     * Constructor for MySort
     */
    private MySort(){}
    
    /**
     * Bubble Sort. Puts vector in order from least to greatest.
     * @param vec: Vector to put in order
     * @return The sorted vector
     */
    public static MyVector bubbleSort(MyVector vec)
    {
        Comparable first, second;
        for(int i=1; i<vec.size(); ++i){
            for(int j=vec.size()-1; j>=i; --j){
                first = (Comparable)vec.elementAt(j-1);
                second = (Comparable)vec.elementAt(j);
                if(first.compareTo(second)>0){
                    swap(vec,j-1,j);
                }  
            }
        }
        return vec;
    }
    
    /**
     * Selection Sort. Puts vector in order from least to greatest.
     * @param vec: Vector to put in order
     * @return The sorted vector
     */
    public static MyVector selectionSort(MyVector vec)
    {
        int i,j,smallestPos=0;
        Comparable smallest, current;
        for(i=0; i<vec.size()-1; ++i){
            smallest = (Comparable)vec.elementAt(i);
            for(j=i+1; j<vec.size(); ++j){                
                current = (Comparable)vec.elementAt(j);
                if(current.compareTo(smallest)<0){
                    smallestPos =j;
                    smallest = current;
                }
            }
            if(smallestPos != i)
                swap(vec,i,smallestPos);
        }
        return vec;
    }
    
    /**
     * Merge Sort. Cut collection into halves until you reach individual 
     * collections of one element, then merge them back together in order.
     * @param vec: The vector to be sorted
     * @param temp: tool used to compare two elements
     * @param left: The left most element of the individual array pieces
     * @param right: The right most element of the individual array pieces
     */
    public static void mergeSort(MyVector vec, Comparable[] temp, int left, 
                                 int right)
    {
        if(left == right)
            return;
        int mid = (left+right)/2;
        int i,j,k;
        mergeSort(vec,temp,left,mid);
        mergeSort(vec,temp,mid+1,right);
        for(i=left; i<=right; ++i){
            temp[i]=(Comparable)vec.elementAt(i);
        }
        i = left;
        k = mid+1;
        for(j=left;j<=right;++j){
            if(i==mid+1)
                vec.replace(j,temp[k++]);
            else{
                if(k>right)
                    vec.replace(j,temp[i++]);
                else{
                    if(temp[i].compareTo(temp[k])<0)
                        vec.replace(j,temp[i++]);
                    else
                        vec.replace(j,temp[k++]);
                }
            }            
        }
    }
    
    /**
     * Quick Sort. Pivot numbers around a median number, then continue this process
     * to sub-collections until whole collection is sorted.
     * @param vec: The vector to be sorted
     * @param left: The leftmost side of the sub-collection being sorted
     * @param right: The rightmost side of the sub-collection being sorted
     */
    public static void quickSort(MyVector vec, int left, int right)
    {
        if((right-left)<10)
            insertionSort(vec,left,right);
        else{
            medianOf3(vec,left,right);
            int leftPointer = partition(vec,left,right);
            quickSort(vec,left,leftPointer-1);
            quickSort(vec,leftPointer,right);
        }
    }
                                 
    /**
     * Find the median of 3 numbers
     * @param vec: The vector that the elements are coming from
     * @param left: The left index
     * @param right: The right index
     */
    public static void medianOf3(MyVector vec, int left, int right)
    {
        int mid = (left+right)/2;
        if(((Comparable)vec.elementAt(left)).compareTo(vec.elementAt(mid))>0)
            swap(vec,left,mid);
        if(((Comparable)vec.elementAt(mid)).compareTo(vec.elementAt(right))>0)
            swap(vec,mid,right);
        if(((Comparable)vec.elementAt(left)).compareTo(vec.elementAt(mid))>0)
            swap(vec,left,mid);
    }
    
    /**
     * Determine the partition for the use of quick sort
     * @param vec: The vector being partitioned
     * @param left: The left boundary of the partition
     * @param right: The right boundary of the partition
     */
    public static int partition(MyVector vec, int left, int right)
    {
        Object pivot = vec.elementAt((left+right)/2);
        while(true){
            while(((Comparable)vec.elementAt(++left)).compareTo(pivot) < 0);
            while(((Comparable)vec.elementAt(--right)).compareTo(pivot) > 0);
            if(left>right)
                break;
            else
                swap(vec,left,right);
        }
        return left;
    }
    
    /**
     * Insertion Sort. Sort a collection by splitting the collection into two,
     * keeping the left side sorted, adding more elements to be sorted as you 
     * iterate throughout the collection.
     * 
     * @param vec: The vector to be sorted
     * @param left: The leftmost part to start the sorting
     * @param right: The rightmost part to end the sorting
     */
    public static void insertionSort(MyVector vec, int left, int right)
    {
        int inner, outer;
        Object target;
        for(outer = left+1; outer<=right; ++outer){
            target = (Comparable)vec.elementAt(outer);
            inner = outer;
            while(inner>left && (((Comparable)vec.elementAt(inner-1)).compareTo(target))>0){
                vec.replace(inner,vec.elementAt(inner-1));
                --inner;
            }
            vec.replace(inner,target);            
        }
    }
    
    /**
     * Shell Sort. Compare elements 'h' elements away from one another, and put 
     * them in order.
     * @param vec: The vector to be sorted
     * @param temp: A Tool to be used to compare two elements
     * @param left: The left index to be compared to the right
     * @param right: The right index to be compared to the left
     */
    public static void shellSort(MyVector vec)
    {
        
        int inner,outer,h=1;
        while(h<vec.size()){
            h = 3*h+1;
        }
        h =((h-1)/3);
        Object target;
        while(h>0){
            for(outer=h;outer<vec.size();++outer){
                target = (Comparable)vec.elementAt(outer);
                inner = outer;
                while((inner>h-1)&&(((Comparable)vec.elementAt(inner-h)).compareTo(target))>0){
                    vec.replace(inner,vec.elementAt(inner-h));
                    inner -=h;
                }
                vec.replace(inner, target);
            }
            h =((h-1)/3);
        }
    }
    
    /**
     * Swap two given values in the given vector
     * @param vec: The vector where the switching is going to take place
     * @param first: The first value to be swapped
     * @param second: The second value to be swapped
     */
    public static void swap(MyVector vec, int first, int second)
    {
        Object temp = vec.elementAt(first);
        vec.replace(first, vec.elementAt(second));
        vec.replace(second, temp);
    }
}
