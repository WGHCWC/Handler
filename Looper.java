package com.example.hander;

/**
 * @author wghcwc
 */
public class Looper {
    /**
     * 主线程Looper,特殊.可以更新Ui
     */
    private static Looper sMainLooper;
    static final ThreadLocal<Looper> sThreadLocal = new ThreadLocal<>();
    final MessageQueue mQueue;

    /**
     * Looper构造函数,创建当前线程的Looper和MessageQueue
     */
    private Looper() {
        mQueue = new MessageQueue();

    }

    /**
     * 获取当前线程looper
     */
    public static Looper myLooper() {
        return sThreadLocal.get();

    }

    /**
     * 构造方法为私有,通过静态方法创建,Looper一个线程只能有一个
     */
    public static void prepare() {
        if (sThreadLocal.get() != null) {
            throw new RuntimeException("Only one Looper may be created per thread");
        }
        sThreadLocal.set(new Looper());
    }

    /**
     * Looper开启循环,从消息队列取出消息
     */
    public static void loop() {
        final Looper me = myLooper();
        final MessageQueue queue = me.mQueue;

        for (; ; ) {
            Message msg = queue.next();
            if (msg == null) {
                return;
            }
            msg.target.dispatchMessage(msg);

        }

    }
}

