package com.YunMuseum.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
//贝叶斯平均算法时间权重计算
public class Datetime {
    public float Datetime(Date datenow, Date datemin){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmm");
        String datenowstring = simpleDateFormat.format(datenow);
        datenowstring = datenowstring.substring(4,12);
        String dateminstring = simpleDateFormat.format(datemin);
        dateminstring = dateminstring.substring(4,12);
        int datenowint = Integer.parseInt(datenowstring);
        System.out.println("datenowint:" + datenowint);
        int dateminint = Integer.parseInt(dateminstring);
        System.out.println("dateminint:" + dateminint);
        float DateRate = 1.0f * datenowint / dateminint;
        return DateRate;
    }
}
