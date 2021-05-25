/*

  Given the head of a linked list, remove the nth node from the end of the list and return its head.

  Follow up: Could you do this in one pass?



  Example 1:


  Input: head = [1,2,3,4,5], n = 2
  Output: [1,2,3,5]
  Example 2:

  Input: head = [1], n = 1
  Output: []
  Example 3:

  Input: head = [1,2], n = 1
  Output: [1]


  Constraints:

  The number of nodes in the list is sz.
  1 <= sz <= 30
  0 <= Node.val <= 100
  1 <= n <= sz

*/

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Leet019 {
  
  	public static void main(String[] args)
    {
      // Test cases
      ListNode l1 = new ListNode(1);
      l1.next = new ListNode(2);
      l1.next.next = new ListNode(3);
      l1.next.next.next = new ListNode(4);
      l1.next.next.next.next = new ListNode(5);
      
      
      System.out.println( removeNthFromEnd(l1, 1) );
    
      
    }
 

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        
      // Keep track of 2 nodes: first and second
      // They need to be n nodes apart
     	
      ListNode first = head;
      ListNode second = head;
     
      
      for(int i=0; i<n; i++)
        second = second.next;
      
      
      // This means the first element needs to be removed.
      // Simply return whatever head.next points to.  That's my new head.
      if(second == null)
        return head.next;
      
      
      // Move second to the end of the list
      // Move first as well so they stay n elements apart
      while(second.next != null)
      {
        first = first.next;
        second = second.next;
      }
      
      // Remove the unwanted node from the list
      first.next = first.next.next;

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
