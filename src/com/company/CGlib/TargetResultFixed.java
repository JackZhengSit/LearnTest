package com.company.CGlib;

import net.sf.cglib.proxy.FixedValue;

public class TargetResultFixed implements FixedValue {
    @Override
    public Object loadObject() throws Exception {
        System.out.println("锁定结果");
        Object obj=2020;
        return obj;
    }
}
