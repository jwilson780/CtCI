

public class Problem2{

  /**
   * used to run and test the problem
   *
   */
    public static void main(String[] args){

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
            if(!b.contains(aSB.charAt(i))){
              return false;
            }
             //overwrite char in a with * to avoid duplicate issues
             aSB.setCharAt(i, '*');
          }
        }else{//same length or a is larger
          for(int i = 0; i < b.length; ++i){
            if(!a.contains(bSB.charAt(i))){
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

}
