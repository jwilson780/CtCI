// Definition for singly-linked list:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
    ListNode<Integer> list = new ListNode<>(0);
    ListNode<Integer> temp = list;
    while(l != null){
        if(l.value != k){
            temp.next = l;
            temp = temp.next;
        }
        l = l.next;
    }
    temp.next = null;
    return list.next;
}

