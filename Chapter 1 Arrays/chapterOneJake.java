/**
 * Chapter one solutions to the even problems in Cracking the Coding Interview
 * @author Jake Wilson
 */

/**
 * This the top level class the will run each numbered assignment
 * @param args
 */
 public class ChapterOneJake{

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
   * Given two strings, see if one is a permutation of other
   * Could have seen this problem as two equal strings (seems way to easy)
   * Did it for possible permutations of any sized strings
   */
   public boolean problemTwo(String a, String b){
     /*create an algorithm to see if they have the same chars
       brute force is to create all possible permutations of both then compare till you hit a match
       you really don't have to do that.  You can just see if all chars of the smaller string
       (if they are equal then the first string) exist in the other string.*/
       StringBuilder aSB = new StringBuilder(a);
       StringBuilder bSB = new StringBuilder(b);

       if(a.length < b.length){//b is bigger
         for(int i = 0; i < a.length; ++i){
           if(!b.contains(a.charAt(i))){
             return false;
           }
            //overwrite char in a with * to avoid duplicate issues
            aSB.setCharAt(i, '*');
         }
       }else{//same length or a is larger
         for(int i = 0; i < b.length; ++i){
           if(!a.contains(b.charAt(i))){
             return false;
           }
           //overwrite char in b with * to avoid duplicate issues
           bSB.setCharAt(i, '*');
         }
       }

       return true;//we made it through with the possible permutations

       //tried this with a hash table and I wasn't able to get it perfectly correct
       //may not be possible this way
   }

   /**
    * Given string, write method to see if it is a permutation of a palendrome
    * Had trouble with this one, I have other solutions that are not perfect, but much faster
    */
    public boolean problemFour(String input){
      /*The strings are separated into words, but they ignore spaces and the
      chars in one word can be used in the next

      brute force says to make all the permutations, then check if they are
      palendromes, may be able to optimize that.*/

      input.replaceAll("\\s+",""); //replace all whitespace in input
      //create a permutation of the above and (check it as you go(optimize)).  If you find
      //a palendrome you stop it all.  Again there has to be a better way.

      //I found permutations recursivley, in interview, maybe don't do that
      //and check after each one.

      ArrayList<String> allPermutationsOfInput = permutations(input);
      //now go over permutations and check to see if palendrome
      for(int i = 0; i < allPermutationsOfInput.size(); ++i){
        if(isPalendrome(allPermutationsOfInput.get(i))){
          return true;
        }
      }
      return false;
    }

    public ArrayList<String> permutations(String s){
      return permutations("", s);
    }

    private ArrayList<String> permutations(String prefix, String wholeString, ArrayList<String> list){
      int size = wholeString.length;
      //base case (we are done)
      if(size == 0){
        list.add(prefix);
      }else{
        for(int i = 0; i < n; ++i){//create all permutations recur
          permutations(prefix + wholeString.charAt(i), wholeString.substring(0, i) + wholeString.substring(i + 1, n), list);
        }
      }

    }

    private boolean isPalendrome(String str){
      for(int i = 0; i < str.length/2; ++i){
        if(str.charAt(i) != str.charAt(str.length-1-i)){
          return false;
        }
      }
      return true;
    }


    /**
     * Problem 6: compress a string with repeated letters, if the string that is
     * compressed is larger print the origional, if not then print compressed
     */
    public String problemSix(String toBeCompressed){
      StringBuilder compressed = new StringBuilder();
      char[] compressionArray = toBeCompressed.toCharArray();
      int start = 0; //keep track of start of run
      for(int i = 0; i < compressionArray.length; ++i){
        //just need to make sure one we are is the same as the previous (2 pointers)
        if(compressionArray[i] != compressionArray[start]){//change of char in array
          //add char to string builder
          compressed.append(compressionArray[start].toString());
          //add length of run to string builder
          compressed.append(i - start + "");
          //set start to i for new run
          start = i;
        }

      }

      //check to see if compressed is longer than uncompressed
      if(toBeCompressed.length < compressed.length){
        return toBeCompressed;
      }else{
        return compressed.toString();
      }
    }

    /**
     * Problem 8: Write an algorithm such that if an element in a MxN matrix is 0,
     * its entire row and column is zero.
     */
     public int[][] problemEight(int[][] inputMatrix){
       //You must keep state in this problem (can't do it as you go)
       //loop over matrix and dump row and column values into 2 ArrayLists
       ArrayList<Integer> rowsToBeZeroed = new ArrayList<>();
       ArrayList<Integer> columnsToBeZeroed = new ArrayList<>();
       for(int i = 0; i < inputMatrix.length; ++i){
         for(int j = 0; j < inputMatrix[0].length; ++j){//if array row length differs this is wrong (it doesn't in this problem)
           if(inputMatrix[i][j] == 0){
             rowsToBeZeroed.append(i);
             columnsToBeZeroed.append(j);
           }
         }
       }

       //go through arraylists and zero out the columns/rows
       for(int i = 0; i < rowsToBeZeroed.size(); ++i){
         //loop across given row and zero out
         int rowZero = rowsToBeZeroed.get(i);
         for(int x = 0; i < inputMatrix[0].length; ++x){
           inputMatrix[rowZero][x] = 0;
         }
       }
       for(int i = 0; i < columnsToBeZeroed.size(); ++i){
         int colZero = columnsToBeZeroed.get(i);
         for(int x = 0; i < inputMatrix.length; ++x){
           inputMatrix[x][colZero] = 0;
         }
       }
       //return the modified array
       return inputMatrix;
     }

 }
