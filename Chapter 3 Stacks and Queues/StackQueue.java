import java.util.Stack;

/**
* This class makes a queue out of 2 stacks
*/
public class StackQueue<T>{

  private Stack<T> right = new Stack<T>();
  private Stack<T> left = new Stack<T>();

  /**
  * Puts an item in the queue (FIFO)
  * @return True if enqueue was successful
  */
  public boolean enqueue(T element){
    //I am yoyoing back and forth between them
    //first element
    if(right.empty() && left.empty()){
      //both empty so push onto right
      right.push(element);
    }
    if(right.empty()){
      //we will push all from left into right then finally the element
      while(!left.empty()){
        right.push(left.pop());
      }
      right.push(element);
    }else{//left is empty
      while(!right.empty()){
        left.push(right.pop());
      }
      left.push(element);
    }
  }

  /**
  * Returns the element at the front of queue (FIFO)
  */
  public T dequue(){
    //simply pop from no empty one
    if(right.empty() && left.empty()){
      return null;
    }

    if(!right.empty()){
      return right.pop();
    }else{
      return left.pop();
    }
  }

}
