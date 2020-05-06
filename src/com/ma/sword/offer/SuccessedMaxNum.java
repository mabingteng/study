package com.ma.sword.offer;

import java.util.Random;

public class SuccessedMaxNum {

  public static void main(String[] args) {
    int A[] = new int[10000000];
    for (int i = 0; i < 10000000; i++) {
      A[i] = new Random().nextInt();
    }
    //int [] A = {1,-2,3,10,-4,7,2,-5};
    //FindGreatestSumOfSubArray(A);
    FindGreatestSumOfSubArray1(A);
  }

  public static int FindGreatestSumOfSubArray(int[] A) {
    long start = System.currentTimeMillis();
    int max = 0;
    for (int i = 0; i < A.length; i++) {
      if (A[i] >= 0) {
        int tmp = A[i];
        int j = i + 1;
        for (; j < A.length; j++) {
          if (A[j] >= 0) {
            tmp += A[j];
          } else {
            break;
          }
        }
        max = Math.max(max, tmp);
        i = j;
      }
    }
    System.out.println(System.currentTimeMillis() - start + " ms cost!");
    System.out.println(max);
    return max;
  }

  public static int FindGreatestSumOfSubArray1(int[] A) {
    long start = System.currentTimeMillis();
    int cur = A[0], max = A[0];
    for (int i = 1; i < A.length; i++) {
      cur = Math.max(cur + A[i], A[i]);
      max = Math.max(max, cur);
    }
    System.out.println(System.currentTimeMillis() - start + " ms cost!");
    System.out.println(max);
    return max;
  }
}
