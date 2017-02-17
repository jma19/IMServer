package com.im.server.utils;

import org.apache.commons.lang.time.FastDateFormat;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Strings.isNullOrEmpty;

public class TimeUtils {
    private static final String TIME_FORMAT = "\\d{4}-{1}\\d{2}-{1}\\d{2}";
    private static final Log logger = LogFactory.getLog(TimeUtils.class);
    private static final FastDateFormat fastDateFormat = FastDateFormat.getInstance("yyyy-MM-dd");

    public static String getStartTime(String startTime) {
        return isNullOrEmpty(startTime)
                ? new StringBuilder().append(fastDateFormat.format(new Date())).toString()
                : startTime;
    }

    public static String getEndTime(String startTime, String endTime)  {
        checkNotNull(startTime, "start time should not be null");
        return isNullOrEmpty(endTime) ?
                increaseOneDay(startTime) : increaseOneDay(endTime);
    }

    private static String increaseOneDay(String time) {
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(time));
        } catch (Exception e) {
            logger.error(String.format("时间解析出错, time=%s,error=%s", time, e));
        }
        cal.add(Calendar.DATE, 1);
        return fastDateFormat.format(cal.getTime());
    }

    public static boolean timeParametrValidateFailed(String startTime, String endTime) {
        return absentOneTimeParamter(startTime, endTime) || isIllegalFormatTime(startTime, endTime) || startTimeOverEndTime(startTime, endTime);
    }

    private static boolean startTimeOverEndTime(String startTime, String endTime) {
        return containBothTimeParameter(startTime, endTime) && startTime.compareTo(endTime) > 0;
    }

    private static boolean containBothTimeParameter(String startTime, String endTime) {
        return !isNullOrEmpty(startTime) && !isNullOrEmpty(endTime);
    }


    private static boolean absentOneTimeParamter(String startTime, String endTime) {
        return isNullOrEmpty(startTime) && !isNullOrEmpty(endTime)
                || (!isNullOrEmpty(startTime)) && isNullOrEmpty(endTime);
    }

    private static boolean isIllegalFormatTime(String startTime, String endTime) {
        return !isNullOrEmpty(startTime) && !isNullOrEmpty(endTime) ?
                isIllegalFormatTime(startTime) || isIllegalFormatTime(endTime) : false;
    }

    private static boolean isIllegalFormatTime(String time) {
        return !time.matches(TIME_FORMAT);
    }

    //将Long time 转化为Timestamp

    public static Timestamp getTimestamp(Long time){
        return new Timestamp(time);
    }
}

