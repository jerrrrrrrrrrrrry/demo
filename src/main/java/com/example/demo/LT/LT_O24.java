package com.example.demo.LT;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_O24 {
    public ListNode reverseList(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode now = head;
        ListNode next = head.next;
        ListNode next2 = next.next;
        while (next!=null){
            next.next = now;
            now=next;
            next=next2;
            next2=next2==null?null:next2.next;
        }
        head.next=null;
        return now;
    }
}
