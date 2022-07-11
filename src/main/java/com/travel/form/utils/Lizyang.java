package com.travel.form.utils;

/**
 * @author by 李泽阳 on 2022/6/9 13:06
 * @description：此类为eg实例类
 */
public class Lizyang {


    public static void main(String[] args) {
        /**
         * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
         *
         * 请你将两个数相加，并以相同形式返回一个表示和的链表。
         *
         * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
         */

        /**
         * Definition for singly-linked list.
         * public class ListNode {
         *     int val;
         *     ListNode next;
         *     ListNode(int x) { val = x; }
         * }
         */
    }
    public static class ListNode {
        int val;

        ListNode next;

        public ListNode(int x) {
            val = x;
        }

    }
    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode pre = new ListNode(0);
            ListNode cur = pre;
            int carry = 0;
            while (l1 != null || l2 != null) {
                int x = l1 == null ? 0 : l1.val;
                int y = l2 == null ? 0 : l2.val;
                int sum = x + y + carry;

                carry = sum / 10;
                sum = sum % 10;
                cur.next = new ListNode(sum);

                cur = cur.next;
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }
            if (carry == 1) {
                cur.next = new ListNode(carry);
            }
            return pre.next;
        }
    }
}
