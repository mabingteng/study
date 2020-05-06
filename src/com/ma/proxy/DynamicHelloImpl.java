package com.ma.proxy;

public class DynamicHelloImpl implements DynamicProxyHello1, DynamicProxyHello2 {

  private String ts;

  public DynamicHelloImpl(String ts) {
    this.ts = ts;
  }

  @Override
  public void sayHello() {
    System.out.println("say hello " + ts);

  }

  public void doSomething() {
    System.out.println("do something");
  }

}
