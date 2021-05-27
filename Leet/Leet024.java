
/*
Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

 

Example 1:


Input: head = [1,2,3,4]
Output: [2,1,4,3]
Example 2:

Input: head = []
Output: []
Example 3:

Input: head = [1]
Output: [1]
 

Constraints:

The number of nodes in the list is in the range [0, 100].
0 <= Node.val <= 100

*/

public class Leet024 {
  
  	public static void main(String[] args)
    {
      	// Test Cases
        ListNode l1 = new ListNode(1);
      	l1.next = new ListNode(2);
      	l1.next.next = new ListNode(3);
      	l1.next.next.next = new ListNode(4);
      	l1.next.next.next.next = new ListNode(5);
      	l1.next.next.next.next.next = new ListNode(6);
      
      	ListNode l2 = new ListNode(1);
      	l2.next = new ListNode(2);
      	l2.next.next = new ListNode(3);
      	l2.next.next.next = new ListNode(4);
       	l2.next.next.next.next = new ListNode(5);
      	System.out.println( swapPairs(l1) );
      	System.out.println( swapPairs(l2) );
      
    }
  
    public static ListNode swapPairs(ListNode head) {
      
      int count = 2;
      
      // Be done with it if there is 1 or fewer elements
      if(head == null || head.next == null)
        return head;
      
      // Swap the first two elements
      ListNode temp = head;
      head = head.next;
      temp.next = head.next;
      head.next = temp;
  
      ListNode current = temp;
      ListNode prev = head;
      
      // Go through and swap adjacent pairs.  I used a count to keep track position in linked list.
      while(current.next != null)
      {
        count++;
        current = current.next;
        prev = prev.next;
        
        if(count % 2 == 1 && current.next != null )
        {
          	prev.next = current.next;
          	current.next = current.next.next;
          	prev.next.next = current;
          	current = prev.next;
	
        }
       
      }
        
      return head;
    }
}


class ListNode {
     int val;
     ListNode next;
   	 ListNode() {}
	 ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  
  	 public String toString()
     {
       if(next != null)
         return val + " " + next.toString();
       
       return val + "";
     }
  
 }
