import java.util.HashSet;
public class Question1{
	public static void main(String[] args){
		BasicSLList list = new BasicSLList();
		list.append("This");
		list.append("This");
		list.append("is");
		list.append("a");
		list.append("list");
		list.append("to");
		list.append("search");
		list.append("a");
		list.append("to");
		System.out.println(list);
		removeDuplicatesOne(list);
		System.out.println(list);
		BasicSLList list2 = new BasicSLList();
		list2.append("This");
		list2.append("This");
		list2.append("is");
		list2.append("a");
		list2.append("list");
		list2.append("to");
		list2.append("search");
		list2.append("a");
		list2.append("to");
		System.out.println(list2);
		removeDuplicatesTwo(list2);
		System.out.println(list2);
	}

	/**
	* O(n^2) time,O(n) space
	*/
	public static void removeDuplicatesOne(BasicSLList list){
		BasicSLListNode pointerA = list.head;
		BasicSLListNode pointerB = list.head;
		while(pointerA.next!=null){
			while(pointerB.next!=null){
				if(pointerB.next.data.equals(pointerA.data)){
					pointerB.next = pointerB.next.next;	
				}
				if(pointerB.next!=null){
					pointerB = pointerB.next;
				}
			}
			pointerA=pointerB=pointerA.next;
		}
	}

	/**
	* O(n) time,O(n^2) space
	*/
	public static void removeDuplicatesTwo(BasicSLList list){
		BasicSLListNode pointerA = list.head;
		HashSet<Object> set = new HashSet<Object>();
		set.add(pointerA.data);
		while(pointerA.next!=null){
			if(!set.add(pointerA.next.data)){
				pointerA.next=pointerA.next.next;
				continue;
			}
			pointerA=pointerA.next;
		}
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