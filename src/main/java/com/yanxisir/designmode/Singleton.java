package com.yanxisir.designmode;

public class Singleton {

    // volatile 阻止指令重排
    public static volatile Singleton instance = null;

    public static Singleton instance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
