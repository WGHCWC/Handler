package com.example.hander;

import java.io.FileFilter;

public class MessageQueue {
    Message first;
    Message last;

    public MessageQueue() {


    }

    /**
     * 简单模拟
     * 消息出队,如果消息队列为空,则睡眠等待
     */
    public Message next() {
        synchronized (this) {
            while (true) {
                if (first == null) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else if (first == last) {
                    Message msg = first;
                    first = null;
                    last = null;
                    return msg;

                } else {
                    Message msg = first;
                    first = msg.next;
                    return msg;

                }


            }

        }

    }

    /**
     * 线程
     * 消息入队,如果消息入队则唤醒睡眠线程
     */
    public boolean enqueueMessage(Message msg) {
        synchronized (this) {
            if (first == null) {
                first = msg;
                last = msg;
            } else {
                last.next = msg;
                last = msg;
            }
            notify();
            return true;
        }

    }
}
