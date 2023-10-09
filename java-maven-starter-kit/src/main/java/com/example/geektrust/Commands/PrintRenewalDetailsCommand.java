package com.example.geektrust.Commands;

import java.util.List;

import com.example.geektrust.MainClass.Enums;
import com.example.geektrust.Service.SubsService;

public class PrintRenewalDetailsCommand implements ICommand{
    private final SubsService subsService;
    
    public PrintRenewalDetailsCommand(SubsService subsService){
        this.subsService = subsService;
    }

    @Override
    public void invoke(List<String> tokens) {
        if(!Enums.getDflag() || !Enums.getSflag()){
            System.out.println("SUBSCRIPTIONS_NOT_FOUND");
            return;
        }
        List<String> list = subsService.printRenewal();
        for(String strr : list){
            System.out.println(strr);
        }
    }
}
