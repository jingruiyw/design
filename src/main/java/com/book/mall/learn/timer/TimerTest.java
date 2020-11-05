package com.book.mall.learn.timer;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

/**
 * ClassName: TimerTest
 * Description:
 * date: 2020/11/1 3:05 下午
 *
 * @author: Jingrui
 * @since JDK 1.8
 */
public class TimerTest {

    private static Map<String, TimerTaskBean> taskBeanMap = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        System.out.println("当前线程名：" + Thread.currentThread().getName());
        String key1 = putTimerTask(timer, "1");
        String key2 = putTimerTask(timer, "2");
        Thread.sleep(10000);
//        cancelTimerTask(key1);

        timer.cancel();
        int purge = timer.purge();
        System.out.println(purge);


    }

    private static void cancelTimerTask(String key) {
        TimerTaskBean bean = taskBeanMap.get(key);
        bean.cancel();
        System.out.println("=====> 定时任务已取消");
    }

    private static String putTimerTask(Timer timer, String key) {
        TimerTaskBean bean = new TimerTaskBean();
        timer.schedule(bean , new Date(), 2000);
        taskBeanMap.put(key, bean);
        return key;
    }


    //返回ota可以执行时，生成一个40min的定时器
    //40分钟结束，定时器还存在，则报警到微信群，并将机器人置为故障

    //重复回调不处理
    //不回调超时置机器人故障
    //回调未将定时任务取消（***）


}
