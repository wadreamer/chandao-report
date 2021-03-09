package club.wadreamer.chandao.common.utils;

import cn.hutool.core.date.DateUtil;

import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName DateUtils
 * @Description TODO
 * @Author bear
 * @Date 2021/3/6 11:34
 * @Version 1.0
 **/
public class DateUtils extends DateUtil {

    public static void calculateTimeDifferenceByCalendar(Date estStarted, Date finishedDate) {

        Calendar estStartedCal = Calendar.getInstance();
        Calendar finishedDateCal = Calendar.getInstance();

        estStartedCal.setTime(estStarted);   //设置为另一个时间
        finishedDateCal.setTime(finishedDate);

        int oldDay = estStartedCal.get(Calendar.DAY_OF_MONTH);
        int newDay = finishedDateCal.get(Calendar.DAY_OF_MONTH);

        //这里只是简单的对两个年份数字进行相减，而没有考虑月份的情况
        System.out.println("传入的日期与今年的年份差为：" + (newDay - oldDay));
    }
}
