package com.ma.leetcode;

/**
 * problem:738
 * Given a non-negative integer N, find the largest number that is less than or equal to N with monotone increasing digits.
 * (Recall that an integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.)
 *
 * Example 1:
 * Input: N = 10
 * Output: 9
 *
 * Example 2:
 * Input: N = 1234
 * Output: 1234
 *
 * Example 3:
 * Input: N = 332
 * Output: 299
 *
 * Note: N is an integer in the range [0, 10^9].
 */
public class MonotoneIncreasingDigits {

  public static void main(String arts[]) {
    MonotoneIncreasingDigits monotoneIncreasingDigits = new MonotoneIncreasingDigits();
    int xx = monotoneIncreasingDigits.monotoneIncreasingDigits1(120);
    System.out.println(xx);
  }

  /**
   * 1. 先找到单调递增的最右侧位置(char[index]>= char[index -1]?index++)，用index表示，如333222，index=3
   * 2. [index-1]位减一后左侧是否满足单调递增，不满足则向左移动并将对应位置位减一，得到222222，index=1
   * 3. index及右侧的位使用9替换，得到299999
   */
  public int monotoneIncreasingDigits1(int num) {
    char[] numChars = String.valueOf(num).toCharArray();
    int index = 1;
    while (index < numChars.length && numChars[index] >= numChars[index - 1]) {
      index++;
    }
    while (index > 0 && index < numChars.length && numChars[index - 1] > numChars[index]) {
      numChars[--index]--;
    }
    for (index = index + 1; index < numChars.length; index++) {
      numChars[index] = '9';
    }
    return Integer.parseInt(String.valueOf(numChars));
  }

  public int monotoneIncreasingDigits2(int N) {
    char[] arrN = String.valueOf(N).toCharArray();
    int monotoneIncreasingToTheLeftOf = arrN.length - 1;
    for (int i = arrN.length - 1; i > 0; i--) {
      if (arrN[i] < arrN[i - 1]) {
        monotoneIncreasingToTheLeftOf = i - 1;
        arrN[i - 1]--;
      }
    }
    for (int i = monotoneIncreasingToTheLeftOf + 1; i < arrN.length; i++) {
      arrN[i] = '9';
    }

    return Integer.parseInt(new String(arrN));
  }

  /**
   * 给num不同位的数字排序：
   * 1. 如果最小是0则需要减位
   * 2. 非0则和原位比较，相同则放入结果池，不同则减一后补9
   */
  public int monotoneIncreasingDigits(int num) {
    int result = 0;
    int length = String.valueOf(num).length();
    boolean flag = false;
    for (int index = 0; index < length; index++) {
      if (flag) {
        result = result * 10 + 9;
        continue;
      }
      int temp = (int) Math.pow(10, length - index - 1);
      int rawFirst = num / temp;
      int first = calculateFirst(num);
      num = num % temp;
      result = result * 10 + first;
      if (rawFirst != first) {
        flag = true;
      }
    }
    return result;
  }

  private int calculateFirst(int num) {
    int length = String.valueOf(num).length();
    if (length == 1) {
      return num;
    }
    int index = num / (int) Math.pow(10, length - 1);
    while (length >= 2) {
      int firstTemp = (int) Math.pow(10, length - 1);
      int first = num / firstTemp;
      int second = num % firstTemp / (firstTemp / 10);
      if (second > first) {
        return index;
      }
      if (second < first) {
        return Math.max(0, index - 1);
      }
      length--;
      num = num % firstTemp;
    }
    return 0;
  }


}
