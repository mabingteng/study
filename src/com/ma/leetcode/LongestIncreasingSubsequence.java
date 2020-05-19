package com.ma.leetcode;

/**
 * 300. 最长上升子序列
 *
 * @author mabingteng
 */
public class LongestIncreasingSubsequence {

  public static void main(String[] args) {
    int si[] = {-2, -1};
    System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(si));
  }

  /**
   * O(n2)
   */
  public int lengthOfLIS(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int result = 1;
    int[] indexDict = new int[nums.length];
    indexDict[0] = 1;
    for (int right = 1; right < nums.length; right++) {
      int left = 0;
      int tempMax = 1;
      while (left < right) {
        tempMax = Math.max(nums[left] < nums[right] ? indexDict[left] + 1 : 1, tempMax);
        left++;
      }
      indexDict[right] = tempMax;
      result = Math.max(tempMax, result);
    }
    return result;
  }

  public int lengthOfLIS2(int[] nums) {
    int dp[] = new int[nums.length];
    int dpIndex = 0;
    for (int index = 0; index < nums.length; index++) {
      int left = 0, right = dpIndex;
      while (left < right) {
        int tempIndex = (left + right) / 2;
        if (nums[index] > dp[tempIndex]) {
          left = tempIndex + 1;
        } else {
          right = tempIndex;
        }
      }
      dp[left] = nums[index];
      if (right == dpIndex) {
        dpIndex++;
      }
    }
    return dpIndex;
  }
}
