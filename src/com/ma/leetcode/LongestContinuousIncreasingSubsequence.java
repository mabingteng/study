package com.ma.leetcode;

/**
 * problem:674 2020-05-09 22:50
 * Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).
 *
 * Example 1:
 * Input: [1,3,5,4,7]
 * Output: 3
 * Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
 * Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
 *
 * Example 2:
 * Input: [2,2,2,2,2]
 * Output: 1
 * Explanation: The longest continuous increasing subsequence is [2], its length is 1.
 * Note: Length of the array will not exceed 10,000.
 */
public class LongestContinuousIncreasingSubsequence {

  public int findLengthOfLCIS(int[] nums) {
    int result = 0;
    for (int left = 0, right = 0; right < nums.length; right++) {
      if (right < nums.length - 1 && nums[right + 1] < nums[right]) {
        left = right;
      }
      result = Math.max(right - left + 1, result);
    }
    return result;
  }


  /**
   * ×óÓÒÖ¸Õë
   */
  public int findLengthOfLCIS1(int[] nums) {
    int result = nums.length == 0 ? 0 : 1;
    for (int left = 0, right = 1; right < nums.length; right++) {
      if (nums[right - 1] >= nums[right]) {
        left = right;
      }
      result = Math.max(right - left + 1, result);
    }
    return result;
  }

}
