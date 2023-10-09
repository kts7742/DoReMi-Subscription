package com.example.geektrust.Repository.RepositoryHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.geektrust.Entity.Subscription;

public class RepositoryHelper {

    RepositoryAmountHelper repositoryHelper2 = new RepositoryAmountHelper();
    RepositoryDateHelper repositoryDateHelper = new RepositoryDateHelper();

    final int TOPUP_FOUR = 50, TOPUP_TEN = 100;

    public int getType(String str) {
        if(str.equals("FOUR_DEVICE")){
            return TOPUP_FOUR;
        }else{
            return TOPUP_TEN;
        }
    }

    public List<String> printRenewalHelp(List<Subscription> slist){
        List<String> ans = new ArrayList<>();
        HashMap<String, String> categoryMap = slist.get(0).getCategoryMap();
       int totalAmount = 0;
       
       for(String str : categoryMap.keySet()){
        int[] amountAndTime = RepositoryAmountHelper.getAmountAndTime(str, categoryMap);
        int amount = amountAndTime[0];
        int time = amountAndTime[1];
        totalAmount += amount;
        String date = repositoryDateHelper.getDate(slist.get(0).getDate(), time);
        String lstr = "RENEWAL_REMINDER " + str + " " + date;
        ans.add(lstr);
       }

       HashMap<String, Integer> topupMap = slist.get(0).getTopupMap();

       for(String str : topupMap.keySet()){
            totalAmount += getType(str)*topupMap.get(str);
       }

       String lstr = "RENEWAL_AMOUNT " + totalAmount;
       ans.add(lstr);

       return ans;
    }
}
