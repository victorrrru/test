package com.example.demo;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo {
    @Test
    public void create() throws ParseException {
        for (int i = 0; i < 60; i++) {
            int step = new Random().nextInt(10000) + 1000;
            String dateStr = "2017-11-13 00:00:00";
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = format.parse(dateStr);
            Date newDate = DateUtils.addDays(date, -i);
            String newDateStr = format.format(newDate);
            String sql = "INSERT INTO `smart_report`.`report_step` (`object_id`, `count_base`, `object_type`, `step_number`, `type`, `time_date`, `gmt_create`) VALUES ('1', '1', '0', '"+ step +"', '0', '" + newDateStr + "', '2017-11-29 18:05:01');";
            System.out.println(sql);
        }
    }
}
