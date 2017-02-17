package com.im.server.utils;


import java.util.concurrent.*;

/**
 * Created by majun on 16/2/1.
 */
public class ScheduleTask {

    private final static ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);

    public static Future<Boolean> submit(Callable<Boolean> task) {
        return executorService.submit(task);
    }

}
