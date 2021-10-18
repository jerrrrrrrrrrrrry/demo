package com.example.demo.LT;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_203 {
    ListNode newHead;

    public ListNode removeElements(ListNode head, int val) {
        ListNode now = head;
        newHead = head;
        while (now!=null){
            if (now.val==val){
                newHead = now.next;
            }
            if (now.next!=null) {
                if (now.next.val == val) {
                    now.next = now.next.next;
                } else {
                    now = now.next;
                }
            }else {
                now=null;
            }
        }
        return newHead;
    }

}
