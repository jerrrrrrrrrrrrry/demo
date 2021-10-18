package com.example.demo.LT;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode resNow = res;
        ListNode nowL1 = l1;
        ListNode nowL2 = l2;
        int a = 0;
        while (nowL1!=null||nowL2!=null||a!=0){

            int nowVal = (nowL1==null?0:nowL1.val)+ (nowL2==null?0:nowL2.val)+a;
            ListNode tmp = new ListNode(nowVal % 10);
            a = nowVal/10;
            resNow.next = tmp;
            resNow = resNow.next;
            nowL1 = nowL1==null?null:nowL1.next;
            nowL2 = nowL2==null?null:nowL2.next;
        }
        return res.next;
    }

}
