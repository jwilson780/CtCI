import java.util.HashSet;
public class Question5{
	public static void main(String[] args){
		BasicSLList list1 = new BasicSLList();
		list1.append(7);//617 reverse, 716 regular
		list1.append(1);
		list1.append(6);
		System.out.println("List 1: "+list1);
		BasicSLList list2 = new BasicSLList();
		list2.append(5);//295 reverse, 592 regular
		list2.append(9);
		list2.append(2);
		System.out.println("List 2: "+list2);
		System.out.println(addReverseOne(list1,list2));
		System.out.println(addReverseTwo(list1,list2));
		System.out.println(addRegularOne(list1,list2));
	}

	/**
	* O(n) time,O(n) space
	*/
	public static BasicSLList addReverseOne(BasicSLList list1, BasicSLList list2){
		BasicSLListNode p1 = list1.head;
		String s1="";
		BasicSLListNode p2 = list2.head;
		String s2="";
		while(p1!=null){
			s1+=p1.data;
			p1=p1.next;
		}
		while(p2!=null){
			s2+=p2.data;
			p2=p2.next;
		}
		StringBuilder sb1 = new StringBuilder(s1);
		StringBuilder sb2 = new StringBuilder(s2);
		int i1 = Integer.parseInt(sb1.reverse().toString());
		int i2 = Integer.parseInt(sb2.reverse().toString());
		int sum = i1+i2;
		String sumString =sum+"";
		BasicSLList sumList = new BasicSLList();
		for(int i=0;i<sumString.length();++i){
			sumList.append(sumString.charAt(i));
		}
		return sumList;
	}

	/**
	* O(n) time,O(n) space
	*/
	public static BasicSLList addReverseTwo(BasicSLList list1, BasicSLList list2){
		BasicSLListNode p1 = list1.head;
		int num1=0;
		int num1Ctr=0;
		BasicSLListNode p2 = list2.head;
		int num2=0;
		int num2Ctr=0;
		while(p1!=null){
			int i = new Integer((int)p1.data);
			num1+= i*Math.pow(10,num1Ctr++);
			p1=p1.next;
		}
		while(p2!=null){
			int i = new Integer((int)p2.data);
			num2+=i*Math.pow(10,num2Ctr++);
			p2=p2.next;
		}
		int sum = num1+num2;
		int powerChecker =1;
		while(powerChecker*10<sum){
			powerChecker*=10;
		}
		BasicSLList sumList = new BasicSLList();
		while(powerChecker>0){
			sumList.append(sum/powerChecker);
			sum = sum % powerChecker;
			powerChecker/=10;
		}
		return sumList;
	}

	/**
	* O(n) time,O(n) space
	*/
	public static BasicSLList addRegularOne(BasicSLList list1, BasicSLList list2){
		BasicSLListNode p1 = list1.head;
		int num1=0;
		int num1Ctr=0;
		BasicSLListNode p2 = list2.head;
		int num2=0;
		int num2Ctr=0;
		while(p1!=null){
			num1 = num1*10 + new Integer((int)p1.data);
			p1=p1.next;
		}
		while(p2!=null){
			num2 = num2*10 + new Integer((int)p2.data);
			p2=p2.next;
		}
		int sum = num1+num2;
		System.out.println(num1 + " + "+num2 + " = "+ sum);
		int powerChecker =1;
		while(powerChecker*10<sum){
			powerChecker*=10;
		}
		BasicSLList sumList = new BasicSLList();
		while(powerChecker>0){
			sumList.append(sum/powerChecker);
			sum = sum % powerChecker;
			powerChecker/=10;
		}
		return sumList;
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