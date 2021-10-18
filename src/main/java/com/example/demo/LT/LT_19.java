package com.example.demo.LT;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode[] listNodes = new ListNode[30];
        ListNode now = head;
        int index = 0;
        while (now!=null){
            listNodes[index] = now;
            now = now.next;
            index++;
        }
        if (index-n==0){
            return listNodes[1];
        }
        listNodes[index-n-1].next=listNodes[index-n+1];
        return head;
    }
}
