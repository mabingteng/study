package com.ma.leetcode;

/*
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
 * Explanation: The answer is "wke", with the length of3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

  public int lengthOfLongestSubstring(String s) {
    int size = 0;
    String str = new String();
    for (int i = 0; i < s.length(); i++) {
      if (!str.contains(s.substring(i, i + 1))) {
        str += s.charAt(i);
      } else {
        str += s.charAt(i);
        str = str.substring(str.indexOf(s.charAt(i)) + 1, str.length());
      }
      if (size < str.length()) {
        size = str.length();
      }
    }
    return size;
  }

  /**
   * The basic idea is, keep a hashmap which stores the characters in string as keys and their
   * positions as values, and keep two pointers which define the max substring.
   * Move the right pointer to scan through the string , and meanwhile update the hashmap.
   * If the character is already in the hashmap, then move the left pointer to the right of the
   * same character last found. Note that the two pointers can only move forward.
   */
  public int lengthOfLongestSubstring1(String s) {
    if (s.length() == 0) {
      return 0;
    }
    HashMap<Character, Integer> map = new HashMap<>();
    int max = 0;
    for (int i = 0, j = 0; i < s.length(); ++i) {
      if (map.containsKey(s.charAt(i))) {
        //·ÀÖ¹»ØÍË
        j = Math.max(j, map.get(s.charAt(i)) + 1);
      }
      map.put(s.charAt(i), i);
      max = Math.max(max, i - j + 1);
    }
    return max;
  }
}
