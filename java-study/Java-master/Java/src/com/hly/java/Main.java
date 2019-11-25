package com.hly.java;

import java.util.Scanner;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/8/20
 * @QQ :1136513099
 * @desc :
 */
public class Main {

    public static  class ListNode{
        int value;
        ListNode next;
        public ListNode(int value) {
            this.value = value;
        }
    }

    public ListNode merge(ListNode l1,ListNode l2){
        if(l1.next==null)
            return l2;
        if(l2.next==null)
            return l1;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1.next!=null&&l2.next!=null){
            if(l1.next.value<l2.next.value){
                cur.next = l1.next;
                l1 = l1.next;
            }else{
                cur.next = l2.next;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        while (l1.next!=null)
            cur.next = l1.next;
        while (l2.next!=null)
            cur.next = l2.next;
        return head;
    }
}
