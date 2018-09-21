package com.yanxisir.disruptor;


import java.util.Arrays;

/**
 * http://ifeve.com/falsesharing/
 */
public class FalseSharing implements Runnable {

    public final static int NUM_THREADS = 4;
    public final static long ITERATIONS = 500L * 1000L * 1000L;
    private final int arrayIndex;

    private static VolatileLong[] longs = new VolatileLong[NUM_THREADS];

    static {
        for (int i = 0; i < longs.length; i++) {
            longs[i] = new VolatileLong();
        }
    }

    public FalseSharing(int arrayIndex) {
        this.arrayIndex = arrayIndex;
    }

    public static void main(String[] args) throws Exception {
        final long start = System.nanoTime();
        runTest();
        System.out.println("duration = " + (System.nanoTime() - start));
    }

    private static void runTest() throws InterruptedException {
        Thread[] threads = new Thread[NUM_THREADS];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new FalseSharing(i));
        }
        Arrays.asList(threads).forEach(t -> t.start());
        for (Thread t :
                threads) {
            t.join();
        }
    }


    @Override
    public void run() {
        long i = ITERATIONS + 1;
        while (0 != --i) {
            longs[arrayIndex].value = i;
        }
    }

    public final static class VolatileLong {
        public volatile long value = 0L;
        /**
         * comment out ; 测试结果，5个p效果最好，猜测：64位机器一个字8字节。所以对象头占两个字，即2*16字节+内容8字节+填充5*8字节 = 64字节
         */
        public long p1, p2, p3, p4, p5;
    }
}
