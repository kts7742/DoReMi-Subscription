package com.example.geektrust.Repository.RepositoryHelper;

import java.util.HashMap;

public class RepositoryAmountHelper {

    final static int PERSONAL_MUSIC_AMOUNT = 100, PERSONAL_VIDEO_AMOUNT = 200,
    PREMIUM_MUSIC_AMOUNT = 250, PREMIUM_VIDEO_AMOUNT = 500, PREMIUM_PODCAST_AMOUNT = 300, 
    FREE_AMOUNT = 0, PERSONAL_TIME = 1, PREMIUM_TIME = 3, TWO = 2, ZERO = 0;
    final static String music = "MUSIC";

    public static int[] getAmountAndTime(String str, HashMap<String, String> categoryMap){
        int[] ans = new int[TWO];
        if(categoryMap.get(str).equals("FREE")){
            ans[0] = FREE_AMOUNT;
            ans[1] = PERSONAL_TIME;
            return ans;
        } 
        if(categoryMap.get(str).equals("PERSONAL")){
            ans[0] = getPersonalAmount(str);
            ans[1] = PERSONAL_TIME;
            return ans;
        }
        if(categoryMap.get(str).equals("PREMIUM")){
            ans[0] = getPremiumAmount(str);
            ans[1] = PREMIUM_TIME;
            return ans;
        }
        return ans;
    }
    
    public static int getPremiumAmount(String str){
        if(str.equals(music)){
            return PREMIUM_MUSIC_AMOUNT;
        }
        if(str.equals("VIDEO")){
            return  PREMIUM_VIDEO_AMOUNT;
        }
        else{
            return PREMIUM_PODCAST_AMOUNT;
        }
    }

    public static int getPersonalAmount(String str){
        if(str.equals(music) || str.equals("PODCAST")){
            return PERSONAL_MUSIC_AMOUNT;
        }
        else{
            return PERSONAL_VIDEO_AMOUNT;
        }
    }
}
