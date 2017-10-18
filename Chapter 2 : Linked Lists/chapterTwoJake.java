/**
 * Chapter two solutions to the even problems in Cracking the Coding Interview
 * @author Jake Wilson
 */

/**
 * This the top level class the will run each numbered assignment
 * @param args
 */
 public class ChapterTwoJake{

   /**
    * Pass this into the terminal to run a specific numbered assignment.
    * eg. "2"
    * Can't be odd.  Steven does the odds
    */
   public static void main(String[] args){
     if(Integer.parseInt(args[0])%2 != 0){//asserts problem entered is even
       System.out.println("Please try again, this time with an even number");
     }else{//it is even
       this.doProblem(args[0]);
     }
   }

   /**
   * This just runs the problem to be done
   * @param int problem number
   */
   public void doProblem(int problemNumber){
     //if any further input or staging for the problem is required ask here
     //none is needed for many problems
   }

   /**
   * Return kth to last element in a linked list.
   */
   public Node problemTwo(SingleLinkedList sllist, int k){
     //two pointers problem
     //Did not specify if sll or dll
     int offsetCounter = 0;
     Node leader = new Node(sllist.head);
     Node follower = new Node(sllist.head);

     while(leader.next != null){//until we hit last node (tail)
       leader = leader.next;//move up 1
       if(offsetCounter >= k){//go out k nodes then start it
         follower = follower.next;
       }
       offsetCounter += 1;
     }

     return follower;//trailer should be k nodes off end
   }

   /**
    * Partition a linked list around value x, so all nodes less than x come
    * before all notes greater than or equal to x.   If x is in the list
    * the values of x only need to be after the elements less than x.
    * The partition element x can appear anywhere in the 'right partition';
    * it does not need to appear between the left and right partitions
    */
    public SingleLinkedList problemFour(SingleLinkedList sllist, int x){

      //I am just going to make all elements >= x the new tail in new list
      //all elements < x will be head.  Should put them in order
      //if there is no tail then it gets sticky

      Node ref = new Node(sllist.head);
      SingleLinkedList outputList = new SingleLinkedList();
      while(ref.next != null){//until we hit the tail
        if(ref.data >= x){//treating x like pivot
          outputList.insertFront(ref.data);//adds to front in no order
        }else{
          outputList.append(ref.data);//adds larger to tail in no order
        }
      }

      return outputList;

    }

    /**
     * Problem 6: Implement an algorithm to see if a linked list
     * is a palendrome
     */
    public boolean problemSix(SingleLinkedList sllist){
      //there are two possible questions:
      //is this a single linked list or double?
      // - if double then its easy
      //does the last node have a tail reference or does it just entered

      //I am assuming single linked and no tail ref (hardest possible)
      Node ref = new Node(sllist.head);
      int sllistSize = 0;
      while(ref.next != null){
        ref = ref.next;
        sllistSize += 1;
      }
      //get size and / 2
      Node backRef = new Node(sllist.head);
      for(int i = 0; i <= sllistSize/2; ++i){
        backRef = backRef.next;
      }
      //backRef should be one to the right of the middle
      //create node that goes to it one left of the middle and backs down to 0 while
      //increasing backRef up the ladder to the end
      for(int z = sllistSize/2; z > 0; --z){//walking down the ladder with this loop
        Node frontRef = new Node(sllist.head);
        for(int f = 0; f < z; ++f){//walk node to right spot
          frontRef = frontRef.next;
        }
        //compare to backRef, then increase backRef
        if(frontRef.data != backRef.data){
          return false;
        }else{
          backref = backref.next;
        }
      }
      //we made it with no errors.
      return true;

    }

    /**
     *Given circularly linked list, return the front of the loop
     */
     public int[][] problemEight(int[][] inputMatrix){
       //the book makes it seem to easy (first repeated node?)

     }

 }
