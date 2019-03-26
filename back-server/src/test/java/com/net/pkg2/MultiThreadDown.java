package com.net.pkg2;

public class MultiThreadDown {

    public static void main(String[] args) throws Exception {
        // 初始化DownUtil对象
        final DownUtil downUtil = new DownUtil("http://s2.dgtle.com/forum/201803/11/124402sl9aae049l9pv95z.jpg?imageView2/2/w/960/q/100",
                "ios.png", 4);
        // 开始下载
        downUtil.download();
        new Thread(() -> {
            while (downUtil.getCompleteRate() < 1) {
                // 每隔0.1秒查询一次任务的完成进度，
                // GUI程序中可根据该进度来绘制进度条
                System.out.println("已完成：" + downUtil.getCompleteRate());
                try {
                    Thread.sleep(1000);
                } catch (Exception ex) {
                }
            }
        }).start();
    }

}
