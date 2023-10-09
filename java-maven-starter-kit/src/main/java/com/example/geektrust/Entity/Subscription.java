package com.example.geektrust.Entity;

import java.util.HashMap;

public class Subscription {
    private String date;
    private HashMap<String, String> categoryMap;
    private HashMap<String, Integer> topupMap;
    private int EMPTY = 0;

    public Subscription(String date){
        this.date = date; 
        categoryMap = new HashMap<>();
        topupMap = new HashMap<>();
    }
    public String getDate(){
        return date;
    } 
    public boolean isPresent(String category){
        for(String str: categoryMap.keySet()){
            if(str.equals(category)){
                return true;
            }
        }
        return false;
    }
    
    public boolean isTopup(){
        if(topupMap.size() == EMPTY){
            return false;
        }
        return true;
    }
    public void setSubscription(String category, String plan){
        categoryMap.put(category, plan);
    }
    public void setTopup(String devices, int months){
        topupMap.put(devices, months);
    }
    public HashMap<String, String> getCategoryMap(){
        return  categoryMap;
    }
    public HashMap<String, Integer> getTopupMap(){
        return  topupMap;
    }
}
