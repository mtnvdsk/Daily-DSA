class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int c = 0;
        ListNode temp = list1;
        while (temp != null && c<a-1) {
            c++;
            temp = temp.next;
        }
        ListNode t1 = temp;
        temp = temp.next;
        while (temp != null && c<b-1) {
            c++;
            temp = temp.next;
        }
        ListNode t2 = temp.next;
        t1.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = t2;

        return list1;
    }
}
