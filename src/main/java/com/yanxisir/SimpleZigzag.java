package com.yanxisir;

import java.util.Arrays;

public class SimpleZigzag {

    public static void main(String[] args) {
//        System.out.println(cal(2));
//        System.out.println(cal(-2));
        t();
    }

    public static int cal(int n) {
        System.out.println("=========" + n + "========");
        System.out.println("n<<1 : " + (n << 1));
        System.out.println("n>>1 : " + (n >> 31));

        String[] s = new String[]{"123", "abc", "dgs"};
        Arrays.stream(s).sorted((o1, o2) -> o1.compareTo(o2));
        // 左移-补0；右移-补1
        return (n << 1) ^ (n >> 31);
    }

    public static void t() {
        System.out.println(6657486331354661870L % 1024);
    }
}
