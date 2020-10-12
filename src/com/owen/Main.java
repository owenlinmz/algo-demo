package com.owen;

import java.util.List;

public class Main {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int x, ListNode next) {
            this.val = x;
            this.next = next;
        }

        ListNode() {
        }

        ;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fastNode = head;
        while (fastNode != null) {
            fastNode = fastNode.next;
            if (k > 0) k--;
            else head = head.next;
        }
        return head;
    }


    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newNode = new ListNode();
        while (l1 != null || l2 != null) {
            if (newNode == null) {
                newNode = new ListNode();
            }
            if (l1.val < l2.val) {
                newNode.val = l1.val;
                newNode.next = null;
                l1 = l1.next;
            } else {
                newNode.val = l2.val;
                newNode.next = null;
                l2 = l2.next;
            }
            newNode = null;
        }
    }

    public static ListNode addNode(int val) {
        return new ListNode(val, null);
    }


}
