package com.akadatsky.pages;

import com.akadatsky.entities.ListNode;

import java.util.List;

public class Train02 {

    /**
     * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
     * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
     * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
     *
     * Note: You may not slant the container and n is at least 2.
     *
     * The aim is to maximize the area formed between the vertical lines.
     * The area of any container is calculated using the shorter line as length and the distance between the lines as the width of the rectangle.
     * Area = length of shorter vertical line * distance between lines
     * We can definitely get the maximum width container as the outermost lines have the maximum distance between them.
     * However, this container might not be the maximum in size as one of the vertical lines of this container could be really short.
     *
     * Start with the maximum width container and go to a shorter width container if there is a vertical line longer than the current containers shorter line.
     * This way we are compromising on the width but we are looking forward to a longer length container.
     * */
    public static int containerWithMostWater(int[] height) {
        return 0;
    }

    /**
     * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
     *
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
     *
     * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
     *
     * I can be placed before V (5) and X (10) to make 4 and 9.
     * X can be placed before L (50) and C (100) to make 40 and 90.
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
     *
     * Example 1:
     * Input: 3
     * Output: "III"
     *
     * Example 2:
     * Input: 4
     * Output: "IV"
     *
     * Example 3:
     * Input: 9
     * Output: "IX"
     *
     * Example 4:
     * Input: 58
     * Output: "LVIII"
     * Explanation: L = 50, V = 5, III = 3.
     *
     * Example 5:
     * Input: 1994
     * Output: "MCMXCIV"
     * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
     * */
    public String intToRoman(int num) {
        return null;
    }

    /**
     * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
     *
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * For example, two is written as II in Roman numeral, just two one's added together.
     * Twelve is written as, XII, which is simply X + II.
     * The number twenty seven is written as XXVII, which is XX + V + II.
     *
     * Roman numerals are usually written largest to smallest from left to right.
     * However, the numeral for four is not IIII.
     * Instead, the number four is written as IV.
     * Because the one is before the five we subtract it making four.
     * The same principle applies to the number nine, which is written as IX.
     * There are six instances where subtraction is used:
     *
     * I can be placed before V (5) and X (10) to make 4 and 9.
     * X can be placed before L (50) and C (100) to make 40 and 90.
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
     *
     * Example 1:
     * Input: "III"
     * Output: 3
     *
     * Example 2:
     * Input: "IV"
     * Output: 4
     *
     * Example 3:
     * Input: "IX"
     * Output: 9
     *
     * Example 4:
     * Input: "LVIII"
     * Output: 58
     * Explanation: L = 50, V= 5, III = 3.
     *
     * Example 5:
     * Input: "MCMXCIV"
     * Output: 1994
     * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
     *
     * I - 1
     * V - 5
     * X - 10
     * L - 50
     * C - 100
     * D - 500
     * M - 1000
     *
     * Rules:
     * If I comes before V or X, subtract 1 eg: IV = 4 and IX = 9
     * If X comes before L or C, subtract 10 eg: XL = 40 and XC = 90
     * If C comes before D or M, subtract 100 eg: CD = 400 and CM = 900
     * */
    public int romanToInt(String s) {
        return 0;
    }

    /**
     * Write a function to find the longest common prefix string amongst an array of strings.
     *
     * If there is no common prefix, return an empty string "".
     *
     * Example 1:
     *
     * Input: ["flower","flow","flight"]
     * Output: "fl"
     * Example 2:
     *
     * Input: ["dog","racecar","car"]
     * Output: ""
     * Explanation: There is no common prefix among the input strings.
     * Note:
     *
     * All given inputs are in lowercase letters a-z.
     * */
    public String longestCommonPrefix(String[] strs) {
        return null;
    }

    /**
     * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
     * Find all unique triplets in the array which gives the sum of zero.
     *
     * Note:
     *
     * The solution set must not contain duplicate triplets.
     *
     * Example: Given array nums = [-1, 0, 1, 2, -1, -4],
     *
     * A solution set is:
     * [
     *   [-1, 0, 1],
     *   [-1, -1, 2]
     * ]
     *
     * So, we essentially need to find three numbers x, y, and z such that they add up to the given value.
     *
     * If we fix one of the numbers say x, we are left with the two-sum problem at hand!
     * For the two-sum problem, if we fix one of the numbers, say x, we have to scan the entire array to find the next number y
     * which is (value - x) where value is the input parameter. Can we change our array somehow so that this search becomes faster?
     *
     * The second train of thought for two-sum is, without changing the array, can we use additional space somehow? Like maybe a hash map to speed up the search?
     * */
    public List<List<Integer>> threeSum(int[] nums) {
       return null;
    }

    /**
     * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
     * Return the sum of the three integers. You may assume that each input would have exactly one solution.
     *
     * Example: Given array nums = [-1, 2, 1, -4], and target = 1.
     *
     * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
     * */
    public int threeSumClosest(int[] nums, int target) {
        return 0;
    }

    /**
     * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
     *
     * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
     *
     * Example:
     *
     * Input: "23"
     * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     *
     * Note:
     *
     * Although the above answer is in lexicographical order, your answer could be in any order you want.
     * */
    public List<String> letterCombinations(String digits) {
        return null;
    }

    /**
     * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target?
     * Find all unique quadruplets in the array which gives the sum of target.
     *
     * Note:
     * The solution set must not contain duplicate quadruplets.
     *
     * Example:
     * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
     *
     * A solution set is:
     * [
     *   [-1,  0, 0, 1],
     *   [-2, -1, 1, 2],
     *   [-2,  0, 0, 2]
     * ]
     * */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        return null;
    }

    /**
     * Given a linked list, remove the n-th node from the end of list and return its head.
     *
     * Example:
     *
     * Given linked list: 1->2->3->4->5, and n = 2.
     * After removing the second node from the end, the linked list becomes 1->2->3->5.
     *
     * Note:
     * Given n will always be valid.
     *
     * Follow up:
     * Could you do this in one pass?
     *
     * Maintain two pointers and update one with a delay of n steps.
     * */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return null;
    }

    /**
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     *
     * An input string is valid if:
     *
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     * Note that an empty string is also considered valid.
     *
     * Example 1:
     * Input: "()"
     * Output: true
     *
     * Example 2:
     * Input: "()[]{}"
     * Output: true
     *
     * Example 3:
     * Input: "(]"
     * Output: false
     *
     * Example 4:
     * Input: "([)]"
     * Output: false
     *
     * Example 5:
     * Input: "{[]}"
     * Output: true
     *
     * Hint 1
     * An interesting property about a valid parenthesis expression is that a sub-expression of a valid expression should also be a valid expression.
     * (Not every sub-expression) e.g.
     * { { } [ ] [ [ [ ] ] ] } is VALID expression
     *           [ [ [ ] ] ]    is VALID sub-expression
     *   { } [ ]                is VALID sub-expression
     * Can we exploit this recursive structure somehow?
     *
     * Hint 2
     * What if whenever we encounter a matching pair of parenthesis in the expression, we simply remove it from the expression?
     * This would keep on shortening the expression. e.g.
     * { { ( { } ) } }
     *       |_|
     *
     * { { (      ) } }
     *     |______|
     *
     * { {          } }
     *   |__________|
     *
     * {                }
     * |________________|
     *
     * VALID EXPRESSION!
     *
     * Hint 3
     * The stack data structure can come in handy here in representing this recursive structure of the problem.
     * We can't really process this from the inside out because we don't have an idea about the overall structure.
     * But, the stack can help us process this recursively i.e. from outside to inwards.
     * */
    public boolean isValidParentheses(String s) {
        return false;
    }
}
