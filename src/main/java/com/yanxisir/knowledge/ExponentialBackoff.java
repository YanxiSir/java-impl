package com.yanxisir.knowledge;

/**
 * 指数退避算法 （动态退避）
 * http://www.ituring.com.cn/article/213179
 * "Exponential backoff is an algorithm that uses feedback to multiplicatively decrease the rate of some process, in order to gradually find an acceptable rate"。
 * 通俗点说， 退避算法就是网络上的节点在发送数据冲突后，等待一定时间后再发，等待时间是随指数增长，从而避免频繁的触发冲突。
 * <p>
 * 伪代码
 * Do some asynchronous operation.·
 * retries = 0
 * DO
 *     wait for (2^retries * 100) milliseconds
 *     status = Get the result of the asynchronous operation.
 *     IF status = SUCCESS
 *         retry = false
 *     ELSE IF status = NOT_READY
 *         retry = true
 *     ELSE IF status = THROTTLED
 *         retry = true
 *     ELSE
 *         Some other error occurred, so stop calling the API.
 *         retry = false
 *     END IF
 *     retries = retries + 1
 * WHILE (retry AND (retries < MAX_RETRIES))
 */
public class ExponentialBackoff {

    private static final int MAX_ACTIVE_TIME = 100;
    private static final int MAX_ACTIVE_RETRIES = 6;

    public static void main(String[] args) throws Exception {
        new ExponentialBackoff().doOperationAndWaitForResult();
    }

    private void doOperationAndWaitForResult() throws Exception {
        int retries = 0;
        int baseTimes = 1;
        boolean retryFlag ;
        do {
            // 这块应该有一个随机的概念，取nx （x为basetime，n<Math.pow(2,retries)）
            long waitTime = Math.min(getWaitTimeExp(retries, baseTimes), MAX_ACTIVE_TIME);
            System.out.println("waitTime->" + waitTime);
            Results results = asyncOperation();
            switch (results) {
                case SUCCESS:
                    retryFlag = false;
                    break;
                case NOT_READY:
                    retryFlag = true;
                    break;
                case ERROR:
                    retryFlag = true;
                    break;
                default:
                    retryFlag = true;
                    break;
            }

        } while (retryFlag && ((retries++) < MAX_ACTIVE_RETRIES));


    }

    private long getWaitTimeExp(int retryCount, long baseTimes) {
        return (long) (Math.pow(2, retryCount)) * baseTimes;
    }

    private Results asyncOperation() {
        //...
        return Results.ERROR;
    }
}

enum Results {
    SUCCESS, NOT_READY, ERROR
}
