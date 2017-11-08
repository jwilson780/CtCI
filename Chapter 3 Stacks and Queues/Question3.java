import java.util.ArrayList;
public class Question3{
	public static void main(String[] args){
		testSetOfStacks();
	}

	/**
	* Pushing to and popping from array O(n)
	*/
	public static void testSetOfStacks(){
		SetOfStacks ss = new SetOfStacks();
		ss.push("A");
		ss.push("B");
		ss.push("C");
		ss.push("D");
		ss.push("E");
		ss.push("F");
		ss.push("G");
		ss.push("H");
		ss.push("I");
		ss.push("J");
		ss.push("K");
		ss.push("L");
		ss.push("M");
		System.out.println(ss);
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		System.out.println(ss);
		System.out.println(ss.pop(0));
		System.out.println(ss.pop(0));
		System.out.println(ss);
	}
}

class SetOfStacks{
	private final int maxHeight = 5;
	private int currColumn;
	private int sizeOfCurrColumn=0;
	private ArrayList<BasicStack> plateWall;
	SetOfStacks(){
		currColumn=sizeOfCurrColumn=0;
		plateWall= new ArrayList<>();
		plateWall.add(new BasicStack());
	}
	void push(Object element){
		if(sizeOfCurrColumn>=maxHeight){
			plateWall.add(new BasicStack());
			currColumn++;sizeOfCurrColumn=0;
		}
		plateWall.get(currColumn).push(element);
		sizeOfCurrColumn++;
	}
	Object pop(){
		if(sizeOfCurrColumn==0){
			currColumn--;sizeOfCurrColumn=maxHeight-1;
			if(currColumn<0){
				return null;
			}
		}
		sizeOfCurrColumn--;
		return plateWall.get(currColumn).pop();
	}
	Object pop(int index){
		return plateWall.get(index).pop();
	}
	public String toString(){
		String str="";
		for(int i=0;i<=currColumn;i++){
			str+="S:"+i+" ";
			str += plateWall.get(i).toString()+"\n";
		}
		str+="\n";
		return str;
	}

}

class BasicStack{
    BasicSLListNode top;
    BasicStack(){
        top=null;
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