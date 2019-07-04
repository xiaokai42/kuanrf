package com.xiaokai.kuanrf.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.util.CollectionUtils;

/**
 * @author wuy
 */
public class StringUtil
{
    /**
     * 初始化密码
     */
    public final static String PWD = "846c1f911f77a22f5fd42c105c7f6e6b";

    /**
     * 初始化密码，明码
     */
    public final static String PWD_MM = "passCqgp0";

    /**
     * 政治面貌
     */
    public final static Map<Integer, String> ZZMM = new HashMap<Integer, String>();

    /**
     * 验证码
     */
    public final static String[] CODES = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
            "M", "N", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };

    /**
     * 文件下载路径
     */
    public static String download()
    {
        Date date = Calendar.getInstance().getTime();
        String dt = FileUtil.formatDate(date, "yyyyMM");
        return FileUtil.DISK + FileUtil.ROOT + "/download/" + dt;
    }

    /**
     * 年龄计算
     * 
     * @return
     */
    public static int getAge(Date birthDay)
    {
        if (birthDay == null)
        {
            return 0;
        }
        Calendar calendar = GregorianCalendar.getInstance();
        int theYear = calendar.get(Calendar.YEAR);
        int theMonth = calendar.get(Calendar.MONTH) + 1;
        int theDays = calendar.get(Calendar.DATE);
        calendar.setTime(birthDay);
        int birthYear = calendar.get(Calendar.YEAR);
        int birthMonth = calendar.get(Calendar.MONTH) + 1;
        int birthDays = calendar.get(Calendar.DATE);

        int year = theYear - birthYear;
        int month = theMonth - birthMonth;
        int day = theDays - birthDays;
        int age = year;
        // 当前月份与出生日期的月份相比，如果月份小于出生月份，则年龄上减1，表示不满多少周岁
        if (month <= 0)
        {
            // 如果月份相等，在比较日期，如果当前日，小于出生日，也减1，表示不满多少周岁
            if (month == 0)
            {
                if (day < 0)
                {
                    age--;
                }
            } else
            {
                age--;
            }
        }

        return age;
    }

    /**
     * 籍贯,服务意向
     * 
     * @param region
     * @return
     */
    public static String getRegion(String region)
    {
        if (null != region)
        {
            String[] reg = region.split("/");
            if (reg.length > 1)
            {
                if (reg[0].trim().equals(reg[1].trim()))
                {
                    if (reg.length > 2)
                    {
                        return reg[1] + "/" + reg[2];
                    } else
                    {
                        return reg[1];
                    }
                }
            }
        }
        return region;
    }

    /**
     * 政治面貌
     * 
     * @return
     */
    public static String getZzmm(Integer zzmm)
    {
        if (CollectionUtils.isEmpty(ZZMM))
        {
            ZZMM.put(1, "中共党员");
            ZZMM.put(2, "中共预备党员");
            ZZMM.put(3, "共青团员");
            ZZMM.put(4, "民革党员");
            ZZMM.put(5, "民盟盟员");
            ZZMM.put(6, "民建会员");
            ZZMM.put(7, "民进会员");
            ZZMM.put(8, "农工党党员");
            ZZMM.put(9, "致公党党员");
            ZZMM.put(10, "九三学社社员");
            ZZMM.put(11, "台盟盟员");
            ZZMM.put(12, "无党派人士");
            ZZMM.put(13, "群众");
        }
        return ZZMM.get(zzmm);
    }

    /**
     * 验证码
     * 
     * @param x
     *            几位验证码
     * @return
     */
    public static String getCode(int x)
    {
        String sRand = "";
        // 生成随机类
        Random random = new Random();
        for (int i = 0; i < x; i++)
        {
            sRand += CODES[random.nextInt(34)];
        }
        return sRand;
    }
}
