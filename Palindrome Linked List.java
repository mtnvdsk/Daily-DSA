/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        ListNode s=head;
        ListNode f=head;
        Stack<Integer> a=new Stack<>();
        while(f!=null && f.next!=null){
            a.push(s.val);
            s=s.next;
            f=f.next.next;
        }
        if(f!=null) s=s.next;
        while(s!=null){
            if(s.val!=a.pop()) return false;
            s=s.next;
        }
        return true;
    }
}