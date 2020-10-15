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
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;

        ListNode resultNode = mergeTwoLists(node1, node4);
        while (resultNode != null) {
            System.out.println(resultNode.val);
            resultNode = resultNode.next;
        }


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

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode newNode = new ListNode();
        ListNode initNode = newNode;
        while (true) {
            if (l1 == null) {
                newNode.val = l2.val;
                newNode.next = l2.next;
                break;
            } else if (l2 == null) {
                newNode.val = l1.val;
                newNode.next = l1.next;
                break;
            } else if (l1.val < l2.val) {
                newNode.val = l1.val;
                l1 = l1.next;
            } else {
                newNode.val = l2.val;
                l2 = l2.next;
            }
            newNode = getNextNode(newNode);
        }
        return initNode;
    }

    public static ListNode getNextNode(ListNode node) {
        ListNode newNode = new ListNode();
        node.next = newNode;
        return newNode;
    }

    public static ListNode addNode(int val) {
        return new ListNode(val, null);
    }


}
