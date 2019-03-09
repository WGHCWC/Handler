package com.example.hander;

/**
 * @author wghcwc
 */
public class MainActivity {
    int i = 0;
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            System.out.println(msg.what);
        }
    };

    /**
     *模拟Activity入口.循环发送消息
     * */
    public void onCreate() {

        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Message msg = new Message();
                    msg.what = i++;
                    mHandler.sendMessage(msg);
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Message msg = new Message();
                    msg.what = i + 99;
                    mHandler.sendMessage(msg);
                }

            }
        }).start();

    }
}