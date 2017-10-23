

public class Chapter1Problem6{

  /**
   * used to run and test the problem
   *
   */
    public static void main(String[] args){
      Chapter1Problem6 p6 = new Chapter1Problem6();
      System.out.println(p6.problemSix("aaaa"));
      System.out.println(p6.problemSix("aaaabbb"));
      System.out.println(p6.problemSix("aabaa"));
      System.out.println(p6.problemSix("aaaabbbbbbaaaabbbbbabababababa"));
      System.out.println(p6.problemSix("a"));
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
        if(compressionArray[i] != compressionArray[start] || i == compressionArray.length-1){//change of char in array
          //add char to string builder
          compressed.append(compressionArray[start]);
          //add length of run to string builder
          if(i == compressionArray.length-1){
            compressed.append(i + 1 - start + "");
          }else{
            compressed.append(i - start + "");
          }

          //set start to i for new run
          start = i;
        }

      }

      //check to see if compressed is longer than uncompressed
      if(toBeCompressed.length() < compressed.length()){
        return toBeCompressed;
      }else{
        return compressed.toString();
      }
    }

}
