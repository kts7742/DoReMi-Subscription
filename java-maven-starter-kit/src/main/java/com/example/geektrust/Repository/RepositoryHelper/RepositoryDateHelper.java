package com.example.geektrust.Repository.RepositoryHelper;

import java.time.LocalDate;

public class RepositoryDateHelper {
    
    final int TWO_DIGIT = 10;

    public String getDate(String date, int time){
        String ans = "";
        String[] arr = date.split("-");
        int day = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);
        int year = Integer.parseInt(arr[2]);
        LocalDate d1 = LocalDate.of(year, month, day);
        d1 = d1.plusMonths(time);
        d1 =  d1.minusDays(TWO_DIGIT);
        String dday = "", dmonth = "";

        dday = getdday(d1);
        dmonth = getdmonth(d1);

        ans += dday+"-"+dmonth+"-"+d1.getYear();
        return ans;
    }
    
    String getdmonth(LocalDate d1) {
        String dmonth = "";
        if(d1.getMonthValue() < TWO_DIGIT){
            dmonth = dmonth + "0" + d1.getMonthValue();
        }
        else{
            dmonth = dmonth + d1.getMonthValue();
        }
        return dmonth;
    }

    String getdday(LocalDate d1) {
        String dday = "";

        if(d1.getDayOfMonth() < TWO_DIGIT){
            dday = dday + "0" + d1.getDayOfMonth();
        }
        else{
            dday = dday + d1.getDayOfMonth();
        }
        return dday;
    }
}
