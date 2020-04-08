package com.yanxisir;

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
        // 左移-补0；右移-补1
        return (n << 1) ^ (n >> 31);
    }

    public static void t() {
        long[] ll = new long[]{
                281475092449009L,
                281475092449009L,
                283754929325905L,
                299067254829235L,
                299068128508097L,
                283419276619636L,
                283419276619636L,
                282807343063043L,
                282807343063043L,
                282158105305088L,
                282158105305088L,
                299067254829235L,
                286475107958950L,
                286475107958950L,
                283436821912599L
        };
        for (long l : ll) {
            long m = l % 257;
            System.out.println(l + "," + (m == 0L ? 257 : m));
        }
    }
}
