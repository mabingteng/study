package com.ma.leetcode;

/**
 * problem:354 2020-05-08 22:50
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h).
 * One envelope can fit into another if and only if both the width and height of one envelope
 * is greater than the width and height of the other envelope.
 *
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)
 *
 * Note:
 * Rotation is not allowed.
 *
 * Example:
 * Input: [[5,4],[6,4],[6,7],[2,3]]
 * Output: 3
 * Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 */
public class RussianDollEnvelopes {

  // [2,3] [3,5] [4,4] [5,5] [6,6]
  public int maxEnvelopes(int[][] envelopes) {
    if (envelopes.length == 0) {
      return 0;
    }

    return 0;
  }
}
