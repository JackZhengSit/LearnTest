package com.company;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyDynamicProxy {
    public static void main(String[] args){
        HelloImp helloImp=new HelloImp();
        MyInvocationHandler handler=new MyInvocationHandler(helloImp);
        Hello proxyHello= (Hello) Proxy.newProxyInstance(HelloImp.class.getClassLoader(),HelloImp.class.getInterfaces(),handler);
        proxyHello.sayHello();
    }
}

interface Hello{
    void sayHello();
}

class HelloImp implements Hello{

    @Override
    public void sayHello() {
        System.out.println("hello world");
    }
}

class MyInvocationHandler implements InvocationHandler{
    private Object target;
    public MyInvocationHandler(Object target){
        this.target=target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("Invoking sayHello");
        Object result=method.invoke(target,args);
        return result;
    }
}
