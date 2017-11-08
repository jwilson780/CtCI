import java.util.ArrayList;
public class Question5{
	public static void main(String[] args){
		BasicStack bs = new BasicStack();
		bs.push(5);
		bs.push(7);
		bs.push(1);
		bs.push(4);
		bs.push(2);
		bs.push(3);
		System.out.println(bs+"\n~~");
		sortStack(bs);
		//System.out.println(bs);
	}

	public static void sortStack(BasicStack ogStack){
		BasicStack tempStack = new BasicStack();
		Object tempNode = null;
		while(!ogStack.isEmpty()){
			tempStack.push(ogStack.pop());
			if((int)tempStack.peek()>(int)ogStack.peek()){
				tempNode=tempStack.pop();
				while((int)ogStack.peek()<(int)tempNode){
					tempStack.push(ogStack.pop());
				}
				tempStack.push(tempNode);
				tempNode=null;
			}
			System.out.println(ogStack+"\n"+tempStack+"\n~~");
		}
	}


}

class BasicStack{
    BasicSLListNode top;
    BasicStack(){
        top=null;
    }
    boolean isEmpty(){
        return top==null;
    }
	Object pop(){
        if(top==null)
            return null;
        Object temp = top.data;
        top=top.next;
        return temp;
    }
    void push(Object element){
        top=new BasicSLListNode(element,top);
    }
    Object peek(){
        if(top==null)
            return null;
        return top.data;
    }
    public String toString(){
        String str = "Stack Contains: \n [";
        BasicSLListNode temp = top;
        while(temp!=null){
            str+=","+temp.data;
            temp=temp.next;
        }
        str+="]";
        return str.replaceFirst(",", "");
    }

}

class BasicSLListNode{
	Object data;
	BasicSLListNode next;
	BasicSLListNode(Object data, BasicSLListNode next){
		this.data = data;
		this.next = next;
	}
}