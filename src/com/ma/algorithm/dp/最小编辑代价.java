package com.ma.algorithm.dp;

public class 最小编辑代价 {


  public int findMinCost(String A, int n, String B, int m,
      int c0, int c1, int c2) {
    c2 = c2 < c1 + c0 ? c2 : c1 + c0;
    int[][] val = new int[n + 1][m + 1];
    val[0][0] = 0;
    //A长于B执行删除操作
    for (int i = 1; i < n + 1; i++) {
      val[i][0] = val[i - 1][0] + c1;
    }
    //B长于A执行插入操作
    for (int i = 1; i < m + 1; i++) {
      val[0][i] = val[0][i - 1] + c0;
    }
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {
        if (A.charAt(i - 1) == B.charAt(j - 1)) {
          val[i][j] = val[i - 1][j - 1];
        } else {
          int a = val[i - 1][j - 1] + c2;
          int b = val[i - 1][j] + c1;
          int c = val[i][j - 1] + c0;
          a = a < b ? a : b;
          a = a < c ? a : c;
          val[i][j] = a;
        }
      }
    }
    return val[n][m];
  }

}
