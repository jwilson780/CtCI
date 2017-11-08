import java.util.HashSet;
public class Question7{
	public static void main(String[] args){
		BasicSLList list1 = new BasicSLList();
		BasicSLListNode n1 = new BasicSLListNode("a",null);
		BasicSLListNode n2 = new BasicSLListNode("b",null);
		BasicSLListNode n3 = new BasicSLListNode("c",null);
		BasicSLListNode n4 = new BasicSLListNode("d",null);
		BasicSLListNode n5 = new BasicSLListNode("e",null);
		BasicSLListNode n6 = new BasicSLListNode("f",null);
		BasicSLListNode n7 = new BasicSLListNode("g",null);
		list1.append(n1);
		list1.append(n2);
		list1.append(n3);
		list1.append(n4);
		list1.append(n5);
		System.out.println("List 1: "+list1);
		BasicSLList list2 = new BasicSLList();
		list2.append(n4);
		list2.append(n5);
		list2.append(n6);
		list2.append(n7);
		System.out.println("List 2: "+list2);
		System.out.println(findIntersection(list1,list2).data);
	}

	/**
	* O(n) time, O(n) space
	*/
	public static BasicSLListNode findIntersection(BasicSLList list1, BasicSLList list2){
		BasicSLListNode p1 = list1.head;
		HashSet<BasicSLListNode> set = new HashSet<BasicSLListNode>();
		while(p1!=null){
			set.add(p1);
			p1=p1.next;
		}
		p1 = list2.head;
		while(p1!=null){
			if(set.contains(p1)){
				return p1;
			}
			p1=p1.next;
		}
		return null;
	}
}

class BasicSLList{
	BasicSLListNode head;
	BasicSLListNode tail;
	public BasicSLList(){
		head = tail = null;
	}
	void append(BasicSLListNode element){
		if(head==null){
			head =tail = element;
			return;
		}
		tail=tail.next=element;
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