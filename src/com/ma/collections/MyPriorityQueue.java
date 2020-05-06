/**
 *
 */
package com.ma.collections;

import java.util.PriorityQueue;

/**
 * @author waller test PrirorityQueue,优先队列主要是实现其所存对象的compareTo方法。comparable接口
 */
public class MyPriorityQueue extends PriorityQueue<MyPriorityQueue.ToDoItem> {


  public static void main(String[] args) {
    MyPriorityQueue tdl = new MyPriorityQueue();
    tdl.add("Empty", 'C', 4);
    tdl.add("Feed dog", 'A', 2);
    tdl.add("Feed Bird", 'B', 7);
    tdl.add("Mow lawn", 'C', 3);
    tdl.add("Water lawn", 'A', 1);
    tdl.add("Feed cat", 'B', 1);
    while (!tdl.isEmpty()) {
      System.out.println(tdl.remove());
    }
  }

  public void add(String td, char pri, int sec) {
    super.add(new ToDoItem(pri, sec, td));
  }

  static class ToDoItem implements Comparable<ToDoItem> {

    private char primary;
    private int secondary;
    private String item;

    public ToDoItem(char primary, int secondary, String item) {
      this.primary = primary;
      this.secondary = secondary;
      this.item = item;
    }

    @Override
    public int compareTo(ToDoItem o) {
      if (primary > o.primary) {
        return 1;
      } else if (primary == o.primary) {
        if (secondary > o.secondary) {
          return 1;
        } else if (secondary == o.secondary) {
          return 0;
        }
      }
      return -1;
    }

    public String toString() {
      return Character.toString(primary) + secondary + " : " + item;
    }
  }

}
