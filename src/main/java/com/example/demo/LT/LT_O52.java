package com.example.demo.LT;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_O52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nowA = headA;
        ListNode nowB = headB;
        while (nowA!=null&&nowB!=null){
            if (nowA==nowB){
                return nowA;
            }
            nowA = nowA.next;
            nowB = nowB.next;
            if (nowA==null&&nowB==null){
                return null;
            }
            if (nowA==null){
                nowA=headB;
            }
            if (nowB==null){
                nowB=headA;
            }
        }
        return null;
    }
}
