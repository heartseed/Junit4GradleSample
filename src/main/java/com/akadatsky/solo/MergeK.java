package com.akadatsky.solo;

import com.akadatsky.entities.ListNode;

import java.util.*;

public class MergeK {

    // brute force
    public ListNode mergeKLists1(ListNode[] lists) {
        List<Integer> l = new ArrayList<Integer>();

        for (ListNode ln : lists) {
            while (ln != null) {
                l.add(ln.val);
                ln = ln.next;
            }
        }

        Collections.sort(l);

        ListNode head = new ListNode(0);
        ListNode h = head;
        for (int i : l) {
            ListNode t = new ListNode(i);
            h.next = t;
            h = h.next;
        }
        h.next = null;
        return head.next;
    }

    // Compare every \text{k}k nodes (head of every linked list) and get the node with the smallest value.
    //Extend the final sorted linked list with the selected nodes. O(n) space
    public ListNode mergeKLists2(ListNode[] lists) {
        int min_index = 0;
        ListNode head = new ListNode(0);
        ListNode h = head;
        while (true) {
            boolean isBreak = true;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (lists[i].val < min) {
                        min_index = i;
                        min = lists[i].val;
                    }
                    isBreak = false;
                }

            }
            if (isBreak) {
                break;
            }
            ListNode a = new ListNode(lists[min_index].val);
            h.next = a;
            h = h.next;
            lists[min_index] = lists[min_index].next;
        }
        h.next = null;
        return head.next;
    }

    // O(1)
    public ListNode mergeKLists2_2(ListNode[] lists) {
        int min_index = 0;
        ListNode head = new ListNode(0);
        ListNode h = head;
        while (true) {
            boolean isBreak = true;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (lists[i].val < min) {
                        min_index = i;
                        min = lists[i].val;
                    }
                    isBreak = false;
                }

            }
            if (isBreak) {
                break;
            }
            h.next = lists[min_index];
            h = h.next;
            lists[min_index] = lists[min_index].next;
        }
        h.next = null;
        return head.next;
    }

    // Almost the same as the one above but optimize the comparison process by priority queue.
    // You can refer here for more information about it.
    public ListNode mergeKLists3(ListNode[] lists) {
        Comparator<ListNode> cmp;
        cmp = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                // TODO Auto-generated method stub
                return o1.val-o2.val;
            }
        };

        Queue<ListNode> q = new PriorityQueue<ListNode>(cmp);
        for(ListNode l : lists){
            if(l!=null){
                q.add(l);
            }
        }
        ListNode head = new ListNode(0);
        ListNode point = head;
        while(!q.isEmpty()){
            point.next = q.poll();
            point = point.next;
            ListNode next = point.next;
            if(next!=null){
                q.add(next);
            }
        }
        return head.next;
    }

    // Convert merge \text{k}k lists problem to merge 2 lists (\text{k-1}k-1) times. Here is the merge 2 lists problem page.
    public ListNode mergeTwoLists4(ListNode l1, ListNode l2) {
        ListNode h = new ListNode(0);
        ListNode ans=h;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                h.next = l1;
                h = h.next;
                l1 = l1.next;
            } else {
                h.next = l2;
                h = h.next;
                l2 = l2.next;
            }
        }
        if(l1==null){
            h.next=l2;
        }
        if(l2==null){
            h.next=l1;
        }
        return ans.next;
    }
    public ListNode mergeKLists4(ListNode[] lists) {
        if(lists.length==1){
            return lists[0];
        }
        if(lists.length==0){
            return null;
        }
        ListNode head = mergeTwoLists4(lists[0],lists[1]);
        for (int i = 2; i < lists.length; i++) {
            head = mergeTwoLists4(head,lists[i]);
        }
        return head;
    }

    // This approach walks alongside the one above but is improved a lot. We don't need to traverse most nodes many times repeatedly
    //
    //Pair up \text{k}k lists and merge each pair.
    //
    //After the first pairing, \text{k}k lists are merged into k/2k/2 lists with average 2N/k2N/k length, then k/4k/4, k/8k/8 and so on.
    //
    //Repeat this procedure until we get the final sorted linked list.
    //
    //Thus, we'll traverse almost NN nodes per pairing and merging, and repeat this procedure about \log_{2}{k}log
    //2 k times.
    public static ListNode mergeTwoLists5(ListNode l1, ListNode l2) {
        ListNode h = new ListNode(0);
        ListNode ans=h;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                h.next = l1;
                h = h.next;
                l1 = l1.next;
            } else {
                h.next = l2;
                h = h.next;
                l2 = l2.next;
            }
        }
        if(l1==null){
            h.next=l2;
        }
        if(l2==null){
            h.next=l1;
        }
        return ans.next;
    }
    public static ListNode mergeKLists5(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        int interval = 1;
        while(interval<lists.length){
            System.out.println(lists.length);
            for (int i = 0; i + interval< lists.length; i=i+interval*2) {
                lists[i]=mergeTwoLists5(lists[i],lists[i+interval]);
            }
            interval*=2;
        }

        return lists[0];
    }
}
