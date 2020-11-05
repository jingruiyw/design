package com.book.mall.learn.timer;

import java.time.Instant;
import java.util.TimerTask;

/**
 * ClassName: TimerTaskBean
 * Description:
 * date: 2020/11/1 3:04 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class TimerTaskBean extends TimerTask {
    @Override
    public void run() {
        //使用的新线程开启定时任务
        System.out.println(Thread.currentThread().getName());
        System.out.println("time: " + Instant.now().toEpochMilli() + "===定时任务开始执行");
    }
}
