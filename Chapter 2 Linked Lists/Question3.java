import java.util.HashSet;
public class Question3{
	public static void main(String[] args){
		BasicSLList list = new BasicSLList();
		list.append("a");
		list.append("This");
		list.append("is");
		list.append("a");
		list.append("list");
		list.append("to");
		list.append("search");
		list.append("a");
		list.append("a");
		System.out.println(list);
		removeFromMiddle(list,"a");
		System.out.println(list);
	}

	/**
	* O(n^2) time,O(n) space
	*/
	public static void removeFromMiddle(BasicSLList list, Object element){
		while(list.removeIgnoreHeadAndTail(element)){};
	}
}

class BasicSLList{
	BasicSLListNode head;
	BasicSLListNode tail;
	public BasicSLList(){
		head = tail = null;
	}
	void append(Object element){
		if(head==null){
			head =tail = new BasicSLListNode(element,null);
			return;
		}
		tail=tail.next=new BasicSLListNode(element,null);
	}
	boolean remove(Object element){
		if(head==null){
			return false;
		}
		if(head.data.equals(element)){
			if(head==tail){
				head=tail=null;
				return true;
			}
			head = head.next;
			return true;
		}
		if(head==tail){
			return false;
		}
		BasicSLListNode pointer = head;
		while(pointer.next != null){
			if(pointer.next.data.equals(element)){
				pointer.next = pointer.next.next;
				return true;
			}
			pointer = pointer.next;
		}
		if(tail.data.equals(element)){
			tail = pointer;
			return true;
		}
		return false;
	}
	boolean removeIgnoreHeadAndTail(Object element){
		if(head==null){
			return false;
		}
		if(head.data.equals(element)){
			//Do Nothing
		}
		if(head==tail){
			return false;
		}
		BasicSLListNode pointer = head;
		while(pointer.next != null && pointer.next!=tail){
			if(pointer.next.data.equals(element)){
				pointer.next = pointer.next.next;
				return true;
			}
			pointer = pointer.next;
		}
		if(tail.data.equals(element)){
			//Do nothing
		}
		return false;
	}
	public String toString(){
        String out = "SLList contains: \n";
        BasicSLListNode ref = head;
        if(head==null)
            return out + "0 Nodes";
        else
            out+="head :" + ref.data +"\n";
        int j =1;
        while(ref.next!=null){
            
            out+=ref.data + "\t->\t";
            if(j%5 ==0)
                out+="\n";
            ref=ref.next;
            ++j;
        }
        out+=ref.data + "\t->\tnull";
        return out;
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