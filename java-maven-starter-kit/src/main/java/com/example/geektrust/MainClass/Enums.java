package com.example.geektrust.MainClass;

public class Enums {
    private static boolean dflag;
    private static boolean sflag;

    public Enums(){
        dflag = false;
        sflag = false;
    }

    public static void setDflag(boolean value){
        dflag = value;
    }
    public static void setSflag(boolean value){
        sflag = value;
    }

    public static boolean getDflag(){
        return dflag;
    }
    public static boolean getSflag(){
        return sflag;
    }

}
