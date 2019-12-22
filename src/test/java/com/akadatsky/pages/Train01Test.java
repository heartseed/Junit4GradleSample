package com.akadatsky.pages;

import com.akadatsky.entities.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Train01Test {

    @Test
    public void testTwoSum() {
        assertArrayEquals(new int[]{0, 1}, Train01.twoSum(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{0, 3}, Train01.twoSum(new int[]{2, 7, 11, 2}, 4));
        assertArrayEquals(null, Train01.twoSum(new int[]{2, 7, 11, 15}, 100));
        assertArrayEquals(new int[]{0, 1}, Train01.twoSum(new int[]{0, 0, 0, 0}, 0));
    }

    @Test
    public void testAddTwoNumbers() {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(6);
        ListNode node3 = new ListNode(9);

        ListNode listNode1 = node1;
        listNode1.next = node2;
        ListNode listNode2 = node3;

        assertEquals("[2, 7, 0]", Train01.addTwoNumbers(listNode1, listNode2).toString());
    }

    @Test
    public void testLengthOfLongestSubstring() {
        assertEquals(Train01.lengthOfLongestSubstring("xiwlfnca"), 8);
        assertEquals(Train01.lengthOfLongestSubstring("abba"), 2);
        assertEquals(Train01.lengthOfLongestSubstring("abcabcba"), 3);
    }
}
