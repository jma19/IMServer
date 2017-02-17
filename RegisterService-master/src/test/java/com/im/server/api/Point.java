package com.im.server.api;

import org.junit.Test;

/**
 * Created by majun on 16/3/7.
 */
public class Point {
    private double x;
    private double y;
    private String label;
    private double distance;

    public double getDistance() {
        return distance;
    }

    public Point setDistance(double distance) {
        this.distance = distance;
        return this;
    }

    public Point(double x, double y,String label) {
        this.label = label;
        this.x = x;
        this.y = y;
    }

    public String getLabel() {
        return label;
    }

    public Point setLabel(String label) {
        this.label = label;
        return this;
    }

    public double getX() {
        return x;
    }

    public Point setX(double x) {
        this.x = x;
        return this;
    }

    public double getY() {
        return y;
    }

    public Point setY(double y) {
        this.y = y;
        return this;
    }

    @Test
    public void testName() throws Exception {
//        System.out.println(trailingZeroes(5));
    }
    public int trailingZeroes(int n) {
        //转化为1-n的数
        int result = 0;
        for(int i=5; i<=n; i=i+5){
            int temp =i;
            while(temp/5>=5 && temp%5==0){
                result++;
                temp=temp/5;
            }
        }

        if(n<1) return 0;
        int c = 0;

        while(n/5 != 0) {
            n /= 5;
            c += n;
        }

        return c;
    }


}
