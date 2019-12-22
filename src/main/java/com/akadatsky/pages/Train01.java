package com.akadatsky.pages;

import com.akadatsky.entities.ListNode;

import java.util.HashMap;

public class Train01 {

    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *
     * Example: Given nums = [2, 7, 11, 15], target = 9, because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
     *
     * So, if we fix one of the numbers, say x, we have to scan the entire array to find the next number
     * y = (value - x) where value is the input parameter.
     * Can we change our array somehow so that this search becomes faster?
     *
     * The second train of thought is, without changing the array, can we use additional space somehow?
     * Like maybe a hash map to speed up the search?
     *
     * */
    public static int[] twoSum(int[] nums, int target) {
        /**
         * Key point is that use hashmap, also store target - nums[i] as key.
         * */

        HashMap distance = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (distance.get(nums[i]) != null) {
                return new int[]{(int) distance.get(nums[i]), i};
            }
            distance.put(target-nums[i], i);
        }
        return null;
    }

    /**
     * You are given two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order and each of their nodes contain a single digit.
     * Add the two numbers and return it as a linked list.
     *
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     *
     * Example:
     *
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     *
     * Definition for singly-linked list.
     *
     * */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        /**
         * Key point is to create dummy startNode, and a pointer to scan. time O(n), space O(1)
         *
         * Linked lists are preferable over arrays when:
         *
         * you need constant-time insertions/deletions from the list (such as in real-time computing where time predictability is absolutely critical)
         * you don't know how many items will be in the list. With arrays, you may need to re-declare and copy memory if the array grows too big
         * you don't need random access to any elements
         * you want to be able to insert items in the middle of the list (such as a priority queue)
         *
         * Arrays are preferable when:
         *
         * you need indexed/random access to elements
         * you know the number of elements in the array ahead of time so that you can allocate the correct amount of memory for the array
         * you need speed when iterating through all the elements in sequence. You can use pointer math on the array to access each element, whereas you need to lookup the node based on the pointer for each element in linked list, which may result in page faults which may result in performance hits.
         * memory is a concern. Filled arrays take up less memory than linked lists. Each element in the array is just the data. Each linked list node requires the data as well as one (or more) pointers to the other elements in the linked list.
         *
         * */

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        // create tens cachedValue and dummy startNode
        int tens = 0;
        ListNode dummyNode = new ListNode(0);
        ListNode pointer = dummyNode;

        while (l1 != null && l2 != null) {
            pointer.next = new ListNode((l1.val + l2.val + tens) % 10);
            tens = (l1.val + l2.val + tens) / 10;
            l1 = l1.next;
            l2 = l2.next;
            pointer = pointer.next;
        }

        while (l1 != null && l2 == null) {
            pointer.next = new ListNode((l1.val + tens) % 10);
            tens = (l1.val + tens) / 10;
            l1 = l1.next;
            pointer = pointer.next;
        }

        while(l2 != null) {
            pointer.next = new ListNode((l2.val + tens) % 10);
            tens = (l2.val + tens) / 10;
            l2 = l2.next;
            pointer = pointer.next;
        }

        pointer.next = new ListNode(tens);
        return dummyNode.next;
    }

    /**
     * Given a string, find the length of the longest substring without repeating characters.
     *
     * Example 1:
     * Input: "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     *
     * Example 2:
     * Input: "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     *
     * Example 3:
     * Input: "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     *
     * */
    public static int lengthOfLongestSubstring(String s) {
        /**
         * key point is to use two pointers (fixed end, dynamic start that maintained by a map).
         * For each char in the string, every scan you can use one char as the endChar of the string (fixed end).
         * */
        HashMap<Character, Integer> positionStore = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            // use the locationStore to store the char appeared location when scan from left.
            // if it's not appeared before, it will be -1
            // if it's scanned but duplicated, it will be marked as -1
            positionStore.put(s.charAt(i), -1);
        }

        int longestLength = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            // -1 means not appear in the [start, end], so just simply add it.
            // otherwise, find the new start, and reset the map.
            if (positionStore.get(s.charAt(end)) != -1) {
                while (start <= positionStore.get(s.charAt(end))) {
                    // everything before start set to -1.
                    positionStore.put(s.charAt(start), -1);
                    start += 1;
                }
            }

            longestLength = (end - start + 1 > longestLength) ? end-start+1 : longestLength;
            positionStore.put(s.charAt(end), end);
        }
        return longestLength;
    }

    /**
     * There are two sorted arrays nums1 and nums2 of size m and n respectively.
     *
     * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
     *
     * You may assume nums1 and nums2 cannot be both empty.
     *
     * Example 1:
     *
     * nums1 = [1, 3]
     * nums2 = [2]
     *
     * The median is 2.0
     *
     * Example 2:
     *
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     *
     * The median is (2 + 3)/2 = 2.5
     *
     * */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return 0;
    }

    /**
     * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
     *
     * Example 1:
     *
     * Input: "babad"
     * Output: "bab"
     * Note: "aba" is also a valid answer.
     *
     * Example 2:
     *
     * Input: "cbbd"
     * Output: "bb"
     *
     * How can we reuse a previously computed palindrome to compute a larger palindrome?
     *
     * If “aba” is a palindrome, is “xabax” and palindrome? Similarly is “xabay” a palindrome?
     *
     * Complexity based hint:
     * If we use brute-force and check whether for every start and end position a substring is a palindrome
     * we have O(n^2) start - end pairs and O(n) palindromic checks.
     * Can we reduce the time for palindromic checks to O(1) by reusing some previous computation?
     *
     * */
    public String longestPalindrome(String s) {
        return null;
    }


    /**
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
     * (you may want to display this pattern in a fixed font for better legibility)
     *
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * And then read line by line: "PAHNAPLSIIGYIR"
     *
     * Write the code that will take a string and make this conversion given a number of rows:
     *
     * string convert(string s, int numRows);
     *
     * Example 1:
     *
     * Input: s = "PAYPALISHIRING", numRows = 3
     * Output: "PAHNAPLSIIGYIR"
     *
     * Example 2:
     *
     * Input: s = "PAYPALISHIRING", numRows = 4
     * Output: "PINALSIGYAHRPI"
     * Explanation:
     *
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     *
     *
     *
     * */
    public String zigZagConvert(String s, int numRows) {
        return null;
    }

    /**
     * Given a 32-bit signed integer, reverse digits of an integer.
     *
     * Example 1:
     *
     * Input: 123
     * Output: 321
     *
     * Example 2:
     *
     * Input: -123
     * Output: -321
     *
     * Example 3:
     *
     * Input: 120
     * Output: 21
     *
     * Note:
     * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range:
     * [−231,  231 − 1].
     *
     * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
     *
     * */
    public int reverseInteger(int x) {
        return 0;
    }

    /**
     * mplement atoi which converts a string to an integer.
     *
     * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
     *
     * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
     *
     * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
     *
     * If no valid conversion could be performed, a zero value is returned.
     *
     * Note:
     *
     * Only the space character ' ' is considered as whitespace character.
     * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
     *
     * Example 1:
     *
     * Input: "42"
     * Output: 42
     *
     * Example 2:
     *
     * Input: "   -42"
     * Output: -42
     * Explanation: The first non-whitespace character is '-', which is the minus sign.
     *              Then take as many numerical digits as possible, which gets 42.
     * Example 3:
     *
     * Input: "4193 with words"
     * Output: 4193
     * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
     *
     * Example 4:
     *
     * Input: "words and 987"
     * Output: 0
     * Explanation: The first non-whitespace character is 'w', which is not a numerical
     *              digit or a +/- sign. Therefore no valid conversion could be performed.
     * Example 5:
     *
     * Input: "-91283472332"
     * Output: -2147483648
     * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
     *              Thefore INT_MIN (−231) is returned.
     *
     * */
    public int myAtoi(String str) {
        return 0;
    }

    /**
     * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
     *
     * Example 1:
     * Input: 121
     * Output: true
     *
     * Example 2:
     * Input: -121
     * Output: false
     * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
     *
     * Example 3:
     * Input: 10
     * Output: false
     * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
     * Follow up:
     *
     * Coud you solve it without converting the integer to a string?
     * Beware of overflow when you reverse the integer.
     *
     * */
    public boolean isPalindrome(int x) {
        return false;
    }

    /**
     * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
     *
     * '.' Matches any single character.
     * '*' Matches zero or more of the preceding element.
     * The matching should cover the entire input string (not partial).
     *
     * Note:
     *
     * s could be empty and contains only lowercase letters a-z.
     * p could be empty and contains only lowercase letters a-z, and characters like . or *.
     * Example 1:
     *
     * Input:
     * s = "aa"
     * p = "a"
     * Output: false
     * Explanation: "a" does not match the entire string "aa".
     *
     * Example 2:
     * Input:
     * s = "aa"
     * p = "a*"
     * Output: true
     * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
     *
     * Example 3:
     * Input:
     * s = "ab"
     * p = ".*"
     * Output: true
     * Explanation: ".*" means "zero or more (*) of any character (.)".
     * Example 4:
     *
     * Input:
     * s = "aab"
     * p = "c*a*b"
     * Output: true
     * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
     *
     * Example 5:
     * Input:
     * s = "mississippi"
     * p = "mis*is*p*."
     * Output: false
     * */
    public boolean isRegularExpressionMatch(String s, String p) {
        return false;
    }
}
