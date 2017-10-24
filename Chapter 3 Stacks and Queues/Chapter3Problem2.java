public class Chapter3Problem2{

    /**
     * used to run and test the problem
     *
     */
      public static void main(String[] args){

      }

      /**
      *  How would you design a stack which, in additio to push and pop has
      * a function that returns the minimum element.
      */
      public boolean problemTwo(String a, String b){

        /*Not sure about how much coding I would actually have to do here
        but I know that I would just keep an element on the top that was the minimum.
        So if you pushed an element on, if the element was smaller than the top
        min element, then make a copy and push it to the 2nd spot and the top spot (push 2 times).  If it
        is any amount larger you push the larger to the 2nd spot and leave the top min node on the stack alone.
        You would let all peek and pop take off the second element.  The min would just return the top element.
        Since you are making a copy it will work fine.  All should still be O(1) still, as required by the problem.
        This would require a modification of the array class, which I will do when we put all of them up here.
        */



      }

}
