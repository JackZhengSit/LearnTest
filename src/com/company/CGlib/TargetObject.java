package com.company.CGlib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TargetObject {
    public String method1(String paraName){
        return paraName;
    }
    public int method2(int parameter){
        return parameter;
    }
    public int method3(int count){
        return count;
    }

    @Override
    public String toString() {
        return "TargetObject[]"+getClass();
    }
}

