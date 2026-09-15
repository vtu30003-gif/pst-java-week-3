class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode nextTemp = curr.next; // Save next node
            curr.next = prev;              // Reverse pointer
            prev = curr;                   // Move prev one step forward
            curr = nextTemp;               // Move curr one step forward
        }
        
        return prev; // New head of reversed list
    }
}