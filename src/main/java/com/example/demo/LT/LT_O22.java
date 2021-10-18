package com.example.demo.LT;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_O22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode n1 = head;
        ListNode n2 = head;
        int i=0;
        while (n1.next!=null){
            n1 = n1.next;
            if (i>=k){
                n2 = n2.next;
            }
            i++;

        }
        return n2;

    }
}
