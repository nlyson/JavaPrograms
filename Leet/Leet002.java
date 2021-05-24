/*
Problem description:
You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

*/

public class Leet002 {
  public static void main(String[] args) {
    
    // Test Cases
    ListNode l1 = new ListNode(2);
    l1.next = new ListNode(4);
    l1.next.next = new ListNode(3);
    
    ListNode l2 = new ListNode(5);
    l2.next = new ListNode(6);
    l2.next.next = new ListNode(4);
    
    System.out.println(addTwoNumbers(l1, l2));
    
  }
  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
    int num = (l1.val + l2.val) % 10;
    int carry = (l1.val + l2.val) / 10;

    // Create a new node for the root and keep it safe.  We shall return this when we are done
    // filling it up.
    ListNode resultRoot = new ListNode(num);
    ListNode result = resultRoot;

    // While there are still digits in each list, add them up.
    // Keep track of the carry.
    while(l1.next != null && l2.next != null)
    {
        l1 = l1.next; 
        l2 = l2.next;

        num = (l1.val + l2.val + carry) % 10;
        carry = (l1.val + l2.val + carry) / 10;

        result.next = new ListNode(num);
        result = result.next;
    }

    // If we ran out of numbers in l2, then finish adding digits in l1.
    if( l1.next != null )
    {
      while(l1.next != null)
      {
         l1 = l1.next;

         num = (l1.val + carry) % 10;
         carry = (l1.val + carry) / 10;

         result.next = new ListNode(num);
         result = result.next;
      }
    }

    // If we ran out of digits in l1, then finish adding digits in l2.
    if( l2.next != null )
    {
      while(l2.next != null)
      {
         l2 = l2.next;

         num = (l2.val + carry) % 10;
         carry = (l2.val + carry) / 10;

         result.next = new ListNode(num);
         result = result.next;
      }
    }

    // Add the carry if there is something in it.
    if( carry > 0 )
      result.next = new ListNode(carry);

    
    return resultRoot;
  }
  
  
}

class ListNode {
  
  int val;
  ListNode next;
  
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  
  // Added a recursive toString() method for testing purposes
  public String toString()
  {
    if(next != null)
      return val + next.toString();
    
    return val + "";
  }
}
