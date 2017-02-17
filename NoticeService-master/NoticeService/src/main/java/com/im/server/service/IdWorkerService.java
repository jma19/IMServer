package com.im.server.service;

import org.springframework.stereotype.Service;

@Service("idWorkerService")
public class IdWorkerService {
     //毫秒级时间41位+机器ID 10位+毫秒内序列12位
    private final long workerId;
    private final static long twepoch = 1288834974657L;
    private long sequence = 0L;
    private final static long workerIdBits = 4L;
    public final static long maxWorkerId = 15;
    private final static long sequenceBits = 10L;
 
    private final static long workerIdShift = sequenceBits;   //10
    private final static long timestampLeftShift = sequenceBits + workerIdBits; //  10+4
    public final static long sequenceMask = -1L ^ -1L << sequenceBits; //2^10 -1

    private long lastTimestamp = -1L;
 
    public IdWorkerService(final long workerId) {
        super();
        if (workerId > this.maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format(
                    "worker Id can't be greater than %d or less than 0",
                    this.maxWorkerId));
        }
        this.workerId = workerId;
    }
    public IdWorkerService(){
        workerId = 2;
    }
 
    public synchronized long nextId() {
        long timestamp = this.timeGen();
        if (this.lastTimestamp == timestamp) {
            this.sequence = (this.sequence + 1) & this.sequenceMask;
            if (this.sequence == 0) {
                System.out.println("###########" + sequenceMask);
                timestamp = this.tilNextMillis(this.lastTimestamp);
            }
        } else {
            this.sequence = 0;
        }
        if (timestamp < this.lastTimestamp) {
            try {
                throw new Exception(
                        String.format(
                                "Clock moved backwards.  Refusing to generateHeadPath id for %d milliseconds",
                                this.lastTimestamp - timestamp));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
 
        this.lastTimestamp = timestamp;
        long nextId = ((timestamp - twepoch << timestampLeftShift))
                | (this.workerId << this.workerIdShift) | (this.sequence);
        System.out.println("timestamp:" + timestamp + ",timestampLeftShift:"
                + timestampLeftShift + ",nextId:" + nextId + ",workerId:"
                + workerId + ",sequence:" + sequence);
        return nextId;
    }
 
    private long tilNextMillis(final long lastTimestamp) {
        long timestamp = this.timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = this.timeGen();
        }
        return timestamp;
    }
 
    private long timeGen() {
        return System.currentTimeMillis();
    }

//
//    public static void main(String[] args){
//        IdWorkerService worker2 = new IdWorkerService(2);
//        System.out.println(worker2.nextId());
//        System.out.println(sequenceMask);
//    }

 
}