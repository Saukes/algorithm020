package daily;

import data.ListNode;

public class HomeWork07ReversePrint {
    public int[] reversePrint(ListNode head) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        int[] res = new int[size];
        int i = size - 1;
        while (head != null) {
            res[i--] = head.val;
            head = head.next;
        }
        return res;
    }
}
