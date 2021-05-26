/*

  Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.



  Example 1:


  Input: l1 = [1,2,4], l2 = [1,3,4]
  Output: [1,1,2,3,4,4]
  Example 2:

  Input: l1 = [], l2 = []
  Output: []
  Example 3:

  Input: l1 = [], l2 = [0]
  Output: [0]


  Constraints:

  The number of nodes in both lists is in the range [0, 50].
  -100 <= Node.val <= 100
  Both l1 and l2 are sorted in non-decreasing order.

*/

public class Leet021 {
  
  
  	public static void main(String[] args)
    {
      // Test cases
      ListNode l1 = new ListNode(1);
      l1.next = new ListNode(3);
      l1.next.next = new ListNode(4);
      
      ListNode l2 = new ListNode(1);
      l2.next = new ListNode(2);
      l2.next.next = new ListNode(4);
      
      System.out.println( mergeTwoLists(l1, l2) );
      System.out.println( mergeTwoLists(null, null));
      
    }
  
  
  
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      
      // Get easy cases out of the way.  (One or both lists are empty)
      if(l1 == null && l2 == null)
        return null;
      else if(l1 == null)
        return l2;
      else if(l2 == null)
        return l1;
      
      // Keep the head of the new list safe and keep track of the current node
      ListNode head;
      ListNode current;
      
      // Figure out who is first
      if(l1.val < l2.val)
      {
        head = l1;
        l1 = l1.next;
      }
      else
      {
        head = l2;
        l2 = l2.next;
      }
      current = head;
      
      
      // Keep moving along as long as both lists are not empty
      // Each time around, add the node with the lowest value to our linked list.
      while(l1 != null && l2 != null)
      {
        if(l1.val < l2.val)
        {
          current.next = l1;
          l1 = l1.next;
        }
        else
        {
          current.next = l2;
          l2 = l2.next;
        }
        
        current = current.next;
      }
      
      
      // We made it this far because one of our lists became empty.  (Or both)
      // Attach the rest of our non-empty list to our linked list.  (Or null if they both are empty.)
      if(l1 != null)
        current.next = l1;
      else
        current.next = l2;
      

      return head;
    }
}


// Definition for singly-linked list.
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
        else
          return val + "";

      }
}
