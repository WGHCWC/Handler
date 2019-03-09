package com.example.hander;

/**
 * @author wghcwc
 */
public class ActivityThread {
    /**
     * 程序入口
     */
    public static void main(String[] args) {
        Looper.prepare();
        attach();
        Looper.loop();

    }

    /**
     * 模拟启动Activity onCreate方法
     */
    private static void attach() {
        MainActivity activity = new MainActivity();
        activity.onCreate();
    }
}
