/**
 *
 */
package com.ma.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author waller 展示Condition接口使用，实现有界队列：队列空时阻塞删除，队列满时阻塞添加
 */
public class BoundedQueue<K> {

  Lock lock = new ReentrantLock();
  Condition notFull = lock.newCondition();
  Condition notEmpty = lock.newCondition();
  private Object array[] = null;
  private int maxSize;
  private int index = -1;

  public BoundedQueue(int size) {
    array = new Object[size];
    maxSize = size;
  }

  public void add(K key) {
    lock.lock();
    try {
      while (index == maxSize - 1) {
        notFull.await();
      }
      array[++index] = key;
      notEmpty.signal();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }

  public void remove() {
    lock.lock();
    try {
      while (index == -1) {
        notEmpty.await();
      }
      array[index] = null;
      index--;
      notFull.signal();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[ ");
    for (int i = 0; i <= index; i++) {
      sb.append(array[i] + ", ");
    }
    sb.append(" ]");
    return sb.toString();
  }


}
