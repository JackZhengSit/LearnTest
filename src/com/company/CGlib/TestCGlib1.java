package com.company.CGlib;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

public class TestCGlib1 {
    public static void main(String[] args){
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(TargetObject.class);
        CallbackFilter callbackFilter=new TargetMethodCallbackFilter();
        Callback noOpCb= NoOp.INSTANCE;
        Callback callback1=new TargetInterceptor();
        Callback fixValue=new TargetResultFixed();
        Callback[] cbArray=new Callback[]{callback1,noOpCb,fixValue};
        enhancer.setCallbacks(cbArray);
        enhancer.setCallbackFilter(callbackFilter);
        TargetObject targetObjectProxy= (TargetObject) enhancer.create();
        System.out.println(targetObjectProxy);
        System.out.println(targetObjectProxy.method1("m2m2m2"));
        System.out.println(targetObjectProxy.method2(120));
        System.out.println(targetObjectProxy.method3(220));
    }
}
