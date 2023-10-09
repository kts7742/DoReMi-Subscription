package com.example.geektrust.Commands;

import java.util.List;

import com.example.geektrust.MainClass.Enums;
import com.example.geektrust.Service.SubsService;

public class AddTopupCommand implements ICommand{
    private final SubsService subsService;
    
    public AddTopupCommand(SubsService subsService){
        this.subsService = subsService;
    }

    final String failed = "ADD_TOPUP_FAILED";
    @Override
    public void invoke(List<String> tokens) {
        if(!Enums.getDflag()){
            System.out.println(failed + " INVALID_DATE");
            return;
        }

        if(subsService.isTopup()){
            System.out.println(failed + " DUPLICATE_TOPUP");
            return;
        }
        if(!Enums.getSflag()){
            System.out.println(failed + " SUBSCRIPTIONS_NOT_FOUND");
            return;
        }
        String devices = tokens.get(1);
        int months = Integer.parseInt(tokens.get(2));
        subsService.addTopup(devices, months);
    }
}
