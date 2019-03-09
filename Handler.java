package com.example.hander;

/**
 * @author wghcwc
 */
public class Handler {
    final MessageQueue mQueue;
    final Looper mLooper;

    /**
     * handler构造函数,创建对象时获取当前线程的Looper和MessageQueue
     */
    public Handler() {
        mLooper = Looper.myLooper();
        if (mLooper == null) {
            throw new RuntimeException(
                    "Can't create handler inside thread " + Thread.currentThread()
                            + " that has not called Looper.prepare()");
        }
        mQueue = mLooper.mQueue;

    }

    /**
     * 发送消息,并将当前handler赋值给Message中的target
     *
     * @param msg 所要发送的消息
     */
    public boolean sendMessage(Message msg) {
        msg.target = this;
        MessageQueue queue = mQueue;
        if (queue == null) {
            return false;
        }
        return queue.enqueueMessage(msg);
    }

    /**
     * 处理消息,重写
     */
    public void handleMessage(Message msg) {
    }

    /**
     * 在looper.loop()中取出消息后通过消息的target(handler本身)调用,用于处理消息
     */
    public void dispatchMessage(Message msg) {
        handleMessage(msg);
    }

}
