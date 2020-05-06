package com.mbt.reflect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Test {

  public Test() {
    //System.out.print("Test: public Test()");
  }

  private Test(String s) {
    System.out.println("Test: private Test(String s)");
  }

  private String pmethod(String s) {
    System.out.println("Test: private String pmethod(String s)");
    return s;
  }

  public String pub(String s) {
    System.out.println("Test : public pub(String s)");
    return s;
  }

  public void pub() {
    HashMap map = new HashMap<>();
    ArrayList list = new ArrayList<>();
    ConcurrentHashMap<String, Integer> cmap = new ConcurrentHashMap<String, Integer>();
    //System.out.println("Test : public pub(String s)");
    //return s;
  }

  volatile static int[] s = {0, 1, 2};

  public static void main(String[] args) {
    int[] a = s;
    a[0] = 3;
    a[1] = 4;
    a[2] = 5;
    System.out.println(s[0]);
  }
}
