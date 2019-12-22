package com.akadatsky.entities;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        List prettyFormatter = new ArrayList();
        ListNode dummy = new ListNode(0);
        dummy.next = this;
        ListNode pointer = dummy;
        while(pointer.next != null) {
            prettyFormatter.add(pointer.next.val);
            pointer = pointer.next;
        }
        return prettyFormatter.toString();
    }
}
