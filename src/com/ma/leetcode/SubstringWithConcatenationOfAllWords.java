package com.ma.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 30. 串联所有单词的子串
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * <p>
 * 输出：[0,9]
 * <p>
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * <p>
 * 示例 2：
 * <p>
 * 输入：
 * s = "wordgoodgoodgoodbestword",
 * words = ["word","good","best","word"]
 * 输出：[]
 *
 * @author mabingteng
 */
public class SubstringWithConcatenationOfAllWords {


  public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> result = new ArrayList<>();
    if(s == null || s.length() == 0 || words == null || words.length == 0 ) {
      return result;
    }
    String word = words[0];
    int wordLength = word.length();
    Map<String, Integer> dict = new HashMap<>();
    for (int i = words.length - 1; i >= 0; i--) {
     dict.put(words[i], dict.getOrDefault(words[i], 0) + 1);
    }
    for (int index = 0; index < wordLength; index++) {
      int left = index, right = index, count = 0;
      Map<String, Integer> tempDict = new HashMap<>();
      while(right + wordLength < s.length()) {
        String tempWord = s.substring(right, right + wordLength);
        tempDict.put(tempWord, tempDict.getOrDefault(tempWord) + 1)
      }
    }
    return result;
  }


}
