package com.akadatsky.tags;

import com.akadatsky.entities.ListNode;
import com.akadatsky.entities.TreeNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ListSolutions {

    // Reverse a singly linked list.
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newHead = reverseList(next);
        next.next = head;
        head.next = null;
        return newHead;
    }

    // Reverse a singly linked list.
    public ListNode reverseList2(ListNode head) {
        ListNode dummy = new ListNode(0);
        for (ListNode p = head; p != null; ) {
            ListNode next = p.next;
            p.next = dummy.next;
            dummy.next = p;
            p = next; }
        return dummy.next;
    }

    // Reverse a linked list from position m to n. Do it in-place and in one-pass.
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < m - 1; i++) pre = pre.next;
        ListNode start = pre.next;
        ListNode then = start.next;
        for (int i = 0; i < n - m; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        return dummy.next;
    }

    // Sort a linked list in O(n log n) time using constant space complexity.
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return merge(l1, l2);
    }
    ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0), p = l;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next; }
        if (l1 != null)
            p.next = l1;
        if (l2 != null)
            p.next = l2;
        return l.next;
    }

    /**
     * Given a singly linked list, group all odd nodes together followed by the even nodes.
     * Please note here we are talking about the node number and not the value in the nodes.
     * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
     * Example:
     *   Given 1->2->3->4->5->NULL,
     *   return 1->3->5->2->4->NULL.
     * Note:
     * The relative order inside both the even and odd groups should remain as it was in the input.
     * The first node is considered odd, the second node even and so on ...
     *
     * */
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(0), pOdd = odd;
        ListNode even = new ListNode(0), pEven = even;
        int index = 1;
        for (ListNode p = head; p != null; p = p.next) {
            if ((index++ & 1) > 0) {
                pOdd.next = p;
                pOdd = pOdd.next;
            } else {
                pEven.next = p;
                pEven = pEven.next;
            }
        }
        pOdd.next = null;
        pEven.next = null;
        pOdd.next = even.next;
        return odd.next;
    }

    // Merge two sorted linked lists and return it as a new list.
    // The new list should be made by splicing together the nodes of the first two lists.
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = l1, q = l2, cur = dummy;
        for ( ; p != null && q != null; ) {
            if (p.val < q.val) {
                cur.next = p;
                p = p.next;
            } else {
                cur.next = q;
                q = q.next; }
            cur = cur.next;
        }
        cur.next = p != null ? p : q;
        return dummy.next;
    }

    // Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0), cur = dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode node1, ListNode node2) {
                if (node1.val == node2.val) {
                    return 0;
                } else if (node1.val < node2.val) {
                    return -1;
                } else {
                    return 1; }
            } });
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null) {
                queue.offer(node.next);
            }
        }
        return dummy.next;
    }

    /**
     * Write a program to find the node at which the intersection of two singly linked lists begins.
     * For example, the following two linked lists:
     * A: a1 → a2 -> c1 → c2 → c3
     * B: b1→b2→b3 -> c1 → c2 → c3
     *
     * begin to intersect at node c1.
     * Notes:
     * If the two linked lists have no intersection at all, return null.
     * The linked lists must retain their original structure after the function returns.
     * You may assume there are no cycles anywhere in the entire linked structure.
     * Your code should preferably run in O(n) time and use only O(1) memory.
     *
     * */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        for (ListNode p = headA; p != null; p = p.next, lenA++);
        for (ListNode p = headB; p != null; p = p.next, lenB++);
        ListNode p = lenA > lenB ? headA : headB;
        ListNode q = lenA > lenB ? headB : headA;
        for (int i = 0; i < Math.abs(lenA - lenB); i++, p = p.next);
        for ( ; p != null && q != null; p = p.next, q = q.next) {
            if (p == q) {
                return p;
            } }
        return null;
    }

    class RandomListNode {
        int val;
        RandomListNode next;
        RandomListNode random;

        public RandomListNode(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * A linked list is given such that each node contains an additional random pointer
     * which could point to any node in the list or null. Return a deep copy of the list.
     * */
    public RandomListNode copyRandomList(RandomListNode head) {
        for (RandomListNode node = head; node != null; ) {
            RandomListNode next = node.next;
            RandomListNode copy = new RandomListNode(node.val);
            copy.next = next;
            node.next = copy;
            node = next;
        }
        for (RandomListNode node = head; node != null; ) {
            node.next.random = node.random != null ? node.random.next : null;
            node = node.next.next;
        }
        RandomListNode dummy = new RandomListNode(0), cur = dummy;
        for (RandomListNode node = head; node != null; ) {
            cur.next = node.next;
            cur = cur.next;
            node.next = node.next.next;
            node = node.next;
        }
        return dummy.next;
    }

    // Given a singly linked list, determine if it is a palindrome.
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = reverse(slow);
        /**
         * 注意退出条件是 p1 != slow
         */
        for (ListNode p1 = head, p2 = fast; p1 != slow; p1 = p1.next, p2 = p2.next) {
            if (p1.val != p2.val) {
                return false;
            } }
        return true;
    }

    private ListNode reverse(ListNode node) {
        ListNode dummy = new ListNode(0), cur = dummy;
        while (node != null) {
            ListNode next = node.next;
            node.next = cur.next;
            cur.next = node;
            node = next;
        }
        return dummy.next;
    }

    // Sort a linked list using insertion sort.
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode helper = new ListNode(0); //new starter of the sorted list
        ListNode cur = head; //the node will be inserted
        ListNode pre = helper; //insert node between pre and pre.next
        ListNode next = null; //the next node will be inserted
        //not the end of input list
        while (cur != null) {
            next = cur.next;
            //find the right place to insert
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            //insert between pre and pre.next
            cur.next = pre.next;
            pre.next = cur;
            pre = helper;
            cur = next; }
        return helper.next;
    }

    /**
     * Given a linked list, remove the nth node from the end of list and return its head.
     * For example,
     * Given linked list: 1->2->3->4->5, and n = 2.
     * After removing the second node from the end, the linked list becomes 1->2->3->5. Note:
     * Given n will always be valid. Try to do this in one pass.
     *
     * */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        for (int i = 1; i < n; i++) {
            p = p.next; }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        cur.next = head;
        for ( ; p.next != null; p = p.next) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

    /**
     * Given a singly linked list L: L0?L1?⋯?Ln-1?Ln, reorder it to: L0?Ln?L1?Ln-1?L2?Ln-2?⋯
     * You must do this in-place without altering the nodes’ values.
     * For example,
     * Given 1,2,3,4, reorder it to 1,4,2,3.
     * */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        ListNode preMiddle = p1;
        ListNode preCurrent = p1.next;
        while (preCurrent.next != null) {
            ListNode current = preCurrent.next;
            preCurrent.next = current.next;
            current.next = preMiddle.next;
            preMiddle.next = current;
        }
        p1 = head;
        p2 = preMiddle.next;
        while (p1 != preMiddle) {
            preMiddle.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = preMiddle.next;
        }
    }

    /**
     * Given a linked list, swap every two adjacent nodes and return its head.
     * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
     * Your algorithm should use only constant space.
     * You may not modify the values in the list, only nodes itself can be changed.
     * */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode node = head, tail = dummy;
        for ( ; node != null && node.next != null; ) {
            ListNode next = node.next;
            node.next = tail.next;
            tail.next = node;
            ListNode nnext = next.next;
            next.next = node;
            tail.next = next;
            tail = node;
            node = nnext;
        }
        tail.next = node;
        return dummy.next;
    }

    /**
     * Remove all elements from a linked list of integers that have value val.
     * Example
     * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6 Return: 1 --> 2 --> 3 --> 4 --> 5
     * */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0), node = dummy;
        for ( ; head != null; head = head.next) {
            if (head.val != val) {
                node.next = head;
                node = node.next;
            } }
        node.next = null;
        return dummy.next;
    }

    /**
     * Convert Sorted List to Binary Search Tree
     * */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return toBST(head, null);
    }
    public TreeNode toBST(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;
        if (head == tail) return null;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode thead = new TreeNode(slow.val);
        thead.left = toBST(head, slow);
        thead.right = toBST(slow.next, tail);
        return thead;
    }
}
