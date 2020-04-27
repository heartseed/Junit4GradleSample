package com.akadatsky.squads;

import com.akadatsky.entities.ListNode;
import com.akadatsky.solo.MergeIntervalSolution;
import com.akadatsky.solo.MergeK;
import com.akadatsky.tags.ArraySolutions;

public class FiresweepBow {

    // FiresweepBow is the secret name of a giant tech company in social media.

    /**
     * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
     *
     * Example:
     *
     * Input:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * Output: 1->1->2->3->4->4->5->6
     *
     * */
    public ListNode mergeKLists(ListNode[] lists) {
        return MergeK.mergeKLists5(lists);
    }

    /**
     * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
     *
     * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
     *
     * The replacement must be in-place and use only constant extra memory.
     *
     * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
     *
     * 1,2,3 → 1,3,2
     * 3,2,1 → 1,2,3
     * 1,1,5 → 1,5,1
     *
     * */
    public void nextPermutation(int[] nums) {
        ArraySolutions.nextPermutation(nums);
    }

    /**
     * Given a collection of intervals, merge all overlapping intervals.
     *
     * Example 1:
     *
     * Input: [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
     * Example 2:
     *
     * Input: [[1,4],[4,5]]
     * Output: [[1,5]]
     * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
     * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
     *
     * */
    public int[][] mergeInterval(int[][] intervals) {
        return MergeIntervalSolution.merge(intervals);

    }







}
