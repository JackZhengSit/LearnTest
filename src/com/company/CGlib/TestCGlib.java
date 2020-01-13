package com.company.CGlib;

import net.sf.cglib.proxy.Enhancer;

public class TestCGlib {
    public static void main(String[] args){
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(TargetObject.class);
        enhancer.setCallback(new TargetInterceptor());
        TargetObject targetObjectProxy= (TargetObject) enhancer.create();
        System.out.println(targetObjectProxy);
        System.out.println(targetObjectProxy.method1("method1"));
        System.out.println(targetObjectProxy.method2(10));
        System.out.println(targetObjectProxy.method3(20));
    }
}
