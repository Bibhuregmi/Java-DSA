package LinkedList;
//Implementation of the Merge sort algorithm in Singly Linked List
public class MergeSort {
    //This class defines the singly-linked list node
    class ListNode{
        int value; 
        ListNode next;
        ListNode(){};
        ListNode (int x){
            value = x;
            next = null; 
        }
    }
//    Main method to sort the linked list
    public ListNode sort(ListNode head){
        // basecase: if list is empty OR only one node is present in the list
        if (head == null || head.next == null){ 
            return head; 
        }

        ListNode middle = mid(head); //finding middle of the list which splits list into two halves
        ListNode left = sort(head); //recursively sorting the left part
        ListNode right = sort(middle); //recursively sorting the right part

        return merge(left,right); //merging the sorted two list
    }
    // Implementation of the merging two sorted list
    public ListNode merge (ListNode list1, ListNode list2){
        ListNode head = new ListNode(); //dummy head
        ListNode tail = head; 
// Comparing and merging nodes
        while (list1 != null && list2 != null){
            if (list1.value <= list2.value){
                tail.next = list1;
                list1 = list1.next; 
            }else{
                tail.next = list2; 
                list2 = list2.next; 
            }
            tail = tail.next; 
        }
        // Attaches if any nodes are remaining
        if (list1 != null){
            tail.next = list1;
        }
        else{
            tail.next = list2;
        }
        return head.next; //returning the actual head ie. <head.next> (dummy head points to null)

    }
    //Finding mid and splitting list in two part
    public ListNode mid(ListNode head){
        ListNode fast = head; 
        ListNode slow = head;
        ListNode temp = null;

        while (fast != null  && fast.next != null){
            temp = slow;
            slow = slow.next;
            fast = fast.next.next; 
        }
        if (temp != null){ //Splits the list by setting the next of the node before middle to null
            temp.next = null;
        }
        return slow; //returning the middle node, which is "head" of the second half of splited list. 
    }
}


