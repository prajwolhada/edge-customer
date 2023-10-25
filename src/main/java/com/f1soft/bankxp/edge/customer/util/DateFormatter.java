package com.f1soft.bankxp.edge.customer.util;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class DateFormatter extends DateFormat {

    private DateFormatter() {
    }

    public static String convertToString(Date date, String dateFormat) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
            return simpleDateFormat.format(date);
        } catch (Exception e) {
            return null;
        }
    }

}
