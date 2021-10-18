package com.example.demo.LT;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @program: demo
 * @description:
 * @author: Gu
 * @create: 2021-04-25 14:15
 **/
public class LT_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<ListNode,Integer> setA = new HashMap<>();
        Map<ListNode,Integer> setB = new HashMap<>();
        boolean s = true;
        ListNode nowA = headA;
        ListNode nowB = headB;
        if (headA==null||headB==null){
            return null;
        }
        while (s) {
            if (nowA.next == null && nowB.next == null) {
                s = false;
            }
            setA.put(nowA,1);
            setB.put(nowB,1);
            if (setB.containsKey(nowA)) {
                return nowA;
            }
            if (setA.containsKey(nowB)) {
                return nowB;
            }
            if (nowA.next != null) {
                nowA = nowA.next;
            }
            if (nowB.next != null) {
                nowB = nowB.next;
            }
        }
        return null;

    }
}

